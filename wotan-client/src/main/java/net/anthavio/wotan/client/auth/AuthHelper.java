package net.anthavio.wotan.client.auth;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;

/**
 * 
 * @author martin.vanek
 *
 */
public class AuthHelper extends AbstractGroup {

	public AuthHelper(WotanClient client) {
		super(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/auth/login/
	 * 
	 * User visits WOT page
	 * https://api.worldoftanks.eu/wot/auth/login/?application_id=apapapapapapapapapapapapapapap&redirect_uri=http://myserver.com/myapp/oauth/callback
	 * 
	 * Makes login attempt there
	 * 
	 * On failure, user is redirected to
	 * http://myserver.com/myapp/oauth/callback?&status=error&code=12345&message=tellwhathappend
	 * 
	 * On success, user is redirected to
	 * http://myserver.com/myapp/oauth/callback?&status=ok&access_token=atatatatatatatatatatatatatatat&nickname=anthavio&account_id=504644777&expires_at=1389964670
	 * 
	 * Then we can use "access_token" to make authenticated calls until token expires (14 days)
	 * 
	 * To get new access_token before old expires
	 * https://api.worldoftanks.eu/wot/auth/prolongate/?application_id=apapapapapapapapapapapapapapap&access_token=atatatatatatatatatatatatatatat
	 * 
	 * To logout (invalidate access_token)
	 * https://api.worldoftanks.eu/wot/auth/logout/?application_id=apapapapapapapapapapapapapapap&access_token=atatatatatatatatatatatatatatat
	 */
	public String getOauthLoginUrl(String redirectUri) {
		if (!redirectUri.startsWith("http")) {
			throw new IllegalArgumentException("redirect URI must be absolute: " + redirectUri);
		}
		String serverUrl = client.getSettings().getServerUrl();
		//enforce https if api server url is http
		if (!serverUrl.startsWith("https")) {
			serverUrl = "https" + serverUrl.substring(4);
		}
		return serverUrl + "/wot/auth/login/?application_id=" + client.getSettings().getApplicationId() + "&redirect_uri="
				+ redirectUri;
	}

	/**
	 * 
	
	@RequestMapping(value = "oauth/request", method = RequestMethod.GET)
	public void oauthRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String callbackUrl = getCallbackURL(request).toString();
		AuthHelper auth = new AuthHelper(client);
		String loginUrl = auth.getOauthLoginUrl(callbackUrl);
		//redirect user to login page
		response.sendRedirect(loginUrl);
	}


	@RequestMapping(value = "oauth/callback", method = RequestMethod.GET)
	public String oauthCallback(@RequestParam(required = false) String access_token,
			@RequestParam(required = false) String code, HttpServletRequest request) {

		if (StringUtils.isNotBlank(code)) {
			System.err.println("error " + code);
			//error=access_denied;
		}
		if (StringUtils.isNotBlank(access_token)) {
			//put access_token into session 
		}
		return "redirect:...somewhere...";
	}
	
	private URL getCallbackURL(javax.servlet.http.HttpServletRequest request) {
		try {
			URL requestUrl = new URL(request.getRequestURL().toString());

			URL oauthCallbackUrl = new URL(requestUrl.getProtocol(), requestUrl.getHost(), requestUrl.getPort(),
					request.getContextPath() + "/oauth/callback");
			return oauthCallbackUrl;
		} catch (MalformedURLException mux) {
			throw new UnhandledException(mux);
		}

	}
	*/
}

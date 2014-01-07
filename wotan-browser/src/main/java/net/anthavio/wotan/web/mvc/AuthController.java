package net.anthavio.wotan.web.mvc;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;
import net.anthavio.wotan.client.auth.AuthHelper;
import net.anthavio.wotan.web.SessionData;
import net.anthavio.wotan.web.vaadin.view.SettingsView;

import org.apache.commons.lang.UnhandledException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	@Autowired
	private SessionData sessionData;

	@RequestMapping(value = "request", method = RequestMethod.GET)
	public void oauthRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		AuthHelper auth = sessionData.getClient().authentication();
		URL callbackUrl = getCallbackUrl(request);
		String loginUrl = auth.getOauthLoginUrl(callbackUrl.toString());
		//redirect user to login page
		response.sendRedirect(loginUrl);
	}

	@RequestMapping(value = "callback", params = "status=error")
	public String oauthCallbackError(@RequestParam(value = "code") String code,
			@RequestParam(value = "message") String message) {

		System.out.println("Authentication failed " + code + " " + message);

		return "redirect:/vui/#!" + SettingsView.NAME;
	}

	@RequestMapping(value = "callback", params = "status=ok")
	public String oauthCallback(@RequestParam(value = "access_token") String accessToken,
			@RequestParam(value = "nickname") String nickname, @RequestParam(value = "account_id") Long accountId) {

		sessionData.setAccessToken(accessToken);
		sessionData.setAccount(new AccountStub(accountId, nickname));

		return "redirect:/vui/#!" + SettingsView.NAME;
	}

	private URL getCallbackUrl(javax.servlet.http.HttpServletRequest request) {
		try {
			URL requestUrl = new URL(request.getRequestURL().toString());
			URL oauthCallbackUrl = new URL(requestUrl.getProtocol(), requestUrl.getHost(), requestUrl.getPort(),
					request.getContextPath() + "/oauth/callback");
			return oauthCallbackUrl;
		} catch (MalformedURLException mux) {
			throw new UnhandledException(mux);
		}
	}
}

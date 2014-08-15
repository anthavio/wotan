package net.anthavio.wotan.client;

import net.anthavio.httl.api.HttlApi;
import net.anthavio.httl.api.HttlCall;
import net.anthavio.httl.api.HttlVar;
import net.anthavio.wotan.client.account.AccountInfoResponse;
import net.anthavio.wotan.client.account.AccountListResponse;

/**
 * 
 * @author martin.vanek
 *
 */
@HttlApi("/wot/account")
public interface ApiAccounts {

	@HttlCall("GET /list/")
	public AccountListResponse list(@HttlVar(name = "search", required = true) String search);

	/**
	 * With access_token, Private section is included in response
	 */
	@HttlCall("GET /info/")
	public AccountInfoResponse info(@HttlVar(name = "access_token", required = true) String access_token,
			@HttlVar(name = "account_id", required = true) long... account_id);

	/**
	 * Without access_token only public information are returned
	 */
	@HttlCall("GET /info/")
	public AccountInfoResponse info(@HttlVar(name = "account_id", required = true) long... account_id);
}

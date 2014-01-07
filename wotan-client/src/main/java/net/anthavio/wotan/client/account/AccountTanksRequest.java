package net.anthavio.wotan.client.account;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.AuthenticatedRequest;
import net.anthavio.wotan.client.WotanClient;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/tanks/
 * 
 * @author martin.vanek
 *
 */
public class AccountTanksRequest extends AuthenticatedRequest<AccountTanksRequest, AccountTanksResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<AccountTanksResponse> tanks = //
	MethodConfig.GET("/wot/account/tanks/", AccountTanksResponse.class);

	public AccountTanksRequest(WotanClient client, long account_id, long... additional_ids) {
		super(tanks, client, account_id, additional_ids);
	}

	@Override
	protected AccountTanksRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		//nothing more
	}

}

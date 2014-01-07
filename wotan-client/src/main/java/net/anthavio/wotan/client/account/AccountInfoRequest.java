package net.anthavio.wotan.client.account;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.AuthenticatedRequest;
import net.anthavio.wotan.client.WotanClient;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/info/
 * 
 * @author martin.vanek
 *
 */
public class AccountInfoRequest extends AuthenticatedRequest<AccountInfoRequest, AccountInfoResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<AccountInfoResponse> config = //
	MethodConfig.GET("/wot/account/info/", AccountInfoResponse.class);

	public AccountInfoRequest(WotanClient client, long account_id, long... additional_ids) {
		super(config, client, account_id, additional_ids);
	}

	@Override
	protected AccountInfoRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		//nothing to add
	}

}

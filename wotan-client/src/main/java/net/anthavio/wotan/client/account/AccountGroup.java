package net.anthavio.wotan.client.account;

import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.account.AccountInfoResponse.AccountInfo;
import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;
import net.anthavio.wotan.client.account.AccountTanksResponse.PlayersTank;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/list/
 * 
 * @author martin.vanek
 *
 */
public class AccountGroup extends AbstractGroup {

	public AccountGroup(WotanClient client) {
		super(client);
	}

	/**
	 * @param search account name
	 * 
	 * https://eu.wargaming.net/developers/api_reference/wot/account/list/
	 */
	public List<AccountStub> list(String search) {
		AccountListRequest request = new AccountListRequest(search);
		return client.execute(request).getData();
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public Map<Long, AccountInfo> info(long account_id, long... additional_ids) {
		AccountInfoRequest request = new AccountInfoRequest(account_id, additional_ids);
		return client.execute(request).getData();
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/ratings/
	 */
	@Deprecated
	public void ratings() {

	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/tanks/
	 * @return 
	 */
	public Map<Long, List<PlayersTank>> tanks(long account_id, long... additional_ids) {
		AccountTanksRequest request = new AccountTanksRequest(account_id, additional_ids);
		return client.execute(request).getData();
	}

}

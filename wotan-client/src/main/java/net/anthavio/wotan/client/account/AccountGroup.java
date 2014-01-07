package net.anthavio.wotan.client.account;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;

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
	public AccountListRequest list(String search) {
		return new AccountListRequest(client, search);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public AccountInfoRequest info(long account_id, long... additional_ids) {
		return new AccountInfoRequest(client, account_id, additional_ids);
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
	public AccountTanksRequest tanks(long account_id, long... additional_ids) {
		return new AccountTanksRequest(client, account_id, additional_ids);
	}

}

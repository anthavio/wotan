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
	 * https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public AccountInfoRequest info(long account_id, long... additional_ids) {
		return new AccountInfoRequest(client, account_id, additional_ids);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/tanks/
	 */
	public AccountTanksRequest tanks(long account_id, long... additional_ids) {
		return new AccountTanksRequest(client, account_id, additional_ids);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/ratings/
	 */
	@Deprecated
	public void ratings() {
		throw new UnsupportedOperationException("Use client.ratings().player(int account_id)");
	}

}

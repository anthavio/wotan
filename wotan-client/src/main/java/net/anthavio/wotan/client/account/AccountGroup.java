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
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/list/
	 * @param search 
	 */
	public AccountListResponse list(String search) {
		AccountListRequest request = new AccountListRequest(search);
		return client.execute(request, AccountListResponse.class);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public void info() {

	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/ratings/
	 */
	public void ratings() {

	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/tanks/
	 */
	public void tanks() {

	}

}

package net.anthavio.wotan.client.clan;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/clan/list/
 * 
 * @author martin.vanek
 *
 */
public class ClanGroup extends AbstractGroup {

	public ClanGroup(WotanClient client) {
		super(client);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/list/
	 */
	public ClanListRequest list(String search) {
		return new ClanListRequest(client, search);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public void info() {

	}

}

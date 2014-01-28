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
	 * https://eu.wargaming.net/developers/api_reference/wot/clan/top/
	 */
	public TopClansRequest top() {
		return new TopClansRequest(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/clan/list/
	 */
	public ClanListRequest list(String search) {
		return new ClanListRequest(client, search);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public ClanInfoRequest info(long clan_id, long... additional_ids) {
		return new ClanInfoRequest(client, clan_id, additional_ids);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/membersinfo/
	 */
	public MembersInfoRequest member(long member_id, long... additional_ids) {
		return new MembersInfoRequest(client, member_id, additional_ids);
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/battles/
	 */
	public void battles(long clan_id, long... additional_ids) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/provinces/
	 */
	public void provinces(long clan_id) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/victorypoints/
	 */
	public void victorypoints(long clan_id, long... additional_ids) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/victorypointshistory/
	 */
	public void victorypointshistory(long clan_id) {
		throw new UnsupportedOperationException("Not implemented yet");
	}

}

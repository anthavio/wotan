package net.anthavio.wotan.client;

import net.anthavio.httl.api.HttlApi;
import net.anthavio.httl.api.HttlCall;
import net.anthavio.wotan.client.clan.ClanInfoResponse;
import net.anthavio.wotan.client.clan.ClanListResponse;
import net.anthavio.wotan.client.clan.MembersInfoResponse;

/**
 * 
 * @author vanek
 *
 */
@HttlApi("/wot/clan")
public interface ApiClan {

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/clan/top/
	 */
	@HttlCall("GET /top/")
	public ClanInfoResponse top();

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/clan/list/
	 */
	public ClanListResponse list(String search);

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/info/
	 */
	public ClanInfoResponse info(long clan_id, long... additional_ids);

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/account/membersinfo/
	 */
	public MembersInfoResponse member(long member_id, long... additional_ids);

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/battles/
	 */
	public void battles(long clan_id, long... additional_ids);

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/provinces/
	 */
	public void provinces(long clan_id);

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/victorypoints/
	 */
	public void victorypoints(long clan_id, long... additional_ids);

	/**
	 * TODO https://eu.wargaming.net/developers/api_reference/wot/clan/victorypointshistory/
	 */
	public void victorypointshistory(long clan_id);
}

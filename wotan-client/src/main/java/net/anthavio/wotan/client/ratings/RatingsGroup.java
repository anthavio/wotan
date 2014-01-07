package net.anthavio.wotan.client.ratings;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/ratings/types/
 * 
 * @author martin.vanek
 *
 */
public class RatingsGroup extends AbstractGroup {

	public RatingsGroup(WotanClient client) {
		super(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/types/
	 */
	public RatingsTypesRequest types() {
		return new RatingsTypesRequest(client);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/dates/
	 * @return 
	 */
	public RatingsDatesRequest dates(RatingType type) {
		return new RatingsDatesRequest(client, type);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/accounts/
	 */
	public PlayerRatingsRequest player(int account_id, RatingType type) {
		return new PlayerRatingsRequest(client, account_id).setType(type);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/neighbors/
	 */
	public NeighborsRatingsRequest neighbors(int account_id, RatingType type, String rank_field) {
		return new NeighborsRatingsRequest(client, account_id).setType(type).setRankField(rank_field);
	}

}

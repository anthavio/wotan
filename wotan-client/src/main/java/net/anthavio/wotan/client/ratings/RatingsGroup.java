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
	public PlayerRatingsRequest player(RatingType type, long account_id, long... additional_ids) {
		return new PlayerRatingsRequest(client, account_id, additional_ids).setType(type);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/neighbors/
	 */
	public NeighborsRatingsRequest neighbors(long account_id, RatingType type, RankField field) {
		return new NeighborsRatingsRequest(client, account_id).setType(type).setRankField(field);
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/top/
	 * @return 
	 */
	public TopRatingsRequest top(RatingType type, RankField field) {
		return new TopRatingsRequest(client).setType(type).setRankField(field);
	}

}

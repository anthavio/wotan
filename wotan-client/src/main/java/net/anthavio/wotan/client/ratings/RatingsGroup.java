package net.anthavio.wotan.client.ratings;

import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.AbstractGroup;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.ratings.PlayerRatingsResponse.Ratings;

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
	public Map<RatingType, RatingsTypesResponse.Ratings> types() {
		return client.execute(new RatingsTypesRequest()).getData();
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/dates/
	 */
	public void dates(RatingType type) {
		client.execute(new RatingsDatesRequest(type)).getData();
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/accounts/
	 */
	public Map<Long, Ratings> player(int account_id, RatingType type) {
		PlayerRatingsRequest request = new PlayerRatingsRequest(account_id);
		request.setType(type);
		return client.execute(request).getData();
	}

	/**
	 * https://eu.wargaming.net/developers/api_reference/wot/ratings/neighbors/
	 */
	public List<PlayerRatingsResponse.Ratings> neighbors(int account_id, RatingType type, String rank_field) {
		NeighborsRatingsRequest request = new NeighborsRatingsRequest(account_id);
		request.setType(type).setRankField(rank_field);
		return client.execute(request).getData();
	}

}

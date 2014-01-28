package net.anthavio.wotan.client.ratings;

import java.util.List;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;
import net.anthavio.wotan.client.ratings.PlayerRatingsResponse.Ratings;

/**
 * 
 * @author martin.vanek
 *
 */
public class TopRatingsResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private List<Ratings> data;

	public List<Ratings> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

}

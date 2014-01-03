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
public class NeighborsRatingsResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private List<Ratings> data;

	public List<Ratings> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}
	/*
		public static class NeighborsRatings implements Serializable {

			private static final long serialVersionUID = 1L;

			private Long account_id;

			private Integer battles_to_play;

			private PlayerRating battles_count;

			private PlayerRating damage_avg;

			private PlayerRating damage_dealt;

			private PlayerRating frags_avg;

			private PlayerRating frags_count;

			private PlayerRating hits_ratio;

			private PlayerRating spotted_avg;

			private PlayerRating spotted_count;

			private PlayerRating survived_ratio;

			private PlayerRating wins_ratio;

			private PlayerRating xp_amount;

			private PlayerRating xp_avg;

			private PlayerRating xp_max;

			@Override
			public String toString() {
				return JsonStringBuilder.toString(this, true);
			}
		}
	*/
}

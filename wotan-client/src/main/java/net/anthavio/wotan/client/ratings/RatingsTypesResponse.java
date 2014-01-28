package net.anthavio.wotan.client.ratings;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class RatingsTypesResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	//"1","7","28","all"
	private Map<RatingType, RatingsTypesData> data;

	public Map<RatingType, RatingsTypesData> getData() {
		return data;
	}

	public RatingsTypesData get(RatingType type) {
		return data.get(type.getCode());
	}

	public RatingsTypesData getDay() {
		return get(RatingType.DAY);
	}

	public RatingsTypesData getWeek() {
		return get(RatingType.WEEK);
	}

	public RatingsTypesData getMonth() {
		return get(RatingType.MONTH);
	}

	public RatingsTypesData getAll() {
		return get(RatingType.ALL);
	}

	public static class RatingsTypesData implements Serializable {

		private static final long serialVersionUID = 1L;

		private RatingType type;

		private Integer threshold;

		private List<String> rank_fields;

		public RatingType getType() {
			return type;
		}

		public void setType(RatingType type) {
			this.type = type;
		}

		public Integer getThreshold() {
			return threshold;
		}

		public void setThreshold(Integer threshold) {
			this.threshold = threshold;
		}

		public List<String> getRank_fields() {
			return rank_fields;
		}

		public void setRank_fields(List<String> rank_fields) {
			this.rank_fields = rank_fields;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}
}

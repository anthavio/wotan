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
	private Map<RatingType, Ratings> data;

	public Map<RatingType, Ratings> getData() {
		return data;
	}

	public Ratings get(RatingType type) {
		return data.get(type.getCode());
	}

	public Ratings getDay() {
		return data.get("1");
	}

	public Ratings getWeek() {
		return data.get("7");
	}

	public Ratings getMonth() {
		return data.get("28");
	}

	public Ratings getAll() {
		return data.get("all");
	}

	public static class Ratings implements Serializable {

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
}

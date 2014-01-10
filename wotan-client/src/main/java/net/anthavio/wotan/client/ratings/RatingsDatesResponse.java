package net.anthavio.wotan.client.ratings;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.JacksonDeserializers.WotDateListDeserializer;
import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author martin.vanek
 *
 */
public class RatingsDatesResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<RatingType, Data> data;

	public Map<RatingType, Data> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public Data get(RatingType type) {
		return data.get(type.getCode());
	}

	public Data getDay() {
		return get(RatingType.DAY);
	}

	public Data getWeek() {
		return get(RatingType.WEEK);
	}

	public Data getMonth() {
		return get(RatingType.MONTH);
	}

	public Data getAll() {
		return get(RatingType.ALL);
	}

	public static class Data implements Serializable {

		private static final long serialVersionUID = 1L;

		private List<Date> dates;

		@JsonDeserialize(using = WotDateListDeserializer.class)
		public List<Date> getDates() {
			return dates;
		}

		public void setDates(List<Date> dates) {
			this.dates = dates;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

}

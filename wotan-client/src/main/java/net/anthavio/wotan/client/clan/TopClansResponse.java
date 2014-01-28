package net.anthavio.wotan.client.clan;

import java.io.Serializable;
import java.util.List;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class TopClansResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private List<TopClan> data;

	public List<TopClan> getData() {
		return data;
	}

	public void setData(List<TopClan> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class TopClan extends Clan implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer rating_position;

		private Integer victory_points;

		private Integer victory_points_step_delta;

		private Integer victory_points_turn_delta;

		public Integer getRating_position() {
			return rating_position;
		}

		public void setRating_position(Integer rating_position) {
			this.rating_position = rating_position;
		}

		public Integer getVictory_points() {
			return victory_points;
		}

		public void setVictory_points(Integer victory_points) {
			this.victory_points = victory_points;
		}

		public Integer getVictory_points_step_delta() {
			return victory_points_step_delta;
		}

		public void setVictory_points_step_delta(Integer victory_points_step_delta) {
			this.victory_points_step_delta = victory_points_step_delta;
		}

		public Integer getVictory_points_turn_delta() {
			return victory_points_turn_delta;
		}

		public void setVictory_points_turn_delta(Integer victory_points_turn_delta) {
			this.victory_points_turn_delta = victory_points_turn_delta;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

}

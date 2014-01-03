package net.anthavio.wotan.client.account;

import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/tanks/
 * 
 * @author martin.vanek
 *
 */
public class AccountTanksResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, List<PlayersTank>> data;

	public Map<Long, List<PlayersTank>> getData() {
		return data;
	}

	public void setData(Map<Long, List<PlayersTank>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class PlayersTank {

		private Integer tank_id;

		private Integer mark_of_mastery;

		//@Deprecated
		//private Integer in_garage;

		//@Deprecated
		//private Date last_battle_time;

		private VehicleStatistics statistics;

		@Deprecated
		private Map<String, Integer> achievements;

		public Integer getTank_id() {
			return tank_id;
		}

		public void setTank_id(Integer tank_id) {
			this.tank_id = tank_id;
		}

		public Integer getMark_of_mastery() {
			return mark_of_mastery;
		}

		public void setMark_of_mastery(Integer mark_of_mastery) {
			this.mark_of_mastery = mark_of_mastery;
		}

		public VehicleStatistics getStatistics() {
			return statistics;
		}

		public void setStatistics(VehicleStatistics statistics) {
			this.statistics = statistics;
		}

		public Map<String, Integer> getAchievements() {
			return achievements;
		}

		public void setAchievements(Map<String, Integer> achievements) {
			this.achievements = achievements;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

	public static class VehicleStatistics {

		private Integer battles;

		private Integer wins;

		//@Deprecated
		//private Integer max_frags;

		//@Deprecated
		//private Integer max_xp;

		//@Deprecated
		//private Integer win_and_survived;

		@Deprecated
		private Map<String, Integer> all;

		@Deprecated
		private Map<String, Integer> clan;

		@Deprecated
		private Map<String, Integer> company;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

}

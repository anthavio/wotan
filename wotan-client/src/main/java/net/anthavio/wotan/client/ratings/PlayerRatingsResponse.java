package net.anthavio.wotan.client.ratings;

import java.io.Serializable;
import java.util.Map;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class PlayerRatingsResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, Ratings> data;

	public Map<Long, Ratings> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class Ratings implements Serializable {

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

		public Long getAccount_id() {
			return account_id;
		}

		public void setAccount_id(Long account_id) {
			this.account_id = account_id;
		}

		public Integer getBattles_to_play() {
			return battles_to_play;
		}

		public void setBattles_to_play(Integer battles_to_play) {
			this.battles_to_play = battles_to_play;
		}

		public PlayerRating getBattles_count() {
			return battles_count;
		}

		public void setBattles_count(PlayerRating battles_count) {
			this.battles_count = battles_count;
		}

		public PlayerRating getDamage_avg() {
			return damage_avg;
		}

		public void setDamage_avg(PlayerRating damage_avg) {
			this.damage_avg = damage_avg;
		}

		public PlayerRating getDamage_dealt() {
			return damage_dealt;
		}

		public void setDamage_dealt(PlayerRating damage_dealt) {
			this.damage_dealt = damage_dealt;
		}

		public PlayerRating getFrags_avg() {
			return frags_avg;
		}

		public void setFrags_avg(PlayerRating frags_avg) {
			this.frags_avg = frags_avg;
		}

		public PlayerRating getFrags_count() {
			return frags_count;
		}

		public void setFrags_count(PlayerRating frags_count) {
			this.frags_count = frags_count;
		}

		public PlayerRating getHits_ratio() {
			return hits_ratio;
		}

		public void setHits_ratio(PlayerRating hits_ratio) {
			this.hits_ratio = hits_ratio;
		}

		public PlayerRating getSpotted_avg() {
			return spotted_avg;
		}

		public void setSpotted_avg(PlayerRating spotted_avg) {
			this.spotted_avg = spotted_avg;
		}

		public PlayerRating getSpotted_count() {
			return spotted_count;
		}

		public void setSpotted_count(PlayerRating spotted_count) {
			this.spotted_count = spotted_count;
		}

		public PlayerRating getSurvived_ratio() {
			return survived_ratio;
		}

		public void setSurvived_ratio(PlayerRating survived_ratio) {
			this.survived_ratio = survived_ratio;
		}

		public PlayerRating getWins_ratio() {
			return wins_ratio;
		}

		public void setWins_ratio(PlayerRating wins_ratio) {
			this.wins_ratio = wins_ratio;
		}

		public PlayerRating getXp_amount() {
			return xp_amount;
		}

		public void setXp_amount(PlayerRating xp_amount) {
			this.xp_amount = xp_amount;
		}

		public PlayerRating getXp_avg() {
			return xp_avg;
		}

		public void setXp_avg(PlayerRating xp_avg) {
			this.xp_avg = xp_avg;
		}

		public PlayerRating getXp_max() {
			return xp_max;
		}

		public void setXp_max(PlayerRating xp_max) {
			this.xp_max = xp_max;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

	public static class PlayerRating implements Serializable {

		private static final long serialVersionUID = 1L;

		public Integer rank;

		public Integer rank_delta;

		public Integer value;

		public Integer getRank() {
			return rank;
		}

		public void setRank(Integer rank) {
			this.rank = rank;
		}

		public Integer getRank_delta() {
			return rank_delta;
		}

		public void setRank_delta(Integer rank_delta) {
			this.rank_delta = rank_delta;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}
}

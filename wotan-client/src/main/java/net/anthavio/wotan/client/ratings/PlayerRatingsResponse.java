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

		private RankDeltaValue battles_count;

		private RankDeltaValue damage_avg;

		private RankDeltaValue damage_dealt;

		private RankDeltaValue frags_avg;

		private RankDeltaValue frags_count;

		private RankDeltaValue hits_ratio;

		private RankDeltaValue spotted_avg;

		private RankDeltaValue spotted_count;

		private RankDeltaValue survived_ratio;

		private RankDeltaValue wins_ratio;

		private RankDeltaValue xp_amount;

		private RankDeltaValue xp_avg;

		private RankDeltaValue xp_max;

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

		public RankDeltaValue getBattles_count() {
			return battles_count;
		}

		public void setBattles_count(RankDeltaValue battles_count) {
			this.battles_count = battles_count;
		}

		public RankDeltaValue getDamage_avg() {
			return damage_avg;
		}

		public void setDamage_avg(RankDeltaValue damage_avg) {
			this.damage_avg = damage_avg;
		}

		public RankDeltaValue getDamage_dealt() {
			return damage_dealt;
		}

		public void setDamage_dealt(RankDeltaValue damage_dealt) {
			this.damage_dealt = damage_dealt;
		}

		public RankDeltaValue getFrags_avg() {
			return frags_avg;
		}

		public void setFrags_avg(RankDeltaValue frags_avg) {
			this.frags_avg = frags_avg;
		}

		public RankDeltaValue getFrags_count() {
			return frags_count;
		}

		public void setFrags_count(RankDeltaValue frags_count) {
			this.frags_count = frags_count;
		}

		public RankDeltaValue getHits_ratio() {
			return hits_ratio;
		}

		public void setHits_ratio(RankDeltaValue hits_ratio) {
			this.hits_ratio = hits_ratio;
		}

		public RankDeltaValue getSpotted_avg() {
			return spotted_avg;
		}

		public void setSpotted_avg(RankDeltaValue spotted_avg) {
			this.spotted_avg = spotted_avg;
		}

		public RankDeltaValue getSpotted_count() {
			return spotted_count;
		}

		public void setSpotted_count(RankDeltaValue spotted_count) {
			this.spotted_count = spotted_count;
		}

		public RankDeltaValue getSurvived_ratio() {
			return survived_ratio;
		}

		public void setSurvived_ratio(RankDeltaValue survived_ratio) {
			this.survived_ratio = survived_ratio;
		}

		public RankDeltaValue getWins_ratio() {
			return wins_ratio;
		}

		public void setWins_ratio(RankDeltaValue wins_ratio) {
			this.wins_ratio = wins_ratio;
		}

		public RankDeltaValue getXp_amount() {
			return xp_amount;
		}

		public void setXp_amount(RankDeltaValue xp_amount) {
			this.xp_amount = xp_amount;
		}

		public RankDeltaValue getXp_avg() {
			return xp_avg;
		}

		public void setXp_avg(RankDeltaValue xp_avg) {
			this.xp_avg = xp_avg;
		}

		public RankDeltaValue getXp_max() {
			return xp_max;
		}

		public void setXp_max(RankDeltaValue xp_max) {
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

	public static class RankDeltaValue implements Serializable {

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

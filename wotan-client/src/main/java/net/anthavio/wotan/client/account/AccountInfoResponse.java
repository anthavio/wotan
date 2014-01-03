package net.anthavio.wotan.client.account;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.JacksonDeserializers.WotDateDeserializer;
import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/info/
 * 
 * @author martin.vanek
 *
 */
public class AccountInfoResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, AccountInfo> data;

	public Map<Long, AccountInfo> getData() {
		return data;
	}

	public void setData(Map<Long, AccountInfo> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class AccountInfoData implements Serializable {

		private static final long serialVersionUID = 1L;

		private List<AccountInfo> accounts;

		public List<AccountInfo> getAccounts() {
			return accounts;
		}

		public void setAccounts(List<AccountInfo> accounts) {
			this.accounts = accounts;
		}

		public AccountInfoData(List<AccountInfo> accounts) {
			this.accounts = accounts;
		}

	}

	public static class AccountInfo implements Serializable {

		private static final long serialVersionUID = 1L;

		@JsonProperty("account_id")
		private Long account_id;

		@JsonProperty("nickname")
		private String nickname;

		@JsonProperty("created_at")
		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date created_at;

		@JsonProperty("updated_at")
		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date updated_at;

		@JsonProperty("achievements")
		private Map<String, Integer> achievements;

		@Deprecated
		@JsonProperty("clan")
		private Map clan; //Warning. The field will be disabled.Use clan/membersinfo method.

		@JsonProperty("private")
		private Private _private; //well private is java keyword

		@JsonProperty("statistics")
		private StatisticsWrapper statistics;

		public Long getAccount_id() {
			return account_id;
		}

		public void setAccount_id(Long account_id) {
			this.account_id = account_id;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

		public Date getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}

		public Map<String, Integer> getAchievements() {
			return achievements;
		}

		public void setAchievements(Map<String, Integer> achievements) {
			this.achievements = achievements;
		}

		public Map getClan() {
			return clan;
		}

		public void setClan(Map clan) {
			this.clan = clan;
		}

		public Private getPrivate() {
			return _private;
		}

		public void setPrivate(Private personal) {
			this._private = personal;
		}

		public StatisticsWrapper getStatistics() {
			return statistics;
		}

		public void setStatistics(StatisticsWrapper statistics) {
			this.statistics = statistics;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

	public static class Private implements Serializable {

		private static final long serialVersionUID = 1L;

		private String account_type;

		private String account_type_i18n;

		private String ban_info;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date ban_time;

		private Integer credits;

		private Integer free_xp;

		private List<Long> friends;

		private Integer gold;

		private Boolean is_bound_to_phone;

		private Boolean is_premium;

		private Date premium_expires_at;

		private Restrictions restrictions;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}
	}

	public static class Restrictions implements Serializable {

		private static final long serialVersionUID = 1L;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date chat_ban_time;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date clan_time;

		public Date getChat_ban_time() {
			return chat_ban_time;
		}

		public void setChat_ban_time(Date chat_ban_time) {
			this.chat_ban_time = chat_ban_time;
		}

		public Date getClan_time() {
			return clan_time;
		}

		public void setClan_time(Date clan_time) {
			this.clan_time = clan_time;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

	public static class StatisticsWrapper implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer max_xp;

		private PlayerStatistics all;

		private PlayerStatistics company;

		private PlayerStatistics clan;

		public Integer getMax_xp() {
			return max_xp;
		}

		public void setMax_xp(Integer max_xp) {
			this.max_xp = max_xp;
		}

		public PlayerStatistics getAll() {
			return all;
		}

		public void setAll(PlayerStatistics all) {
			this.all = all;
		}

		public PlayerStatistics getCompany() {
			return company;
		}

		public void setCompany(PlayerStatistics company) {
			this.company = company;
		}

		public PlayerStatistics getClan() {
			return clan;
		}

		public void setClan(PlayerStatistics clan) {
			this.clan = clan;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

	public static class PlayerStatistics implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer battle_avg_xp;

		private Integer battles;

		private Integer capture_points;

		private Integer damage_dealt;

		private Integer damage_received;

		private Integer draws;

		private Integer dropped_capture_points;

		private Integer frags;

		private Integer hits;

		private Integer hits_percents;

		private Integer losses;

		private Integer shots;

		private Integer spotted;

		private Integer survived_battles;

		private Integer wins;

		private Integer xp;

		public Integer getBattle_avg_xp() {
			return battle_avg_xp;
		}

		public void setBattle_avg_xp(Integer battle_avg_xp) {
			this.battle_avg_xp = battle_avg_xp;
		}

		public Integer getBattles() {
			return battles;
		}

		public void setBattles(Integer battles) {
			this.battles = battles;
		}

		public Integer getCapture_points() {
			return capture_points;
		}

		public void setCapture_points(Integer capture_points) {
			this.capture_points = capture_points;
		}

		public Integer getDamage_dealt() {
			return damage_dealt;
		}

		public void setDamage_dealt(Integer damage_dealt) {
			this.damage_dealt = damage_dealt;
		}

		public Integer getDamage_received() {
			return damage_received;
		}

		public void setDamage_received(Integer damage_received) {
			this.damage_received = damage_received;
		}

		public Integer getDraws() {
			return draws;
		}

		public void setDraws(Integer draws) {
			this.draws = draws;
		}

		public Integer getDropped_capture_points() {
			return dropped_capture_points;
		}

		public void setDropped_capture_points(Integer dropped_capture_points) {
			this.dropped_capture_points = dropped_capture_points;
		}

		public Integer getFrags() {
			return frags;
		}

		public void setFrags(Integer frags) {
			this.frags = frags;
		}

		public Integer getHits() {
			return hits;
		}

		public void setHits(Integer hits) {
			this.hits = hits;
		}

		public Integer getHits_percents() {
			return hits_percents;
		}

		public void setHits_percents(Integer hits_percents) {
			this.hits_percents = hits_percents;
		}

		public Integer getLosses() {
			return losses;
		}

		public void setLosses(Integer losses) {
			this.losses = losses;
		}

		public Integer getShots() {
			return shots;
		}

		public void setShots(Integer shots) {
			this.shots = shots;
		}

		public Integer getSpotted() {
			return spotted;
		}

		public void setSpotted(Integer spotted) {
			this.spotted = spotted;
		}

		public Integer getSurvived_battles() {
			return survived_battles;
		}

		public void setSurvived_battles(Integer survived_battles) {
			this.survived_battles = survived_battles;
		}

		public Integer getWins() {
			return wins;
		}

		public void setWins(Integer wins) {
			this.wins = wins;
		}

		public Integer getXp() {
			return xp;
		}

		public void setXp(Integer xp) {
			this.xp = xp;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

}

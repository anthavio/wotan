package net.anthavio.wotan.client.clan;

import java.io.Serializable;
import java.util.Date;

import net.anthavio.wotan.client.JacksonDeserializers.WotDateDeserializer;
import net.anthavio.wotan.client.JsonStringBuilder;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author martin.vanek
 *
 */
public class Clan implements Serializable {

	private static final long serialVersionUID = 1L;

	private String abbreviation;

	private Long clan_id;

	private String color;

	@JsonDeserialize(using = WotDateDeserializer.class)
	private Date created_at;

	private Integer members_count;

	private String motto;

	private String name;

	private Long owner_id;

	private String owner_name;

	private Emblems emblems;

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public Long getClan_id() {
		return clan_id;
	}

	public void setClan_id(Long clan_id) {
		this.clan_id = clan_id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Integer getMembers_count() {
		return members_count;
	}

	public void setMembers_count(Integer members_count) {
		this.members_count = members_count;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(Long owner_id) {
		this.owner_id = owner_id;
	}

	public String getOwner_name() {
		return owner_name;
	}

	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}

	public Emblems getEmblems() {
		return emblems;
	}

	public void setEmblems(Emblems emblems) {
		this.emblems = emblems;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class Emblems implements Serializable {

		private static final long serialVersionUID = 1L;

		private String bw_tank;

		private String large;

		private String medium;

		private String small;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

		public String getBw_tank() {
			return bw_tank;
		}

		public void setBw_tank(String bw_tank) {
			this.bw_tank = bw_tank;
		}

		public String getLarge() {
			return large;
		}

		public void setLarge(String large) {
			this.large = large;
		}

		public String getMedium() {
			return medium;
		}

		public void setMedium(String medium) {
			this.medium = medium;
		}

		public String getSmall() {
			return small;
		}

		public void setSmall(String small) {
			this.small = small;
		}

	}

}

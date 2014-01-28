package net.anthavio.wotan.client.clan;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import net.anthavio.wotan.client.JacksonDeserializers.WotDateDeserializer;
import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;
import net.anthavio.wotan.client.clan.Clan.Emblems;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author martin.vanek
 *
 */
public class ClanInfoResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;
	private ClanInfo data;

	public ClanInfo getData() {
		return data;
	}

	public void setData(ClanInfo data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class ClanInfo implements Serializable {

		private static final long serialVersionUID = 1L;

		private String abbreviation;

		private String clan_color;

		private Long clan_id;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date created_at;

		private String description;

		private String description_html;

		private Boolean is_clan_disbanded;

		private Integer members_count;

		private String motto;

		private String name;

		private Long owner_id;

		private Boolean request_availability;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date updated_at;

		private Emblems emblems;

		private List<Member> members;

		@JsonProperty("private")
		private Private _private;

		public String getAbbreviation() {
			return abbreviation;
		}

		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		public String getClan_color() {
			return clan_color;
		}

		public void setClan_color(String clan_color) {
			this.clan_color = clan_color;
		}

		public Long getClan_id() {
			return clan_id;
		}

		public void setClan_id(Long clan_id) {
			this.clan_id = clan_id;
		}

		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getDescription_html() {
			return description_html;
		}

		public void setDescription_html(String description_html) {
			this.description_html = description_html;
		}

		public Boolean getIs_clan_disbanded() {
			return is_clan_disbanded;
		}

		public void setIs_clan_disbanded(Boolean is_clan_disbanded) {
			this.is_clan_disbanded = is_clan_disbanded;
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

		public Boolean getRequest_availability() {
			return request_availability;
		}

		public void setRequest_availability(Boolean request_availability) {
			this.request_availability = request_availability;
		}

		public Date getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}

		public Emblems getEmblems() {
			return emblems;
		}

		public void setEmblems(Emblems emblems) {
			this.emblems = emblems;
		}

		public List<Member> getMembers() {
			return members;
		}

		public void setMembers(List<Member> members) {
			this.members = members;
		}

		public Private getPrivate() {
			return _private;
		}

		public void setPrivate(Private _private) {
			this._private = _private;
		}

	}

	public static class Private implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long chips_count;

		private Long treasury;

		public Long getChips_count() {
			return chips_count;
		}

		public void setChips_count(Long chips_count) {
			this.chips_count = chips_count;
		}

		public Long getTreasury() {
			return treasury;
		}

		public void setTreasury(Long treasury) {
			this.treasury = treasury;
		}

	}

	public static class Member implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long account_id;

		private String account_name;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date created_at;

		private String role;

		private String role_i18n;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date updated_at;

		public Long getAccount_id() {
			return account_id;
		}

		public void setAccount_id(Long account_id) {
			this.account_id = account_id;
		}

		public String getAccount_name() {
			return account_name;
		}

		public void setAccount_name(String account_name) {
			this.account_name = account_name;
		}

		public Date getCreated_at() {
			return created_at;
		}

		public void setCreated_at(Date created_at) {
			this.created_at = created_at;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getRole_i18n() {
			return role_i18n;
		}

		public void setRole_i18n(String role_i18n) {
			this.role_i18n = role_i18n;
		}

		public Date getUpdated_at() {
			return updated_at;
		}

		public void setUpdated_at(Date updated_at) {
			this.updated_at = updated_at;
		}

	}

}

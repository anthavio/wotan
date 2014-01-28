package net.anthavio.wotan.client.clan;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import net.anthavio.wotan.client.JacksonDeserializers.WotDateDeserializer;
import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * 
 * @author martin.vanek
 *
 */
public class MembersInfoResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, Member> data;

	public Map<Long, Member> getData() {
		return data;
	}

	public void setData(Map<Long, Member> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class Member implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long clan_id;

		private String clan_name;

		private String role;

		private String role_i18n;

		@JsonDeserialize(using = WotDateDeserializer.class)
		private Date since;

		public Long getClan_id() {
			return clan_id;
		}

		public void setClan_id(Long clan_id) {
			this.clan_id = clan_id;
		}

		public String getClan_name() {
			return clan_name;
		}

		public void setClan_name(String clan_name) {
			this.clan_name = clan_name;
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

		public Date getSince() {
			return since;
		}

		public void setSince(Date since) {
			this.since = since;
		}

	}

}

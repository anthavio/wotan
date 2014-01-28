package net.anthavio.wotan.client.encyclopedia;

import java.io.Serializable;
import java.util.Map;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class VehiclesResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, Vehicle> data;

	public Map<Long, Vehicle> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class Vehicle implements Serializable {

		private static final long serialVersionUID = 1L;

		private Boolean is_premium;

		private Integer level;

		private String name;

		private String name_i18n;

		private String nation;

		private String nation_i18n;

		private Long tank_id;

		private String type;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

		public Boolean getIs_premium() {
			return is_premium;
		}

		public void setIs_premium(Boolean is_premium) {
			this.is_premium = is_premium;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName_i18n() {
			return name_i18n;
		}

		public void setName_i18n(String name_i18n) {
			this.name_i18n = name_i18n;
		}

		public String getNation() {
			return nation;
		}

		public void setNation(String nation) {
			this.nation = nation;
		}

		public String getNation_i18n() {
			return nation_i18n;
		}

		public void setNation_i18n(String nation_i18n) {
			this.nation_i18n = nation_i18n;
		}

		public Long getTank_id() {
			return tank_id;
		}

		public void setTank_id(Long tank_id) {
			this.tank_id = tank_id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}
}

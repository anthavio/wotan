package net.anthavio.wotan.client.encyclopedia;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class VehicleInfoResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map<Long, VehicleInfo> data;

	public Map<Long, VehicleInfo> getData() {
		return data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class VehicleModule implements Serializable {

		private static final long serialVersionUID = 1L;

		private Boolean is_default;

		private Long module_id;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

		public Boolean getIs_default() {
			return is_default;
		}

		public void setIs_default(Boolean is_default) {
			this.is_default = is_default;
		}

		public Long getModule_id() {
			return module_id;
		}

		public void setModule_id(Long module_id) {
			this.module_id = module_id;
		}

	}

	public static class CrewRole implements Serializable {

		private static final long serialVersionUID = 1L;

		private String role;

		private String role_i18n;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
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
	}

	public static class VehicleCrewMember extends CrewRole {

		private List<CrewRole> additional_roles_i18n;

		public List<CrewRole> getAdditional_roles_i18n() {
			return additional_roles_i18n;
		}

		public void setAdditional_roles_i18n(List<CrewRole> additional_roles_i18n) {
			this.additional_roles_i18n = additional_roles_i18n;
		}

	}

	public static class VehicleInfo implements Serializable {

		private static final long serialVersionUID = 1L;

		private Integer chassis_rotation_speed;

		private Integer circular_vision_radius;

		private String contour_image;

		private Integer engine_power;

		private Integer gun_damage_max;

		private Integer gun_damage_min;

		private Integer gun_max_ammo;

		private String gun_name;

		private Integer gun_piercing_power_max;

		private Integer gun_piercing_power_min;

		private Float gun_rate;

		private String image;

		private String image_small;

		private Boolean is_gift;

		private Integer level;

		private Float limit_weight;

		private String localized_name;

		private Integer max_health;

		private String name;

		private String name_i18n;

		private String nation;

		private String nation_i18n;

		private Integer price_credit;
		private Integer price_gold;
		private Integer radio_distance;

		private Float speed_limit;

		private Long tank_id;

		private Integer turret_armor_board;
		private Integer turret_armor_fedd;
		private Integer turret_armor_forehead;
		private Integer turret_rotation_speed;

		private String type;

		private Integer vehicle_armor_board;
		private Integer vehicle_armor_fedd;
		private Integer vehicle_armor_forehead;

		@Deprecated
		private List<Long> parent_tanks;

		@Deprecated
		private Integer price_xp;

		private Integer weight;

		private List<VehicleCrewMember> crew;

		private List<VehicleModule> chassis;

		private List<VehicleModule> engines;

		private List<VehicleModule> guns;

		private List<VehicleModule> radios;

		private List<VehicleModule> turrets;

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

		public Integer getChassis_rotation_speed() {
			return chassis_rotation_speed;
		}

		public void setChassis_rotation_speed(Integer chassis_rotation_speed) {
			this.chassis_rotation_speed = chassis_rotation_speed;
		}

		public Integer getCircular_vision_radius() {
			return circular_vision_radius;
		}

		public void setCircular_vision_radius(Integer circular_vision_radius) {
			this.circular_vision_radius = circular_vision_radius;
		}

		public String getContour_image() {
			return contour_image;
		}

		public void setContour_image(String contour_image) {
			this.contour_image = contour_image;
		}

		public Integer getEngine_power() {
			return engine_power;
		}

		public void setEngine_power(Integer engine_power) {
			this.engine_power = engine_power;
		}

		public Integer getGun_damage_max() {
			return gun_damage_max;
		}

		public void setGun_damage_max(Integer gun_damage_max) {
			this.gun_damage_max = gun_damage_max;
		}

		public Integer getGun_damage_min() {
			return gun_damage_min;
		}

		public void setGun_damage_min(Integer gun_damage_min) {
			this.gun_damage_min = gun_damage_min;
		}

		public Integer getGun_max_ammo() {
			return gun_max_ammo;
		}

		public void setGun_max_ammo(Integer gun_max_ammo) {
			this.gun_max_ammo = gun_max_ammo;
		}

		public String getGun_name() {
			return gun_name;
		}

		public void setGun_name(String gun_name) {
			this.gun_name = gun_name;
		}

		public Integer getGun_piercing_power_max() {
			return gun_piercing_power_max;
		}

		public void setGun_piercing_power_max(Integer gun_piercing_power_max) {
			this.gun_piercing_power_max = gun_piercing_power_max;
		}

		public Integer getGun_piercing_power_min() {
			return gun_piercing_power_min;
		}

		public void setGun_piercing_power_min(Integer gun_piercing_power_min) {
			this.gun_piercing_power_min = gun_piercing_power_min;
		}

		public Float getGun_rate() {
			return gun_rate;
		}

		public void setGun_rate(Float gun_rate) {
			this.gun_rate = gun_rate;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getImage_small() {
			return image_small;
		}

		public void setImage_small(String image_small) {
			this.image_small = image_small;
		}

		public Boolean getIs_gift() {
			return is_gift;
		}

		public void setIs_gift(Boolean is_gift) {
			this.is_gift = is_gift;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public Float getLimit_weight() {
			return limit_weight;
		}

		public void setLimit_weight(Float limit_weight) {
			this.limit_weight = limit_weight;
		}

		public String getLocalized_name() {
			return localized_name;
		}

		public void setLocalized_name(String localized_name) {
			this.localized_name = localized_name;
		}

		public Integer getMax_health() {
			return max_health;
		}

		public void setMax_health(Integer max_health) {
			this.max_health = max_health;
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

		public Integer getPrice_credit() {
			return price_credit;
		}

		public void setPrice_credit(Integer price_credit) {
			this.price_credit = price_credit;
		}

		public Integer getPrice_gold() {
			return price_gold;
		}

		public void setPrice_gold(Integer price_gold) {
			this.price_gold = price_gold;
		}

		public Integer getRadio_distance() {
			return radio_distance;
		}

		public void setRadio_distance(Integer radio_distance) {
			this.radio_distance = radio_distance;
		}

		public Float getSpeed_limit() {
			return speed_limit;
		}

		public void setSpeed_limit(Float speed_limit) {
			this.speed_limit = speed_limit;
		}

		public Long getTank_id() {
			return tank_id;
		}

		public void setTank_id(Long tank_id) {
			this.tank_id = tank_id;
		}

		public Integer getTurret_armor_board() {
			return turret_armor_board;
		}

		public void setTurret_armor_board(Integer turret_armor_board) {
			this.turret_armor_board = turret_armor_board;
		}

		public Integer getTurret_armor_fedd() {
			return turret_armor_fedd;
		}

		public void setTurret_armor_fedd(Integer turret_armor_fedd) {
			this.turret_armor_fedd = turret_armor_fedd;
		}

		public Integer getTurret_armor_forehead() {
			return turret_armor_forehead;
		}

		public void setTurret_armor_forehead(Integer turret_armor_forehead) {
			this.turret_armor_forehead = turret_armor_forehead;
		}

		public Integer getTurret_rotation_speed() {
			return turret_rotation_speed;
		}

		public void setTurret_rotation_speed(Integer turret_rotation_speed) {
			this.turret_rotation_speed = turret_rotation_speed;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Integer getVehicle_armor_board() {
			return vehicle_armor_board;
		}

		public void setVehicle_armor_board(Integer vehicle_armor_board) {
			this.vehicle_armor_board = vehicle_armor_board;
		}

		public Integer getVehicle_armor_fedd() {
			return vehicle_armor_fedd;
		}

		public void setVehicle_armor_fedd(Integer vehicle_armor_fedd) {
			this.vehicle_armor_fedd = vehicle_armor_fedd;
		}

		public Integer getVehicle_armor_forehead() {
			return vehicle_armor_forehead;
		}

		public void setVehicle_armor_forehead(Integer vehicle_armor_forehead) {
			this.vehicle_armor_forehead = vehicle_armor_forehead;
		}

		public List<Long> getParent_tanks() {
			return parent_tanks;
		}

		public void setParent_tanks(List<Long> parent_tanks) {
			this.parent_tanks = parent_tanks;
		}

		public Integer getPrice_xp() {
			return price_xp;
		}

		public void setPrice_xp(Integer price_xp) {
			this.price_xp = price_xp;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public List<VehicleCrewMember> getCrew() {
			return crew;
		}

		public void setCrew(List<VehicleCrewMember> crew) {
			this.crew = crew;
		}

		public List<VehicleModule> getChassis() {
			return chassis;
		}

		public void setChassis(List<VehicleModule> chassis) {
			this.chassis = chassis;
		}

		public List<VehicleModule> getEngines() {
			return engines;
		}

		public void setEngines(List<VehicleModule> engines) {
			this.engines = engines;
		}

		public List<VehicleModule> getGuns() {
			return guns;
		}

		public void setGuns(List<VehicleModule> guns) {
			this.guns = guns;
		}

		public List<VehicleModule> getRadios() {
			return radios;
		}

		public void setRadios(List<VehicleModule> radios) {
			this.radios = radios;
		}

		public List<VehicleModule> getTurrets() {
			return turrets;
		}

		public void setTurrets(List<VehicleModule> turrets) {
			this.turrets = turrets;
		}

	}
}

package net.anthavio.wotan.client.ratings;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * 
 * @author martin.vanek
 *
 */
public enum RatingType {

	DAY("1"), WEEK("7"), MONTH("28"), ALL("all");

	private final String code;

	private RatingType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	//When toString returns JSON value, we can use ObjectMapper.enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING)
	//@JsonCreator is another way...
	@Override
	public String toString() {
		return name() + "(" + code + ")";
	}

	@JsonCreator
	public static RatingType getEnum(String value) {
		if (DAY.code.equals(value)) {
			return DAY;
		} else if (WEEK.code.equals(value)) {
			return WEEK;
		} else if (MONTH.code.equals(value)) {
			return MONTH;
		} else if (ALL.code.equals(value)) {
			return ALL;
		} else {
			throw new IllegalArgumentException("Unknown code " + value);
		}
	}
}

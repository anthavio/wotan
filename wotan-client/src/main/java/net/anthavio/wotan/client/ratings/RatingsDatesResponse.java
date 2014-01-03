package net.anthavio.wotan.client.ratings;

import java.util.Map;

import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class RatingsDatesResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Map data;

	public Map getData() {
		return data;
	}

}

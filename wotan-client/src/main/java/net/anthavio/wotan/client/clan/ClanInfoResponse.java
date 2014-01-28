package net.anthavio.wotan.client.clan;

import java.util.List;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class ClanInfoResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private List<Clan> data;

	public List<Clan> getData() {
		return data;
	}

	public void setData(List<Clan> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

}

package net.anthavio.wotan.client.clan;

import java.util.List;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/clan/info/
 * 
 * @author martin.vanek
 *
 */
public class ClanInfoRequest extends WotanRequest<ClanInfoRequest, ClanInfoResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<ClanInfoResponse> config = //
	MethodConfig.GET("/wot/clan/info/", ClanInfoResponse.class);

	private List<Long> clan_ids;

	private String access_token;

	public ClanInfoRequest(WotanClient client, long clan_id, long... additional_ids) {
		super(config, client);
		this.clan_ids = toList(clan_id, additional_ids);
	}

	public void addClanId(long clan_id) {
		clan_ids.add(clan_id);
	}

	public List<Long> getClanIds() {
		return clan_ids;
	}

	public String getAccessToken() {
		return access_token;
	}

	public ClanInfoRequest setAccessToken(String access_token) {
		this.access_token = access_token;
		return getSelf();
	}

	@Override
	protected ClanInfoRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		request.addParameter("clan_id", toIdList(clan_ids));

		if (access_token != null) {
			request.addParameter("access_token", access_token);
		}

	}

}

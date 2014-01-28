package net.anthavio.wotan.client.clan;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/clan/top/
 * 
 * @author martin.vanek
 *
 */
public class TopClansRequest extends WotanRequest<TopClansRequest, ClanInfoResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<ClanInfoResponse> config = //
	MethodConfig.GET("/wot/clan/top/", ClanInfoResponse.class);

	public static enum TimeDelta {
		current_season, current_step;
	}

	private TimeDelta time;

	public TopClansRequest(WotanClient client) {
		super(config, client);
	}

	public TimeDelta getTime() {
		return time;
	}

	public TopClansRequest setTime(TimeDelta time) {
		this.time = time;
		return getSelf();
	}

	@Override
	protected TopClansRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		if (time != null) {
			request.addParameter("time", time);
		}

	}

}

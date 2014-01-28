package net.anthavio.wotan.client.encyclopedia;

import java.util.List;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * 
 * https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tankinfo/
 * 
 * @author martin.vanek
 *
 */
public class VehicleInfoRequest extends WotanRequest<VehicleInfoRequest, VehicleInfoResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<VehicleInfoResponse> config = MethodConfig.GET("/wot/encyclopedia/tankinfo/",
			VehicleInfoResponse.class);

	private List<Long> tank_ids;

	public VehicleInfoRequest(WotanClient client, long tank_id, long... tank_ids) {
		super(config, client);
		this.tank_ids = toList(tank_id, tank_ids);
	}

	@Override
	protected VehicleInfoRequest getSelf() {
		return this;
	}

	public VehicleInfoRequest addTankId(long tank_id) {
		this.tank_ids.add(tank_id);
		return getSelf();
	}

	@Override
	protected void addParameters(SenderRequest request) {
		request.addParameter("tank_id", toIdList(tank_ids));
	}

}

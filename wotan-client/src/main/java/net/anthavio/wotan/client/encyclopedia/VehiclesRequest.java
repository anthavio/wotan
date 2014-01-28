package net.anthavio.wotan.client.encyclopedia;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * 
 * https://eu.wargaming.net/developers/api_reference/wot/encyclopedia/tanks/
 * 
 * @author martin.vanek
 *
 */
public class VehiclesRequest extends WotanRequest<VehiclesRequest, VehiclesResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<VehiclesResponse> config = MethodConfig.GET("/wot/encyclopedia/tanks/",
			VehiclesResponse.class);

	public VehiclesRequest(WotanClient client) {
		super(config, client);
	}

	@Override
	protected VehiclesRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {

	}

}

package net.anthavio.wotan.client.ratings;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanRequest;

/**
 * 
 * @author martin.vanek
 *
 */
public class RatingsTypesRequest extends WotanRequest<RatingsTypesRequest, RatingsTypesResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<RatingsTypesResponse> config = MethodConfig.GET("/wot/ratings/types/",
			RatingsTypesResponse.class);

	public RatingsTypesRequest() {
		super(config);
	}

	@Override
	protected RatingsTypesRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		//no parameters
	}

}

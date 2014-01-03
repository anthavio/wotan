package net.anthavio.wotan.client.ratings;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanRequest;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/ratings/dates/
 * 
 * @author martin.vanek
 *
 */
public class RatingsDatesRequest extends WotanRequest<RatingsDatesRequest, RatingsDatesResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<RatingsDatesResponse> config = MethodConfig.GET("/wot/ratings/dates/",
			RatingsDatesResponse.class);

	private RatingType type;

	public RatingsDatesRequest(RatingType type) {
		super(config);
		this.type = type;
	}

	public RatingType getType() {
		return type;
	}

	public RatingsDatesRequest setType(RatingType type) {
		this.type = type;
		return getSelf();
	}

	@Override
	protected RatingsDatesRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		if (type == null) {
			throw new IllegalStateException("type not set");
		}
		request.addParameter("type", type.getCode());
	}

}

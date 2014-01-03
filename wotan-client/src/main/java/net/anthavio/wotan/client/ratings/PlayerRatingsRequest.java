package net.anthavio.wotan.client.ratings;

import java.util.Date;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.AuthenticatedRequest;

/**
 * 
 * https://eu.wargaming.net/developers/api_reference/wot/ratings/accounts/
 * 
 * @author martin.vanek
 *
 */
public class PlayerRatingsRequest extends AuthenticatedRequest<PlayerRatingsRequest, PlayerRatingsResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<PlayerRatingsResponse> config = MethodConfig.GET("/wot/ratings/accounts/",
			PlayerRatingsResponse.class);

	private RatingType type;

	private Date date;

	public PlayerRatingsRequest(long account_id, long... additional_ids) {
		super(config, account_id, additional_ids);
	}

	public RatingType getType() {
		return type;
	}

	public PlayerRatingsRequest setType(RatingType type) {
		this.type = type;
		return getSelf();
	}

	public Date getDate() {
		return date;
	}

	public PlayerRatingsRequest setDate(Date date) {
		this.date = date;
		return getSelf();
	}

	@Override
	protected PlayerRatingsRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		if (type == null) {
			throw new IllegalStateException("Type must be set");
		}
		request.addParameter("type", type.getCode());

		if (date != null) {
			request.addParameter("date", date.getTime() / 1000); //to seconds
		}
	}

}

package net.anthavio.wotan.client.ratings;

import java.util.Date;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.AuthenticatedRequest;
import net.anthavio.wotan.client.WotanClient;

/**
 * 
 * https://eu.wargaming.net/developers/api_reference/wot/ratings/neighbors/
 * 
 * @author martin.vanek
 *
 */
public class NeighborsRatingsRequest extends AuthenticatedRequest<NeighborsRatingsRequest, NeighborsRatingsResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<NeighborsRatingsResponse> config = MethodConfig.GET("/wot/ratings/neighbors/",
			NeighborsRatingsResponse.class);

	private RatingType type;

	private String rank_field;

	private Date date;

	private Integer limit;

	public NeighborsRatingsRequest(WotanClient client, long account_id, long... additional_ids) {
		super(config, client, account_id, additional_ids);
	}

	public RatingType getType() {
		return type;
	}

	public NeighborsRatingsRequest setType(RatingType type) {
		this.type = type;
		return getSelf();
	}

	public Date getDate() {
		return date;
	}

	public NeighborsRatingsRequest setDate(Date date) {
		this.date = date;
		return getSelf();
	}

	public String getRankField() {
		return rank_field;
	}

	public NeighborsRatingsRequest setRankField(String rank_field) {
		this.rank_field = rank_field;
		return getSelf();
	}

	public Integer getLimit() {
		return limit;
	}

	public NeighborsRatingsRequest setLimit(Integer limit) {
		this.limit = limit;
		return getSelf();
	}

	@Override
	protected NeighborsRatingsRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		if (type == null) {
			throw new IllegalStateException("Type must be set");
		}
		request.addParameter("type", type.getCode());

		if (rank_field == null) {
			throw new IllegalStateException("rank_field must be set");
		}
		request.addParameter("rank_field", rank_field);

		if (date != null) {
			request.addParameter("date", date.getTime() / 1000); //to seconds
		}
	}

}

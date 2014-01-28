package net.anthavio.wotan.client.ratings;

import java.util.Date;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * 
 * https://eu.wargaming.net/developers/api_reference/wot/ratings/top/
 * 
 * @author martin.vanek
 *
 */
public class TopRatingsRequest extends WotanRequest<TopRatingsRequest, TopRatingsResponse> {

	private static final long serialVersionUID = 1L;

	public static MethodConfig<TopRatingsResponse> config = MethodConfig.GET("/wot/ratings/top/",
			TopRatingsResponse.class);

	private RatingType type;

	private RankField rank_field;

	private Date date;

	private Integer limit;

	public TopRatingsRequest(WotanClient client) {
		super(config, client);
	}

	public RatingType getType() {
		return type;
	}

	public TopRatingsRequest setType(RatingType type) {
		this.type = type;
		return getSelf();
	}

	public Date getDate() {
		return date;
	}

	public TopRatingsRequest setDate(Date date) {
		this.date = date;
		return getSelf();
	}

	public RankField getRankField() {
		return rank_field;
	}

	public TopRatingsRequest setRankField(RankField rank_field) {
		this.rank_field = rank_field;
		return getSelf();
	}

	public Integer getLimit() {
		return limit;
	}

	public TopRatingsRequest setLimit(Integer limit) {
		this.limit = limit;
		return getSelf();
	}

	@Override
	protected TopRatingsRequest getSelf() {
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

		if (limit != null) {
			request.addParameter("limit", limit);
		}
	}

}

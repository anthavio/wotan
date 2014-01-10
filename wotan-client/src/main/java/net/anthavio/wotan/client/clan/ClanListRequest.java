package net.anthavio.wotan.client.clan;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

import org.apache.commons.lang.StringUtils;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/clan/list/
 * 
 * @author martin.vanek
 *
 */
public class ClanListRequest extends WotanRequest<ClanListRequest, ClanListResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<ClanListResponse> config = //
	MethodConfig.GET("/wot/clan/list/", ClanListResponse.class);

	private String search;

	private Integer limit;

	//TODO private 

	public ClanListRequest(WotanClient client, String search) {
		super(config, client);
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

	public ClanListRequest setSearch(String search) {
		this.search = search;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public ClanListRequest setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	@Override
	protected ClanListRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {
		if (StringUtils.isBlank(search)) {
			throw new IllegalArgumentException("Blank search");
		}
		if (search.length() < 3) {
			throw new IllegalArgumentException("search must be at least 3 characters long: '" + search + "'");
		}
		request.addParameter("search", search);

		if (limit != null) {
			request.addParameter("limit", limit.intValue());
		}

	}

}

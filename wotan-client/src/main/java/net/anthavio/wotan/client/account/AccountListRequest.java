package net.anthavio.wotan.client.account;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

import org.apache.commons.lang.StringUtils;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/list/
 * 
 * @author martin.vanek
 *
 */
public class AccountListRequest extends WotanRequest<AccountListRequest, AccountListResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<AccountListResponse> config = //
	MethodConfig.GET("/wot/account/list/", AccountListResponse.class);

	private String search;

	private Integer limit;

	public AccountListRequest(WotanClient client, String search) {
		super(config, client);
		this.search = search;
	}

	public String getSearch() {
		return search;
	}

	public AccountListRequest setSearch(String search) {
		this.search = search;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public AccountListRequest setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	@Override
	protected AccountListRequest getSelf() {
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

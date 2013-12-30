package net.anthavio.wotan.client.account;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.SenderRequest.Method;
import net.anthavio.wotan.client.AbstractRequest;

import org.apache.commons.lang.StringUtils;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/account/list/
 * 
 * @author martin.vanek
 *
 */
public class AccountListRequest extends AbstractRequest {

	private static final long serialVersionUID = 1L;

	private String search;

	private Integer limit;

	private String[] fields;

	public AccountListRequest(String search) {
		this.search = search;
	}

	public String getUrlPath() {
		return "/wot/account/list/";
	}

	@Override
	public SenderRequest toSenderRequest() {
		SenderRequest request = new SenderRequest(Method.GET, getUrlPath());
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

		if (fields != null && fields.length != 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < fields.length; i++) {
				sb.append(fields[i]);
				if (i < fields.length - 1) {
					sb.append(',');
				}
			}
		}
		return request;
	}

}

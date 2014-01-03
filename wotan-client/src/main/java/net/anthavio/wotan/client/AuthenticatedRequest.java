package net.anthavio.wotan.client;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.httl.rest.MethodConfig.ClientAuth;

/**
 * There is small mismatch, because not ALL methods with account_id also needs access_token, but...laziness is stronger
 * 
 * @author martin.vanek
 *
 */
public abstract class AuthenticatedRequest<B extends AuthenticatedRequest<?, R>, R extends WotanResponse> extends
		WotanRequest<B, R> {

	private static final long serialVersionUID = 1L;

	private String access_token;

	private long account_id;

	private long[] additional_ids;

	/*
	public AuthenticatedRequest(MethodConfig<R> config) {
		super(config);
	}
	*/

	public AuthenticatedRequest(MethodConfig<R> config, long[] account_ids) {
		super(config);

		if (account_ids == null || account_ids.length == 0) {
			throw new IllegalArgumentException("Empty account id array");
		} else if (account_ids.length == 1) {
			this.account_id = account_ids[0];
		} else {
			this.account_id = account_ids[0];
			this.additional_ids = new long[account_ids.length - 1];
			System.arraycopy(account_ids, 1, additional_ids, 0, additional_ids.length);
		}
	}

	public AuthenticatedRequest(MethodConfig<R> config, long account_id, long... additional_ids) {
		super(config);
		this.account_id = account_id;
		this.additional_ids = additional_ids;
	}

	public String getAccessToken() {
		return access_token;
	}

	public B setAccessToken(String access_token) {
		this.access_token = access_token;
		return getSelf();
	}

	public Long getAccountId() {
		return account_id;
	}

	public B setAccountId(Long account_id) {
		this.account_id = account_id;
		return getSelf();
	}

	public long[] getAdditionalIds() {
		return additional_ids;
	}

	public void setAdditionalIds(long[] additional_ids) {
		this.additional_ids = additional_ids;
	}

	public SenderRequest buildRequest() {
		SenderRequest request = super.buildRequest();

		if (access_token != null && access_token.length() != 0) {
			request.addParameter("access_token", access_token);
		} else {
			if (getConfig().getAuthentication() == ClientAuth.REQUIRED) {
				throw new IllegalStateException("access_token is required for " + getConfig().getUrlPath());
			}
		}

		if (additional_ids != null && additional_ids.length != 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(account_id).append(',');

			for (int i = 0; i < additional_ids.length; i++) {
				sb.append(additional_ids[i]);
				if (i < additional_ids.length - 1) {
					sb.append(',');
				}
			}
			request.addParameter("account_id", sb.toString());
		} else {
			request.addParameter("account_id", account_id);
		}

		return request;
	}

}

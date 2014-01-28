package net.anthavio.wotan.client.clan;

import java.util.List;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanRequest;

/**
 * https://eu.wargaming.net/developers/api_reference/wot/clan/info/
 * 
 * @author martin.vanek
 *
 */
public class MembersInfoRequest extends WotanRequest<MembersInfoRequest, MembersInfoResponse> {

	private static final long serialVersionUID = 1L;

	public static final MethodConfig<MembersInfoResponse> config = //
	MethodConfig.GET("/wot/clan/membersinfo/", MembersInfoResponse.class);

	private List<Long> member_ids;

	private String access_token;

	public MembersInfoRequest(WotanClient client, long member_id, long... additional_ids) {
		super(config, client);
		member_ids = toList(member_id, additional_ids);
	}

	public void addMemberId(long member_id) {
		member_ids.add(member_id);
	}

	public List<Long> getMemberIds() {
		return member_ids;
	}

	public String getAccessToken() {
		return access_token;
	}

	public MembersInfoRequest setAccessToken(String access_token) {
		this.access_token = access_token;
		return getSelf();
	}

	@Override
	protected MembersInfoRequest getSelf() {
		return this;
	}

	@Override
	protected void addParameters(SenderRequest request) {

		request.addParameter("member_id", toIdList(member_ids));

		if (access_token != null) {
			request.addParameter("access_token", access_token);
		}

	}

}

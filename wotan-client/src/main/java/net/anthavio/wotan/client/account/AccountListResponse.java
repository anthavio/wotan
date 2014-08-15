package net.anthavio.wotan.client.account;

import java.util.List;

import net.anthavio.wotan.client.JsonStringBuilder;
import net.anthavio.wotan.client.WotanResponse;

/**
 * 
 * @author martin.vanek
 *
 */
public class AccountListResponse extends WotanResponse {

	private static final long serialVersionUID = 1L;

	private Integer count;

	private List<AccountStub> data;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<AccountStub> getData() {
		return data;
	}

	public void setData(List<AccountStub> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class AccountStub {

		private String nickname;

		private Long id;

		private Long account_id;

		public AccountStub() {
			//json
		}

		public AccountStub(Long account_id, String nickname) {
			this.account_id = account_id;
			this.nickname = nickname;
		}

		public String getNickname() {
			return nickname;
		}

		public void setNickname(String nickname) {
			this.nickname = nickname;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getAccount_id() {
			return account_id;
		}

		public void setAccount_id(Long account_id) {
			this.account_id = account_id;
		}

		@Override
		public String toString() {
			return JsonStringBuilder.toString(this, true);
		}

	}

}

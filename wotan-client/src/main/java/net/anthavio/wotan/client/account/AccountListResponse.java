package net.anthavio.wotan.client.account;

import java.util.List;

import net.anthavio.wotan.client.BasicResponse;
import net.anthavio.wotan.client.JsonStringBuilder;

/**
 * 
 * @author martin.vanek
 *
 */
public class AccountListResponse extends BasicResponse {

	private static final long serialVersionUID = 1L;

	private Integer count;

	private List<Account> data;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Account> getData() {
		return data;
	}

	public void setData(List<Account> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return JsonStringBuilder.toString(this, true);
	}

	public static class Account {

		private String nickname;

		private Long id;

		//private Long account_id; //same value as id

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

	}

}

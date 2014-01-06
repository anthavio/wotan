package net.anthavio.wotan.web.vaadin;

import net.anthavio.wotan.client.WotanClient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * Session data abstraction
 * 
 * @author martin.vanek
 *
 */
@Component
@Scope("session")
public class SessionData {

	private String account;

	private WotanClient wotanClient;

	public WotanClient initClient(String applicationId) {
		if (wotanClient != null) {
			wotanClient.close();
		}
		WotanClient wotanClient = new WotanClient(applicationId);
		//validate via executing rest call
		wotanClient.ratings().types();
		this.wotanClient = wotanClient;
		return wotanClient;
	}

	public WotanClient getClient() {
		return wotanClient;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

}

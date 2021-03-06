package net.anthavio.wotan.web;

import java.io.Serializable;

import net.anthavio.cache.CacheBase;
import net.anthavio.cache.impl.HeapMapCache;
import net.anthavio.httl.cache.CachedResponse;
import net.anthavio.wotan.client.WotanClient;
import net.anthavio.wotan.client.WotanSettings;
import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;

/**
 * 
 * Session data abstraction
 * 
 * @author martin.vanek
 *
 */
public class SessionData implements Serializable {

	private static final long serialVersionUID = 1L;

	private String accessToken;

	private AccountStub account;

	private transient WotanClient wotanClient;

	public WotanClient initClient(String applicationId, long cacheSeconds) {
		WotanClient wotanClient;
		WotanSettings settings = new WotanSettings(applicationId);
		if (cacheSeconds > 0) {
			settings.setCacheSeconds(cacheSeconds);
			CacheBase<CachedResponse> cache = new HeapMapCache<CachedResponse>();
			wotanClient = new WotanClient(settings, cache);
		} else {
			//do not use any caching then....
			wotanClient = new WotanClient(settings);
		}

		//validate via executing rest call
		wotanClient.ratings().types().getData();
		//if no exception is thrown....
		if (this.wotanClient != null) {
			//kill existing
			this.wotanClient.close();
		}

		this.wotanClient = wotanClient;
		return wotanClient;
	}

	public WotanClient getClient() {
		return wotanClient;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public AccountStub getAccount() {
		return account;
	}

	public void setAccount(AccountStub account) {
		this.account = account;
	}

}

package net.anthavio.wotan.client;

import java.net.MalformedURLException;
import java.net.URL;

import net.anthavio.wotan.client.WotanRequest.Language;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanSettings {

	private final String serverUrl;

	private final String applicationId;

	private Language language;

	private Long cacheSeconds;

	public WotanSettings(String serverUrl, String applicationId) {
		if (serverUrl == null || serverUrl.length() == 0) {
			throw new IllegalArgumentException("Blank serverUrl");
		}
		if (!serverUrl.startsWith("http")) {
			serverUrl = "http://" + serverUrl;
		}
		try {
			new URL(serverUrl);
		} catch (MalformedURLException mux) {
			throw new IllegalArgumentException("Invalid server url " + serverUrl, mux);
		}
		this.serverUrl = serverUrl;

		if (applicationId == null || applicationId.length() == 0) {
			throw new IllegalArgumentException("Blank applicationId");
		}
		this.applicationId = applicationId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Long getCacheSeconds() {
		return cacheSeconds;
	}

	public void setCacheSeconds(Long cacheSeconds) {
		this.cacheSeconds = cacheSeconds;
	}

	public WotanSettings(String applicationId) {
		this("http://api.worldoftanks.eu", applicationId);
	}

}

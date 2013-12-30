package net.anthavio.wotan.client;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanSettings {

	private final String baseUrl;

	private final String applicationId;

	public WotanSettings(String applicationId) {
		this("http://api.worldoftanks.eu", applicationId);
	}

	public WotanSettings(String baseUrl, String applicationId) {
		this.baseUrl = baseUrl;
		this.applicationId = applicationId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

}

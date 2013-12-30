package net.anthavio.wotan.client;

import java.io.IOException;

import net.anthavio.httl.HttpSender;
import net.anthavio.httl.HttpURLSender;
import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.SenderResponse;
import net.anthavio.wotan.client.BasicResponse.Status;
import net.anthavio.wotan.client.account.AccountGroup;
import net.anthavio.wotan.client.clan.ClanGroup;
import net.anthavio.wotan.client.encyclopedia.EncyclopediaGroup;
import net.anthavio.wotan.client.ratings.RatingsGroup;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanClient {

	private final WotanSettings settings;

	private final HttpSender sender;

	private final ObjectMapper mapper;

	public WotanClient(String applicationId) {
		this(new WotanSettings(applicationId));
	}

	public WotanClient(WotanSettings settings) {
		this.settings = settings;
		this.sender = new HttpURLSender(settings.getBaseUrl());
		this.mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public AccountGroup account() {
		return new AccountGroup(this);
	}

	public ClanGroup clan() {
		return new ClanGroup(this);
	}

	public EncyclopediaGroup encyclopedia() {
		return new EncyclopediaGroup(this);
	}

	public RatingsGroup ratings() {
		return new RatingsGroup(this);
	}

	public <T extends BasicResponse> T execute(AbstractRequest request, Class<T> responseClass) {
		SenderRequest sr = request.toSenderRequest();
		sr.addParameter("application_id", settings.getApplicationId());
		SenderResponse response = this.sender.execute(sr);
		try {
			T value = mapper.readValue(response.getStream(), responseClass);
			if (value.getStatus() == Status.error) {
				throw new WotanException(value.getError());
			}
			return value;
		} catch (IOException iox) {
			throw new WotanException(iox);
		}
	}
}

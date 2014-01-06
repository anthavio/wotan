package net.anthavio.wotan.client;

import java.io.Closeable;
import java.io.IOException;

import net.anthavio.httl.HttpSender;
import net.anthavio.httl.HttpURLSender;
import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.SenderResponse;
import net.anthavio.wotan.client.WotanResponse.Status;
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
public class WotanClient implements Closeable {

	private final WotanSettings settings;

	private final HttpSender sender;

	private final ObjectMapper mapper;

	public WotanClient(String applicationId) {
		this(new WotanSettings(applicationId));
	}

	public WotanClient(WotanSettings settings) {
		this(settings, new HttpURLSender(settings.getServerUrl()));
	}

	public WotanClient(WotanSettings settings, HttpSender sender) {
		if (settings == null) {
			throw new IllegalArgumentException("Null settings");
		}
		this.settings = settings;

		if (sender == null) {
			throw new IllegalArgumentException("Null sender");
		}
		this.sender = sender;

		this.mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//SimpleModule testModule = new SimpleModule("MyModule", new Version(1, 0, 0, null)).addDeserializer(MyType.class,
		//		new MyTypeDeserializer());
	}

	public WotanSettings getSettings() {
		return settings;
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

	public <T extends WotanResponse> T execute(WotanRequest<?, T> request) {
		SenderRequest sr = request.buildRequest();
		sr.addParameter("application_id", settings.getApplicationId());

		if (request.getLanguage() == null && settings.getLanguage() != null) {
			sr.addParameter("language", settings.getLanguage().getCode());
		}

		SenderResponse response = this.sender.execute(sr);

		try {
			T value = mapper.readValue(response.getStream(), request.getConfig().getResponseClass());
			if (value.getStatus() == Status.error) {
				throw new WotanException(value.getError());
			}
			return value;
		} catch (IOException iox) {
			throw new WotanException(iox);
		}
	}

	public void close() {
		sender.close();
	}
}

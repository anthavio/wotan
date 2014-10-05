package net.anthavio.wotan.client;

import java.io.Closeable;
import java.lang.reflect.Array;

import net.anthavio.cache.CacheBase;
import net.anthavio.httl.HttlBuilderVisitor;
import net.anthavio.httl.HttlParameterSetter.ConfigurableParamSetter;
import net.anthavio.httl.HttlRequestBuilders.HttlRequestBuilder;
import net.anthavio.httl.HttlSender;
import net.anthavio.httl.HttlSender.Multival;
import net.anthavio.httl.SenderConfigurer;
import net.anthavio.httl.api.HttlApiBuilder;
import net.anthavio.httl.cache.CachedResponse;
import net.anthavio.httl.cache.CachingSender;
import net.anthavio.httl.marshall.Jackson2Unmarshaller;
import net.anthavio.httl.transport.HttpUrlConfig;
import net.anthavio.wotan.client.auth.AuthHelper;
import net.anthavio.wotan.client.clan.ClanGroup;
import net.anthavio.wotan.client.encyclopedia.EncyclopediaGroup;
import net.anthavio.wotan.client.ratings.RatingsGroup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * http://eu.wargaming.net/developers/
 * 
 * http://eu.wargaming.net/developers/api_reference/wot/
 * 
 * @author martin.vanek
 *
 */
public class WotanClient implements Closeable {

	private static final Logger logger = LoggerFactory.getLogger(WotanClient.class);

	private final WotanSettings settings;

	private final HttlSender sender;

	private final CachingSender cachingSender;

	private final ObjectMapper mapper;

	private final ApiAccounts accountsApi;

	public WotanClient(WotanSettings settings) {
		this(settings, new HttpUrlConfig(settings.getServerUrl()).sender(), null);
	}

	public WotanClient(WotanSettings settings, SenderConfigurer config) {
		this(settings, config, null);
	}

	public WotanClient(WotanSettings settings, CacheBase<CachedResponse> cache) {
		this(settings, new HttpUrlConfig(settings.getServerUrl()).sender(), cache);
	}

	public WotanClient(final WotanSettings settings, SenderConfigurer config, CacheBase<CachedResponse> cache) {
		if (settings == null) {
			throw new IllegalArgumentException("Null settings");
		}
		this.settings = settings;

		if (config == null) {
			throw new IllegalArgumentException("Null config");
		}

		config.setParamSetter(new ConfigurableParamSetter("yyyy-MM-dd HH:mm:ss.SSS")); //2010-06-01 12:21:47.000

		config.addBuilderVisitor(new HttlBuilderVisitor() {

			@Override
			public void visit(HttlRequestBuilder<?> builder) {
				builder.param("application_id", settings.getApplicationId());
			}
		});
		/*
				config.addExecutionFilter(new HttlExecutionFilter() {

					@Override
					public HttlResponse filter(HttlRequest request, HttlExecutionChain chain) throws IOException {

						HttlResponse response = chain.next(request);

						if (response.getHttpStatusCode() != 200) {
							Disqus.throwException(response, mapper);
						}
						return response;
					}
				});
				*/
		this.mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		//SimpleModule testModule = new SimpleModule("MyModule", new Version(1, 0, 0, null)).addDeserializer(MyType.class,
		//		new MyTypeDeserializer());

		Jackson2Unmarshaller jackson = new Jackson2Unmarshaller(mapper);
		config.setUnmarshaller(jackson);

		//WOT uses comma sparated string for multiple values
		config.setParamSetter(new ConfigurableParamSetter() {

			@Override
			protected void array(Multival<String> parameters, boolean reset, String paramName, Object array) {
				int length = Array.getLength(array);
				if (length != 0) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < length; i++) {
						Object element = Array.get(array, i);
						sb.append(element);
						sb.append(",");
					}
					parameters.set(paramName, sb.toString());
				}
			}

		});
		this.sender = config.build();

		this.accountsApi = HttlApiBuilder.build(ApiAccounts.class, sender);

		if (cache != null) {
			cachingSender = new CachingSender(sender, cache);
		} else {
			cachingSender = null;
		}
	}

	public CacheBase<CachedResponse> getCache() {
		if (cachingSender != null) {
			return cachingSender.getCache();
		} else {
			return null;
		}
	}

	public void close() {
		if (cachingSender != null) {
			cachingSender.close();
		} else {
			sender.close();
		}
	}

	public WotanSettings getSettings() {
		return settings;
	}

	public ApiAccounts accounts() {
		return accountsApi;
	}

	public AuthHelper authentication() {
		return new AuthHelper(this);
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
	/*
		public <T extends WotanResponse> T execute(WotanRequest<?, T> request) {
			SenderRequest sr = request.buildRequest();
			sr.addParameter("application_id", settings.getApplicationId());

			if (request.getLanguage() == null && settings.getLanguage() != null) {
				sr.addParameter("language", settings.getLanguage().getCode());
			}

			SenderResponse response;
			if (cachingSender != null) {

				Long cacheSeconds = request.getCacheSeconds();
				if (cacheSeconds == null) {
					cacheSeconds = settings.getCacheSeconds();
				}
				if (cacheSeconds == null) {
					cacheSeconds = 10 * 60l;
				}
				response = this.cachingSender.from(sr).evictTtl(cacheSeconds, TimeUnit.SECONDS).execute();
			} else {
				if (request.getCacheSeconds() != null || settings.getCacheSeconds() != null) {
					logger.warn("Cache is not configured, setting cache time is futile.");
				}
				response = this.sender.execute(sr);
			}

			try {
				T value = mapper.readValue(response.getReader(), request.getConfig().getResponseClass());
				if (value.getStatus() == Status.error) {
					throw new WotanException(value.getError());
				}
				return value;
			} catch (IOException iox) {
				throw new WotanException(iox);
			}
		}
	*/
}

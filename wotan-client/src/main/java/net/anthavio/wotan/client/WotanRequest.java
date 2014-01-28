package net.anthavio.wotan.client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import net.anthavio.httl.SenderRequest;
import net.anthavio.httl.rest.MethodConfig;

/**
 * @author martin.vanek
 * 
 * @param <B> - generic self
 * @param <R> - response type
 */
public abstract class WotanRequest<B extends WotanRequest<?, R>, R extends WotanResponse> implements Serializable {

	private static final long serialVersionUID = 1L;

	public static enum Language {
		en("en"), ru("ru"), pl("pl"), //
		de("de"), fr("fr"), es("es"), //
		zh_cn("zh-cn"), it("it"), tr("tr"), //
		cs("cs"), hu("hu"), th("th"), //
		ms("ms"), vi("vi");

		private final String code;

		private Language(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

	}

	private final MethodConfig<R> config;

	private final WotanClient client;

	private Language language;

	private String[] fields;

	private Long cacheSeconds;

	public WotanRequest(MethodConfig<R> config, WotanClient client) {
		if (config == null) {
			throw new IllegalArgumentException("Null config");
		}
		this.config = config;

		if (client == null) {
			throw new IllegalArgumentException("Null client");
		}
		this.client = client;
	}

	public R execute() {
		return client.execute(this);
	}

	public MethodConfig<R> getConfig() {
		return config;
	}

	protected abstract B getSelf(); //Generic self

	public Language getLanguage() {
		return language;
	}

	public B setLanguage(Language language) {
		this.language = language;
		return getSelf();
	}

	public String[] getFields() {
		return fields;
	}

	public B setFields(String[] fields) {
		this.fields = fields;
		return getSelf();
	}

	public B setCache(int value, TimeUnit unit) {
		this.cacheSeconds = unit.toSeconds(value);
		return getSelf();
	}

	public Long getCacheSeconds() {
		return this.cacheSeconds;
	}

	public SenderRequest buildRequest() {
		SenderRequest request = config.buildRequest();
		addParameters(request);

		if (language != null) {
			request.addParameter("language", language.getCode());
		}

		if (fields != null && fields.length != 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < fields.length; i++) {
				sb.append(fields[i]);
				if (i < fields.length - 1) {
					sb.append(',');
				}
			}
		}

		return request;
	}

	protected abstract void addParameters(SenderRequest request);

	public static String toIdList(long first, long[] others) {
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		if (others != null && others.length != 0) {
			sb.append(',');
			for (int i = 0; i < others.length; ++i) {
				long o = others[i];
				sb.append(o);
				if (i < others.length - 1) {
					sb.append(',');
				}
			}
		}
		return sb.toString();
	}

	public static String toIdList(List<?> ids) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ids.size(); ++i) {
			Object id = ids.get(i);
			sb.append(id);
			if (i < ids.size() - 1) {
				sb.append(',');
			}
		}
		return sb.toString();
	}

	public static List<Long> toList(long first, long... others) {
		ArrayList<Long> list = new ArrayList<Long>();
		list.add(first);
		if (others != null && others.length != 0) {
			for (long id : others) {
				list.add(id);
			}
		}
		return list;
	}

}

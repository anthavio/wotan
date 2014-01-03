package net.anthavio.wotan.client;

import java.io.Serializable;

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

	private Language language;

	private String[] fields;

	public WotanRequest(MethodConfig<R> config) {
		this.config = config;
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

}

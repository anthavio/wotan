package net.anthavio.wotan.client;

import java.io.Serializable;

import net.anthavio.httl.SenderRequest;

/**
 * 
 * @author martin.vanek
 *
 */
public abstract class AbstractRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Language language;

	public static enum Language {
		en("en"), ru("ru"), pl("pl"), de("de"), fr("fr"), es("es"), zh_cn("zh-cn"), it("it"), tr("tr"), cs("cs"), hu("hu"), th(
				"th"), ms("ms"), vi("vi");

		private final String code;

		private Language(String code) {
			this.code = code;
		}

		public String getCode() {
			return code;
		}

	}

	public abstract SenderRequest toSenderRequest();

}

package net.anthavio.wotan.client;

/**
 * 
 * @author vanek
 *
 */
public enum WotanLanguage {

	en("en"), ru("ru"), pl("pl"), //
	de("de"), fr("fr"), es("es"), //
	zh_cn("zh-cn"), it("it"), tr("tr"), //
	cs("cs"), hu("hu"), th("th"), //
	ms("ms"), vi("vi");

	private final String code;

	private WotanLanguage(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}

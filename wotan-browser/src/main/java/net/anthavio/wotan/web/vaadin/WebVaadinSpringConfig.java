package net.anthavio.wotan.web.vaadin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import ru.xpoft.vaadin.VaadinMessageSource;

/**
 * @author martin.vanek
 * 
 * Does not work because SpringVaadinServlet is using XmlWebApplicationContext which can be only initialized from xml
 */
//@Configuration
//@ComponentScan(value = "com.nature.npis.web.vaadin", excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
public class WebVaadinSpringConfig {

	@Bean
	public VaadinMessageSource VaadinMessageSource() {
		return new VaadinMessageSource();
	}

	public org.springframework.context.MessageSource MessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding("utf-8");
		messageSource.setFallbackToSystemLocale(false);
		messageSource.setBasename("classpath:/locales/messages");
		return messageSource;
	}
}

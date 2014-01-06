package net.anthavio.wotan.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Web application root spring config. Parent of all Vaadin or SpringMvc contexts.
 * 
 * @author martin.vanek
 *
 */
@Configuration
//@PropertySource("classpath:wotan.properties")
public class WebappSpringConfig {

	@Autowired
	private ServletContext servletContext;

	/**
	 * From @PropertySource("...") inject @Value("${...}")
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
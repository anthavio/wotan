package net.anthavio.wotan.web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.context.WebApplicationContext;

/**
 * Web application root spring config. Parent of all Vaadin or SpringMvc contexts.
 * 
 * @author martin.vanek
 *
 */
@Configuration
//@ComponentScan(basePackageClasses = WebappSpringConfig.class, excludeFilters = @ComponentScan.Filter(value = Configuration.class, type = FilterType.ANNOTATION))
//@PropertySource("classpath:wotan.properties")
public class WebappSpringConfig {

	@Autowired
	private ServletContext servletContext;

	private URL serverUrl;

	private URL webappUrl;

	private URL servletUrl;

	public void init(HttpServletRequest request) throws MalformedURLException {
		if (serverUrl == null) {
			if ((request.getScheme().equals("http") && request.getServerPort() != 80)
					|| (request.getScheme().equals("https") && request.getServerPort() != 443)) {
				serverUrl = new URL(request.getScheme(), request.getServerName(), request.getServerPort(), "/");
			} else {
				serverUrl = new URL(request.getScheme(), request.getServerName(), "/");
			}
			this.webappUrl = new URL(serverUrl, request.getContextPath());
			this.servletUrl = new URL(serverUrl, request.getContextPath() + request.getServletPath());
		}
	}

	public URL getServerUrl() {
		return serverUrl;
	}

	public URL getWebappUrl() {
		return webappUrl;
	}

	public URL getServletUrl() {
		return servletUrl;
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SessionData sessionData() {
		return new SessionData();
	}

	/**
	 * From @PropertySource("...") inject @Value("${...}")
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
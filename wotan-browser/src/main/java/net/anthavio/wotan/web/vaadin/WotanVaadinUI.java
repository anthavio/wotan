package net.anthavio.wotan.web.vaadin;

import net.anthavio.wotan.web.vaadin.view.SettingsView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.DiscoveryNavigator;

import com.vaadin.annotations.Title;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 * This is configured via SpringVaadinServlet inside web.xml 
 * @author martin.vanek
 *
 */
@Title("Wotan")
@Component("WotanVaadinUI")
@Scope("prototype")
//@Theme("myTheme")
public class WotanVaadinUI extends UI implements ErrorHandler, ViewChangeListener {
	/*
	static {
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();
	}
	*/
	private static final long serialVersionUID = 1L;

	@Autowired
	private transient ApplicationContext applicationContext;

	@Autowired
	private SessionData sessionData;

	@Override
	protected void init(final VaadinRequest request) {
		setSizeFull();
		//getSession().getConfiguration().getHeartbeatInterval()

		//DiscoveryNavigator automaticaly gathers Spring managed @VaadinView anotated Views  
		DiscoveryNavigator navigator = new DiscoveryNavigator(this, this);

		getSession().setErrorHandler(this);
		getNavigator().addViewChangeListener(this);
		//Notification.show(String.format("Session counter: %d, application counter: %d", sessionCounter.getCount(),
		//		applicationCounter.getCount()));

	}

	@Override
	public void error(com.vaadin.server.ErrorEvent event) {
		//Use event.getThrowable() to decide action to be taken
		DefaultErrorHandler.doDefault(event);
	}

	@Override
	public boolean beforeViewChange(ViewChangeEvent event) {
		boolean isLoggedIn = sessionData.getClient() != null;
		boolean isLoginView = event.getNewView() instanceof SettingsView;

		boolean allow;

		if (isLoggedIn) {
			if (isLoginView) {
				allow = true;//authenticated tries to view login view
			} else {
				allow = true; //authenticated view (access control logic could be here)
			}
		} else {
			if (isLoginView) {
				allow = true; //anonymous views login view
			} else {
				allow = false;//intercept view change
				getSession().setAttribute(SettingsView.VIEW_AFTER_LOGIN_KEY, event.getViewName());
				UI.getCurrent().getNavigator().navigateTo(SettingsView.NAME);
			}
		}

		return allow;
	}

	@Override
	public void afterViewChange(ViewChangeEvent event) {
		// nothing to do... 
	}

}

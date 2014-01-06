package net.anthavio.wotan.web.vaadin.view;

import javax.annotation.PostConstruct;

import net.anthavio.wotan.web.vaadin.SessionData;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Link;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author martin.vanek
 *
 */
@Component
@Scope("prototype")
@VaadinView(value = SettingsView.NAME, cached = true)
public class SettingsView extends Panel implements View {

	public static final String NAME = "Settings";

	private static final long serialVersionUID = 1L;

	public static final String VIEW_AFTER_LOGIN_KEY = "VIEW_AFTER_LOGIN";

	@Autowired
	private SessionData sessionData;

	TextField applicationId = new TextField("Application ID");
	Button button = new Button("Set");

	public SettingsView() {
		applicationId.setRequired(true);

		//https://eu.wargaming.net/developers/applications/
		VerticalLayout layout = new VerticalLayout();
		applicationId.setRequiredError("Please enter a Application ID");
		//applicationId.setWidth(COMMON_FIELD_WIDTH);
		//applicationId.addValidator(new EmailValidator("Not valid email"));
		applicationId.setNullRepresentation("");
		applicationId.setNullSettingAllowed(false);
		applicationId.setImmediate(true);
		applicationId
				.setDescription("Application ID is 32 characters long alphanumeric string. Standalone application type must be used");

		applicationId.setWidth("18em");
		applicationId.setMaxLength(32);

		applicationId.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				if (event.getText() != null && event.getText().length() == 32) {
					button.setEnabled(true);
				} else if (button.isEnabled()) {
					button.setEnabled(false);
				}
			}
		});

		Link link = new Link("My Applications", new ExternalResource("https://eu.wargaming.net/developers/applications/"));
		link.setDescription("Application are managed inside your Wargaming account");
		link.setTargetName("_blank");

		button.setEnabled(false);
		button.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String value = applicationId.getValue();
				if (!StringUtils.isEmpty(value)) {
					try {
						sessionData.initClient(value);
						Notification.show("Application ID is set correctly. Enjoy browsing!");
						String viewName = (String) getSession().getAttribute(VIEW_AFTER_LOGIN_KEY);
						if (viewName == null) {
							viewName = MainView.NAME;
						}
						getUI().getNavigator().navigateTo(viewName);
					} catch (final Exception x) {
						UserError error = new UserError(x.getMessage());//, ErrorLevel.WARNING);
						applicationId.setComponentError(error);
						Notification.show("Application ID is incorrect: " + x.getMessage());
					}
				}

			}
		});

		layout.addComponent(applicationId);
		layout.addComponent(button);
		layout.addComponent(link);
		setCaption("Settings");
		setContent(layout);
		setSizeFull();
	}

	@PostConstruct
	public void init() {

		/*
		Button apply = new Button("Save", new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent event) {
				try {
					fieldGroup.commit();
					Notification.show("OK");
				} catch (Exception e) {
					Notification.show("Error: " + e.getMessage(), Notification.Type.WARNING_MESSAGE);
				}
			}
		});
		*/

	}

	@Override
	public void enter(ViewChangeEvent event) {
		if (sessionData.getClient() != null) {
			applicationId.setValue(sessionData.getClient().getSettings().getApplicationId());
			applicationId.setComponentError(null);
			button.setEnabled(true);
		}
	}
}

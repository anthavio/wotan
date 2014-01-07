package net.anthavio.wotan.web.vaadin.view;

import javax.annotation.PostConstruct;

import net.anthavio.wotan.web.SessionData;
import net.anthavio.wotan.web.WebappSpringConfig;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.data.validator.IntegerRangeValidator;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
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

	private static final long serialVersionUID = 1L;

	public static final String NAME = "settings";

	public static final ExternalResource link = new ExternalResource("#!" + NAME);

	public static final String VIEW_AFTER_LOGIN_KEY = "VIEW_AFTER_LOGIN";

	@Autowired
	private SessionData sessionData;

	@Autowired
	private WebappSpringConfig config;

	Layout layApplication = new HorizontalLayout();
	TextField tfApplication = new TextField();
	Button setButton = new Button("Set");
	TextField tfCacheMinutes = new TextField();

	Layout layAccount = new HorizontalLayout();
	TextField tfAccessToken = new TextField();
	Link linkAuthentication = new Link("Authentication", null);

	Link linkMain = new Link("Main", new ExternalResource("#!" + MainView.NAME));

	public SettingsView() {

		Link linkApplication = new Link("Application", new ExternalResource(
				"https://eu.wargaming.net/developers/applications/"));
		linkApplication.setDescription("Application are managed inside your Wargaming account");
		linkApplication.setTargetName("_blank");

		tfApplication.setRequired(true);
		tfApplication.setRequiredError("Please enter a Application ID");
		//applicationId.setWidth(COMMON_FIELD_WIDTH);
		//applicationId.addValidator(new EmailValidator("Not valid email"));
		tfApplication.setNullRepresentation("");
		tfApplication.setNullSettingAllowed(false);
		tfApplication.setImmediate(true);
		tfApplication
				.setDescription("Application ID is 32 characters long alphanumeric string. Standalone type must be used, NOT server");

		tfApplication.setWidth("18em");
		tfApplication.setMaxLength(32);

		tfApplication.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				if (event.getText() != null && event.getText().length() == 32) {
					setButton.setEnabled(true);
				} else if (setButton.isEnabled()) {
					setButton.setEnabled(false);
				}
			}
		});

		tfCacheMinutes.setRequired(true);
		tfCacheMinutes.setValue("30");
		tfCacheMinutes.setConverter(Integer.class);
		tfCacheMinutes.addValidator(new IntegerRangeValidator("Only numbers from 1 to 60", 1, 60));
		tfCacheMinutes.setRequired(true);
		tfCacheMinutes.setImmediate(true);

		setButton.setEnabled(false);
		setButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String applicationId = tfApplication.getValue();
				if (!StringUtils.isEmpty(applicationId)) {
					try {
						long cacheMinutes = Long.parseLong(tfCacheMinutes.getValue());
						sessionData.initClient(applicationId, cacheMinutes * 60);
						Notification.show("Application ID is set correctly. Enjoy browsing!");
						String viewName = (String) getSession().getAttribute(VIEW_AFTER_LOGIN_KEY);
						if (viewName == null) {
							viewName = MainView.NAME;
						}
						getUI().getNavigator().navigateTo(viewName);
					} catch (final Exception x) {
						UserError error = new UserError(x.getMessage());//, ErrorLevel.WARNING);
						tfApplication.setComponentError(error);
						Notification.show("Application ID is incorrect: " + x.getMessage());
					}
				}

			}
		});

		linkApplication.setWidth("7em");
		layApplication.addComponent(linkApplication);
		layApplication.addComponent(tfApplication);
		layApplication.addComponent(tfCacheMinutes);
		layApplication.addComponent(setButton);

		linkAuthentication.setWidth("7em");
		layAccount.addComponent(linkAuthentication);
		layAccount.addComponent(tfAccessToken);

		tfAccessToken.setWidth("22em");
		tfAccessToken.setReadOnly(true);

		Layout layout = new VerticalLayout();
		layout.addComponent(layApplication);
		layout.addComponent(layAccount);
		layout.addComponent(linkMain);

		setCaption("Settings");
		setContent(layout);
		setSizeFull();
	}

	@PostConstruct
	public void init() {
		linkAuthentication.setResource(new ExternalResource(config.getWebappUrl() + "/oauth/request"));
		tfAccessToken.setReadOnly(false);
		tfAccessToken.setValue(sessionData.getAccessToken());
		tfAccessToken.setReadOnly(true);
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
			tfApplication.setValue(sessionData.getClient().getSettings().getApplicationId());
			tfApplication.setComponentError(null);
			setButton.setEnabled(true);
			layAccount.setVisible(true);
			linkMain.setVisible(true);
		} else {
			layAccount.setVisible(false);
			linkMain.setVisible(false);
		}
	}
}

package net.anthavio.wotan.web.vaadin.view;

import java.util.List;

import javax.annotation.PostConstruct;

import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;
import net.anthavio.wotan.web.SessionData;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author xpoft
 */
@Component
@Scope("prototype")
@VaadinView(value = MainView.NAME, cached = true)
public class MainView extends Panel implements View {

	private static final long serialVersionUID = 1L;

	public static final String NAME = "";

	public static final ExternalResource link = new ExternalResource("#!" + NAME);

	@Autowired
	private SessionData sessionData;

	TextField accountName = new TextField("Account");
	Button accountSearch = new Button("Search");
	VerticalLayout layoutResults = new VerticalLayout();

	@PostConstruct
	public void init() {
		setSizeFull();

		accountName.setRequired(true);
		accountName.setRequiredError("Please enter a Name!");
		accountName.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				if (event.getText() != null && event.getText().length() >= 3) {
					accountSearch.setEnabled(true);
				} else if (accountSearch.isEnabled()) {
					accountSearch.setEnabled(false);
				}
			}
		});

		accountSearch.setEnabled(false);
		accountSearch.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String value = accountName.getValue();
				if (!StringUtils.isEmpty(value)) {
					try {
						List<AccountStub> accounts = sessionData.getClient().account().list(value).execute().getData();
						if (accounts.size() == 0) {
							Notification.show("Nothing found", Type.WARNING_MESSAGE);
							accountName.setComponentError(new UserError("Nothing found"));
						} else if (accounts.size() == 1) {
							Long accountId = accounts.get(0).getId();
							getUI().getNavigator().navigateTo(AccountView.NAME + "/" + accountId);
						} else {
							display(accounts);
							//display list to choose
							//System.out.println(account.s);
						}
					} catch (final Exception x) {
						x.printStackTrace();
						UserError error = new UserError(x.getMessage());//, ErrorLevel.WARNING);
						accountName.setComponentError(error);
						Notification.show("Something failed: " + x.getMessage());
					}
				}

			}
		});

		Layout accLayout = new FormLayout();
		accLayout.addComponent(accountName);
		accLayout.addComponent(accountSearch);

		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);

		layout.addComponent(accLayout);

		layout.addComponent(layoutResults);

		//layout.addComponent(new Link("Go to the UI scoped View", new ExternalResource("#!" + UIScopedView.NAME)));
		setContent(layout);
	}

	public void display(List<AccountStub> accounts) {
		layoutResults.removeAllComponents();

		Table table = new Table("Accounts: " + accounts.size());
		//table.setSelectable(true);
		//table.setImmediate(true);

		table.addContainerProperty("Id", Long.class, null);
		table.addContainerProperty("Nickname", String.class, null);
		table.addContainerProperty("Details", Button.class, null);

		for (AccountStub account : accounts) {
			Button bView = new Button("View");
			bView.setData(account.getId());
			bView.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					Long accountId = (Long) event.getButton().getData();
					getUI().getNavigator().navigateTo(AccountView.NAME + "/" + accountId);
				}
			});
			bView.addStyleName("link");

			table.addItem(new Object[] { account.getId(), account.getNickname(), bView }, account.getId());

		}

		//table.setSizeFull();

		layoutResults.addComponent(table);
		//layoutResults.setSizeFull();
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		String parameters = event.getParameters();
		if (!StringUtils.isBlank(parameters)) {

			String[] split = parameters.split("/");
			if (split.length == 2) {
				String type = split[0];
				String value = split[1];
				if (type.equals("account")) {
					accountName.setValue(value);
					accountSearch.click();
				} else if (value.equals("clan")) {
					//TODO ... clan
				} else {
					Notification.show("Unknown value" + value + " for " + type);
				}
			} else if (split.length == 0) {
				//nothing to do...
			} else {
				Notification.show("Bugger! '" + parameters + "' ");
			}
		}
	}
}
package net.anthavio.wotan.web.vaadin.view;

import java.util.List;

import javax.annotation.PostConstruct;

import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;
import net.anthavio.wotan.client.clan.Clan;
import net.anthavio.wotan.web.SessionData;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
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

	TextField tfAccount = new TextField();
	Button btAccount = new Button("Search");

	TextField tfClan = new TextField();
	Button buClan = new Button("Search");

	VerticalLayout layoutResults = new VerticalLayout();

	/*
		public static void bound(final TextField textField, final Button button, final int min) {

			textField.addTextChangeListener(new TextChangeListener() {

				@Override
				public void textChange(TextChangeEvent event) {
					if (event.getText() != null && event.getText().length() >= min) {
						button.setEnabled(true);
					} else if (button.isEnabled()) {
						button.setEnabled(false);
					}
				}
			});

			if (textField.getValue() != null && textField.getValue().length() >= min) {
				button.setEnabled(true);
			} else {
				button.setEnabled(false);
			}
			
			button.addClickListener(new ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					String value = textField.getValue();
					if (!StringUtils.isEmpty(value)) {
						searchAccount(value);
					}

				}
			});
		}
	*/
	@PostConstruct
	public void init() {
		setSizeFull();

		tfAccount.setRequired(true);
		tfAccount.setRequiredError("Please enter a Name!");
		tfAccount.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				if (event.getText() != null && event.getText().length() >= 3) {
					btAccount.setEnabled(true);
					buClan.removeClickShortcut();
					btAccount.setClickShortcut(KeyCode.ENTER);
				} else if (btAccount.isEnabled()) {
					btAccount.setEnabled(false);
				}
			}
		});

		btAccount.setEnabled(false);
		btAccount.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String value = tfAccount.getValue();
				if (!StringUtils.isEmpty(value)) {
					searchAccount(value);
				}

			}
		});

		GridLayout accLayout = new GridLayout(3, 1, new Label("Account"), tfAccount, btAccount);
		accLayout.setSpacing(true);
		accLayout.setMargin(true);

		tfClan.setRequired(true);
		tfClan.setRequiredError("Please enter a Name!");
		tfClan.addTextChangeListener(new TextChangeListener() {

			@Override
			public void textChange(TextChangeEvent event) {
				if (event.getText() != null && event.getText().length() >= 3) {
					buClan.setEnabled(true);
					btAccount.removeClickShortcut();
					buClan.setClickShortcut(KeyCode.ENTER);
				} else if (buClan.isEnabled()) {
					buClan.setEnabled(false);
				}
			}
		});

		buClan.setEnabled(false);
		buClan.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String value = tfClan.getValue();
				if (!StringUtils.isEmpty(value)) {
					searchClan(value);
				}
			}
		});

		GridLayout clanLayout = new GridLayout(3, 1, new Label("Clan"), tfClan, buClan);
		clanLayout.setSpacing(true);
		clanLayout.setMargin(true);

		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);

		layout.addComponent(accLayout);
		layout.addComponent(clanLayout);

		layout.addComponent(layoutResults);

		//layout.addComponent(new Link("Go to the UI scoped View", new ExternalResource("#!" + UIScopedView.NAME)));
		setContent(layout);
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
					tfAccount.setValue(value);
					btAccount.click();
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

	private void searchAccount(String value) {
		try {
			List<AccountStub> accounts = sessionData.getClient().account().list(value).execute().getData();
			if (accounts.size() == 0) {
				Notification.show("Nothing found", Type.WARNING_MESSAGE);
				tfAccount.setComponentError(new UserError("Nothing found"));
			} else if (accounts.size() == 1) {
				Long accountId = accounts.get(0).getId();
				getUI().getNavigator().navigateTo(AccountView.NAME + "/" + accountId);
			} else {
				displayAccounts(accounts);
				//display list to choose
				//System.out.println(account.s);
			}
		} catch (final Exception x) {
			x.printStackTrace();
			UserError error = new UserError(x.getMessage());//, ErrorLevel.WARNING);
			tfAccount.setComponentError(error);
			Notification.show("Something failed: " + x.getMessage());
		}
	}

	protected void searchClan(String value) {
		try {
			List<Clan> clans = sessionData.getClient().clan().list(value).execute().getData();
			if (clans.size() == 0) {
				Notification.show("Nothing found", Type.WARNING_MESSAGE);
				tfAccount.setComponentError(new UserError("Nothing found"));
			} else if (clans.size() == 1) {
				Long id = clans.get(0).getClan_id();
				getUI().getNavigator().navigateTo(AccountView.NAME + "/" + id);
			} else {
				displayClans(clans);
				//display list to choose
				//System.out.println(account.s);
			}
		} catch (final Exception x) {
			x.printStackTrace();
			UserError error = new UserError(x.getMessage());//, ErrorLevel.WARNING);
			tfClan.setComponentError(error);
			Notification.show("Clan search failed: " + x.getMessage());
		}
	}

	public void displayAccounts(List<AccountStub> accounts) {
		layoutResults.removeAllComponents();

		Table table = new Table("Accounts: " + accounts.size());
		//table.setSelectable(true);
		//table.setImmediate(true);

		table.addContainerProperty("Id", Button.class, null);
		table.addContainerProperty("Nickname", String.class, null);

		for (AccountStub account : accounts) {
			Button bView = new Button(String.valueOf(account.getId()));
			bView.setData(account.getId());
			bView.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					Long accountId = (Long) event.getButton().getData();
					getUI().getNavigator().navigateTo(AccountView.NAME + "/" + accountId);
				}
			});
			bView.addStyleName("link");

			table.addItem(new Object[] { bView, account.getNickname() }, account.getId());

		}
		layoutResults.addComponent(table);
	}

	private void displayClans(List<Clan> clans) {
		layoutResults.removeAllComponents();

		Table table = new Table("Accounts: " + clans.size());
		//table.setSelectable(true);
		//table.setImmediate(true);

		table.addContainerProperty("Id", Button.class, null);
		table.addContainerProperty("Name", String.class, null);
		table.addContainerProperty("Members", Integer.class, null);

		for (Clan clan : clans) {
			Button bView = new Button(String.valueOf(clan.getClan_id()));
			bView.setData(clan.getClan_id());
			bView.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					Long accountId = (Long) event.getButton().getData();
					getUI().getNavigator().navigateTo(AccountView.NAME + "/" + accountId);
				}
			});
			bView.addStyleName("link");

			table.addItem(new Object[] { bView, clan.getName(), clan.getMembers_count() }, clan.getClan_id());

		}
		layoutResults.addComponent(table);
	}

}
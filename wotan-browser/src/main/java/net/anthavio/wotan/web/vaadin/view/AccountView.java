package net.anthavio.wotan.web.vaadin.view;

import java.util.List;
import java.util.Map;

import net.anthavio.wotan.client.account.AccountInfoResponse.AccountInfo;
import net.anthavio.wotan.client.account.AccountListResponse.AccountStub;
import net.anthavio.wotan.web.SessionData;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import ru.xpoft.vaadin.VaadinView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;

/**
 * 
 * @author martin.vanek
 *
 */
@Component
@Scope("prototype")
@VaadinView(value = AccountView.NAME, cached = true)
public class AccountView extends Panel implements View {

	public static final String NAME = "account";

	private static final long serialVersionUID = 1L;

	@Autowired
	private SessionData sessionData;

	TextArea textArea = new TextArea("Name");

	public AccountView() {
		setSizeFull();
		textArea.setWidth("20em");
		textArea.setHeight("30em");
		setContent(textArea);
	}

	public void display(long accountId) {
		Map<Long, AccountInfo> info = sessionData.getClient().account().info(accountId).execute().getData();
		AccountInfo account = info.values().iterator().next();

		textArea.setValue(account.toString());
	}

	public void display(String parameter) {
		try {
			long accountId = Long.parseLong(parameter);
			display(accountId);
		} catch (NumberFormatException nfx) {
			//not numeric accountId -> accountName search
			List<AccountStub> accounts = sessionData.getClient().account().list(parameter).execute().getData();
			if (accounts.size() == 1) {
				Long accountId = accounts.get(0).getId();
				display(accountId);
			} else if (accounts.size() == 0) {
				Notification.show("Account not found: " + parameter, Type.WARNING_MESSAGE);
				getUI().getNavigator().navigateTo(MainView.NAME);
			} else {
				//multiple results
				Notification.show("Multiple accounts found: " + parameter, Type.WARNING_MESSAGE);
				getUI().getNavigator().navigateTo(MainView.NAME + "/accounts/" + parameter);
			}
		}
	}

	@Override
	public void enter(ViewChangeEvent event) {
		String parameters = event.getParameters();
		if (StringUtils.isEmpty(parameters)) {
			getUI().getNavigator().navigateTo(MainView.NAME);
		}
		display(parameters);

	}
}

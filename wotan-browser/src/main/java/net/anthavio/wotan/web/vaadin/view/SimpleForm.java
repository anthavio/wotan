package net.anthavio.wotan.web.vaadin.view;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.StringLengthValidator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

/**
 * @author xpoft
 */
@org.springframework.stereotype.Component
@Scope("prototype")
public class SimpleForm extends VerticalLayout {

	private static final String COMMON_FIELD_WIDTH = "12em";

	@PostConstruct
	public void init() {
		User user = new User();

		setCaption("Simple form");
		setSpacing(true);

		TextField name = new TextField("Name");
		name.setRequired(true);
		name.setRequiredError("Please enter a Name!");
		name.setWidth(COMMON_FIELD_WIDTH);
		name.addValidator(new StringLengthValidator("It must be 3-25 characters", 3, 25, false));
		name.setNullRepresentation("");
		name.setImmediate(true);

		TextField email = new TextField("Email:");
		email.setRequired(true);
		email.setRequiredError("Please enter a Email");
		email.setWidth(COMMON_FIELD_WIDTH);
		email.addValidator(new EmailValidator("Not valid email"));
		email.setNullRepresentation("");
		email.setImmediate(true);

		DateField date = new DateField("Date");
		date.setDateFormat("yyyy-MM-dd");
		date.setRequired(true);
		date.setRequiredError("Set a frickin date!");

		final BeanFieldGroup<User> fieldGroup = new BeanFieldGroup<User>(User.class);
		fieldGroup.setItemDataSource(new BeanItem<User>(user));
		fieldGroup.bind(name, "name");
		fieldGroup.bind(email, "email");
		fieldGroup.bind(date, "date");

		// The cancel / apply buttons
		HorizontalLayout buttons = new HorizontalLayout();
		buttons.setSpacing(true);
		Button discardChanges = new Button("Reset", new Button.ClickListener() {
			public void buttonClick(Button.ClickEvent event) {
				fieldGroup.discard();
			}
		});
		buttons.addComponent(discardChanges);
		buttons.setComponentAlignment(discardChanges, Alignment.MIDDLE_LEFT);

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
		buttons.addComponent(apply);

		addComponent(name);
		addComponent(email);
		addComponent(date);
		addComponent(buttons);
	}
}

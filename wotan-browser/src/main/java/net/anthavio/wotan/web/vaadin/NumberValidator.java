package net.anthavio.wotan.web.vaadin;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

import com.vaadin.data.validator.AbstractValidator;

/**
 * 
 * @author martin.vanek
 *
 */
public class NumberValidator extends AbstractValidator<String> {

	private static final long serialVersionUID = 1L;

	private NumberFormat numberFormat;

	public NumberValidator(String errorMessage, String format) {
		super(errorMessage);
		this.numberFormat = new DecimalFormat(format);
	}

	public NumberValidator(String errorMessage, DecimalFormat numberFormat) {
		super(errorMessage);
		this.numberFormat = numberFormat;
	}

	@Override
	protected boolean isValidValue(String value) {
		try {
			numberFormat.parse(value);
		} catch (ParseException px) {
			setErrorMessage(value + " does not have right format");
		}
		return false;
	}

	@Override
	public Class<String> getType() {
		return String.class;
	}

}

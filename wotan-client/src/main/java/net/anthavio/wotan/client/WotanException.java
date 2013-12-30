package net.anthavio.wotan.client;

import net.anthavio.wotan.client.BasicResponse.ErrorDetails;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public WotanException(String message, Throwable cause) {
		super(message, cause);
	}

	public WotanException(String message) {
		super(message);
	}

	public WotanException(Throwable cause) {
		super(cause);
	}

	public WotanException(ErrorDetails error) {
		super(error.toString());
	}

}

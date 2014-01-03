package net.anthavio.wotan.client;

import java.io.Serializable;

/**
 * 
 * @author martin.vanek
 *
 */
public class WotanResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	public static enum Status {
		ok, error;
	}

	private Status status;

	private ErrorDetails error;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public ErrorDetails getError() {
		return error;
	}

	public void setError(ErrorDetails error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "WotanResponse [status=" + status + ", error=" + error + "]";
	}

	public static class ErrorDetails implements Serializable {

		private static final long serialVersionUID = 1L;

		private String code;

		private String message;

		private String field;

		private String value;

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "ErrorDetails [code=" + code + ", message=" + message + ", field=" + field + ", value=" + value + "]";
		}

	}
}

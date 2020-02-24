package com.minotore.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class NullModificationException extends RunTimeRestControllerException {

	/**
	 * no time for comment
	 */
	private static final long serialVersionUID = 7355445966641984092L;

	private static final HttpStatus errorCode = HttpStatus.NOT_MODIFIED;

	@Override
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public NullModificationException() {
		super();

	}

	public NullModificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public NullModificationException(String message, Throwable cause) {
		super(message, cause);

	}

	public NullModificationException(String message) {
		super(message);

	}

	public NullModificationException(Throwable cause) {
		super(cause);

	}

}

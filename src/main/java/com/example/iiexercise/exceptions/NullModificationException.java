package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class NullModificationException extends RunTimeRestControllerException {

	/**
	 * no time for comment
	 */
	private static final long serialVersionUID = 7355445966641984092L;

	public NullModificationException() {
		super();
		errorCode = HttpStatus.NOT_MODIFIED;
	}

	public NullModificationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorCode = HttpStatus.NOT_MODIFIED;
	}

	public NullModificationException(String message, Throwable cause) {
		super(message, cause);
		errorCode = HttpStatus.NOT_MODIFIED;
	}

	public NullModificationException(String message) {
		super(message);
		errorCode = HttpStatus.NOT_MODIFIED;
	}

	public NullModificationException(Throwable cause) {
		super(cause);
		errorCode = HttpStatus.NOT_MODIFIED;
	}
	
}

package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class MissingDataException extends RunTimeRestControllerException {

	/**
	 * Throw error that's submitted data are missing
	 */
	private static final long serialVersionUID = -5347330080054232982L;

	private static final HttpStatus errorCode = HttpStatus.BAD_REQUEST;

	@Override
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public MissingDataException() {
		super();

	}

	public MissingDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public MissingDataException(String message, Throwable cause) {
		super(message, cause);

	}

	public MissingDataException(String message) {
		super(message);

	}

	public MissingDataException(Throwable cause) {
		super(cause);

	}

}

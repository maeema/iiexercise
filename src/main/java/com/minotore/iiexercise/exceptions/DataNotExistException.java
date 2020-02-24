package com.minotore.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotExistException extends RunTimeRestControllerException {

	/**
	 * Throw error that's data are not found in database
	 */
	private static final long serialVersionUID = -5472727930699224488L;

	private static final HttpStatus errorCode = HttpStatus.NOT_FOUND;

	@Override
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public DataNotExistException() {
		super();
	}

	public DataNotExistException(String object, String DataType) {
		super(object + " is not found as " + DataType);
	}

	public DataNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotExistException(String message) {
		super(message);
	}

	public DataNotExistException(Throwable cause) {
		super(cause);
	}

}

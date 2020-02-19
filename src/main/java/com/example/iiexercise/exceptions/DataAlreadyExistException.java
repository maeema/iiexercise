package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class DataAlreadyExistException extends RunTimeRestControllerException {

	/**
	 * Throw error that's data are already exist in database
	 */
	private static final long serialVersionUID = 8542350769880652389L;

	private static final HttpStatus errorCode = HttpStatus.ALREADY_REPORTED;

	@Override
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public DataAlreadyExistException() {
		super();

	}

	public DataAlreadyExistException(String object, String DataType) {
		super(object + " is already exits as " + DataType);
	}

	public DataAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DataAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataAlreadyExistException(String message) {
		super(message);
	}

	public DataAlreadyExistException(Throwable cause) {
		super(cause);
	}

}

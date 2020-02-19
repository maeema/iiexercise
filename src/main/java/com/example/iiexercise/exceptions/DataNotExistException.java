package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class DataNotExistException extends RunTimeRestControllerException {

	/**
	 * Throw error that's data are not found in database
	 */
	private static final long serialVersionUID = -5472727930699224488L; 

	public DataNotExistException() {
		super();
		errorCode = HttpStatus.NOT_FOUND ;
	}

	public DataNotExistException(String object, String DataType) {
		super(object + " is not found as " + DataType);
		errorCode = HttpStatus.NOT_FOUND;
	}

	public DataNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorCode = HttpStatus.NOT_FOUND;
	}

	public DataNotExistException(String message, Throwable cause) {
		super(message, cause);
		errorCode = HttpStatus.NOT_FOUND;
	}

	public DataNotExistException(String message) {
		super(message);
		errorCode = HttpStatus.NOT_FOUND;
	}

	public DataNotExistException(Throwable cause) {
		super(cause);
		errorCode = HttpStatus.NOT_FOUND;
	}

}

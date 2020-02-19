package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class DataAlreadyExistException extends RunTimeRestControllerException {

	/**
	 * Throw error that's data are already exist in database
	 */
	private static final long serialVersionUID = 8542350769880652389L;
	

	public DataAlreadyExistException() {
		super();
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

	public DataAlreadyExistException(String object, String DataType) {
		super(object + " is already exits as " + DataType);
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

	public DataAlreadyExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

	public DataAlreadyExistException(String message, Throwable cause) {
		super(message, cause);
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

	public DataAlreadyExistException(String message) {
		super(message);
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

	public DataAlreadyExistException(Throwable cause) {
		super(cause);
		errorCode = HttpStatus.ALREADY_REPORTED ; 
	}

}

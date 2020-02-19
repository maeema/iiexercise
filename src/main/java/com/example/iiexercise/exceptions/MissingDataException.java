package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class MissingDataException extends RunTimeRestControllerException {

	/**
	 * Throw error that's submitted data are missing
	 */
	private static final long serialVersionUID = -5347330080054232982L;

	public MissingDataException() {
		super();
		errorCode = HttpStatus.BAD_REQUEST ;
	}

	public MissingDataException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		errorCode = HttpStatus.BAD_REQUEST ;

	}

	public MissingDataException(String message, Throwable cause) {
		super(message, cause);
		errorCode = HttpStatus.BAD_REQUEST ;
	}

	public MissingDataException(String message) {
		super(message);
		errorCode = HttpStatus.BAD_REQUEST ;
	}

	public MissingDataException(Throwable cause) {
		super(cause);
		errorCode = HttpStatus.BAD_REQUEST ;
	}

}

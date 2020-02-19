package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public abstract class RunTimeRestControllerException extends RuntimeException {
	/**
	 * 
	 */

	private static final long serialVersionUID = 856750563167800651L;

	public  abstract HttpStatus getErrorCode();

	public RunTimeRestControllerException() {
		super();
	}

	public RunTimeRestControllerException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RunTimeRestControllerException(String message, Throwable cause) {
		super(message, cause);
	}

	public RunTimeRestControllerException(String message) {
		super(message);
	}

	public RunTimeRestControllerException(Throwable cause) {
		super(cause);
	}
}

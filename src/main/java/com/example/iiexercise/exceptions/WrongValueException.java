package com.example.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class WrongValueException extends RunTimeRestControllerException {

	/**
	 * throw error if data not much the expectation
	 */
	private static final long serialVersionUID = 9020957539563927515L;

	public WrongValueException() {
		super();
		errorCode = HttpStatus.NOT_ACCEPTABLE ;
	}

	public WrongValueException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		errorCode = HttpStatus.NOT_ACCEPTABLE ;
	}

	public WrongValueException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		errorCode = HttpStatus.NOT_ACCEPTABLE ;
	}

	public WrongValueException(String arg0) {
		super(arg0);
		errorCode = HttpStatus.NOT_ACCEPTABLE ;
	}

	public WrongValueException(Throwable arg0) {
		super(arg0);
		errorCode = HttpStatus.NOT_ACCEPTABLE ;
	}

}

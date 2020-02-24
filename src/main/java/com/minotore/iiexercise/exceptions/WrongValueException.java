package com.minotore.iiexercise.exceptions;

import org.springframework.http.HttpStatus;

public class WrongValueException extends RunTimeRestControllerException {

	/**
	 * throw error if data not much the expectation
	 */
	private static final long serialVersionUID = 9020957539563927515L;

	private static final HttpStatus errorCode = HttpStatus.NOT_ACCEPTABLE;

	@Override
	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public WrongValueException() {
		super();
	}

	public WrongValueException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public WrongValueException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public WrongValueException(String arg0) {
		super(arg0);
	}

	public WrongValueException(Throwable arg0) {
		super(arg0);
	}

}

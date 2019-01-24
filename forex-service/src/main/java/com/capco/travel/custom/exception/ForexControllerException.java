package com.capco.travel.custom.exception;

public class ForexControllerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForexControllerException(String msg) {
		super(msg);
	}

	public ForexControllerException(Throwable msg) {
		super(msg);
	}
}

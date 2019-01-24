package com.capco.travel.custom.exception;

public class ForexServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForexServiceException(String msg) {
		super(msg);
	}

	public ForexServiceException(Throwable msg) {
		super(msg);
	}

}


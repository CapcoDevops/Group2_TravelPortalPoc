package com.capco.travel.custom.exception;

public class ForexNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ForexNotFoundException(String msg) {
		super(msg);
	}

	public ForexNotFoundException(Throwable msg) {
		super(msg);
	}
}

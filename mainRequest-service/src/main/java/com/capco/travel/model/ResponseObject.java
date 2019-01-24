package com.capco.travel.model;

public class ResponseObject {
	
	private String statusCode;
	private String message;
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	public ResponseObject(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public ResponseObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseObject [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
}

package com.capco.travel.custom.exception;

public class TravelException {

	public static class TravelServiceException extends BaseException {
		private static final long serialVersionUID = 1L;

		public TravelServiceException(String msg) {
			super(msg);
		}

		public TravelServiceException(Throwable msg) {
			super(msg);
		}
	}
	
}

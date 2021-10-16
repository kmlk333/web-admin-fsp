package com.lti.fsp.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

		public CustomException() {
			
		}
		
		public CustomException(String msg){
			super(msg);
		}
}

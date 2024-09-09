package com.cooklist.config.exception;

public class CockListException extends RuntimeException {
	
	private static final long serialVersionUID = 8746115778720917534L;
	
	private ExceptionType exceptionType;
	
	public CockListException() {
		super();
	}

	public CockListException(ExceptionType exceptionType, String message) {
		super(message);
		this.setExceptionType(exceptionType);
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

}

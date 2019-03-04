package com.example.demo.exception;

public class EmployeeServiceException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public EmployeeServiceException() {
		super();
	}

	public EmployeeServiceException(final String message) {
		super(message);
	}

}

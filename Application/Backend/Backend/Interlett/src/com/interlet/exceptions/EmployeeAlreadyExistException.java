package com.interlet.exceptions;

@SuppressWarnings("serial")
public class EmployeeAlreadyExistException extends Exception {
	public EmployeeAlreadyExistException() {
		super("Employee Already Registered");
	}
}

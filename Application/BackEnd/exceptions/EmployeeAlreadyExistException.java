package com.interlet.exceptions;

public class EmployeeAlreadyExistException extends Exception {
	public EmployeeAlreadyExistException() {
		super("Employee Already Registered");
	}
}

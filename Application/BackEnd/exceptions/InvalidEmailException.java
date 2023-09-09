package com.interlet.exceptions;

public class InvalidEmailException extends Exception {
	public InvalidEmailException() {
		super("Email is invalid");
	}

}

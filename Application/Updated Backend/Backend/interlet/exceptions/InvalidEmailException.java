package com.interlet.exceptions;

@SuppressWarnings("serial")
public class InvalidEmailException extends Exception {
	public InvalidEmailException() {
		super("Email is invalid");
	}

}

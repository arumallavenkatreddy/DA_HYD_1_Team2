package com.interlet.exceptions;

@SuppressWarnings("serial")
public class LoginDeatailsInvalidException extends Exception {
	public LoginDeatailsInvalidException() {
		super("Incorrect Email Id or Password");
	}
}

package com.interlet.exceptions;

public class LoginDeatailsInvalidException extends Exception {
	public LoginDeatailsInvalidException() {
		super("Incorrect Email Id or Password");
	}
}

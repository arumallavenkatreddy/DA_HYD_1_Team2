package com.interlet.exceptions;

@SuppressWarnings("serial")
public class PasswordFormatException extends Exception {
	public PasswordFormatException() {
		super("Please Enter Strong Password");
	}
}

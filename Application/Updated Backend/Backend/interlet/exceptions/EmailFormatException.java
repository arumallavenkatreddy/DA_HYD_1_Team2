package com.interlet.exceptions;

@SuppressWarnings("serial")
public class EmailFormatException extends Exception {
	public EmailFormatException() {
		super("Invalid Email");
	}

}

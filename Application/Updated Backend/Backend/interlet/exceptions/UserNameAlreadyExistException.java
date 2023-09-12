package com.interlet.exceptions;

@SuppressWarnings("serial")
public class UserNameAlreadyExistException extends Exception {
	
	public UserNameAlreadyExistException() {
		super("User Name is not available");
	}

}

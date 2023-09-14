package com.interlet.exceptions;

@SuppressWarnings("serial")
public class UserNameAlreadyExistException extends Exception {
	
	public UserNameAlreadyExistException() {
		super("Registration Unsuccesfull reason : User Name is not available");
	}

}

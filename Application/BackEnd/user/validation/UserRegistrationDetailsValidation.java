package com.interlet.user.validation;

import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.PasswordFormatException;

public interface UserRegistrationDetailsValidation {
	public String emailFormatValidation(String emailId) throws EmailFormatException;

	public String passwordFormatValidation(String password) throws PasswordFormatException;
}

package com.interlet.user.validation;

import com.interlet.exceptions.LoginDeatailsInvalidException;

public interface UserLoginValidation {

	// Method is used for login credentials validation

	public boolean userLoginValidation(String emailId_or_userName, String password)
			throws LoginDeatailsInvalidException;
}

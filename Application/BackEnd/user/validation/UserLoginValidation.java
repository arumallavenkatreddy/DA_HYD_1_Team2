package com.interlet.user.validation;

import com.interlet.exceptions.LoginDeatailsInvalidException;

public interface UserLoginValidation {
	public String userLoginValidation(String emailId, String password) throws LoginDeatailsInvalidException;
}

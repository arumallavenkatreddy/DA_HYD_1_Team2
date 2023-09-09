package com.interlet.user.validation.impl;

import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.user.validation.UserRegistrationDetailsValidation;
import java.util.regex.*;

public class UserRegistrationDetailsValidationImpl implements UserRegistrationDetailsValidation {
	// Method is used for Email Format Validation
	@Override
	public String emailFormatValidation(String emailId) throws EmailFormatException {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		if (matcher.matches() == false)
			throw new EmailFormatException();
		else
			return "valid email";
	}

	// Method is used for Password Format Validation
	@Override
	public String passwordFormatValidation(String password) throws PasswordFormatException {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches() == false)
			throw new PasswordFormatException();
		else
			return "valid Password";
	}

}

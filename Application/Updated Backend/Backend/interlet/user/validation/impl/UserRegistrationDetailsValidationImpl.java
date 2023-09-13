package com.interlet.user.validation.impl;

import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.exceptions.PhoneNumberFormatException;
import com.interlet.user.validation.UserRegistrationDetailsValidation;
import java.util.regex.*;

public class UserRegistrationDetailsValidationImpl implements UserRegistrationDetailsValidation {
	
	// Method is used for Email Format Validation
	
	@Override
	public boolean emailFormatValidation(String emailId) throws EmailFormatException {
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId);
		
		if (matcher.matches() == false || emailId.toLowerCase().contains("admin") )
			throw new EmailFormatException();
		else
			return true;
	}

	// Method is used for Password Format Validation
	
	@Override
	public boolean passwordFormatValidation(String password) throws PasswordFormatException {
		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		if (matcher.matches() == false)
			throw new PasswordFormatException();
		else
			return true;
	}
	
	// Method is used to validate phone number format

	@Override
	public boolean phoneNumberFormatValidation(String phoneNumber) throws PhoneNumberFormatException {
		 String regex = "(0/91)?[7-9][0-9]{9}";
		 Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(phoneNumber);
		 if(matcher.matches() == false)
			 throw new PhoneNumberFormatException();
		 else
			 return true;
	}

}

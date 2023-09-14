package com.interlet.user.validation;

import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.exceptions.PhoneNumberFormatException;

public interface UserRegistrationDetailsValidation {
	
	// Method is used to validate email format
	
	public boolean emailFormatValidation(String emailId) throws EmailFormatException;
	
	// Method is used to validate password format

	public boolean passwordFormatValidation(String password) throws PasswordFormatException;
	
	// Method is used to validate phone number format

	public boolean phoneNumberFormatValidation(String phoneNumber) throws PhoneNumberFormatException;
}

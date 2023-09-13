package com.interlet.exceptions;

@SuppressWarnings("serial")
public class PhoneNumberFormatException extends Exception{
	public PhoneNumberFormatException()
	{
		super("Please Enter Valid Phone Number");
	}

}

package com.interlet.ui;

import com.interlet.exceptions.LoginDeatailsInvalidException;
import com.interlet.user.validation.UserLoginValidation;
import com.interlet.user.validation.impl.UserLoginValidationImpl;

public class UserFactory {
public int factoryPattern(String emailId,String Password)
{
	UserLoginValidation userLoginValidation=new UserLoginValidationImpl();
	try {
		
		if(userLoginValidation.userLoginValidation(emailId, Password))
		{
			switch(emailId)
			{
			case "admin@org.co.in":
			{
				Admin admin=new Admin();
				admin.adminServices();
				break;
			}
			case "admin":
			{
				Admin admin=new Admin();
				admin.adminServices();
				break;
			}
			default :
				Employee employee=new Employee();
				employee.employeeServices(emailId);
				break;			
			}
			
		}
	} catch (LoginDeatailsInvalidException e) {
		System.out.println(e.getMessage());
	}
	return 3;
}
}

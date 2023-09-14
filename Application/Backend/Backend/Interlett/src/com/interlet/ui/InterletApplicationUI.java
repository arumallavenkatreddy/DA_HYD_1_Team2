package com.interlet.ui;

import java.util.Scanner;
import com.interlet.beans.User;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.exceptions.PhoneNumberFormatException;
import com.interlet.exceptions.UserNameAlreadyExistException;
import com.interlet.user.employee.dao.services.EmployeeDaoServices;
import com.interlet.user.employee.dao.services.impl.EmployeeDaoServicesImpl;

public class InterletApplicationUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("*******Asset Management System*******");
			System.out.println("-------------------------------------");
			System.out.println();
			System.out.println("Enter your choice");
			System.out.println("   ------------  ");
			System.out.println("1 ---> Register");
			System.out.println("2 ---> Login");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				EmployeeDaoServices employeeDaoServices = new EmployeeDaoServicesImpl();
				User user = new User();
				System.out.println("Enter UserName");
				user.setUserName(sc.next());
				System.out.println("Enter Your Phone Number");
				user.setPhoneNumber(sc.next());
				System.out.println("Enter Your EmailId");
				user.setEmailId(sc.next());
				System.out.println("Enter New Password ");
				System.out.println(
						"Password size should be minimum of 9, contain 1 Uppercase, 1 Lowercase,digit,Special character");
				user.setPassword(sc.next());
				String result;
				try {
					result = employeeDaoServices.registerEmployee(user);
					System.out.println(result);
					System.out.println();
				} catch (EmployeeAlreadyExistException | EmailFormatException | PasswordFormatException
						| PhoneNumberFormatException | UserNameAlreadyExistException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				System.out.println();
				System.out.println("Welcome To Interlet Login Page");
				System.out.println("--------------------");
				System.out.println("Enter EmailId or UserName");
				String emailId = sc.next();
				emailId = emailId.toLowerCase();
				System.out.println("Enter Password");
				String password = sc.next();
				UserFactory userFactory = new UserFactory();
				choice = userFactory.factoryPattern(emailId, password);
				break;
			}
			}

		}
		sc.close();
	}

}

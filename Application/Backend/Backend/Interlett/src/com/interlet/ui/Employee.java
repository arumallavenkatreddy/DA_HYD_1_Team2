package com.interlet.ui;

import java.util.List;
import java.util.Scanner;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.beans.User;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.user.employee.dao.services.EmployeeDaoServices;
import com.interlet.user.employee.dao.services.impl.EmployeeDaoServicesImpl;

public class Employee {
public int employeeServices(String emailId)
{
	
	Scanner sc=new Scanner(System.in);
	EmployeeDaoServices employeeDaoServices=new EmployeeDaoServicesImpl();
	User user=employeeDaoServices.getEmployeeDetails(emailId);
	System.out.println("Welcome "+user.getUserName());
	System.out.println("---------------------------");
	int choice=0;
	while(choice!=5)
	{
		System.out.println();
		System.out.println("Please enter your choice");
		System.out.println("1 ---> Borrowing Asset");
		System.out.println("2 ---> Returning Asset");
		System.out.println("3 ---> Borrowed Assets Details");
		System.out.println("4 ---> Available Assets");
		System.out.println("5 ---> Logout");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		{
			System.out.println("Enter Asset Type");
			String assetType=sc.next();
			try {
				String result=employeeDaoServices.borrowAsset(assetType, user);
				System.out.println(result);
			} catch (OverDueAssetFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 2:
		{
			System.out.println("Enter Asset Id");
			int assetId=sc.nextInt();	
			try {
				String result=employeeDaoServices.returningAsset(assetId, user);
				System.out.println(result);
			} catch (AssetsNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 3:
		{
			try {
				List<BorrowedAsset> borrowedAssetsDetailsList=employeeDaoServices.getBorrowedAssetsDetails(user);
				for(BorrowedAsset borrowedAsset:borrowedAssetsDetailsList)
				{
					System.out.println(borrowedAsset);
				}
			} catch (AssetsNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		case 4:
		{
			try {
				List<Asset> assetsList=employeeDaoServices.getAllAvailableAssets();
				for(Asset asset:assetsList)
				{
					System.out.println(asset);
				}
			} catch (AssetsNotFoundException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		default :
			System.out.println("Log Out Succesfull");
			break;
		}
	}
	sc.close();
	return 3;
}
}

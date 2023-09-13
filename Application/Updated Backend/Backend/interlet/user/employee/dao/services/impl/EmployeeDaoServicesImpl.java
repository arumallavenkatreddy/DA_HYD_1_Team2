package com.interlet.user.employee.dao.services.impl;

import java.util.List;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.beans.User;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.exceptions.PhoneNumberFormatException;
import com.interlet.exceptions.UserNameAlreadyExistException;
import com.interlet.user.employee.dao.EmployeeDao;
import com.interlet.user.employee.dao.impl.EmployeeDaoImpl;
import com.interlet.user.employee.dao.services.EmployeeDaoServices;

public class EmployeeDaoServicesImpl implements EmployeeDaoServices {
	
	EmployeeDao employeeDao = new EmployeeDaoImpl();
    
	 // Method is used to Register the User
	
	@Override
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException,
			PasswordFormatException, PhoneNumberFormatException, UserNameAlreadyExistException {
		return employeeDao.registerEmployee(user);
	}

	// Method is used to Borrow an Asset

	@Override
	public String borrowAsset(String assetType, User user) throws OverDueAssetFoundException {
		return employeeDao.borrowAsset(assetType, user);
	}
	
	// Method returns list of returning Assets

	@Override
	public String returningAsset(int assetId, User user) throws AssetsNotFoundException {
		return employeeDao.returningAsset(assetId, user);
	}
	
	// Method returns list of BorrowedAssets

	@Override
	public List<BorrowedAsset> getBorrowedAssetsDetails(User user) throws AssetsNotFoundException {
		return employeeDao.getBorrowedAssetsDetails(user);
	}
	
	// Method returns list of All available Assets

	@Override
	public List<Asset> getAllAvailableAssets() throws AssetsNotFoundException {
		return employeeDao.getAllAvailableAssets();
	}
	
	// Method return Employee details

	@Override
	public User getEmployeeDetails(String emailId) {
		return employeeDao.getEmployeeDetails(emailId);
	}

}

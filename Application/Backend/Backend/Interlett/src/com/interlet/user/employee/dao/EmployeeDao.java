package com.interlet.user.employee.dao;

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

public interface EmployeeDao {
	
	// Method is used to Register the User
	
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException,
			PasswordFormatException, PhoneNumberFormatException, UserNameAlreadyExistException;

	// Method is used to Borrow an Asset
	
	public String borrowAsset(String assetType, User user) throws OverDueAssetFoundException;

	// Method returns list of BorrowedAssets
	
	public List<BorrowedAsset> getBorrowedAssetsDetails(User user) throws AssetsNotFoundException;

	// Method returns list of All available Assets
	
	public List<Asset> getAllAvailableAssets() throws AssetsNotFoundException;

	// Method used for returning an Asset
	
	public String returningAsset(int assetId, User user) throws AssetsNotFoundException;

	// Method return Employee details
	
	public User getEmployeeDetails(String emailId);
}

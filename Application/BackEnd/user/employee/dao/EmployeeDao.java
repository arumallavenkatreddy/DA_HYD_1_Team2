package com.interlet.user.employee.dao;

import com.interlet.beans.User;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;

public interface EmployeeDao {
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException;

	public String borrowAsset(String type, String assetName) throws OverDueAssetFoundException;

}

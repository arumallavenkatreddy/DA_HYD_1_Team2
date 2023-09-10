package com.interlet.user.employee.dao.impl;

import com.interlet.beans.User;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.user.employee.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String borrowAsset(String type, String assetName) throws OverDueAssetFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	



}

package com.interlet.user.employee.dao.services.impl;

import com.interlet.beans.User;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.user.employee.dao.EmployeeDao;
import com.interlet.user.employee.dao.impl.EmployeeDaoImpl;
import com.interlet.user.employee.dao.services.EmployeeDaoServices;

public class EmployeeDaoServicesImpl implements EmployeeDaoServices {
	EmployeeDao employeeDao = new EmployeeDaoImpl();

	@Override
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException {

		return employeeDao.registerEmployee(user);
	}

	@Override
	public String borrowAsset(String type, String assetName) throws OverDueAssetFoundException {

		return employeeDao.borrowAsset(type, assetName);
	}

}

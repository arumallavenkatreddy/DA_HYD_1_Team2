package com.interlet.user.validation.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.interlet.beans.User;
import com.interlet.dbconnection.DBConnection;
import com.interlet.exceptions.LoginDeatailsInvalidException;
import com.interlet.user.validation.UserLoginValidation;

public class UserLoginValidationImpl implements UserLoginValidation {

	// Method is used for login credentials validation
	
	@Override
	public boolean userLoginValidation(String emailId_or_userName, String password)
			throws LoginDeatailsInvalidException {
		Connection conn;
		PreparedStatement pst;
		ResultSet rs;
		User user = new User();
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(emailId_or_userName);
		boolean flag = true;
		if (matcher.matches() == false)
			flag = false;
		String query;
		if (flag == true) {
			query = "SELECT * FROM User WHERE emailId = ?";

		} else {
			query = "SELECT * FROM User WHERE userName = ?";
		}
		try {
			conn = DBConnection.getConnection();

			pst = conn.prepareStatement(query);
			pst.setString(1, emailId_or_userName);

			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setRole(rs.getString(3));
				user.setPhoneNumber(rs.getString(4));
				user.setEmailId(rs.getString(5));
				user.setPassword(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}

		if (user.getPassword() == null) {
			throw new LoginDeatailsInvalidException();
		} else if (user.getPassword().equals(password)) {
			return true;
		} else {
			throw new LoginDeatailsInvalidException();
		}

	}
}

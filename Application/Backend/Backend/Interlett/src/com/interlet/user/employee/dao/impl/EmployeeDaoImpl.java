package com.interlet.user.employee.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.beans.User;
import com.interlet.dbconnection.DBConnection;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.exceptions.EmailFormatException;
import com.interlet.exceptions.EmployeeAlreadyExistException;
import com.interlet.exceptions.OverDueAssetFoundException;
import com.interlet.exceptions.PasswordFormatException;
import com.interlet.exceptions.PhoneNumberFormatException;
import com.interlet.exceptions.UserNameAlreadyExistException;
import com.interlet.user.admin.dao.services.AdminDaoServices;
import com.interlet.user.admin.dao.services.impl.AdminDaoServicesImpl;
import com.interlet.user.employee.dao.EmployeeDao;
import com.interlet.user.validation.UserRegistrationDetailsValidation;
import com.interlet.user.validation.impl.UserRegistrationDetailsValidationImpl;

public class EmployeeDaoImpl implements EmployeeDao {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public boolean checkIfEmailAlreadyExists(String emailId) {
		try {
			conn = DBConnection.getConnection();
			String query = "SELECT * FROM User WHERE emailId = ?";

			pst = conn.prepareStatement(query);
			pst.setString(1, emailId);
			rs = pst.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close();
		}
	}

	public boolean checkIfUserNameAlreadyExists(String userName) {
		try {
			conn = DBConnection.getConnection();
			String query = "SELECT * FROM User WHERE userName = ?";
			pst = conn.prepareStatement(query);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close();
		}
	}

	// Method is used to Register the User

	@Override
	public String registerEmployee(User user) throws EmployeeAlreadyExistException, EmailFormatException,
			PasswordFormatException, PhoneNumberFormatException, UserNameAlreadyExistException {
		UserRegistrationDetailsValidation userRegistrationDetailsValidation = new UserRegistrationDetailsValidationImpl();
		if (checkIfEmailAlreadyExists(user.getEmailId())) {
			throw new EmployeeAlreadyExistException();
		} else if (checkIfUserNameAlreadyExists(user.getUserName())) {
			throw new UserNameAlreadyExistException();
		} else {
			try {
				if (userRegistrationDetailsValidation.emailFormatValidation(user.getEmailId())) {
					if (userRegistrationDetailsValidation.passwordFormatValidation(user.getPassword())) {
						if (userRegistrationDetailsValidation.phoneNumberFormatValidation(user.getPhoneNumber())) {
							conn = DBConnection.getConnection();
							String query = "INSERT INTO User VALUES(?,?,?,?,?,?)";
							try {
								pst = conn.prepareStatement(query);
								pst.setInt(1, user.getUserId());
								pst.setString(2, user.getUserName());
								pst.setString(3, user.getRole());
								pst.setString(4, user.getPhoneNumber());
								pst.setString(5, user.getEmailId());
								pst.setString(6, user.getPassword());
								pst.executeUpdate();
							} catch (SQLException e) {
								return e.getMessage();
							}
						}
					}
				}
			} catch (EmailFormatException | PasswordFormatException | PhoneNumberFormatException e) {
				return e.getMessage();
			}
		}
		return "Registration Successfull";
	}

	// Method is used to Borrow an Asset

	@Override
	public String borrowAsset(String assetType, User user) throws OverDueAssetFoundException {
		AdminDaoServices adminDaoServices = new AdminDaoServicesImpl();
		List<BorrowedAsset> overDueAssetList = new ArrayList<BorrowedAsset>();
		int rows = 0;

		overDueAssetList = adminDaoServices.overDueAssetsByDate();

		boolean flag = false;
		for (BorrowedAsset borrowedAsset : overDueAssetList) {
			if (borrowedAsset.getUserId() == user.getUserId()) {
				flag = true;
			}
		}
		if (flag == false) {
			List<Asset> availableAssetsList = new ArrayList<Asset>();
			Asset availableAsset = null;
			try {
				availableAssetsList = getAllAvailableAssets();
			} catch (AssetsNotFoundException e1) {
				return e1.getMessage();
			}
			boolean status = false;
			for (Asset asset : availableAssetsList) {
				if (asset.getAssetType().equals(assetType)) {
					status = true;
					availableAsset = asset;
				}
			}
			if (status == true) {
				String query1 = "UPDATE Asset SET isAvailable=? WHERE assetId=?";
				String query2 = "INSERT INTO BorrowedAsset VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pst2 = null;
				LocalDate localDate = LocalDate.now();
				Date date = java.sql.Date.valueOf(localDate);

				try {
					conn = DBConnection.getConnection();
					pst = conn.prepareStatement(query1);
					pst2 = conn.prepareStatement(query2);
					pst.setBoolean(1, false);
					pst.setInt(2, availableAsset.getAssetId());
					pst.executeUpdate();
					pst2.setInt(1, user.getUserId());
					pst2.setInt(2, availableAsset.getAssetId());
					pst2.setString(3, user.getUserName());
					pst2.setString(4, availableAsset.getAssetName());
					pst2.setString(5, availableAsset.getAssetType());
					pst2.setString(6, date.toString());
					pst2.setString(7, "not returned");
					rows = pst2.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					DBConnection.close();
				}
			}

		} else {
			throw new OverDueAssetFoundException();
		}

		if (rows == 1)
			return "Borrowing Process Done";
		else
			return "Borrowing Process Stopped";
	}

	// Method returns list of BorrowedAssets

	@Override
	public List<BorrowedAsset> getBorrowedAssetsDetails(User user) throws AssetsNotFoundException {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM BorrowedAsset WHERE userId=?";
		List<BorrowedAsset> borrowedAssetsList = new ArrayList<>();
		BorrowedAsset borrowedAsset = new BorrowedAsset();

		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(query);
			pst.setInt(1, user.getUserId());
			rs = pst.executeQuery();
			while (rs.next()) {
				borrowedAsset.setUserId(rs.getInt(1));
				borrowedAsset.setAssetId(rs.getInt(2));
				borrowedAsset.setUserName(rs.getString(3));
				borrowedAsset.setAssetName(rs.getString(4));
				borrowedAsset.setAssetType(rs.getString(5));
				borrowedAsset.setDateBorrowed(rs.getDate(6));
				borrowedAsset.setStatus(rs.getString(7));
				borrowedAssetsList.add(borrowedAsset);
			}

		} catch (SQLException e) {
			throw new AssetsNotFoundException();
		} finally {
			DBConnection.close();
		}
		if (borrowedAssetsList.isEmpty())
			throw new AssetsNotFoundException();
		else
			return borrowedAssetsList;
	}

	// Method returns list of All available Assets

	@Override
	public List<Asset> getAllAvailableAssets() throws AssetsNotFoundException {
		List<Asset> availableAssetsList = new ArrayList<Asset>();
		String query = "Select * FROM Asset WHERE isAvailable=?";
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(query);
			pst.setBoolean(1, true);
			rs = pst.executeQuery();
			while (rs.next()) {
				Asset asset = new Asset();
				asset.setAssetId(rs.getInt(1));
				asset.setAssetName(rs.getString(2));
				asset.setAssetType(rs.getString(3));
				asset.setDescription(rs.getString(4));
				asset.setDateAdded(rs.getDate(5));
				asset.setIsAvailable(rs.getBoolean(6));
				asset.setLendingPeriod(rs.getInt(7));
				asset.setLateFee(rs.getInt(8));
				availableAssetsList.add(asset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		if (availableAssetsList.isEmpty())
			throw new AssetsNotFoundException();
		else
			return availableAssetsList;
	}

	// Method used for returning an Asset

	@Override
	public String returningAsset(int assetId, User user) throws AssetsNotFoundException {
		String query1 = "SELECT status FROM BorrowedAsset WHERE assetId=?";
		String query2 = "UPDATE BorrowedAsset SET status=? WHERE assetId=?";
		String query3 = "UPDATE Asset SET isAvailable=? WHERE assetId=?";
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		int row = 0;
		BorrowedAsset borrowedAsset = new BorrowedAsset();
		try {
			conn = DBConnection.getConnection();
			pst = conn.prepareStatement(query1);
			pst.setInt(1, assetId);
			rs = pst.executeQuery();
			while (rs.next()) {
				borrowedAsset.setStatus(rs.getString(1));
			}
			if (!borrowedAsset.getStatus().equals("returned")) {
				pst2 = conn.prepareStatement(query2);
				pst2.setString(1, "returned");
				pst2.setInt(2, assetId);
				row = pst2.executeUpdate();
				pst3 = conn.prepareStatement(query3);
				pst3.setBoolean(1, true);
				pst3.setInt(2, assetId);
				pst3.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (row == 1)
			return "Asset returning successfull";
		else
			return "Asset returning not successfull";
	}

	// Method return Employee details

	@Override
	public User getEmployeeDetails(String emailId_or_userName) {
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

		return user;
	}

}

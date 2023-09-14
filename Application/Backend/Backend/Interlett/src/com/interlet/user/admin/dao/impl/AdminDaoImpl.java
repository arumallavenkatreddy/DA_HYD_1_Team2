package com.interlet.user.admin.dao.impl;

import com.interlet.dbconnection.DBConnection;
import com.interlet.exceptions.AssetsNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.user.admin.dao.AdminDao;

public class AdminDaoImpl implements AdminDao {

	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	List<String> assetTypes = new ArrayList<String>();
	List<String> assetNames = new ArrayList<String>();
	Map<String, Integer> lendingPeriods = new HashMap<String, Integer>();
	List<Asset> assetsList = new ArrayList<Asset>();

	// Method is used to add assets

	@Override
	public String addAsset(Asset asset) {
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		Connection conn;
		PreparedStatement pst;
		int rows = 0;
		conn = DBConnection.getConnection();
		String query = "insert into Asset values(?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, asset.getAssetId());
			pst.setString(2, asset.getAssetName());
			pst.setString(3, asset.getAssetType());
			pst.setString(4, asset.getDescription());
			pst.setString(5, date.toString());
			pst.setBoolean(6, true);
			pst.setInt(7, asset.getLendingPeriod());
			pst.setInt(8, asset.getLateFee());
			rows = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		if (rows == 1)
			return "Asset Added";
		else
			return "Asset Not Added";
	}

	// Method returns list of all assets from database

	@Override
	public List<Asset> getAllAssets() {
		List<Asset> assetsList = new ArrayList<Asset>();
		conn = DBConnection.getConnection();
		String query = "SELECT * FROM Asset";
		try {
			pst = conn.prepareStatement(query);
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
				assetsList.add(asset);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		return assetsList;
	}

	// Method returns list of over due assets by date

	@Override
	public List<BorrowedAsset> overDueAssetsByDate() {
		List<BorrowedAsset> borrowedAssetsList = new ArrayList<BorrowedAsset>();
		List<BorrowedAsset> overDueAssetsList = new ArrayList<BorrowedAsset>();

		conn = DBConnection.getConnection();
		String query = "SELECT * FROM BorrowedAsset";
		LocalDate currentDate = LocalDate.now();
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				BorrowedAsset borrowedAsset = new BorrowedAsset();
				borrowedAsset.setUserId(rs.getInt(1));
				borrowedAsset.setAssetId(rs.getInt(2));
				borrowedAsset.setUserName(rs.getString(3));
				borrowedAsset.setAssetName(rs.getString(4));
				borrowedAsset.setAssetType(rs.getString(5));
				borrowedAsset.setDateBorrowed(rs.getDate(6));
				borrowedAsset.setStatus(rs.getString(7));
				borrowedAssetsList.add(borrowedAsset);
			}
			List<Asset> a = getAllAssets();

			for (Asset assets : a) {
				assetTypes.add(assets.getAssetType());
			}

			for (Asset assets : a) {
				lendingPeriods.put(assets.getAssetType(), assets.getLendingPeriod());
			}

			for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBorrowed = null;
				try {
					dateBorrowed = dtf.parse(borrowedAsset.getDateBorrowed().toString());

				} catch (ParseException e) {
					e.printStackTrace();
				}
				LocalDate borrowedDate = dateBorrowed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				Period period = Period.between(borrowedDate, currentDate);

				if (assetTypes.contains(borrowedAsset.getAssetType())
						&& period.getDays() > lendingPeriods.get(borrowedAsset.getAssetType()) || period.getMonths() > 0
						|| period.getYears() > 0) {
					if (!borrowedAsset.getStatus().equals("returned"))
						overDueAssetsList.add(borrowedAsset);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}

		return overDueAssetsList;
	}

	// Method returns list of over due assets by assetType

	@Override
	public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException {
		List<BorrowedAsset> borrowedAssetsList = new ArrayList<BorrowedAsset>();
		List<BorrowedAsset> overDueAssetsList = new ArrayList<BorrowedAsset>();

		conn = DBConnection.getConnection();
		String query = "SELECT * FROM BorrowedAsset";
		LocalDate currentDate = LocalDate.now();
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				BorrowedAsset borrowedAsset = new BorrowedAsset();
				borrowedAsset.setUserId(rs.getInt(1));
				borrowedAsset.setAssetId(rs.getInt(2));
				borrowedAsset.setUserName(rs.getString(3));
				borrowedAsset.setAssetName(rs.getString(4));
				borrowedAsset.setAssetType(rs.getString(5));
				borrowedAsset.setDateBorrowed(rs.getDate(6));
				borrowedAsset.setStatus(rs.getString(7));
				borrowedAssetsList.add(borrowedAsset);
			}

			for (Asset assets : getAllAssets()) {
				assetTypes.add(assets.getAssetType());
			}
			for (Asset assets : getAllAssets()) {
				lendingPeriods.put(assets.getAssetType(), assets.getLendingPeriod());
			}

			for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBorrowed = null;
				try {
					dateBorrowed = dtf.parse(borrowedAsset.getDateBorrowed().toString());

				} catch (ParseException e) {
					e.printStackTrace();
				}
				LocalDate borrowedDate = dateBorrowed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Period period = Period.between(borrowedDate, currentDate);
				if (borrowedAsset.getAssetType().equals(assetType)) {
					if (period.getDays() > lendingPeriods.get(assetType) || period.getMonths() > 0
							|| period.getYears() > 0) {
						if (!borrowedAsset.getStatus().equals("returned")) {
							overDueAssetsList.add(borrowedAsset);
						}
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		if (overDueAssetsList.isEmpty())
			throw new AssetsNotFoundException();
		else
			return overDueAssetsList;
	}

	// Method returns list of over due assets by assetName

	@Override
	public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException {
		List<BorrowedAsset> borrowedAssetsList = new ArrayList<BorrowedAsset>();
		List<BorrowedAsset> overDueAssetsList = new ArrayList<BorrowedAsset>();

		conn = DBConnection.getConnection();
		String query = "SELECT * FROM BorrowedAsset";
		LocalDate currentDate = LocalDate.now();
		try {
			pst = conn.prepareStatement(query);
			rs = pst.executeQuery();
			while (rs.next()) {
				BorrowedAsset borrowedAsset = new BorrowedAsset();
				borrowedAsset.setUserId(rs.getInt(1));
				borrowedAsset.setAssetId(rs.getInt(2));
				borrowedAsset.setUserName(rs.getString(3));
				borrowedAsset.setAssetName(rs.getString(4));
				borrowedAsset.setAssetType(rs.getString(5));
				borrowedAsset.setDateBorrowed(rs.getDate(6));
				borrowedAsset.setStatus(rs.getString(7));
				borrowedAssetsList.add(borrowedAsset);
			}

			for (Asset assets : getAllAssets()) {
				assetNames.add(assets.getAssetName());
			}
			for (Asset assets : getAllAssets()) {
				lendingPeriods.put(assets.getAssetName(), assets.getLendingPeriod());
			}
			for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
				SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
				Date dateBorrowed = null;
				try {
					dateBorrowed = dtf.parse(borrowedAsset.getDateBorrowed().toString());

				} catch (ParseException e) {
					e.printStackTrace();
				}
				LocalDate borrowedDate = dateBorrowed.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				Period period = Period.between(borrowedDate, currentDate);

				if (borrowedAsset.getAssetName().equals(assetName)) {

					if (period.getDays() > lendingPeriods.get(assetName) || period.getMonths() > 0
							|| period.getYears() > 0) {

						if (!borrowedAsset.getStatus().equals("returned")) {

							overDueAssetsList.add(borrowedAsset);
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close();
		}
		if (overDueAssetsList.isEmpty())
			throw new AssetsNotFoundException();
		else
			return overDueAssetsList;
	}

}

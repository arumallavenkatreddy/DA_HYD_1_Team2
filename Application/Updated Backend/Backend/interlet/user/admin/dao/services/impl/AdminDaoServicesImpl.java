package com.interlet.user.admin.dao.services.impl;

import java.util.List;
import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.user.admin.dao.AdminDao;
import com.interlet.user.admin.dao.impl.AdminDaoImpl;
import com.interlet.user.admin.dao.services.AdminDaoServices;

public class AdminDaoServicesImpl implements AdminDaoServices {

	AdminDao adminDao = new AdminDaoImpl();

	// Method is used to add assets

	@Override
	public String addAsset(Asset asset) {
		return adminDao.addAsset(asset);
	}

	// Method returns list of over due Borrowed Assets by date

	@Override
	public List<BorrowedAsset> overDueAssetsByDate() {

		return adminDao.overDueAssetsByDate();
	}
	// Method returns list of over due Borrowed Assets by assetName

	@Override
	public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException {

		return adminDao.overDueAssetsByAssetName(assetName);
	}

	// Method returns list of over due assets by AssetType

	@Override
	public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException {

		return adminDao.overDueAssetByAssetType(assetType);
	}

	// Method returns list of all assets from database

	@Override
	public List<Asset> getAllAssets() {

		return adminDao.getAllAssets();
	}

}

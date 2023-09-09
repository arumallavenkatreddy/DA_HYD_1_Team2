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

	@Override
	public int addAsset(Asset asset) {
		return adminDao.addAsset(asset);
	}

	@Override
	public List<BorrowedAsset> overDueAssetsByDate() throws AssetsNotFoundException {

		return adminDao.overDueAssetsByDate();
	}

	@Override
	public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException {

		return adminDao.overDueAssetsByAssetName(assetName);
	}

	@Override
	public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException {

		return adminDao.overDueAssetByAssetType(assetType);
	}

}

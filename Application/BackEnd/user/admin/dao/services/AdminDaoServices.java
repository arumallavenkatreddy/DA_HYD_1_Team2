package com.interlet.user.admin.dao.services;

import java.util.List;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;

public interface AdminDaoServices {
	public int addAsset(Asset asset);

	public List<BorrowedAsset> overDueAssetsByDate() throws AssetsNotFoundException;

	public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException;

	public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException;
}

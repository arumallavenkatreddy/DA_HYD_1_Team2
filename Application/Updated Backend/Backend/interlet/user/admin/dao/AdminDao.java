package com.interlet.user.admin.dao;

import java.util.List;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;

public interface AdminDao {
	
	// Method is used to add assets
	
	public String addAsset(Asset asset);

	// Method returns list of over due assets by date

	public List<BorrowedAsset> overDueAssetsByDate();

	// Method returns list of over due assets by assetName
	
	public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException;
	
	// Method returns list of over due assets by assetType

	public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException;

	// Method returns list of all assets from database
	
	public List<Asset> getAllAssets();

}

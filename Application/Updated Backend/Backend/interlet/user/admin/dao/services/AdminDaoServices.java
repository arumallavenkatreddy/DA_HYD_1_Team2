package com.interlet.user.admin.dao.services;

import java.util.List;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;

public interface AdminDaoServices {
	// Method is used to add assets
	
		public String addAsset(Asset asset);

		// Method returns list of over due Borrowed Assets by date

		public List<BorrowedAsset> overDueAssetsByDate();

		// Method returns list of over due assets by name
		
		public List<BorrowedAsset> overDueAssetsByAssetName(String assetName) throws AssetsNotFoundException;
		
		// Method returns list of over due Borrowed Assets by assetName

		public List<BorrowedAsset> overDueAssetByAssetType(String assetType) throws AssetsNotFoundException;

		// Method is used to get all assets from database
		
		public List<Asset> getAllAssets();
}

package com.interlet.ui;

import java.util.List;
import java.util.Scanner;

import com.interlet.beans.Asset;
import com.interlet.beans.BorrowedAsset;
import com.interlet.exceptions.AssetsNotFoundException;
import com.interlet.user.admin.dao.services.AdminDaoServices;
import com.interlet.user.admin.dao.services.impl.AdminDaoServicesImpl;

public class Admin {
	public int adminServices() {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		AdminDaoServices adminDaoServices = new AdminDaoServicesImpl();
		System.out.println("Welcome Admin");
		while (choice != 6) {
			System.out.println();
			System.out.println("1 ---> Adding Asset");
			System.out.println("2 ---> Get over due asset by date");
			System.out.println("3 ---> Get over due asset by asset name");
			System.out.println("4 ---> Get over due asset by asset type");
			System.out.println("5 ---> Get all Assets");
			System.out.println("6 ---> Logout");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				Asset asset = new Asset();

				System.out.println("Enter Asset Name");
				String assetName = sc.next();
				asset.setAssetName(assetName);
				System.out.println("Enter Asset Type");
				String assetType = sc.next();
				asset.setAssetType(assetType);
				System.out.println("Enter Description");
				String description = sc.next();
				asset.setDescription(description);
				System.out.println("Enter Lending Period");
				int lendingPeriod = sc.nextInt();
				asset.setLendingPeriod(lendingPeriod);
				System.out.println("Enter Late Fee");
				int lateFee = sc.nextInt();
				asset.setLateFee(lateFee);
				String result = adminDaoServices.addAsset(asset);
				System.out.println(result);
				break;
			}
			case 2: {

				List<BorrowedAsset> borrowedAssetsList = adminDaoServices.overDueAssetsByDate();
				if (borrowedAssetsList.isEmpty()) {
					System.out.println("No Over Due Assets are found");
				} else {
					for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
						System.out.println(borrowedAsset);
					}
				}
				break;

			}
			case 3: {
				System.out.println("Enter Asset Name");
				String assetName = sc.next();
				try {
					List<BorrowedAsset> borrowedAssetsList = adminDaoServices.overDueAssetsByAssetName(assetName);
					for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
						System.out.println(borrowedAsset);
					}
				} catch (AssetsNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				System.out.println("Enter Asset Type");
				String assetType = sc.next();
				try {
					List<BorrowedAsset> borrowedAssetsList = adminDaoServices.overDueAssetByAssetType(assetType);
					for (BorrowedAsset borrowedAsset : borrowedAssetsList) {
						System.out.println(borrowedAsset);
					}
				} catch (AssetsNotFoundException e) {
					System.out.println(e.getMessage());
				}
				break;
			}
			case 5: {
				List<Asset> assetsList = adminDaoServices.getAllAssets();
				if (assetsList.isEmpty()) {
					System.out.println("Assets list is empty");
				} else {
					for (Asset asset : assetsList) {
						System.out.println(asset);
					}
				}
				break;
			}
			default:
				System.out.println("Log Out Succesfull");
				break;
			}

		}
		sc.close();
		return 3;
	}
}

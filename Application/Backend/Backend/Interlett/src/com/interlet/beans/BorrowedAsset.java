package com.interlet.beans;

import java.util.Date;

public class BorrowedAsset {
	private int userId;
	private int assetId;
	private String userName;
	private String assetName;
	private String assetType;
	private Date dateBorrowed;
	private String status;
	
	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAssetId() {
		return assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Date getDateBorrowed() {
		return dateBorrowed;
	}

	public void setDateBorrowed(Date dateBorrowed) {
		this.dateBorrowed = dateBorrowed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "BorrowedAsset [userId=" + userId + ", assetId=" + assetId + ", userName=" + userName + ", assetName="
				+ assetName + ", assetType=" + assetType + ", dateBorrowed=" + dateBorrowed + ", status=" + status
				+ "]";
	}
}

package com.interlet.beans;

import java.util.Date;
import java.util.Random;

public class Asset {
	private int assetId;
	private String assetName;
	private String assetType;
	private String description;
	private Date dateAdded;
	private boolean isAvailable;
	private int lendingPeriod;
	private int lateFee;

	public Asset() {
		Random random = new Random();
		assetId = random.nextInt(8) + 1;
		assetId = (assetId * 10) + random.nextInt(8) + 1;
		assetId = (assetId * 10) + random.nextInt(8) + 1;
		assetId = (assetId * 10) + random.nextInt(8) + 1;
		assetId = (assetId * 10) + random.nextInt(8) + 1;
		assetId = (assetId * 10) + random.nextInt(8) + 1;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public int getAssetId() {
		return assetId;
	}

	public String getAssetName() {
		return assetName;
	}

	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getLendingPeriod() {
		return lendingPeriod;
	}

	public void setLendingPeriod(int lendingPeriod) {
		this.lendingPeriod = lendingPeriod;
	}

	public int getLateFee() {
		return lateFee;
	}

	public void setLateFee(int lateFee) {
		this.lateFee = lateFee;
	}

	@Override
	public String toString() {
		return "Asset [assetId=" + assetId + ", assetName=" + assetName + ", assetType=" + assetType + ", description="
				+ description + ", dateAdded=" + dateAdded + ", isAvailable=" + isAvailable + ", lendingPeriod="
				+ lendingPeriod + ", lateFee=" + lateFee + "]";
	}

}

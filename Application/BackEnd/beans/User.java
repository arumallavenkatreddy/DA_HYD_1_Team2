package com.interlet.beans;

import java.util.Random;

public class User {
	private int userId;
	private String userName;
	private String role;
	private long phoneNumber;
	private String emailId;
	private String password;

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return userName;
	}

	public void setName(String name) {
		this.userName = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		Random random = new Random();
		userId = random.nextInt(8) + 1;
		userId = (userId * 10) + random.nextInt(8) + 1;
		userId = (userId * 10) + random.nextInt(8) + 1;
		userId = (userId * 10) + random.nextInt(8) + 1;
		userId = (userId * 10) + random.nextInt(8) + 1;
	}
}

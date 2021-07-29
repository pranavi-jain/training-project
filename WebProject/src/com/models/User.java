package com.models;

public class User {
	private int userId, phone;
	private String name, regDate, address, email;
	
	public User() {
		
	}
	
	public User(int id, String name, int phone, String email, String addr, String date) {
		this.userId = id;
		this.name = name;
		this.regDate = date;
		this.address = addr;
		this.phone = phone;
		this.email = email;
	}
	
	public int getUserId() {
		return this.userId;
	}

	public int getPhone() {
		return this.phone;
	}
	
	public String getName() {
		return this.name;
	}

	public String getRegDate() {
		return this.regDate;
	}

	public String getAddress() {
		return this.address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

}

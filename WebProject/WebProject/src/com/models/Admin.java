package com.models;

public class Admin {

	private int adminId;
	private String name, email;
	
	public Admin() {
		
	}
	
	public Admin(int id, String name, String email) {
		this.adminId = id;
		this.name = name;
		this.email = email;
	}
	
	public int getAdminId() {
		return this.adminId;
	}
	
	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

}

package com.models;

public class Course {
	private int courseId;
	private String cName;
	private String cDesc;
	private String cFees;
	private String cResc;
	
	public Course(int id, String name, String desc, String fees, String resc) {
		this.courseId = id;
		this.cName = name;
		this.cDesc = desc;
		this.cFees = fees;
		this.cResc = resc;
	}
	
	public int getCourseId() {
		return this.courseId;
	}
	
	public String getCName() {
		return this.cName;
	}

	public String getCDesc() {
		return this.cDesc;
	}
	
	public String getCFees() {
		return this.cFees;
	}
	
	public String getCResc() {
		return this.cResc;
	}

}

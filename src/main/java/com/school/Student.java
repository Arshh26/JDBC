package com.school;

public class Student {
	private int studentID;
	private String studentName;
	private String studentGender;
	
	public Student() {

	}

	public Student(int studentID, String studentName, String studentGender) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentGender = studentGender;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	
	
	

}

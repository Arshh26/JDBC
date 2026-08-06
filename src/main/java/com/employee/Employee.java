package com.employee;

public class Employee {
	private int id;
	private String employeeName;
	private String role;
	
	
	
	public Employee(int id, String employeeName, String role) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

}

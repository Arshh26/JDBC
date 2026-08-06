package com.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentServices {
	private static Connection connection;
	
	static {
		try { 
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school",
					"postgres",
					"123");
			System.out.println("Connection established successfully!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertStudent(Student student) {
		try {
		String insertStu = "insert into student values(?, ?, ?)";
		PreparedStatement ps = connection.prepareStatement(insertStu);
		ps.setInt(1, student.getStudentID());
		ps.setString(2, student.getStudentName());
		ps.setString(3, student.getStudentGender());
		int rows = ps.executeUpdate();
		System.out.println("Student Added Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteStudent(int id) {
		String deleteStu = "delete from student where studentID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteStu);
			ps.setInt(1, id);
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Student Deleted Successfully");
			} else {
			System.out.println("There is no data");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(Student student) {
		String updateStu = "UPDATE student SET studentName = ?, studentGender = ? WHERE studentID = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(updateStu);
			ps.setInt(3, student.getStudentID());
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentGender());
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println("Student Updated");
			} else {
			System.out.println("Sorry, i can't find any data to update!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void fetch() {
		String listStu = "select * from student";
		try {
			PreparedStatement ps = connection.prepareStatement(listStu);
			ResultSet rs = ps.executeQuery();
			System.out.println("========List of Students=========");
			while (rs.next()) {
				int id = rs.getInt("studentID");
				String name = rs.getString("studentName");
				String gender = rs.getString("studentGender");
				
				System.out.println("Student Id: "+id);
				System.out.println("Student Name: "+name);
				System.out.println("Student Gender: "+gender);
				System.out.println("=================================");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	
	
	
		
		

}

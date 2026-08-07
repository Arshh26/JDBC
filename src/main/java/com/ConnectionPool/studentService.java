package com.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class studentService {
	public void insertStudent(Student student) {
	String insertStu = "insert into student values(?, ?, ?)";
	Connection con = null;
		try {
			con = ConnectionPool.getConnection();
			PreparedStatement ps = con.prepareStatement(insertStu);
			ps.setInt(1, student.getStudentID());
			ps.setString(2, student.getStudentName());
			ps.setString(3, student.getStudentGender());
			
			int rows = ps.executeUpdate();
			
			if(rows > 0) {
				System.out.println(rows +" inserted successfully");
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public void updateStudent(Student student) {
		String updateStudent = "update student set studentName=?, studentGender=? where studentID=?";
		Connection con = null;
		try {
			con = ConnectionPool.getConnection();
			PreparedStatement ps = con.prepareStatement(updateStudent);
			ps.setInt(3, student.getStudentID());
			ps.setString(1, student.getStudentName());
			ps.setString(2, student.getStudentGender());
			
			int rows = ps.executeUpdate();
			
			if(rows>0) {
				System.out.println("Updated Successfully");
			}
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public void deleteStudent(int id) {
		String deleteStu = "delete from student where id=?";
		Connection con = null;
		try {
			PreparedStatement ps = con.prepareStatement(deleteStu);
			ps.setInt(1, id);
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				System.out.println("Student Deleted");
			} else {
				System.out.println("Sorry there is no data to delete");
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
	}
	
	public void fetch() {
		String fetchData = "Select * from student";
		Connection con = null;
		try {
			PreparedStatement ps = con.prepareStatement(fetchData);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("studentID");
				String name = rs.getString("studentName");
				String gender = rs.getString("studentGender");
				
				System.out.println("Student Name: "+ name);
				System.out.println("Student ID: "+ id);
				System.out.println("Student Gender: "+ gender);
			}
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.releaseConnection(con);
		}
	}

}

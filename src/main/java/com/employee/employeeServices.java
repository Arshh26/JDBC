package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class employeeServices {
	private static Connection connection;
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection
					("jdbc:postgresql://localhost:5432/company",
						"postgres",
						"123");
			System.out.println("Connection Established Succsessfully!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void insert(Employee employee) {
		String insertQuery = "insert into employee1 values(?, ?, ?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(insertQuery);
			pstm.setInt(1, employee.getId());
			pstm.setString(2, employee.getEmployeeName());
			pstm.setString(3, employee.getRole());
			
			int rows = pstm.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateEmployee(Employee employee) {
		String updateQuery = "update employee set employeeid = ?, name = ?, role = ?";
		
		try {
			PreparedStatement pstm = connection.prepareStatement(updateQuery);
			pstm.setInt(1, employee.getId());
			pstm.setString(2, employee.getEmployeeName());
			pstm.setString(3, employee.getRole());
			
			int rows = pstm.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace(); 
			
		}
		
	}
	
	public static void deleteEmployee(int id) {

	    String deleteQuery = "DELETE FROM employee1 WHERE employeeID = ?";

	    try {
	        PreparedStatement pstm = connection.prepareStatement(deleteQuery);

	        pstm.setInt(1, id);

	        int rows = pstm.executeUpdate();

	        if (rows > 0) {
	            System.out.println("Employee deleted successfully.");
	        } else {
	            System.out.println("Employee not found.");
	        }

	        pstm.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public static void fetchEmployees() {

	    String selectQuery = "SELECT * FROM employee1";

	    try {

	        PreparedStatement pstm = connection.prepareStatement(selectQuery);

	        ResultSet rs = pstm.executeQuery();

	        while (rs.next()) {

	            System.out.println(rs.getInt("employeeID"));
	            System.out.println(rs.getString("name"));
	            System.out.println(rs.getString("role"));

	        }

	        rs.close();
	        pstm.close();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

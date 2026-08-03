package com.qspiders.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbcDemo2 {
	public static void main(String[] args) {
		try {
			//Loading driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded succesessfully");
			
			//Establishing connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
					"postgres",
					"123");
			System.out.println("Connection Established successfully");
			
			
			//prepared Statement
			String insertQuery = ("insert into patient values(?, ?, ?, ?)");
			PreparedStatement pstm = con.prepareStatement(insertQuery);
			
			pstm.setInt(1, 4584);
			pstm.setString(2, "Basappa");
			pstm.setInt(3, 35);
			pstm.setString(4, "corona");
			
			pstm.addBatch();
			pstm.setInt(1, 1241);
			pstm.setString(2, "Basu");
			pstm.setInt(3, 34);
			pstm.setString(4, "fever");
			
			pstm.addBatch();
			pstm.setInt(1, 14251);
			pstm.setString(2, "Sharan");
			pstm.setInt(3, 33);
			pstm.setString(4, "cough");
			
			pstm.addBatch();
			pstm.setInt(1, 8525);
			pstm.setString(2, "Goutam");
			pstm.setInt(3, 32);
			pstm.setString(4, "cold");
			
			pstm.addBatch();
			pstm.setInt(1, 7596);
			pstm.setString(2, "malik");
			pstm.setInt(3, 31);
			pstm.setString(4, "fever");
			
			int arr[] = pstm.executeBatch();
			for (int i : arr) {
				System.out.println(i+"Query executed");
			}
			
			
			//update 
//			String updateQuery = ("update patient set id=? where name=?");
//			PreparedStatement pstm = con.prepareStatement(updateQuery);
//			pstm.setInt(1, 1003);
//			pstm.setString(2, "basup");
//			pstm.execute();
//			System.out.println("Updated query");
			
			//delete
//			String deleteQuery = ("delete from patient where id=?");
//			PreparedStatement pstm = con.prepareStatement(deleteQuery);
//			pstm.setInt(1, 1001);
//			pstm.execute();
//			System.out.println("Query deleted");
//			
//			
			
			//Execute query
//			ResultSet rs = pstm.executeQuery(insertQuery);
//			while(rs.next()) {
//				System.out.println(rs.getInt("id"));
//				System.out.println(rs.getString("name"));
//				System.out.println(rs.getInt("age"));
//				System.out.println(rs.getString("disease"));
//			}
			con.close();
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connections = new ArrayList<>(); //Connections are stored in a list
	static {
		try {
			Class.forName("org.postgresql.Driver");
			for(int i=0; i<5; i++) {
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school",
						 "postgres",
						 "123");
				connections.add(con);
			}
			System.out.println("5 Connections Established Successfully!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(!connections.isEmpty()) {
			Connection con = connections.get(0);
			connections.remove(0);
			return con;
		}
		
		System.out.println("No connections are availbale");
		return null;
	}
	
	public static void releaseConnection(Connection con) {
		if(con!=null) {
			connections.add(con);
		}

	}

}

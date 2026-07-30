package com.qspiders.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        try {
            // Step 1: Load Driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully!");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/institute",
                    "postgres",
                    "123");

            System.out.println("Connection Established Successfully!");

            // Step 3: Create PreparedStatement
            String insertQuery = "INSERT INTO trainers (id, name, email) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            // Insert First Record
            ps.setInt(1, 107);
            ps.setString(2, "Rehman");
            ps.setString(3, "rehman@gmail.com");

            int rows = ps.executeUpdate();
            System.out.println(rows + " row inserted.");

            // Insert Second Record
            ps.setInt(1, 108);
            ps.setString(2, "Hafiz");
            ps.setString(3, "hafiz@gmail.com");

            rows = ps.executeUpdate();
            System.out.println(rows + " row inserted.");

            // Step 4: Display Records
            String selectQuery = "SELECT * FROM trainers";
            PreparedStatement ps2 = con.prepareStatement(selectQuery);

            ResultSet rs = ps2.executeQuery();

            System.out.println("\nTrainer Details:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("email"));
            }

            // Step 5: Close Resources
            rs.close();
            ps2.close();
            ps.close();
            con.close();

            System.out.println("\nResources Closed Successfully!");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
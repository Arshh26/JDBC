package com.qspiders.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo1 {

    public static void main(String[] args) {

        try {
            // Step 1: Load the Driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver Loaded Successfully");

            // Step 2: Establish the Connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/school",
                    "postgres",
                    "123");
            System.out.println("Connection Established successfully");

            System.out.println("Connection Established Successfully");

            // Step 3: Create Statement
            Statement statement = connection.createStatement();
            System.out.println("Statement Created Successfully");

            //  INSERT 
            String insertQuery = "INSERT INTO student VALUES('4KM22CS020','Arsh',30,'arsh@gmail.com')";

            int insertRows = statement.executeUpdate(insertQuery);

            System.out.println(insertRows + " Row Inserted Successfully");

            //  UPDATE 
            String updateQuery = "UPDATE student SET name='Rehman' WHERE rollno='4KM22CS017'";

            int updateRows = statement.executeUpdate(updateQuery);

            System.out.println(updateRows + " Row Updated Successfully");

           // SELECT
            String selectQuery = "SELECT * FROM student";

            ResultSet rs = statement.executeQuery(selectQuery);

            while (rs.next()) {

                System.out.println("Roll No : " + rs.getString("rollno"));
                System.out.println("Name    : " + rs.getString("name"));
                System.out.println("Age     : " + rs.getInt("age"));
                System.out.println("Email   : " + rs.getString("email"));
           
            }

            // Step 4: Close Resources
            rs.close();
            statement.close();
            connection.close();

            System.out.println("Resources Closed Successfully");

        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception Occurred");
            e.printStackTrace();
        }
    }
}
package com.employee;

import java.util.Scanner;

public class driver {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Insert Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Fetch All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

            case 1:

                Employee employee = new Employee();

                System.out.print("Enter Employee ID: ");
                employee.setId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                employee.setEmployeeName(sc.nextLine());

                System.out.print("Enter Employee Role: ");
                employee.setRole(sc.nextLine());

                employeeServices.insert(employee);
                break;

            case 2:

                Employee employee1 = new Employee();

                System.out.print("Enter Employee ID to Update: ");
                employee1.setId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter New Employee Name: ");
                employee1.setEmployeeName(sc.nextLine());

                System.out.print("Enter New Employee Role: ");
                employee1.setRole(sc.nextLine());

                employeeServices.updateEmployee(employee1);
                break;

            case 3:

                System.out.print("Enter Employee ID to Delete: ");
                int id = sc.nextInt();

                employeeServices.deleteEmployee(id);
                break;

            case 4:

                employeeServices.fetchEmployees();
                break;

            case 5:

                System.out.println("Thank You! Exiting the application...");
                sc.close();
                System.exit(0);
                break;

            default:

                System.out.println("Invalid Choice! Please enter a number between 1 and 5.");
            }
        }
    }
}
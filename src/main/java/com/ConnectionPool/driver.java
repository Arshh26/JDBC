package com.ConnectionPool;

import java.util.Scanner;

import com.school.studentServices;

public class driver {
	public static void main(String[] args) {
		studentService service = new studentService();
		
		Scanner input = new Scanner(System.in);
		System.out.println("1. Insert Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. List all Student");
		
		System.out.println("Please Enter Your Choice: ");
		int choice = input.nextInt();
		
		switch (choice) {
		case 1:
			Student insert = new Student();
			
			System.out.println("Enter Student ID: ");
			insert.setStudentID(input.nextInt());
			input.nextLine();
			
			System.out.println("Enter Student Name: ");
			insert.setStudentName(input.nextLine());
			
			System.out.println("Enter Student Gender: ");
			insert.setStudentGender(input.nextLine());
			
			service.insertStudent(insert);
			break;
			
		case 2:
			Student update = new Student();
			
			System.out.println("Enter Student ID: ");
			update.setStudentID(input.nextInt());
			input.nextLine();
			
			System.out.println("Enter New Student Name: ");
			update.setStudentName(input.nextLine());
			
			System.out.println("Enter New Student Gender: ");
			update.setStudentName(input.nextLine());
			
			service.updateStudent(update);
			
		case 3:
			Student delete = new Student();
			
			System.out.println("Enter Student ID: ");
			int id =input.nextInt();
			input.nextLine();
			
			service.deleteStudent(id);
			break;
			
		case 4:
			Student fetch = new Student();
			
			service.fetch();

		default:
			System.out.println("Invalid Value");
			break;
		}
	}
}

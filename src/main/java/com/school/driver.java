package com.school;

import java.util.Scanner;

public class driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		studentServices stuser = new studentServices();
		
		while(true) {
			System.out.println("1 Insert Student");
			System.out.println("2 Update Student");
			System.out.println("3 Delete Student");
			System.out.println("4 List All Student");
			System.out.println("Enter your choice: ");
			
			int choice = input.nextInt();

			
			switch (choice) {
			case 1:
				Student student = new Student();
				
				System.out.println("Enter student id: ");
				student.setStudentID(input.nextInt());
				
				input.nextLine();
				
				System.out.println("Enter student name: ");
				student.setStudentName(input.nextLine());
				
				System.out.println("Enter student gender: ");
				student.setStudentGender(input.nextLine());
				
				System.out.println("Student Added");
				
				stuser.insertStudent(student);
				break;
				
			case 2:
				Student student1 = new Student();
				System.out.println("Enter student new id: ");
				student1.setStudentID(input.nextInt());
				input.nextLine();
				
				System.out.println("Enter student new name: ");
				student1.setStudentName(input.nextLine());
				
				System.out.println("Enter student new gender: ");
				student1.setStudentGender(input.nextLine());
				
				System.out.println("Student Updated");
				
				stuser.updateStudent(student1);
				break;
				
			case 3:
				Student student3 = new Student();
				System.out.println("Enter student id to remove : ");
				int id = input.nextInt();
				
				stuser.deleteStudent(id);
				break;
				
			case 4:
				stuser.fetch();
				break;
				
			default:
				System.out.println("Please choise a valid value");
				break;
			}
		}
	}
}
			
			





package com.raghav;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Welcome to Student Management App!");
			System.out.println("------------------------------------");
			System.out.println("Press 1 to ADD Student");
			System.out.println("Press 2 to DELETE Student");
			System.out.println("Press 3 to DISPLAY Student");
			System.out.println("Press 4 to EXIT app");
			System.out.println("------------------------------------");
			int c = Integer.parseInt(br.readLine());
			
			if(c == 1) {
				//Add student..
				System.out.print("Enter Student Name: ");
				String name = br.readLine();
				
				System.out.print("Enter Student Phone Number: ");
				String phone = br.readLine();
				
				System.out.print("Enter Student City: ");
				String city = br.readLine();
				
				//Create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer = StudentDao.InsertStudentToDB(st);
				if(answer) {
					System.out.println("Student is added successfully!");
				} else {
					System.out.println("Something went wrong, try again...");
				}
				System.out.println(st);
				System.out.println();
				System.out.println("------------------------------------");
				
			} else if(c == 2) {
				//Delete student...
				System.out.print("Enter student id to delete: ");
				int userId = Integer.parseInt(br.readLine());
				boolean flag = StudentDao.deleteStudent(userId);
				if(flag) {
					System.out.println("Student deleted successfully!");
					System.out.println();
					System.out.println("------------------------------------");
				} else {
					System.out.println("Something went wrong, try again...");
					System.out.println();
					System.out.println("------------------------------------");
				}
			} else if(c == 3) {
				//display student...
				StudentDao.showAllStudents();
			} else if(c == 4) {
				//exit
				break;
			} else {
				System.out.println("Please enter a valid number!");
				System.out.println();
				System.out.println("------------------------------------");
			}
		}
		System.out.println("Thankyou for using Application..");
	}
}

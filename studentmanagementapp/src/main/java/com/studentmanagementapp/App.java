package com.studentmanagementapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.studentdata.Student;
import com.studentdata.StudentDao;

public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to student management app");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to dispaly Student");
			System.out.println("Press 4 to exit app");

			int num = Integer.parseInt(br.readLine());

			if (num == 1) {
				// add Student

				System.out.println("Enter user name : ");
				String name = br.readLine();

				System.out.println("Enter user phone : ");
				String phone = br.readLine();

				System.out.println("Enter user city : ");
				String city = br.readLine();

				// create object of student to store

				Student st = new Student(name, phone, city);

				boolean answer = StudentDao.insertStudentToDb(st);

				if (answer) {
					System.out.println("Succesfuly added.....");
				} else {
					System.out.println("Something went wrong.......");
				}
			}

			else if (num == 2) {

				// delete student
				
				System.out.println("Enter Student id to delete : ");
				int userId = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.deleteStudentToDb(userId);
				
				if (answer) {
					System.out.println("Succesfuly deleted.....");
				} else {
					System.out.println("Something went wrong.......");
				}
			}

			else if (num == 3) {

				// display student
				StudentDao.showAllStudent();
				
			}

			else if (num == 4) {

				// exit the app
				break;
			} else {

			}

			System.out.println("Thank you for using my application");
		}
	}
}

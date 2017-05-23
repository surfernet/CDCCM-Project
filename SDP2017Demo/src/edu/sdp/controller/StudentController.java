package edu.sdp.controller;

import java.util.Scanner;

import edu.sdp.services.StudentService;
import edu.sdp.services.impl.SDPDemoExceptions;
import edu.sdp.services.impl.StudentServiceImpl;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         This class is used as the controller class for performing student
 *         operations. This class having different operation based on user
 *         priveliadge. Normal student can only list the students where as the
 *         staff user can perform CURD operations on the DB.
 * 
 *         This demo is to show the different access types similar operations.
 *
 */

public class StudentController {

	private Scanner consoleScanner;
	private boolean conditionFlag = true;
	private StudentService studentService;

	public StudentController(Scanner consoleScanner) {
		this.consoleScanner = consoleScanner;
		studentService = new StudentServiceImpl();
	}

	public void startOperations() {

		do {
			System.out.println("Please Select Operation To Perform");
			System.out.println("1. List All Students. \n2. Main Menu.");
			int choice = 0;
			try {
				choice = Integer.parseInt(consoleScanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				try {
					studentService.listAllStudents();
				} catch (SDPDemoExceptions e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				conditionFlag = false;
				System.out.println("...");
				break;

			default:
				System.out.println("Invalid Choice Please Try Again");
				break;
			}

		} while (conditionFlag);
	}
}

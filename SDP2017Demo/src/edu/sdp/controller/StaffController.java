package edu.sdp.controller;

import java.util.Scanner;

import edu.sdp.pojo.StudentPOJO;
import edu.sdp.services.StaffService;
import edu.sdp.services.StudentService;
import edu.sdp.services.impl.SDPDemoExceptions;
import edu.sdp.services.impl.StaffServiceImpl;
import edu.sdp.services.impl.StudentServiceImpl;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         This class acts like a controller class for perfoming CRUD operations
 *         on Students and Staff Table into DB.
 * 
 *
 */
public class StaffController {

	// The scanner oklknlbject is not created but it is assigned with the same object
	// passed from the main class.
	private Scanner consoleScanner;

	// the condition flag is used for handling loop condition.
	private boolean conditionFlag = true;

	private StaffService staffService = new StaffServiceImpl();

	// constructor with parameters.
	public StaffController(Scanner consoleScanner) {
		// this operator refers to the variable of current object.
		this.consoleScanner = consoleScanner;
	}

	// start of all operations
	public void startOperations() {

		do {
			System.out.println("Please Select Operation To Perform");
			System.out.println("1. Students Operation. \n2. Staff Operations. \n3. Main Menu.");
			int choice = 0;
			try {
				choice = Integer.parseInt(consoleScanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				startStudentOperations();

				break;
			case 2:
				startStaffOperations();
				break;
			case 3:
				conditionFlag = false;
				System.out.println("...");
				break;

			default:
				System.out.println("Invalid Choice Please Try Again");
				break;
			}

		} while (conditionFlag);

	}

	private void startStudentOperations() {
		boolean studFlag = true;
		do {
			System.out.println("Please Select Operation To Perform");
			System.out.println("1. List All Students. \n2. Insert Student. \n3. Delete Student \n4. Go Back To Menu.\n5. SQL Injection");
			int choice = 0;
			try {
				choice = Integer.parseInt(consoleScanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				StudentService studService = new StudentServiceImpl();
				try {
					studService.listAllStudents();
				} catch (SDPDemoExceptions e) {
					System.out.println(e.getErrorMessage());
				}
				break;
			case 2:
				StudentPOJO studentPojo = new StudentPOJO();
				System.out.println("Enter First name :");
				studentPojo.setFirst_name(consoleScanner.nextLine());
				System.out.println("Enter Last name :");
				studentPojo.setLast_name(consoleScanner.nextLine());
				System.out.println("Enter Brance :");
				studentPojo.setBranch(consoleScanner.nextLine());
				try {
					staffService.insertStudent(studentPojo);
				} catch (SDPDemoExceptions e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:

				int rollNo;
				System.out.println("Enter RollNo To delete Students Record:");
				try {
					rollNo = Integer.parseInt(consoleScanner.nextLine());
					staffService.deleteStudent(rollNo);
				} catch (NumberFormatException e) {
					System.out.println("Error: Invalid Roll No Please Try Again.");
				} catch (SDPDemoExceptions e) {
					System.out.println("Error: " + e.getErrorMessage());
				}
				break;
			case 4:
				studFlag = false;
				System.out.println("...");
				break;
			
			case 5:
				System.out.println("Enter Roll no to be searched:");
				String inputStr = consoleScanner.nextLine();
				staffService.searchByRollNo(inputStr);
				break;
			default:
				System.out.println("Invalid Choice Please Try Again");
				break;
			}
		} while (studFlag);
		// TODO Auto-generated method stub

	}

	private void startStaffOperations() {
		do {

			System.out.println("Please Select Operation To Perform");
			System.out.println(
					"1. List All Staff Members. \n2. Insert Staff Member. \n3. Delete StaffMember \n4. Go Back To Main Menu.");
			int choice = 0;
			try {
				choice = Integer.parseInt(consoleScanner.nextLine());
			} catch (NumberFormatException e) {
			}
			switch (choice) {
			case 1:
				System.out.println("Method Not Implemented");
				break;
			case 2:
				System.out.println("Method Not Implemented");
				break;
			case 3:
				System.out.println("Method Not Implemented");
				break;
			case 4:
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

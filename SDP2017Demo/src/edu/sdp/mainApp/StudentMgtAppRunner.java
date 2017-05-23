package edu.sdp.mainApp;

import java.io.IOException;
import java.util.Scanner;

import edu.sdp.controller.StaffController;
import edu.sdp.controller.StudentController;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         This Class is the start of the program. Two types of user are
 *         considered, 1. student and 2. staff. Both have different access
 *         rights.
 * 
 *         This demo is to give you a understanding of java concepts and to give
 *         the idea way to develop the project.
 *
 */
public class StudentMgtAppRunner {

	// main Method
	public static void main(String[] args) throws IOException {
		// condition flag data type of boolean used for checking the condition
		// weather the program must terminate or not.
		// this flag can be found in different classes for displaying menus.
		boolean conditionFlag = true;
		// Scanner object is used for receiving / getting the input from the
		// console/user.
		// This scanner single object has been shared every where for fetching
		// input from user. This can be done using the singleton class concept,
		// the approach used over here is to describe how to pass the object
		// from methods.
		Scanner consoleScanner = new Scanner(System.in);

		System.out.println("|--------- Welcome To College Portal ---------|");
		// start of do while loop >> control flow
		do {
			System.out.println("Select User Type : \n1. Student. \n2. Staff.\n3. Exit. \n Enter Choice :");
			int choice = 0;
			try {
				// Try Catch block is for handling exceptions. For more details
				// please read Exception Handling in Java.
				// Integer.parseInt Method is used to convert the String input
				// to Integer data type. This throws exception so it is
				// mandatory to handle exceptions.
				choice = Integer.parseInt(consoleScanner.nextLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			// switch case is used to select one of the block matching to
			// particular conditions. Type of control flow.
			switch (choice) {
			case 1:
				// Creating object of Student class and starting the operations.
				// Also passing scanner object.
				StudentController studentCtrl = new StudentController(consoleScanner);
				studentCtrl.startOperations();
				break;
			case 2:
				// creating the object for StaffController class and passing the
				// Scanner object for scanning the input values form users.
				StaffController staffCtrl = new StaffController(consoleScanner);
				staffCtrl.startOperations();
				break;
			case 3:
				conditionFlag = false;
				break;

			default:
				// default block will execute when any of the conditions dont
				// matches.
				System.out.println("Invalid Choice Please Try Again...!");
				break;
			}

		} while (conditionFlag);
		// closing the console object
		consoleScanner.close();
		System.out.println("|--------- Thank You For Using College Portal ---------|");
	}

}

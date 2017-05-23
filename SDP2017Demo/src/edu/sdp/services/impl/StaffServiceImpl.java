package edu.sdp.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import edu.sdp.dbServices.MySQLDBConnector;
import edu.sdp.pojo.StudentPOJO;
import edu.sdp.services.StaffService;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         This class provides the application logic and builds the building
 *         breach between the controller class and the database model. All the
 *         database operations has to be called from this class.
 *
 */
public class StaffServiceImpl implements StaffService {

	private MySQLDBConnector dbConnector;

	public StaffServiceImpl() {
		dbConnector = MySQLDBConnector.getInstance();
	}

	@Override
	public void displayAllStaffMembers() {
		System.out.println("Displaying all the staff members");

	}

	@Override
	public void insertStudent(StudentPOJO studentPojo) throws SDPDemoExceptions {

		try {
			int resultCount = dbConnector
					.insert("INSERT INTO students(fname,lname,branch) VALUES('" + studentPojo.getFirst_name() + "','"
							+ studentPojo.getLast_name() + "','" + studentPojo.getBranch() + "')");
			if (resultCount > 0)
				System.out.println("Record Inserted Successfully");
			else
				System.out.println("Error Inserting Record Please Try Again");
		} catch (SQLException e) {
			throw new SDPDemoExceptions("Error Inserting Record Message:" + e.getMessage());
		}

	}

	@Override
	public void deleteStudent(int rollNo) throws SDPDemoExceptions {

		try {
			int deleteCount = dbConnector.delete("delete from students where rollNo=" + rollNo + ";");
			if (deleteCount > 0)
				System.out.println("Record Deleted Succefully");
			else
				System.out.println("Error Deleting Account.");
		} catch (SQLException e) {
			throw new SDPDemoExceptions("Error While Deleting The Record Message:" + e.getMessage());
		}
	}

	@Override
	public ResultSet searchByRollNo(String inputStr) {
		try {
			ResultSet queryList = dbConnector.query("SELECT * FROM students WHERE rollNo="+inputStr+";");
			while (queryList.next()) {
				System.out.println("\nRoll No: " + queryList.getInt("rollNo"));
				System.out.println("First Name: " + queryList.getString("fname"));
				System.out.println("Last Name: " + queryList.getString("lname"));
				System.out.println("Branch: " + queryList.getString("branch"));
				System.out.println("");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}

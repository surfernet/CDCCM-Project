package edu.sdp.services.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import edu.sdp.dbServices.MySQLDBConnector;
import edu.sdp.services.StudentService;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         This class provides the service layer between student controller and
 *         student database layer. All DB request for Student table has to be
 *         called from this class. This class also performs the applications
 *         logic.
 *
 */
public class StudentServiceImpl implements StudentService {

	private MySQLDBConnector dbConnector;

	public StudentServiceImpl() {
		dbConnector = MySQLDBConnector.getInstance();
	}

	@Override
	public void listAllStudents() throws SDPDemoExceptions {
		ResultSet studentsList;
		try {
			studentsList = dbConnector.query("SELECT * FROM students");
				
			//modificacion para  push

			while (studentsList.next()) {
				System.out.println("\nRoll No: " + studentsList.getInt("rollNo"));
				System.out.println("First Name: " + studentsList.getString("fname"));
				System.out.println("Last Name: " + studentsList.getString("lname"));
				System.out.println("Branch: " + studentsList.getString("branch"));
				System.out.println("");
			}

		} catch (SQLException e) {
			throw new SDPDemoExceptions("SQL-Excepiton Message: " + e.getMessage());
		}

	}

}

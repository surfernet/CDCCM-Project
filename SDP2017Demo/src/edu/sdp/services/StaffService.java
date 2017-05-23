package edu.sdp.services;

import java.sql.ResultSet;

import edu.sdp.pojo.StudentPOJO;
import edu.sdp.services.impl.SDPDemoExceptions;

public interface StaffService {

	void displayAllStaffMembers();

	void insertStudent(StudentPOJO studentPojo) throws SDPDemoExceptions;

	void deleteStudent(int rollNo) throws SDPDemoExceptions;

	ResultSet searchByRollNo(String inputStr);

}

package edu.sdp.dbServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Vaibhav Sakharkar
 * 
 *         Singleton class for creating and using DB object.
 * 
 *
 */

public class MySQLDBConnector {

	public Connection conn;
	private Statement statement;
	private static MySQLDBConnector dbConnectorObj;

	private MySQLDBConnector() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "collegeDB";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}

	public static MySQLDBConnector getInstance() {
		if (dbConnectorObj == null)
			dbConnectorObj = new MySQLDBConnector();

		return dbConnectorObj;
	}

	/*
	 * public static Connection name() {
	 * 
	 * return null; }
	 */

	/**
	 *
	 * @param query
	 *            String The query to be executed
	 * @return a ResultSet object containing the results or null if not
	 *         available
	 * @throws SQLException
	 */
	public ResultSet query(String query) throws SQLException {
		statement = conn.createStatement();
		ResultSet res = statement.executeQuery(query);
		return res;
	}

	/**
	 * @desc Method to insert data to a table
	 * @param insertQuery
	 *            String The Insert query
	 * @return boolean
	 * @throws SQLException
	 */
	public int insert(String insertQuery) throws SQLException {
		statement = conn.createStatement();
		int resultCount = statement.executeUpdate(insertQuery);
		return resultCount;

	}

	public int delete(String deleteQuery) throws SQLException {
		statement = conn.createStatement();
		int resultCount = statement.executeUpdate(deleteQuery);
		return resultCount;
	}
}

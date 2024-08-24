package com.comcast.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	Connection con;
	//get connection hard corded
	public void getDbconnection() throws Throwable {
		try {
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		con =DriverManager.getConnection("jbdc:mysql://localhost:3306", "root", "root");
		}
		catch (Exception e) {
		}
	}
	
	//get connection not hard corded
	/*
	 * public void getDbconnection(String url, String username, String password)
	 * throws Throwable { try { Driver driver= new Driver();
	 * DriverManager.registerDriver(driver); con =DriverManager.getConnection(url,
	 * username, password); } catch (Exception e) { } }
	 */
	
	//close the connection
	public void closeDbconnection() throws Throwable {
		try {
		con.close();
		}
		catch (Exception e) {
		}
	}
	
	//use for select query
	public ResultSet excuteSelectQuery(String query) throws SQLException {
		ResultSet result = null;

		try {
		Statement stat = con.createStatement();
		 result = stat.executeQuery(query);
		}
		catch (Exception e) {
		}
		return result;
	}
	
	//use for non select query
	public int excuteNonSelectQuery(String query) throws SQLException {
		int result = 0;

		try {
		Statement stat = con.createStatement();
		 result = stat.executeUpdate(query);
		}
		catch (Exception e) {
		}
		return result;
	}
}

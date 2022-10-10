package com.revature.rxcthefirst;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * LinkedIn tutorial (Frank P. Moley III) on using JDBC to integrate RDBMS into Java applications.
 */

public class JDBCExecutor {
	
	public static void main(String[] args) {
		
		
		//Using DBCM template to manage connections
		DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost:5433", "revature", "postgres", "root");
		
		try {
			// Establish connection to PostGreSQL server
			Connection connection = dcm.getConnection();		
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT COUNT (*) FROM customer WHERE state LIKE 'CA'");
			while(resultSet.next()){
				System.out.println(resultSet.getInt(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}

package com.sdet34l1.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;
/**
 * This class contain all common action releated to database.
 * @author ME
 *
 */

public class DatabaseStorage {
	static Connection connection;
	static Statement statement;
/**
 * This method is used to open the database connection and intiallize the connection,statement .
 * @param dBurl
 * @param dBUserName
 * @param dBPassword
 * @throws SQLException
 */

	public static void openDBConnection(String dBurl,String dBUserName,String dBPassword) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection =DriverManager.getConnection(dBurl,dBUserName,dBPassword);
		statement = connection.createStatement();
	}
/**
 * This method is used to fetch the data from database /to do DQL actions on database.
 * @param query
 * @param columneName
 * @return
 * @throws SQLException
 */

	public static ArrayList<String> getDataFromDataBase(String query, String columneName) throws SQLException {
		ArrayList<String> list = new ArrayList<>();
		ResultSet result = statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columneName));
		}
		return list;


	}


/**
 * This method is used to validate data whether it is present in database or not.
 * @param query
 * @param columneName
 * @param exceptedData
 * @return
 * @throws SQLException
 */


	public static boolean validateDataInDataBase(String query,String columneName ,String exceptedData) throws SQLException {
		ArrayList<String> list = getDataFromDataBase(query,columneName);
		boolean flag = false;
		for(String actualData:list) {
			if(actualData.equalsIgnoreCase(exceptedData)) {
				flag=true;
				break;	
			}
		}
		return flag;
	}


/**
 * This method is used to store/modification/insert/delete/ the data in database /to do the DML and DDl actions on database.
 * @param query
 * @throws SQLException
 */
	public static void setDataInDataBase(String query) throws SQLException {
		int result = statement.executeUpdate(query);
		if(result>=1) {
			System.out.println("Data Entered/modification is successfully");
		}
	}
/**
 * This method is used to cloase the database connection.
 */
	public static void closeConnection() {
		try {
			connection.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("while closeing the connection we get exception");

		}
	}



}

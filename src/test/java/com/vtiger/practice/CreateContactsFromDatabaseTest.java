package com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateContactsFromDatabaseTest {
	public static void main(String[] args) throws SQLException {
		
		Driver d= new Driver();
		DriverManager.registerDriver(d);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger","root","root");
		
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("select * from vtiger where S_no=2;");
		while(result.next())
		{
		       String url = result.getString("url");
		       String username = result.getString("username");
		      String password = result.getString("password");
		         int contacts = result.getInt("contacts");
		         
		      
		      
		}
		
	}

}

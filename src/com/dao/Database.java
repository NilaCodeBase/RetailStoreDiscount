package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public Connection conn = null;
	
		public Connection getConnection() throws SQLException, ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
		conn = DriverManager.getConnection("jdbc:sqlserver://localhost;database=DemoLearning;integratedSecurity=true;");
		
		return conn;
	}
}

package com.sb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConectaDB {
	
	ResourceBundle recursos = ResourceBundle.getBundle("database");
	
	public Connection getAcceso() throws Exception{
		Class.forName(recursos.getString("driver"));
		Connection conn = DriverManager.getConnection(
				recursos.getString("url"),
				recursos.getString("username"),
				recursos.getString("password"));
		return conn;
	}
}

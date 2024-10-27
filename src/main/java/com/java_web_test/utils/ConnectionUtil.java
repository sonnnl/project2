package com.java_web_test.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String url = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String username = "root";
    private static final String password = "son17092004";
	public static Connection getConnection() {
		Connection conn =  null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	    
	}
}

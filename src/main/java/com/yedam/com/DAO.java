package com.yedam.com;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	static String url = "jdbc:oracle:thin:@43.202.10.36:1521/xe";
	static String user = "proj";
	static String pass = "proj";
	static Connection conn;

	public static Connection getConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return conn;
	}
}

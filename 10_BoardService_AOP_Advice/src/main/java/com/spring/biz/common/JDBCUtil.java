package com.spring.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

	//JDBC 연결
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println(" [JDBCUtil] >> JDBC 연결 ");
			e.printStackTrace();
		}
	}
	
	// DB 연결
	public static Connection getConnection() throws SQLException {
		System.out.println(" [JDBCUtil] >> DB 연결 ");
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MYSTUDY", "mystudypw");
	}
	
	
	
	public static void close(Connection conn, Statement stmt) {
		System.out.println(" [JDBCUtil] >> CONN, STMT, RS 닫기 ");
		try {
			if (stmt != null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (stmt != null) stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}





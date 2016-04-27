package com.nings.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author       nings
 */
public class JDBCBaseDao {
	private static String url = "jdbc:oracle:thin:@20.36.18.186:1521:mca";
	private static String user = "eip";
	private static String password = "eip";
	private static String driver = "oracle.jdbc.OracleDriver";
	/*
		private static String url = "jdbc:mysql://localhost/csii";
		private static String user = "root";
		private static String password = "root";
		private static String Driver = "com.mysql.jdbc.Driver";
	*/
	/**
	 * 注意： 修改自己的数据库密码
	 * 
	 * @return 获得数据库连接对象
	 * @throws SQLException
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

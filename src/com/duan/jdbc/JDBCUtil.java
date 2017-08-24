package com.duan.jdbc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * JDBC工具类
 * 包含返回Connection 关闭ResultSet、Statement、Connection
 */
public class JDBCUtil {
	
	private static Properties pros;
	//静态加载属性表
	static {
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().
					getResourceAsStream("config.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//返回Connection
	public static Connection getMySQLConn() {
		try {
			Class.forName(pros.getProperty("driver"));
			return DriverManager.getConnection(pros.getProperty("sqlUrl"),
					pros.getProperty("userName"),
					pros.getProperty("pwd"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close(ResultSet rs, Statement s, Connection c) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (c != null) {
				c.close();
				c = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement s) {
		try {
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(Connection c) {		
		try {
			if (c != null) {
				c.close();
				c = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

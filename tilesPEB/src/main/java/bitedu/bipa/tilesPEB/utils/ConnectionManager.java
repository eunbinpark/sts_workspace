package bitedu.bipa.tilesPEB.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionManager {
	
	private static Connection getConnection() {
		Connection con = null;
		Context ctx = null;
		try {			
			ctx = new InitialContext();
			Context env = (Context)ctx.lookup("java:comp/env");
			DataSource ds = (DataSource)env.lookup("jdbc/mysql");
			con = ds.getConnection();
			//System.out.println(con);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	private static Connection getConnectionOld() {
		Connection con = null;
		String id = "root";
		String pwd = "1234";
		String url = "jdbc:mysql://localhost:3306/bitedu";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection(ResultSet rs, Statement stmt, Connection con) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

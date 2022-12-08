package kr.co.Kmarket.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DBCP {

	protected Connection conn = null;
	protected PreparedStatement psmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	public Connection getConnection() {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/java1_kmarket");
			conn = ds.getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void close() {
		try {
			if(rs != null) 
				rs.close();
			if(stmt != null)
				stmt.close();
			if(psmt != null)
				psmt.close();
			if(conn != null)
				conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

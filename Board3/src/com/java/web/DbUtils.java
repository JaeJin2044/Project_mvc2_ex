package com.java.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbUtils {

	
	public static Connection getCon() throws Exception {
		final String url = "jdbc:mysql://localhost/javadev?serverTimezone=UTC&useUnicode=trfue&characterEncoding=UTF-8";
		final String user = "root";
		final String pw = "1234";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,user,pw);
		System.out.println("Board3_DbUtils 연결 이상무");
		
		return con;
		
	}
	
	
	public static void close(Connection con ,PreparedStatement ps) throws Exception {
		close(con,ps,null);
	}

	
	public static void close(Connection con , PreparedStatement ps, ResultSet rs) throws Exception {
		
		try {
			if(rs!=null) {rs.close();}
			if(ps!=null) {ps.close();}
			if(con!=null) {con.close();}
		} catch (Exception e) { e.printStackTrace();}
	
	}
	
}








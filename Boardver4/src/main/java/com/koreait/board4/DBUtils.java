package com.koreait.board4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;





public class DBUtils {
		
	public static Connection getCon() throws Exception{
		
		final String DB_NAME = "boardver3";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/boardver3";
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);//리소스를 엄청 많이 먹는다
		System.out.println("연결성공");										 //사용하고 바로 닫아줘야한다.
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		
		close(con, ps, null);
		
	}
	
	
						    //다리 자바랑 DB랑 연결 //쿼리실행				//셀렉트때만 re 결과가 담긴다. 셀렉트때만 resullt사용 
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {//닫아주는 메서드
		
		if(rs != null) {
			try {rs.close();} catch(SQLException e){e.printStackTrace();}
		}
		if(ps != null) {
			try {ps.close(); } catch(SQLException e){e.printStackTrace();}
		}
		if(con != null) {
			try {con.close(); } catch(SQLException e){e.printStackTrace();}
		}
	}
	
}

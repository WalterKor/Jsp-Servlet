package com.koreait.board4;

import java.sql.*;


//Data Access Object (DB 담당)
public class BoardDAO {
	
	//글등록
	public static int insertBoard(BoardVO3 vo){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board  (title, ctnt)"
				+ " VALUES (?, ?)";
				
		try {
			con = DBUtils.getCon();//리소스를 엄청 많이 잡아 먹는다.
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps); //꼭 닫아줘야한다 사용하고 아니면 서버 다운
		}
		return 0;
	}
}

package com.koreait.board4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


//Data Access Object (DB 담당) //DB쿼리 날릴수 있는 녀석
public class BoardDAO {
	
	//글등록
	public static int insertBoard(BoardVO3 vo){
		
		Connection con = null;//재은이한테 물어봐야지 Connetion con의 역활 
		PreparedStatement ps = null; //PreparedStatement 장점 : ?값넣는게 편해짐 ?에 값을 넣고 쿼리문 실행까지해주낟.00
		
		String sql = " INSERT INTO t_board  (title, ctnt)" //컬럼이 4개라서 날짜는 디폴트고 pk는 auto increment 
				   + " VALUES (?, ?)";
				
		try {
			
			con = DBUtils.getCon();//리소스를 엄청 많이 잡아 먹는다.
			ps = con.prepareStatement(sql);//객체를 생성하고 난후에 해야한다.
			ps.setString(1, vo.getTitle());//실행해야한다. , 0부터 시작안한다 1부터 시작한다. 
					 //(정수 : ?순서,에  vo.getTitle()넣겠다.)
			
			ps.setString(2, vo.getCtnt());
			
			return ps.executeUpdate();//완성된 문장이 실행이된다. 실행된다 무슨말이ㅑ? 값을 넣는다는거야 아니면 , 영향받은 행의 갯수를 리턴 
									  //insert update delet 영향을 미친 레코드의 수 
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps); //꼭 닫아줘야한다 사용하고 아니면 서버 다운
		}
		return 0;
	}
	
	
	public static  List<BoardVO3> selBoardList(){
		
		List<BoardVO3> list = new ArrayList<BoardVO3>();
		
		
				//레코드 수많큼만
			
			Connection con = null;// final에 사용하기 위해서 
			PreparedStatement ps = null;
			ResultSet rs = null;//결과물을 받을것 
			
			
		
		String sql =" SELECT iboard,title,regdt FROM t_board ";//ctnt는 티테일에 들어가서 사용하는거라
		
		
		try {
			
			con = DBUtils.getCon(); //getCon에 throw가 있기 때문에
			ps = con.prepareStatement(sql);
			
			
			
			rs = ps.executeQuery();//ps.executeQuery(); 셀렉트만 
			 	  //ps.executeUpdate();insert, delet, update
			
			while (rs.next()) { //rs.next() 1. f레코드가리키기 리턴타입 불린
				//레코드 수만큼 반복이 된다. 
				BoardVO3 vo = new BoardVO3();
				list.add(vo);
				
				int iboard = rs.getInt("iboard");//괄호안 컴럼명 
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			
			}
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);//리소스를 엄청 잡아먹기때무ㅠ에
		}
		 
		
		return list;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

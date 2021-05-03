package com.Korea.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.jasper.tagplugins.jstl.core.Param;

import com.mysql.cj.exceptions.RSAException;

public class DAO {

	public static  int insertBoard(BoardVO vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board "
				+" (title,ctnt) "
				+" VALUES "
				+" (? , ?) ";
		
		
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			
			System.out.println(ps.toString());
			return ps.executeUpdate(); //insert, update, delete
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			DBUtils.close(con, ps);
		}
		
		return 0;
		
		
		
		
	}

	public static List<BoardVO> selBoardList() {
		
		List<BoardVO> list = new ArrayList();
		

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT iboard, title, regdt FROM"
				+ " t_board ORDER BY iboard DESC";
		
		
		try {
			
			con = DBUtils.getCon(); //실행
			ps = con.prepareStatement(sql); //sql문 실행
			rs = ps.executeQuery(); //쿼리문 종료
			
			while(rs.next()) {//가리켰을때 그 행이 있으면 true로 반환
				
				BoardVO vo =  new BoardVO(); //새로운 객체 생성 
				list.add(vo);
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				
			}
		
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
			
		return list;
	}

	
	public static BoardVO selBoard(int iboard) {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM t_board WHERE iboard = ?";
		
		try {
			
			con = DBUtils.getCon();//실행
			ps = con.prepareStatement(sql); //실행
			ps.setInt(1, iboard);
			
			rs = ps.executeQuery();//쿼리를 종료해라
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();//새로운 객체를 만들고
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setCtnt(ctnt);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				
				return vo;
			}		
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		
		return null;
	}

	
	public static int updBoard(BoardVO vo) {
	
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? ";
				
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());;
			ps.setInt(3, vo.getIboard());
			
			System.out.println(ps.toString());
			return ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
			
		}
		return 0;
				
	}

	public static void delBoard(BoardVO param) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM t_board WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			
			System.out.println(ps.toString());
			ps.executeUpdate();
					 
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
	}

	}

	
	
	
	
	



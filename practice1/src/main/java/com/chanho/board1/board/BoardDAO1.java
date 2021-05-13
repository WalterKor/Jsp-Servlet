package com.chanho.board1.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.chanho.board1.DBUtils;
import com.chanho.board1.Myutils;
import com.mysql.cj.exceptions.RSAException;

public class BoardDAO1 {

	public static void write(BoardVO1 bo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " Insert Into t_board "
				+ "( title, ctnt, iuser )"
				+ " values "
				+ "(?, ?, ?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getCtnt());
			ps.setInt(3, bo.getIuser());
		
			
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<BoardVO1> selboard() {
		List<BoardVO1> list = new ArrayList();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT a.iboard, a.title, a.iuser, a.regdt, b.unm "
				+ " FROM t_board a "
				+ " LEFT JOIN t_user b "
				+ " ON a.iuser = b.iuser "
				+ " ORDER BY a.iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				BoardVO1 vo = new BoardVO1();
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");

				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setUnm(unm);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}

	public static BoardVO1 pickboard(int iboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT a.iboard, a.title, a.ctnt, a.regdt,a.iuser,b.unm "
				+ "FROM t_board a "
				+ "LEFT JOIN t_user b "
				+ "ON a.iuser = b.iuser "
				+ " where iboard = ? ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO1 bo = new BoardVO1();
				
				String title = rs.getString("title");
				String ctnt = rs.getString("ctnt");
				String regdt = rs.getString("regdt");
				String unm = rs.getString("unm");
				int iuser = rs.getInt("iuser");
				
				bo.setTitle(title);
				bo.setCtnt(ctnt);
				bo.setRegdt(regdt);
				bo.setUnm(unm);
				bo.setIuser(iuser);
				
				
				return bo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return null;
	}

	public static void updateBoard(BoardVO1 bo) {
		Connection con = null;
		PreparedStatement ps =null;
		
		String sql = " UPDATE t_board "
				+ " SET title = ? "
				+ " , ctnt = ? "
				+ " WHERE iBoard = ? "
				+ " AND Iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, bo.getTitle());
			ps.setString(2, bo.getCtnt());
			ps.setInt(3, bo.getIboard());
			ps.setInt(4, bo.getIuser());
				
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		
	}

	public static void remove(BoardVO1 bo) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board WHERE iboard = ? AND iuser = ? " ;
		
		try {
			con = DBUtils.getCon();
			ps =  con.prepareStatement(sql);
			
			ps.setInt(1, bo.getIboard());
			ps.setInt(2, bo.getIuser());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
			
		}
		
		
	}

	
}

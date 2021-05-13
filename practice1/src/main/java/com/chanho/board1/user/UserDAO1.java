package com.chanho.board1.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.chanho.board1.DBUtils;

public class UserDAO1 {

	public static void insert(UserVO1 vo) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_user(uid,upw,unm,gender) "
				   + " VALUES ( ? , ?, ?, ? ) ";

		
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getUid());
			ps.setString(2, vo.getUpw());
			ps.setString(3, vo.getUnm());
			ps.setInt(4, vo.getGender());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
	}
	//로그인 성공 1, 아이디 없음 2, 비밀번호 틀림 3, 에러 0
	public static int loginUser(UserVO1 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM t_user "
				   + " WHERE uid = ? ";
		
		try {
			
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			//셋팅하고 rs실행해야한다.
			ps.setString(1, vo.getUid());
			rs = ps.executeQuery();

			if(rs.next()) {
				String dbpw = rs.getString("upw");
				
				if(BCrypt.checkpw(vo.getUpw(), dbpw)) {
					int iuser = rs.getInt("iuser");
					String unm = rs.getString("unm");
					
					vo.setIuser(iuser);
					vo.setUnm(unm);
					//아이디 비밀번호 일치
					return 1;
					
				}else {
					//비밀번호가 다를때
					return 3;
				}
			}else {
				//아이디가 없을때
				return 2;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		
		return 0;
	}

}

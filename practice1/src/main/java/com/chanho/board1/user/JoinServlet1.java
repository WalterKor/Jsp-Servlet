package com.chanho.board1.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.chanho.board1.Myutils;

@WebServlet("/user/join")
public class JoinServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Myutils.openJsp("/user/join", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserVO1 vo = new UserVO1();
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = Myutils.getParamInt("gender", request);
		String hasedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		
		vo.setUid(uid);
		vo.setUpw(hasedUpw);
		vo.setUnm(unm);
		vo.setGender(gender);
		
		UserDAO1.insert(vo);
		
		System.out.println("userId : "+vo.getUid());
		System.out.println("userPw : "+vo.getUpw());
		System.out.println("userNm : "+vo.getUnm());
		System.out.println("userGender :"+vo.getGender());
		
		Myutils.openJsp("/user/login", request, response);
		
	}

}

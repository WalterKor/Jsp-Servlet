package com.chanho.board1.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chanho.board1.Myutils;


@WebServlet("/user/login")
public class LoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		UserVO1 loginUser = (UserVO1)hs.getAttribute("loginUser");
		if(loginUser != null) {
			response.sendRedirect("/board/list");
			return;
		}
		Myutils.openJsp("/user/login", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO1 vo = new UserVO1();
		vo.setUid(uid);
		vo.setUpw(upw);
		
		int result = UserDAO1.loginUser(vo);
		//로그인 성공했을때
		if(result == 1) {
			
			HttpSession hs = request.getSession();
			vo.setUpw(null);
			hs.setAttribute("loginUser", vo);
			
			response.sendRedirect("/board/list");//서블릿으로간다
			return;
		}
		
		String errmsg = null;
		switch (result) {
		case 0:
			errmsg = "에러가 발생했습니다.";
			break;
		case 2:
			errmsg = "아이디를 확인해주세요";
			break;
		case 3:
			errmsg = "비밀번호를 확인해주세요.";
			break;
			
		}
		request.setAttribute("errMsg", errmsg);
		
		doGet(request, response);//get함수를 호출
		
		
	}

}

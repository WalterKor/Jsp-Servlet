package com.chanho.board1.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chanho.board1.Myutils;
import com.chanho.board1.user.UserVO1;


@WebServlet("/board/write")
public class WriteServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession hs = request.getSession();
    	UserVO1 loginUser = (UserVO1) hs.getAttribute("loginUser");
    	
    	if(loginUser == null) {
    		response.sendRedirect("/user/login");
    		return;
    	}
    	
    	Myutils.openJsp("/board/write", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iuser = Myutils.getLoginUserPk(request);
		
		BoardVO1 bo = new BoardVO1();
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		bo.setIuser(iuser);
		
		BoardDAO1.write(bo);
		response.sendRedirect("/board/list");
	}

}

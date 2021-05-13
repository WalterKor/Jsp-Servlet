package com.chanho.board1.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;

import com.chanho.board1.Myutils;
import com.chanho.board1.user.UserVO1;


@WebServlet("/board/list")
public class ListServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO1 loginUser = (UserVO1) hs.getAttribute("loginUser");
		
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO1> list = BoardDAO1.selboard();
		request.setAttribute("list", list);
		
		Myutils.openJsp("/board/list", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}

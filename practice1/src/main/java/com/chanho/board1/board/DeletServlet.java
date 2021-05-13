package com.chanho.board1.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chanho.board1.Myutils;


@WebServlet("/board/del")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iuser = Myutils.getLoginUserPk(request);
		int iboard = Myutils.getParamInt("iboard", request);
		
		BoardVO1 bo = new BoardVO1();
		
		bo.setIboard(iboard);
		bo.setIuser(iuser);
		
		System.out.println("iboard : " + iboard);
		System.out.println("iuser : " + iuser);
		
		BoardDAO1.remove(bo);
		response.sendRedirect("/board/list");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

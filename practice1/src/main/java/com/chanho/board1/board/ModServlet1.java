package com.chanho.board1.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chanho.board1.Myutils;


@WebServlet("/board/mod")
public class ModServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BoardVO1 bo = BoardDAO1.pickboard(Myutils.getParamInt("iboard", request));
		
		if(bo.getIuser() != Myutils.getLoginUserPk(request)) {
			response.sendRedirect("/board/list");
			return;
		}
		
		int iboard = Myutils.getParamInt("iboard", request);
		BoardVO1 data = BoardDAO1.pickboard(iboard);
		request.setAttribute("data", data);
		
		Myutils.openJsp("/board/mod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int iboard = Myutils.getParamInt("iboard", request);
		int iuser = Myutils.getLoginUserPk(request);
		
		BoardVO1 bo = new BoardVO1();
		bo.setTitle(title);
		bo.setCtnt(ctnt);
		bo.setIboard(iboard);
		bo.setIuser(iuser);
		
		BoardDAO1.updateBoard(bo);
		response.sendRedirect("/board/detail?iboard="+iboard);
				


	}

}

package com.Korea.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class modServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String iboard = request.getParameter("iboard");
		
		int intIBOARD = Integer.parseInt(iboard);
		
		BoardVO data = DAO.selBoard(intIBOARD); //선택
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String iboard = request.getParameter("iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		int intIBOARD = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		vo.setIboard(intIBOARD);
		
		DAO.updBoard(vo);
		
		response.sendRedirect("/detail?iboard=" +iboard);
		
		
	}

}

package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDetailServlet3
 */
@WebServlet("/detail3")
public class BoardDetailServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " +iboard);
		
	
		
		BoardVO3 data= BoardDAO.selBoard(int iboard);
		
		request.setAttribute("data", data);
		
		String jsp = "/WEB-INF/view/detail3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		
	}

	

}

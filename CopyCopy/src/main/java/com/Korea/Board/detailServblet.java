package com.Korea.Board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;


@WebServlet("/detail")
public class detailServblet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String iboard = request.getParameter("iboard");
		System.out.println("iboard : " + iboard);
		
		BoardVO data = DAO.selBoard(Integer.parseInt(iboard));
		
		request.setAttribute("data", data);
		
		String jsp ="/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
}

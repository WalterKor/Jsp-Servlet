package com.Koreait.Board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod")
public class Boardmod extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String no = request.getParameter("no");
		request.setAttribute("data", Database.db.get(Integer.parseInt(no)));
		
		String jsp = "WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO vo = Database.db.get(Integer.parseInt(no));
		
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		
		response.sendRedirect("/detail?no="+no);
	}

}

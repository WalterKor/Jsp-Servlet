package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/mod3")
public class BoardModServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String iboard = request.getParameter("iboard");		
		System.out.println("iboard : " + iboard);
		
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO3 data = BoardDAO.selBoard(intIboard);
		
		request.setAttribute("data", data);
		
		
		
		String jsp = "/WEB-INF/view/mod3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String title = request.getParameter("title");//getParameter리턴타입이 String
		String ctnt = request.getParameter("ctnt");
		String iboard = request.getParameter("iboard");
		
		
		BoardVO3 vo = new BoardVO3();
		vo.setIboard(Integer.parseInt(iboard));
		vo.setTitle(title);
		vo.setCtnt(ctnt); //이렇게 객체를 받은걸
		
		
		BoardDAO.modBoard(vo);//굳이 객체화를 할 필요가 없다. //static으로 했기때문에 굳이 객체화를 할 필요가 없다.
		response.sendRedirect("/detail3?iboard=" + iboard);//서블릿에서 서블릿으로 
		
		
		
		
		
		
		
	}

}

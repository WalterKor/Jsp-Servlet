package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/write3")
public class BoardwriteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String jsp = "/WEB-INF/view/write3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}//화면을 띄울때 사용한다. 화면을 이동할때 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");//getParameter리턴타입이 String
		String ctnt = request.getParameter("ctnt");
		
		BoardVO3 vo = new BoardVO3();
		vo.setTitle(title);
		vo.setCtnt(ctnt); //이렇게 객체를 받은걸
		
		
		BoardDAO.insertBoard(vo);//굳이 객체화를 할 필요가 없다. //static으로 했기때문에 굳이 객체화를 할 필요가 없다.
		response.sendRedirect("/list3");//서블릿에서 서블릿으로 
		
		
		
	}

}

package com.Koreait.Board2;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/list") //모듈패스해주는 이유  단계를 다 지운다.
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<BoardVO> list = Database.db;
		
		request.setAttribute("list", list);
		
				
		String jsp = "/WEB-INF/jsp/list.jsp";//처음으로 get방식으로 보낸다 get방식은 화면 띄우는 역활
		request.getRequestDispatcher(jsp).forward(request, response);
		
		//post방식은 처리
		
	}

	

}

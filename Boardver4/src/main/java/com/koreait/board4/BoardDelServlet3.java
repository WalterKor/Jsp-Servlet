package com.koreait.board4;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/del3")
public class BoardDelServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String iboard = request.getParameter("iboard");	//받아온 pk값을 문자열로 저장  	
		
		int intIboard = Integer.parseInt(iboard); //저장한 문자열을 숫자로 변환
		
		BoardVO3 param = new BoardVO3(); //BoardVO3 새로운 객체 생성 
		param.setIboard(intIboard);
		
		BoardDAO.delBoard(param);
		
		response.sendRedirect("/list3");
		
	
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}

}

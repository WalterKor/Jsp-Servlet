package com.koreait.board4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/list3")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<BoardVO3> list = BoardDAO.selBoardList();//리턴값이 없다 다 델꼬오겠다. 
							//어레이리스트 객체주소값이된다. 
		request.setAttribute("list", list);
		
		String jsp = "/WEB-INF/view/list3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}


}

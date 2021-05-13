package com.chanho.board1.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chanho.board1.Myutils;

@WebServlet("/board/detail")
public class DetailServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		int iboard = Myutils.getParamInt("iboard", request);
  		BoardVO1 data = BoardDAO1.pickboard(iboard);
  		//값을 쓰기 위해서
  		request.setAttribute("data", data);
  		Myutils.openJsp("/board/detail", request, response);
	}

	
}

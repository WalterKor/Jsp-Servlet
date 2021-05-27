package com.koreait.board7.cmt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;


@WebServlet("/board/cmtDelUpd")
public class BoardCmtDelUpd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   //댓글 삭제
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int icmt = MyUtils.getParamInt("icmt", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIcmt(icmt);
		param.setIuser(iuser);
		
		//댓글 삭제면 1 아니면 0
		int result = BoardCmtDAO.delBoardCmt(param);
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		
	}

	//댓글 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int iuser = MyUtils.getLoginUserPk(request);
		int icmt = MyUtils.getParamInt("icmt", request);
		String cmt = request.getParameter("cmt");
		
		
		
		System.out.println("icmt : " +icmt);
		System.out.println("cmt : " +cmt);
		
		BoardCmtDomian bo = new BoardCmtDomian();
		bo.setIcmt(icmt);
		bo.setCmt(cmt);
		bo.setIuser(iuser);
		
		//수정 성공 1 아니면 0
		int result = BoardCmtDAO.updateCmt(bo);
		
		response.getWriter()
		.append("{")
		.append("\"result\":")
		.append(String.valueOf(result))
		.append("}")
		.flush();
		
		
		
		
		
	}

}

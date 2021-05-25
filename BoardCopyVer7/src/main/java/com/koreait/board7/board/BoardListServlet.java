package com.koreait.board7.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;

@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	//페이징처리기술
    	final int recordCnt = 5;    	
    	int cPage = MyUtils.getParamInt("cPage", request);
    	//cPage가 0이되는 경우 
    	//쿼리스트링의 키 값이 없을경우
    	if(cPage == 0) { cPage = 1; }   	    	
    	int startIdx = (cPage-1)*recordCnt;
    	BoardDTO param = new BoardDTO();
    	
    	param.setStartIdx(startIdx);
    	param.setRecordCnt(recordCnt);
    	

    	//검색기능
    	int searchType = MyUtils.getParamInt("searchType", request);
    	String searchText = request.getParameter("searchText");
    	
    	if(searchType !=0 && searchText != null && !searchText.equals("")) {
    		param.setSearchType(searchType);
    		param.setSearchText(searchText);
    	}
    	
        	
    	request.setAttribute("pagingCnt", BoardDAO.selPagingCnt(param));
    	request.setAttribute("list", BoardDAO.selBoardList(param));
    	request.setAttribute("searchText", searchText);
    	MyUtils.openJSP("리스트", "board/boardList", request, response);
    	
    	
	}	
}

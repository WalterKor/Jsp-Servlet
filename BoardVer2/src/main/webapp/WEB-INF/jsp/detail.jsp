
<%@page import="com.Koreait.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String no = request.getParameter("no");
    	BoardVO vo = (BoardVO)request.getAttribute("data");
    	String title = request.getParameter("no");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내용</title>
</head>
<body>
	<h1>내용</h1>
	<div><%=request.getParameter("no") %>></div>
	
	<div>
		<form action="/del" method="post">
			<input type="hidden" name="no" value="<%=no %>">
			<input type="submit" value="삭제">
		</form>
		<a href="/mod?no=<%=no %>"><button>수정</button></a>
		
	</div>
	
	<div>제목 : <%=vo.getTitle()%></div>
	<div>내용 : <%=vo.getCtnt()%> </div>
	
</body>
</html>
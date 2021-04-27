<%@page import="com.Koreait.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <% 
   		String no = request.getParameter("no");
   		BoardVO vo = (BoardVO)request.getAttribute("data");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
		<h1>글수정</h1>
		<form action="/mod" method="post">
			<input type="hidden" name="no" value="<%=no %>">
		 	<div>
	 		제목 : <input type="text" name="title" value="<%=vo.getTitle() %>">
	 	</div>
	 	
	 	<div>
	 		내용 : <textarea name="ctnt" rows="10" cols="10"><%=vo.getCtnt() %></textarea>
	 	</div>
	 	
	 	<div>
	 		<input type="submit" value="수정">
	 		<input type="reset" value="초기화">	 		
	 	</div>	 	
			
		
		</form>
		
</body>
</html>
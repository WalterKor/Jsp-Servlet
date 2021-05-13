<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일페이지</title>
</head>
<body>
		<h1>디테일페이지</h1>
		<a href="/board/list">리스트로 돌아가기</a>	
		<div>${param.iboard}</div>
		
		<div>제목 : ${data.title}</div>
		<div>작성자 : ${data.unm}</div>
		<div>내용 : ${data.ctnt}</div>
		<div>작성일 : ${data.regdt}</div>
		
		<c:if test="${loginUser.iuser == data.iuser}">
			<div>
				<button><a href="/board/del?iboard=${param.iboard}">삭제</a></button>
				<button><a href="/board/mod?iboard=${param.iboard}">수정</a></button>
			</div>
		</c:if>
		
	
</body>
</html>
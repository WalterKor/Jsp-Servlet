<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디테일</title>
</head>
<body>
	
	<h1>디테일</h1>
	<div>
		<a href="/del?iboard=${param.iboard}">삭제</a>
		<a href="/mod?iboard=${param.iboard}">수정</a>
	</div>
	<div><a href="/list">리스트로 돌아가기</a></div>
	
		<div>제목 : ${data.title}</div>
		<div>작성일 : ${data.regdt}</div>
				
		<div>
			내용 : ${data.ctnt};	
		</div>
		
		
				
	
	
	
</body>
</html>
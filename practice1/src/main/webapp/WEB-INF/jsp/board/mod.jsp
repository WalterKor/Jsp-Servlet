<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정페이지</title>
</head>
<body>
	<a href="/board/list">리스트로 돌아가기</a>
	<a href="/board/del?iboard=${param.iboard}">삭제</a>
	
	<form action="/board/mod" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<div>
			<input type="text" name="title" value="${data.title}">
		</div>
		<div>
			<textarea rows="30" cols="30" name="ctnt">${data.ctnt}</textarea>
		</div>
		
		<div>
			<input type="submit" value="글등록">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>
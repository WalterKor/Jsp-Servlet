<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 </title>
</head>
<body>
	
 <a href="/list">리스트로 돌아가기</a>
	<form action="/write" method="post">
	
		<div>
			제목 : <input type="text" name="title">
		</div>
		
		<div>
			<textarea rows="30" cols="30" name="ctnt"></textarea>
		</div>
		
		<input type="submit" value="글등록">
		<input type="reset" value="초기화">		
	
	</form>
</body>
</html>
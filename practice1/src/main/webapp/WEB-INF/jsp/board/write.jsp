<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="/board/write" method="post">
		<div>
			<input type="text" name="title" placeholder="제목">
		</div>
		<div>
			<textarea rows="30" cols="30" name="ctnt" placeholder="내용"></textarea>
		</div>
		
		<div>
			<input type="submit" value="글등록">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>
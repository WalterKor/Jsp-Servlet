<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<a href="/user/login">로그인페이지</a>
	</div>
	<form action="/user/join" method="post">
		<div><input type="text"  name="uid" placeholder="아이디"></div>
		<div><input type="password"  name="upw" placeholder="비밀번호"></div>
		<div><input type="text"  name="unm" placeholder="이름"></div>
		<div>
			성별 : 
			<label>남<input type="radio" name="gender" value="0" checked></label>
			<label>여<input type="radio" name="gender" value="1"></label>
		</div>
		<div><input type="submit" value="회원가입"></div>
	</form>
</body>
</html>
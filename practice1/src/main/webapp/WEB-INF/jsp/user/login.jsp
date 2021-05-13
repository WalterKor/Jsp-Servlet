<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<style>
		.errMsg{color: red};
		boady{
			background: coral;
		}
	</style>
<title>로그인</title>
</head>
<body>
	<div class="errMsg">${errMsg}</div>
	<form action="/user/login" method="post">
		<div>
			<input type="text" name="uid" placeholder="아이디">
		</div>
		<div>
			<input type="password" name="upw" placeholder="비밀번호">
		</div>
		<div>
			<input type="submit" value="로그인">		
		</div>
	</form>
	<div>
	<button><a href="/user/join">회원가입</a></button>
	</div>
</body>
</html>
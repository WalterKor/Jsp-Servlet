<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>	
		<a href="/mod?no=${param.no}"><button>수정</button></a>
		<a href="/del?no=${param.no}"><button>삭제</button></a>		
	</div>
	
	
	<div>제목 : ${data.title}</div>
	<div>내용 : ${data.ctnt}</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
	<style>
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
			}
		.record{ cursor: pointer;} 
		.record hover{ background-color:yellow;}
	</style>

</head>
<body>

	<div>
		<a href="/write3">글쓰기</a>
	</div>
	
	<div>
		<table>
			<tr>
				<td>no</td>
				<td>제목</td>
				<td>작성일</td>
			</tr>
			
			<c:forEach items="${list}" var="item"> <%--items="${list}"EL식의 주소값을 넣어줘야한다. --%>
			
				<tr class="record" onclick="movetoDetail(${item.iboard});">
					
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>
													
				</tr>				
			</c:forEach>
			
			
			
			
			
			
			
		</table>
	</div>
	
	<script>
		function movetoDetail(iboard) { //pk
													 //getParmiter
			location.href='/detail3?iboard=' +iboard; //${param.no}//이런식으로 한다. jsp에서 사용하기위해선  
																	
		}
	</script>
</body>
</html>






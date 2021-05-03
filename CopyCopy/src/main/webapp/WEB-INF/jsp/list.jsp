<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
	<style>
		table, th, td {
			border: 1px solid black;
			border-collapse: collapse; 
		}
		.record{cursor: pointer;}
		.record:hover {background: red; }
		
	</style>
</head>
<body>
		<div>
			<a href="/write">글쓰기</a>		
		</div>
		
	  <div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>Date</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr class="record" onclick="moveTodetail(${item.iboard});">
					<td>${item.iboard}</td>
					<td>${item.title}</td>
					<td>${item.regdt}</td>					
				</tr>
				
			</c:forEach>
		
			
			
			</table>
		</div>
		
		<script>
			function moveTodetail(iboard) {
				location.href='/detail?iboard=' + iboard;
			}
		</script>
</body>
</html>
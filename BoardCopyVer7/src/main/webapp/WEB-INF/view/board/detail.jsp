<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<div><a href="#" onclick="goBack();">뒤로가기</a></div>
	<div>${requestScope.data.title}</div>
	<div>글번호 : ${requestScope.data.iboard}</div>
	<div>작성자 : ${requestScope.data.writerNm}</div>	
	<div>작성일 : <c:out value="${requestScope.data.regdt}"/></div>	
	<div>${requestScope.data.ctnt}</div>
	
	<c:if test="${not empty sessionScope.loginUser}">
		<div>
			<form id="cmtFrm" onsubmit="return false;">
				<input type="text" id="cmt" > 
				<input type="button" value="댓글달기" onclick="regCmt();">
			</form>
		</div>
	</c:if>
<div id="cmtList" data-login_user_pk="${sessionScope.loginUser.iuser}" data-iboard="${param.iboard}"></div>
<script src="/res/js/boardDetail.js"></script>
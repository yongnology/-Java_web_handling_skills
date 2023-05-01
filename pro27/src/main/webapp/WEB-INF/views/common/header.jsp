<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<style>
a {
	text-decoration: none;
}
</style>
<meta charset="UTF-8">
<title>상단부</title>
</head>
<body>
<table border=0 width="100%">
	<tr>
		<td>
			<a href="${contextPath }/"><img src="${contextPath }/resources/image/duke_swing.gif"/></a>
		</td>
		<td>
			<h1><a href="${contextPath }/"><font size=30>스프링실습 홈페이지!!</font></a></h1>
		</td>
		<td>
			<!-- <a href="#"><h3>로그인</h3></a> -->
			<c:choose>
				<c:when test="${isLogOn == true && member!= null }">
					<h3>환여합니다. ${member.name }님!!</h3>
					<a href="${contextPath }/member/logout.do"><h3>로그아웃</h3></a>
				</c:when>
				<c:otherwise>
					<a href="${contextPath }/member/loginForm.do"><h3>로그인</h3></a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>
</body>
</html>

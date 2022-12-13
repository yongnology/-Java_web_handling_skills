<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색창</title>
</head>
<body>
<h2>회원 검색</h2>
<form method="post" action="member_action.jsp">
	<input type="hidden" name="command" value="search" />
	이름 : <input type="text" name="name"> <input type="submit" value="조회"/>
</form>
<br>
<a href="${contextPath }/test06/memberForm.jsp">회원 가입하기</a>
</body>
</html>

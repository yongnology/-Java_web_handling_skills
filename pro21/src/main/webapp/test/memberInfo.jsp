<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 정보</title>
</head>
<body>
<table border="1" align="center" width="100%">
<tr align="center" bgcolor="lightgreen">
	<td><b>아이디</b></td>
	<td><b>비밀번호</b></td>
	<td><b>이름</b></td>
	<td><b>이메일</b></td>
</tr>
<tr align="center">
	<td>${id }</td>
	<td>${pwd }</td>
	<td>${name }</td>
	<td>${email }</td>
</tr>
</table>
</body>
</html>

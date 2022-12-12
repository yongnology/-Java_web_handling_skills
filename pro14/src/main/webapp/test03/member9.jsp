<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:out 태그</title>
</head>
<body>
	<table align="center" bgcolor="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>아이디</b></td>
			<td width="7%"><b>비밀번호</b></td>
			<td width="7%"><b>이름</b></td>
			<td width="7%"><b>이메일</b></td>
			<td width="7%"><b>주소</b></td>
		</tr>
		
<c:choose>
	<c:when test="${empty param.id}">
		<tr align="center">
			<td colspan="5">아이디를 입력하세요</td>
		</tr>
	</c:when>
<c:otherwise >
	<tr aling="center">
		<td><c:out value="${param.id }"/></td>
		<td><c:out value="${param.pwd }"/></td>
		<td><c:out value="${param.name }"/></td>
		<td><c:out value="${param.email }"/></td>
		<td><c:out value="${param.address }" default="서울시 강서구"></c:out>
	</tr>
</c:otherwise>
</c:choose>
	</table>
</body>
</html>
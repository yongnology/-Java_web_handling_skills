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
<title>결과창</title>
</head>
<body>
<table border="1" align="center">
	<tr align="center">
		<td>아이디</td>
		<td style="width:181px;">${id }</td>
	</tr>
	<tr align="center">
		<td>비밀번호</td>
		<td style="width:181px;">${pw }</td>
	</tr>
</table>
</body>
</html>

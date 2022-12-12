<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="dan" value="${param.dan }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
<style>
td {
	text-align: center;
	width: 300px;
}
</style>
</head>
<body>
<table border="1" width="500" align="center">
	<tr bgcolor="#999">
		<td colspan="2"><b><c:out value="${dan }"/>단 출력</b></td>
	</tr>
<c:forEach var="i" begin="1" step="1" end="9">
	<c:if test="${i%2 == 1 }">
		<tr bgcolor="lightyellow">
	</c:if>
	<c:if test="${i%2 == 0 }" >
		<tr bgcolor="lightpink">
	</c:if>
	
		<td><c:out value="${dan }"/> x <c:out value="${i }"/></td>
		<td><c:out value="${dan*i }"/></td>
		</tr>
</c:forEach>
</table>
<br>
<a href="gugu.jsp">다른 단 출력</a>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력</title>
<style>
td {
	width: 150px;
	text-align: center;
}
</style>
</head>
<body>
<table align="center" bgcolor="1">
	<tr bgcolor="lightgreen">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일</td>
	</tr>
<c:choose>
	<c:when test="${membersList == null}">
		<tr>
			<td colspan="5">등록된 회원이 없습니다.</td>
		</tr>
	</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${ membersList}">
			<tr>
				<td>${mem.id }</td>
				<td>${mem.pwd }</td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
				<td>
				<fmt:formatDate value="${mem.joinDate }" pattern="YYYY년 MM월 dd일"/>
				</td>
			</tr>
		</c:forEach>
	</c:when>
</c:choose>
</table>
</body>
</html>

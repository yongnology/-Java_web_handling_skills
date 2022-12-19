<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style>
table {
	margin: 0 auto;
}
tr {
	align-items: center;
	text-align:center;
}
td {
	width: 5%;
}
h2, h3 {
	display: block;
	margin: 0 auto;
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>
<body>
<h2>회원 정보</h2>
<table border="1">
	<tr bgcolor="lightgreen">
		<td><b>아이디</b></td>
		<td><b>비밀번호</b></td>
		<td><b>이름</b></td>
		<td><b>이메일</b></td>
		<td><b>가입일</b></td>
	</tr>
<c:choose>
	<c:when test= "${membersList == null }">
		<tr>
			<td colspan="5">회원 정보가 없습니다.</td>
		</tr>
	</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${membersList }">
			<tr>
				<td>${mem.id }</td>
				<td>${mem.pwd }</td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
				<td>${mem.joinDate }</td>
			</tr>
		</c:forEach>
	</c:when>
</c:choose>
</table>
<hr>
<h3><a href="${contextPath }/member/memberForm.do">회원 가입하기</a></h3>
</body>
</html>

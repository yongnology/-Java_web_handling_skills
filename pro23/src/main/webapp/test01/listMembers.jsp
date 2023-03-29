<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style>
.ttr {
	background: lightgreen;
	text-align: center;
}
</style>
</head>
<body>
<h2>회원 정보 출력창</h2>
<table border="1" align="center" width="80%">
	<tr align="center" bgcolor="lightgreen">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일</td>
	</tr>
		
	<c:forEach var="member" items="${membersList }">
		<tr align="center">
			<td>${member.id }</td>
			<td>${member.pwd }</td>
			<td>${member.name }</td>
			<td>${member.email }</td>
			<td>${member.joinDate }</td>
		</tr>
	</c:forEach>
</table>
<a href="${contextPath }/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>

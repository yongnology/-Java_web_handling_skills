<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>회원 정보 수정</title>
</head>
<body>
<h2>회원 정보 수정</h2>
<form method="post" action="${contextPath }/member3/modMember.do?id=${memInfo.id}">
	<table align="center">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="${memInfo.id }" disabled ></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pwd" name="pwd" value="${memInfo.pwd }"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name" value="${memInfo.name }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="email" value="${memInfo.email }"></td>
		</tr>
		<tr>
			<td>가입일</td>
			<td><input type="text" name="joinDate" value="${memInfo.joinDate }" disabled ></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정하기">
				<input type="reset" value="초기화">
		</tr>
	</table>
</form>
</body>
</html>

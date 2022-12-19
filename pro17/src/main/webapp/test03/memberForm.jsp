<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
td {
	width: 100px;
}
h2, h3 {
	display: block;
	margin: 0 auto;
	text-align: center;
	margin-bottom: 20px;
}
table {
	margin-bottom: 50px;
}
</style>
</head>
<body>
<h2>회원 가입</h2>
<form method="post" action="${contextPath }/member3/addMember.do">
<table align="center">
<tr>
	<td>아이디</td>
	<td><input type="text" name="id" placeholder="아이디"></td>
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pwd" placeholder="비밀번호"></td>
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="name" placeholder="이름"></td>
</tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="email" placeholder="이메일">
</tr>
<tr>
	<td>&nbsp</td>
	<td><input type="submit" value="가입하기">
		<input type="reset" value="다시입력"></td>
</tr>
</table>
</form>

<h3><a href="${contextPath }/member3/listMembers.do">목록보기 되돌아가기</a></h3>
</body>
</html>

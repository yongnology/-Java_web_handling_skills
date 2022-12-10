<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("address", "수원시 팔달구");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보출력</title>
</head>
<body>
<table border="1" align="center">
	<tr align="center" bgcolor="#99ccff">
		<td width="20%"><b>아이디</b></td>
		<td width="20%"><b>비밀번호</b></td>
		<td width="20%"><b>이름</b></td>
		<td width="20%"><b>이메일</b></td>
		<td width="20%"><b>주소</b></td>
	</tr>
	<tr align="center">
		<td colspan="5">session보다 request가 우선순위가 높으므로<br>
		request에 바인딩된 address값이 출력된다.<br>
		page > request > session > application
		</td>
	</tr>
	<tr align="center">
		<td>$id }</td>
		<td>${pwd }</td>
		<td>${name }</td>
		<td>${email }</td>
		<td>${address }</td>
	</tr>
</table>
</body>
</html>

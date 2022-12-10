<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id= (String)request.getAttribute("id");
	String pwd= (String)request.getAttribute("pwd");
	String name =(String)session.getAttribute("name");
	String email = (String)application.getAttribute("email");
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
	</tr>
	<tr align="center">
		<td colspan="4">표현식으로 회원 정보를 출력< %=값 %></td>
	</tr>
	<tr align="center">
		<!-- 표현식으로 회원 정보를 출력 -->
		<td><%=id %></td>
		<td><%=pwd %></td>
		<td><%=name %></td>
		<td><%=email %></td>
	</tr>
	<tr>
		<td colspan="4">&nbsp</td>
	</tr>
	<tr>
		<td colspan="4">바인딩된 속성이름으로 회원 정보를 출력$ {속성이름}</td>
	</tr>
	<tr align="center">
		<!-- 바인딩된 속성이름으로 회원 정보를 출력 -->
		<td>${id }</td>
		<td>${pwd }</td>
		<td>${name }</td>
		<td>${email }</td>
	</tr>
</table>
</body>
</html>

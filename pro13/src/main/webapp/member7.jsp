<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec01.ex01.*"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" />
<jsp:setProperty name="m" property="*" />

<!DOCTYPE html>
<html>
<head>
<style>
table, tr {
	text-align:center;
	alien-itenms: center;
}
</style>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
<table width="100%">
	<tr bgcolor="#99ccff">
		<td width="7%">아이디</td>
		<td width="7%">비밀번호</td>
		<td width="7%">이름</td>
		<td width="7%">이메일</td>
	</tr>
	<tr>
		<td> <jsp:getProperty name="m" property="id"  /> </td>
		<td> <jsp:getProperty name="m" property="pwd" /> </td>
		<td> <jsp:getProperty name="m" property="name" /> </td>
		<td> <jsp:getProperty name="m" property="email" /> </td>
	</tr>

	<tr height="1" bgcolor="#99ccff">
		<td colspan="5"></td>
	</tr>
</table>
</body>
</html>

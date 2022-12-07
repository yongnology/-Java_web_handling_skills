<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
h1 {
	color: red
}
</style>
</head>
<body>
<%
	String msg = request.getParameter("msg");
	if(msg != null ) {
%>
		<h1><%=msg %></h1>
<%
	}
%>
	<form action="result2.jsp" method="post">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"> <input type="reset" value="다시입력">
			</tr>
		</table>
	</form>
</body>
</html>

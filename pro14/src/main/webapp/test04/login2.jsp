<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인창</title>
</head>
<body>
<form action="result2.jsp" method="post">
<table>
<h2>로그인</h2>
<tr>
	<td>아이디</td>
	<td><input type="text" name="id" placeholder="아이디">
</tr>
<tr>
	<td>비밀번호</td>
	<td><input type="password" name="pw" placeholder="비밀번호"/>
</tr>
<tr>
	<td colspan="2" align="right">
		<input type="submit" value="로그인"/>
		<input type="reset" value="다시입력"/>
	</td>
</tr>
</table>
</form>
</body>
</html>
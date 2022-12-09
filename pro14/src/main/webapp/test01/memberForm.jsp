<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입창</title>
<style>
h1 {
	text-align:center;
}
</style>
</head>
<body>
<form method="post" action="member3.jsp">
	<h1>회원 가입창</h1>
	<table align="center">
		<tr>
			<td width="200"><p align="right">
				<label for="id">아이디</label></p></td>
			<td width="400"><input type="text" name="id" id="id" placeholder="아이디"></td>
		</tr>
		<tr>
			<td width="200"><p align="right">
				<label for="pwd">비밀번호</label></p></td>
			<td width="400"><input type="password" name="pwd" id="pwd" placeholder="비밀번호"/></td>
		</tr>
		<tr>
			<td width="200"><p align="right">
				<label for="name">이름</label></p></td>
			<td width="400"><input type="text" name="name" id="name" placeholder="이름"/></td>
		</tr>
		<tr>
			<td width="200"><p align="right">
				<label for="email">이메일</label></p></td>
			<td width="400"><input type="text" name="email" id="email" placeholder="이메일"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="가입하기">
				<input type="reset" value="다시입력">
			</td>
		</tr>
	</table>
</form>
</body>
</html>

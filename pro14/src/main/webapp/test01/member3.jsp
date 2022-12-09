<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="m" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m" property="*" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
	<table align="center" border="1">
		<tr align="center" bgcolor="##99ccff">
			<td width="20%"><b>아이디</b></td>
			<td width="20%"><b>비밀번호</b></td>
			<td width="20%"><b>이름</b></td>
			<td width="20%"><b>이메일</b></td>
		</tr>
		<tr align="center">
			<td><%=m.getId() %></td>
			<td><%=m.getPwd() %></td>
			<td><%=m.getName() %></td>
			<td><%=m.getEmail() %></td>
		</tr>
		<tr align="center">
			<td>${m.id}</td>
			<td>${m.pwd}</td>
			<td>${m.name}</td>
			<td>${m.email}</td>
		</tr>
	</table>
	<br>
	<br>
	<!-- ContextPath 사용 -->
	<span>
		<a href="${pageContext.request.contextPath }/test01/memberForm.jsp">회원가입</a>
	</span>
</body>
</html>

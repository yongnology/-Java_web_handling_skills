<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과창</title>
</head>
<body>
<c:if test="${empty param.id }">
	<h2>아이디를 입력하세요</h2>
	<a href="login.jsp">로그인창</a>
</c:if>
<c:if test="${not empty param.id }">
	<c:if test="${param.id ==  'admin'}">
		<h2>관리자로 로그인 했습니다.</h2>
		<form>
			<input type="button" value="회원정보 삭제" />
			<input type="button" value="회원정보 수정"/>
		</form>
		<hr>
	</c:if>

	<h1>환영합니다. <c:out value="${param.id }" />님</h1>
</c:if>
</body>
</html>
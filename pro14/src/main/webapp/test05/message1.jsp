<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 다국어 기능</title>
</head>
<body>
<h1>회원정보</h1><br><br>

<fmt:setLocale value="ko_KR"/>
<h2>
<fmt:bundle basename="resource.member" >
이름 : <fmt:message key="mem.name" /><br>
주소 : <fmt:message key="mem.address"/><br>
직업 : <fmt:message key="mem.job"/><br>
</fmt:bundle>
</h2>

<hr><!-- --------------------------- -->

<fmt:setLocale value="en_US"/>
<h2>
<fmt:bundle basename="resource.member" >
이름 : <fmt:message key="mem.name" /><br>
주소 : <fmt:message key="mem.address"/><br>
직업 : <fmt:message key="mem.job"/><br>
</fmt:bundle>
</h2>

</body>
</html>

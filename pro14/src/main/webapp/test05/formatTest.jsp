<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.Date"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<style>
td {
	border: 1px solid #555;
	text-align:right;
	width: 200px;
}
</style>
<meta charset="UTF-8">
<title>포매팅 태그 라이브러리 예제</title>
</head>
<body>

<h2>fmt의 number 태그를 이용한 숫자 포매팅 예제</h2>
<c:set var="price" value="100000000"/>
<fmt:formatNumber value="${price }" type="number" var="priceNumber" />
<table>
<tr>
	<td>통화로 표현 시</td>
	<td><fmt:formatNumber type="currency" currencySymbol="₩" value="${price }" groupingUsed="true"/><br></td>
</tr>
<tr>
	<td>퍼센트로 표현 시</td>
	<td><fmt:formatNumber type="percent" value="${price }" groupingUsed="false" /><br></td>
</tr>
<tr>
	<td>일반 숫자로 표현 시</td>
	<td>${priceNumber }</td>
</tr>
</table>
<br>
<hr>

<h2>formatDate 예제</h2>
<c:set var="now" value="<%=new Date() %>" />

1) <fmt:formatDate value="${now }" type="date" dateStyle="full" /><br>
2) <fmt:formatDate value="${now }" type="date" dateStyle="short"/><br>
3) <fmt:formatDate value="${now }" type="time"/>
4) <fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br>
5) <fmt:formatDate value="${now }" pattern="YYYY-MM-dd :hh:mm:ss" /><br>

<br>
한국 현재 시간 : 
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full"/><br><br>

뉴욕 현재 시간 :
<fmt:timeZone value="America/New York">
<fmt:formatDate value="${now }" type="both" dateStyle="full" timeStyle="full" /><br>
</fmt:timeZone>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>escapeXml 변환하기</title>
<style>
table, tr, td {
	text-align:center;
}
td {
	border: 1px solid black;
}
</style>
</head>
<body>
<h2>escapeXml 변환하기</h2>
<h2>
<pre>
<table>
<tr>
	<td width="7%"><c:out  value="&lt;" escapeXml="true" /></td>
	<td width="7%"><c:out  value="&lt;" escapeXml="false" /></td>
</tr>
<tr>
	<td><c:out  value="&gt;" escapeXml="true" /></td>
	<td><c:out  value="&gt;" escapeXml="false" /></td>
</tr>
<tr>
	<td><c:out  value="&amp;" escapeXml="true" /></td>
	<td><c:out  value="&amp;" escapeXml="false" /></td>
<tr>
	<td><c:out  value="&#039;" escapeXml="true" /></td>
	<td><c:out  value="&#039;" escapeXml="false" /></td>
</tr>
<tr>
	<td><c:out  value="&#034;" escapeXml="true" /></td>
	<td><c:out  value="&#034;" escapeXml="false" />
</tr>

</table>

</pre>

</h2>
</body>
</html>

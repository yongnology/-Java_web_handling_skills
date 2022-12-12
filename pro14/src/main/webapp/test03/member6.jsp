<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List dataList= new ArrayList();
	dataList.add("hello");
	dataList.add("world");
	dataList.add("안녕하세요!!");
%>
<c:set var="list" value="<%=dataList %>"/>
<!DOCTYPE html>
<html>
<head>
<style>
.table {
	color: red;
	float: left;
	margin-right: 5px;
}
.table::after {
	clear:both;
}
.clear {
	clear: both;
}
</style>
<meta charset="UTF-8">
<title>반복문 실습</title>
</head>
<body>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="loop">
		i= ${i } &nbsp;&nbsp;&nbsp; 반복회수 : ${loop.count }<br>
	</c:forEach>
<hr>
	<c:forEach var="i" begin="1" end="10" step="2">
		5 * ${i } = ${5*i }<br>
	</c:forEach>
<hr>
<%-- 
	<table border="1">
		<c:forEach var="i" begin="1" end="9" step="1">
			<tr>
				<td colspan="2">${i }단</td>			
			</tr>
			<c:forEach var="j" begin="1" end="9" step="1">
				<tr>
					<td>${i } * ${j } = </td>
					<td>${i*j }</td>
				</tr>			
			</c:forEach>
		</c:forEach>
	</table>
<br>
<hr>
 --%>
<h3>응용</h3>
<c:forEach var="i" begin="1" end="9" step="1">
	<table border="1" class="table">
		<tr>
			<td colspan="2" align="center">${i }단</td>			
		</tr>
		<c:forEach var="j" begin="1" end="9" step="1">
			<tr>
				<td>${i } * ${j } = </td>
				<td>${i*j }</td>
			</tr>
		</c:forEach>
	</table>
</c:forEach>

<br>
<div class="clear">
	<hr>
</div>
	<c:forEach var="data" items="${list }" >
		${data } <br>
	</c:forEach>
<br>
<hr>
<c:set var="fruits" value="사과, 파인애플, 바나나, 망고, 귤" />
<c:forTokens var="token" items="${fruits }" delims="," >
	${token }<br>
</c:forTokens>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<style>
th, td, td {
	border:1px solid #555;
}

td:not(:last-child) {
	text-align:center;
	border: 1px solid #555;
	width: 300px;
}
th {
	text-align:left;
}

</style>
<meta charset="UTF-8">
<title>여러 가지 문자열 함수 기능</title>
</head>
<body>
	<c:set var="title1" value="hello world" />
	<c:set var="title2" value="쇼핑몰 중심 JSP입니다." />
	<c:set var="str1" value="중심" />
	<h2>여러 가지 문자열 함수 기능</h2>
<table>
<tr>
	<td>title1</td>
	<td>hello world</td>
</tr>
<tr>
	<td>title2</td>
	<td>쇼핑몰 중심 JPS 입니다.</td>
</tr>
<tr>
	<td>str1</td>
	<td>중심</td>
</tr>
</table>
<br>
<hr>

<table>
<tr>
	<th>fn:length(title1)</th>
	<td>${fn:length(title1) }</td>
	<td>문자열 길이 반환</td>
</tr>
<tr>
	<th>fn:toUpperCase(title1)</th>
	<td>${fn:toUpperCase(title1) }</td>
	<td>문자열을 대문자로 변환</td>
</tr>
<tr>
	<th>fn:toLowerCase(title1)</th>
	<td>${fn:toLowerCase(title1) }</td>
	<td>문자열을 소문자로 변환</td>
</tr>
<tr></tr>
<tr>
	<th>fn:substring(title1, 3, 6)</th>
	<td>${fn:substring(title1, 3, 6) }</td>
	<td>문자열에서 4~5번째 문자열을 반환</td>
</tr>
<tr>
	<th>fn:trim(title1)</th>
	<td>${fn:trim(title1) }</td>
	<td>앞 뒤 공백 제거</td>
</tr>
<tr>
	<th>fn:replace(title1, " ", "/")</th>
	<td>${fn:replace(title1, " ", "/") }</td>
	<td>문자열에서 공백을 /로 대체 한다.</td>
</tr>
<tr></tr>
<tr>
	<th>fn:indexOf(title2, str1)</th>
	<td>${fn:contains(title1, str1) }</td>
	<td>title2 문자열에서 str1의 위치를 구한다</td>
</tr>
<tr>
	<th>fn:contains(title1, str1)</th>
	<td>${fn:contains(title1, str1) }</td>
	<td>title1 문자열에 str1 문자열이 있는지 판별</td>
</tr>
<tr>
	<th>fn:contains(title2, str1)</th>
	<td>${fn:contains(title2, str1) }</td>
	<td>첫 번째 문자열이 두 번째 문자열을 포함하는지 판별</td>
</tr>
</table>
</body>
</html>

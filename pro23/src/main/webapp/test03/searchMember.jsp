<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>회원 검색창</title>
  <style>
  h1 {
  	text-align: center;
  }

  </style>
</head>
<body>
<h1>회원검색</h1>
<form action="${contextPath}/mem4.do">
    <input  type="hidden" name="action" value="searchMember" />
	<table align="center">
		<tr>
			<td>이름 </td>
			<td><input  type="text" name="name" /><br></td>
		</tr>
		<tr>
			<td>이메일 </td>
			<td><input  type="text" name="email" /><br></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="검색"  /></td>
		</tr>
	</table>
</form> 
</body>
</html>

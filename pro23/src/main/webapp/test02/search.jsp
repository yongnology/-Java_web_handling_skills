<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
   request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색창</title>
</head>
<body>
<h2 align="center">검색기능</h2>
<form action="${pageContext.request.contextPath }/mem3.do">
	<table align="center">
		<tr>
			<td>입력</td>
			<td><input type="text" name="value"/></td>
			<td><select name="action">
				<option value="listMembers">전체</option>
				<option value="selectMemberById">아이디</option>
				<option value="selectMemberByPwd">비밀번호</option>
			</select>
			<td>
			<td><input type="submit" value="검색"></td>
		</tr>
</table>
</form>
</body>
</html>

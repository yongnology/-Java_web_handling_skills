<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "java.util.*, sec02.ex02.*"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>

<c:choose>
	<c:when test='${msg=="addMember" }'>
		<script>
			window.onload= function() {
				alert("회원을 등록했습니다.");
			}
		</script>
	</c:when>
	<c:when test='${msg=="modMember" }'>
		<script>
			window.onload= function() {
				alert("회원 정보를 수정했습니다.");
			}
		</script>
	</c:when>
	<c:when test='${msg=="delMember" }'>
		<script>
			window.onload= function() {
				alert("회원 정보를 삭제했습니다.");
			}
		</script>
	</c:when>
</c:choose>

<meta charset="UTF-8">
<title>회원 정보 출력창</title>
<style>
table {
	margin: 0 auto;
}
tr {
	align-items: center;
	text-align:center;
}
td {
	width: 5%;
}
h2, h3 {
	display: block;
	margin: 0 auto;
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>
<body>
<h2>회원 정보</h2>
<table border="1">
	<tr bgcolor="lightgreen">
		<td><b>아이디</b></td>
		<td><b>비밀번호</b></td>
		<td><b>이름</b></td>
		<td><b>이메일</b></td>
		<td><b>가입일</b></td>
		<td><b>수정</b></td>
		<td><b>삭제</b></td>
	</tr>
<c:choose>
	<c:when test= "${membersList == null }">
		<tr>
			<td colspan="6">회원 정보가 없습니다.</td>
		</tr>
	</c:when>
	<c:when test="${membersList != null }">
		<c:forEach var="mem" items="${membersList }">
			<tr>
				<td>${mem.id }</td>
				<td>${mem.pwd }</td>
				<td>${mem.name }</td>
				<td>${mem.email }</td>
				<td>${mem.joinDate }</td>
				<td><a href="${contextPath }/member3/modMemberForm.do?id=${mem.id}">수정</a></td>
				<td><a href="${contextPath }/member3/delMember.do?id=${mem.id}">삭제</a></td>
			</tr>
		</c:forEach>
	</c:when>
</c:choose>
</table>
<hr>
<h3><a href="${contextPath }/member3/memberForm.do">회원 가입하기</a></h3>
</body>
</html>

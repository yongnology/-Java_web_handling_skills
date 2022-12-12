<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="score" value="${param.score }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>점수 결과</title>
</head>
<body>
<c:set var="score" value="${param.score }" />
<h1>시험 점수 : <c:out value="${score }" /></h1>
<hr>
<h2>
<c:choose>
	<c:when test="${score>=0 && score<=100 && score !='' }">
		<c:choose>
			<c:when test="${score>=90 }">
				A
			</c:when>
			<c:when test="${score>=80 }">
				B
			</c:when>
			<c:when test="${score>=70 }">
				C
			</c:when>
			<c:when test="${score>=60 }">
				D
			</c:when>
			<c:otherwise>
				F
			</c:otherwise>
		</c:choose>
		학점 입니다
	</c:when>
	
	<c:otherwise>
		<h2>점수를 잘못 입력했습니다 .다시 입력해주세요</h2>
	</c:otherwise>
</c:choose>
<br><br>
<a href="scoreTest.jsp">점수 입력 창으로 이동</a>
</h2>
</body>
</html>

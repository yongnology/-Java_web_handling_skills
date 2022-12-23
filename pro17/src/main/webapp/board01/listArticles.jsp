<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<%
	request.setCharacterEncoding("utf-8");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<style>
h2 {
	text-align:center;
}
table {
	margin-bottom: 20px;
}
th {
	border: 1px solid black;
	width: 5%;
	text-align:center;
}
</style>
</head>
<body>
<h2>글 목록</h2>
<table>
<tr>
	<th>글번호</th>
	<th>작성자</th>
	<th>제목</th>
	<th>작성일</th>
</tr>
<c:choose>
	<c:when test="${empty articlesList }">
		<tr>
			<td colspan="4">
			<h3>등록된 글이 없습니다.</h3>
			</td>
		</tr>
	</c:when>

	<c:when test="${!empty articlesList }">
		<c:forEach var="article" items="${articlesList }" varStatus="articleNum">
			<tr>
				<td>${articleNum.count }</td>
				<td>${article.id }</td>
				<td><span style="padding-right:30px"></span>
					<c:choose>
						<c:when test='${article.level > 1 }'>
							<c:forEach begin="1" end="${article.level }" step="1">
								<span style="padding-left:20px"></span>
							</c:forEach>
							<span>[답변]</span>
							<a href="${contextPath }/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
						</c:when>
						<c:otherwise>
							<a href="${contextPath }/board/viewArticle.do?articleNO=${article.articleNO}">${article.title }</a>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${article.writeDate }" />
				</td>
			</tr>
		</c:forEach>
	</c:when>
</c:choose>
</table>
<a href="#">글쓰기</a>
</body>
</html>

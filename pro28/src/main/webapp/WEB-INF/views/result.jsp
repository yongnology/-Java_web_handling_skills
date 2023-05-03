<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>업로드가 완료되었습니다.</h1>
	<table>
		<tr>
			<td><label>아이디</label></td>
			<td><input type="text" value="${map.id }" readonly></td>
		</tr>
		<tr>
			<td><label>이름</label></td>
			<td><input type="text" name="${map.name }"></td>
		</tr>
		<div class="result-images">
		<c:forEach var="imageFileName" items="${map.fileList }">
			<tr>
				<td>
						<img src="${contextPath }/download?imageFileName=${imageFileName}">
				</td>
			</tr>
		</c:forEach>
		</div>
	</table>
	<a href="${contextPath }/form">다시 업로드 하기</a>
</body>
</html>

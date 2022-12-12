<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
	pageContext.setAttribute("crcn", "\r\n");
	pageContext.setAttribute("br", "<br>");
%>

<c:set var="content" value="${param.content }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 표시</title>
</head>
<body>

<h2>글 내용</h2>
<hr>
<h3>
기본<br>
<h4>
${content }<br>
</h4>
<hr>
fn:replace<br>
<h4>
${fn:replace(content, crcn, br) }
</h4>
</h3>
</body>
</html>

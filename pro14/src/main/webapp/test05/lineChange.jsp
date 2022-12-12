<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개행 문자 변환하기</title>
</head>
<body>
<c:set var="title1" value="안녕하세요\r\n 쇼핑몰 중심 JSP 입니다."/>

${title1 } <br><br>
${fn:replace(title1, "\\r\\n", "<br>") }

</body>
</html>

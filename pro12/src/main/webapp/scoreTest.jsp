<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int score = Integer.parseInt(request.getParameter("score"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학점 출력창</title>
</head>
<body>
<h1>시험 점수 : <%= score %>점</h1><br>
<%
	if(score>100 || score<0) {
%>
	<h2>허용점수 범위를 초과 했습니다.</h2>		
<%
	}else if(score >= 90) {
%>
	<h2>A학점 입니다.</h2>
<%
	} else if (score >=80) {
%>
	<h2>B학점 입니다.</h2>	
<%
	} else  if(score >= 70) {
%>
	<h2>C학점 입니다.</h2>
<%
	} else if(score >= 60) {
%>
	<h2>D학점 입니다.</h2>		
<%
	} else {
%>
	<h2>F학점 입니다.</h2>
<%
	}
%>
<br>
<a href="scoreTest.html">시험점수 입력창</a>
</body>
</html>

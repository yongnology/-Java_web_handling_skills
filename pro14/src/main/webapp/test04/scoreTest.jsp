<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 점수 입력 페이지</title>
</head>
<body>
<h1>시험 점수를 입력해 주세요</h1>
<form method="get" action="scoreResult1.jsp">
<table>
	<tr>
		<td>시험 점수</td>
		<td><input type="text" name="score"/>
	</tr>
	<tr>
		<td><input type="submit" value="학점 변환"/></td>
		<td><input type="reset" value="다시 입력"/></td>
	</tr>
</table>
</form>
</body>
</html>

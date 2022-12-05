<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력창</title>
</head>
<body>
	<table border='1' width='500'>
		<tr align='center' bgcolor='#ffff66'>
			<td colspan='2'><b><%=dan %>단 출력</b></td>
		</tr>
	<%
		for(int i=1; i<10; i++) {
	%>
	<%
		if(i%2 == 1) {
	%>
		<tr align='center' bgcolor="lightgreen">
	<%
		} else {
	%>
		<tr align='center' bgcolor="lightyellow">
	<%
		}
	%>
			<td width='20%'>
				<%=dan %> * <%=i %>
			</td>
			<td width='20%'>
				<%=i*dan %>
			</td>
		</tr>
	<%
	}
	%>
	</table>
</body>
</html>

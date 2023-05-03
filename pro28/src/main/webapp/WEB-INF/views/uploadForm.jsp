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
<title>파이 업로드 하기</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
	var cnt = 1;
	function fn_addFile() {
		$("#d_file").append("<br>" + "<input type='file' name='file+"+cnt+"' />");
		cnt++;
	}
</script>
</head>
<body>
	<h1>파일 업로드 하기</h1>
	<form method="post" action="${contextPath }/upload" enctype="multipart/form-data">
	<table>
		<tr>
			<td><label>아이디</label></td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td><label>이름</label></td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td><input type="button" value="파일추가" onclick="fn_addFile()"></td>
			<td><div id="d_file"></div>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="업로드" />
		</tr>
	</table>
	
	</form>
</body>
</html>

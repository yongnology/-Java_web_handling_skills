<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON ajax 연습</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		var _jsonInfo = '{"name":"박지성", "age":25, "gender":"남자", "nickname":"탱크"}';
		$.ajax({
			type:"post",
			async: false,
			url: "${contextPath}/json1",
			data: {jsonInfo: _jsonInfo},
			success: function (data, textStatus) {
				
			},
			error: function(data, textStatus) {
				alert("에러가 발생했습니다");
			}
		});	// end ajax
	});
});
</script>
</head>
<body>
<h2>JSON 테스트5</h2>
<a id="checkJson" style="cursor: pointer">전송</a><br><hr>
	<div id="output"></div>
</body>
</html>

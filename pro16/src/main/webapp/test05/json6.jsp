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
			async:false,
			url:"${contextPath}/json2",
			success: function (data, textStatus) {
				var jsonInfo = JSON.parse(data);	// 서버에 전송한 JSON 데이터를 파싱
				var memberInfo = "회원정보<br>";
				memberInfo += "=============<br>";
				for(var i in jsonInfo.members) {
					memberInfo += "이름 : " + jsonInfo.members[i].name + "<br>";
					memberInfo += "나이 : " + jsonInfo.members[i].age + "<br>";
					memberInfo += "성별 : " + jsonInfo.members[i].gender + "<br>";
					memberInfo += "별명 : " + jsonInfo.members[i].nickname + "<br><br>";
				}
				$("#output").html(memberInfo);
			},
			error: function(data, textStatus) {
				alert("에러가 발생했습니다");
			},
			complete: function (data, textStatus){
			}
		});	// end ajax
	});
});
</script>
</head>
<body>
<h2>JSON 테스트6</h2>
<a id="checkJson" style="cursor: pointer">전송</a><br><hr>
	<div id="output"></div>
</body>
</html>

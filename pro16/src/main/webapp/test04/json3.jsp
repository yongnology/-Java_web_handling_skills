<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트3</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		var jsonStr = '{"name":"박지성", "age":25, "gender":"남자", "nickname":"낼쌘돌이"}';
		var jsonObj = JSON.parse(jsonStr);		// parse()메소드로 배열을 구한다.
		var output = "회원 정보<br>";
		output += "======<br>";
		output += "이름 : " + jsonObj.name + "<br>";
		output += "나이 : " + jsonObj.age + "<br>";
		output += "성별 : " + jsonObj.gender + "<br>";
		output += "별명 : " + jsonObj.nickname + "<br>";
		
		$("#output").html(output);
	});
});
</script>
</head>
<body>
<h2>JSON 테스트3</h2>
<a id="checkJson" style="cursor: pointer">출력</a><br><hr>
<div id="output"></div>
</body>
</html>

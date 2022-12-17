<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON 테스트2</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		var jsonStr = '{"age" : [22, 33, 44] }';
		var jsonInfo = JSON.parse(jsonStr);		// parse()메소드로 배열을 구한다.
		var output = "회원 나이<br>";
		output += "======<br>";
		for(var i in jsonInfo.age) {
			output += jsonInfo.age[i] + "<br>";
		}
		$("#output").html(output);
	});
});
</script>
</head>
<body>
<h2>JSON 테스트2</h2>
<a id="checkJson" style="cursor: pointer">출력</a><br><hr>
<div id="output"></div>
</body>
</html>

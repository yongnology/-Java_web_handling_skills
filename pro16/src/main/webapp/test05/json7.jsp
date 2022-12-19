<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  /> 
<!DOCTYPE html>
<html>
<head>
<style>
img {
	width: 300px;
	height: 400px;
}
.book {
	float: left;
	margin-left: 50px;
}
</style>
<meta charset="UTF-8">
<title>JSON ajax 연습</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function() {
	$("#checkJson").click(function() {
		$.ajax({
			type:"post",
			async:false,
			url:"${contextPath}/json3",
			success: function (data, textStatus) {
				var jsonInfo = JSON.parse(data);	// 서버에 전송한 JSON 데이터를 파싱
				var memberInfo = "회원정보<br>";
				memberInfo += "<hr>";
				for(var i in jsonInfo.members) {
					memberInfo += "이름 : " + jsonInfo.members[i].name + "<br>";
					memberInfo += "나이 : " + jsonInfo.members[i].age + "<br>";
					memberInfo += "성별 : " + jsonInfo.members[i].gender + "<br>";
					memberInfo += "별명 : " + jsonInfo.members[i].nickname + "<br><br>";
				}
				var booksInfo = "<br><br>도서 정보<br>";
				booksInfo +="<hr>";
				for(var i in jsonInfo.books) {
					booksInfo += "<div class='book'>";
					booksInfo += "제목 : " + jsonInfo.books[i].title + "<br>";
					booksInfo += "저자 : " + jsonInfo.books[i].writer + "<br>";
					booksInfo += "가격 : " + jsonInfo.books[i].price + "원<br>";
					booksInfo += "장르 : " + jsonInfo.books[i].genre + "<br>";
					imageURL = jsonInfo.books[i].image;
					booksInfo += "<img src='" + imageURL + "'/><br><br>";
					booksInfo += "</div>";
				}
				$("#output").html(memberInfo + "<br>" + booksInfo);
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
<h2>JSON 테스트7</h2>
<a id="checkJson" style="cursor: pointer">데이터 수신하기</a><br><hr>
	<div id="output"></div>
</body>
</html>

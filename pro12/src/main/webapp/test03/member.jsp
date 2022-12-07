<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*"
    import="sec02.ex01.*"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<style>
h1, h3{
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<h1>회원 정보 출력</h1>
<%
	request.setCharacterEncoding("utf-8");
	String _name = request.getParameter("name");	// 전송된 이름을 가져온다.
	MemberVO memberVO = new MemberVO();
	memberVO.setName(_name);
	MemberDAO dao = new MemberDAO();
	List membersList = dao.listMembers(memberVO);
	// memberVO를 listMembers() 메소드로 전달하여 조회 조건에 해당하는 회원 정보를 조회
%>
<table border="1" width="500" align="center">
	<tr align="center" bgcolor="#FFFF66">
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이름</td>
		<td>이메일</td>
		<td>가입일자</td>
	</tr>
<%
	for (int i=0; i< membersList.size(); i++) {
		MemberVO vo = (MemberVO) membersList.get(i);
		String id = vo.getId();
		String pwd = vo.getPwd();
		String name = vo.getName();
		String email = vo.getEmail();
		Date joinDate = vo.getJoinDate();
%>
	<tr align=center>
		<td><%=id %></td>
		<td><%=pwd %></td>
		<td><%=name %></td>
		<td><%=email %></td>
		<td><%=joinDate %></td>
	</tr>
<%
	}
%>
</table>
<br>
<h3><a href="search.jsp">다른 회원 조회하기</a></h3>
</body>
</html>

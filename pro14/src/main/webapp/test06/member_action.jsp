<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
<jsp:setProperty name="m" property="*" />
<%
	String command = (String) request.getParameter("command");
	MemberDAO memberDAO = new MemberDAO();
	List membersList = null;
	
	if(command.equals("search")) {
		membersList = memberDAO.listMembers(m);	
	} else if(command.equals("addMember")) {
		memberDAO.addMember(m);	 /* 회원 정보를 추가 */
		membersList = memberDAO.listMembers();	 /* 회원 정보를 조회 */
	}
	request.setAttribute("membersList", membersList);	 /* 조회한 회원 정보를 request에 바인딩 */
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출력</title>
</head>
<body>
<jsp:forward page="membersList.jsp"/>
</body>
</html>

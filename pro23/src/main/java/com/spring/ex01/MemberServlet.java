package com.spring.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem.do")
public class MemberServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	}
	
	private void doHandle(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> membersList = dao.selectAllMemberList();
		req.setAttribute("membersList", membersList);
		RequestDispatcher dispatch = req.getRequestDispatcher("test01/listMembers.jsp");
		dispatch.forward(req, res);
	}
}

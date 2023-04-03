package com.spring.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mem2.do")
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
		
		String name = dao.selectName();
		int pwd = dao.selectPwd();
		
		PrintWriter pw = res.getWriter();
		pw.write("<script>");
		pw.write("alert(' 이름 : "+ name + "<br>");
		pw.write("'비밀번호 : "+ pwd +"');");
		
		pw.write("</script>");
		
	}
}

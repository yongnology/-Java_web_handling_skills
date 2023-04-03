package com.spring.ex03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem3.do")
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
		MemberVO memberVO = new MemberVO();
		
		String action = req.getParameter("action");
		String nextPage= "";
		try {
			if(action ==null || action.equals("listMembers")) {
				List<MemberVO> membersList = dao.selectAllMemberList();
				req.setAttribute("membersList", membersList);
				nextPage = "test02/listMembers.jsp";
			} else if(action.equals("selectMemberById")) {
				String id = req.getParameter("value");
				memberVO = dao.selectMemberById(id);
				req.setAttribute("member", memberVO);
				nextPage = "test02/memberInfo.jsp";
			} else if( action.equals("selectMemberByPwd")) {
				int pwd = Integer.parseInt(req.getParameter("value"));
				List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
				req.setAttribute("membersList", membersList);
				nextPage = "test02/listMembers.jsp";
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("해당조건의 회원정보 없음");
			List<MemberVO> membersList = dao.selectAllMemberList();
			req.setAttribute("membersList", membersList);
			nextPage = "test02/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = req.getRequestDispatcher(nextPage);
		dispatch.forward(req, res);
	}
}

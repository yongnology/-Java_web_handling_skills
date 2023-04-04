package com.spring.ex04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem4.do")
public class MemberServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doHandle(req, res);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		
		String action = request.getParameter("action");
		String nextPage= "";
		try {
			
			if(action == null || action.equals("listMembers")) {
				List<MemberVO> membersList = dao.selectAllMemberList();
				request.setAttribute("membersList", membersList);
				nextPage = "test03/listMembers.jsp";
				
			} else if(action.equals("memberForm")) {
				nextPage = "test03/memberForm.jsp";
			
			}else if(action.equals("selectMemberById")) {
				String id = request.getParameter("value");
				memberVO = dao.selectMemberById(id);
				request.setAttribute("member", memberVO);
				nextPage = "test03/memberInfo.jsp";
				
			} else if( action.equals("selectMemberByPwd")) {
				int pwd = Integer.parseInt(request.getParameter("value"));
				List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
				request.setAttribute("membersList", membersList);
				nextPage = "test03/listMembers.jsp";
				
			} else if (action.equals("insertMember")) {
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				
				dao.insertMember(memberVO);
				// 회원 가입창에서 전송된 회원 정보를 MemberVO에 설정한 후 insertMember()메소드로 전달
				nextPage = "/mem4.do?action=listMembers";
				
			} else if (action.equals( "insertMember2" )) {
				String id=request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				
				Map memberMap = new HashMap();
				memberMap.put("id", id);
				memberMap.put("pwd", pwd);
				memberMap.put("name", name);
				memberMap.put("name", name);
				memberMap.put("email", email);
				
				dao.insertMember2(memberMap);
				nextPage="/mem4.do?action=listMembers";
			} else if(action.equals("updateMember")) {
				String id=request.getParameter("id");
				String pwd = request.getParameter("pwd");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				memberVO.setId(id);
				memberVO.setPwd(pwd);
				memberVO.setName(name);
				memberVO.setEmail(email);
				
				dao.updateMember(memberVO);
				// 회원 수정창에서 전송된 회원정보를 MemberVO의 속성에 설정한 후 updateMember()를 호출하면서
				// MemberVO 객체를 전달
				nextPage = "/mem4.do?action=listMembers";
			} else if(action.equals("deleteMember")) {
				String id= request.getParameter("id");
				dao.deleteMember(id);
				nextPage="/mem4.do?action=listMembers";
			
			} else if(action.equals("searchMember")) {
				String name= request.getParameter("name");
				String email= request.getParameter("email");
				memberVO.setName(name);
				memberVO.setEmail(email);
				
				List<MemberVO> membersList = dao.searchMember(memberVO);
				request.setAttribute("membersList", membersList);
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■ searchMember ■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println(membersList);
				nextPage="/test03/listMembers.jsp";
			
			} else if(action.equals("foreachSelect")) {
				List<String> nameList = new ArrayList();
				nameList.add("홍길동");
				nameList.add("차범근");
				nameList.add("이순신");
				
				List<MemberVO> membersList = dao.foreachSelect(nameList);
				request.setAttribute("membersList", membersList);
				nextPage= "test03/listMembers.jsp";
			
			} else if(action.equals("foreachInsert")) {
				List<MemberVO> memList = new ArrayList();
				memList.add(new MemberVO("m1", "1234", "박길동", "m1@test.com"));
				memList.add(new MemberVO("m2", "1234", "이길동", "m2@test.com"));
				memList.add(new MemberVO("m3", "1234", "삼길동", "m3@test.com"));
				memList.add(new MemberVO("m4", "1234", "사길동", "m4@test.com"));
				
				int result = dao.foreachInsert(memList);	// SQL문으로 memList를 전달
				nextPage="/mem4.do?action=listMembers";
			}
			
		} catch(Exception e) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■오류 발생 ■■■■■■■■■■■■■■■■■■■■■■■■■");
			e.printStackTrace();
			System.out.println("해당조건의 회원정보 없음");
			List<MemberVO> membersList = dao.selectAllMemberList();
			request.setAttribute("membersList", membersList);
			nextPage = "test03/listMembers.jsp";
		}
		
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		dispatch.forward(request, response);
	}
}

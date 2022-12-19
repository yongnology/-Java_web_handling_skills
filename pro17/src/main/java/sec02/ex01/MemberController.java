package sec02.ex01;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	MemberDAO memberDAO;
	public void init() throws ServletException {
		memberDAO = new MemberDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = null;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();	// URL 요청명을 가져온다.
		System.out.println("action : " + action);
		
		if(action == null || action.equals("/listMembers.do")) {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";		// listMembers.jsp로 포워딩
		
		} else if (action.equals("/addMember.do")) {	// 회원가입 동작
			String id = request.getParameter("id");
			String pwd= request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			MemberVO memberVO = new MemberVO(id, pwd, name, email);
			memberDAO.addMember(memberVO);
			nextPage = "/member/listmembers.do";	// 회원 등록 후 회원 목록 출력
		
		} else if (action.equals("/memberForm.do")) {
			nextPage ="/test02/memberForm.jsp";		// 회원 가입창으로
		
		} else {
			List<MemberVO> membersList = memberDAO.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";		// listMembers.jsp로 포워딩
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
		// nextPage에 지정한 요청명으로 다시 서블릿에 요청
		dispatch.forward(request, response);
	}

}

package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/input")
public class InputServlet extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String usr_id = request.getParameter("user_id");
		String usr_pw = request.getParameter("user_pw");
		System.out.println("아이디 : " + usr_id);
		System.out.println("비밀번호 : " + usr_pw);
		
		String[] subject = request.getParameterValues("subject");
		for (String str : subject) {
			System.out.println("선택한 과목 : " + str);
		}
	}
	
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
}

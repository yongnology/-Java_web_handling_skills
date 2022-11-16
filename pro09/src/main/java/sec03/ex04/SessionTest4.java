package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class SessionTest4 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		if (session.isNew()) {
			if(user_id != null && user_pw != null) {
				session.setAttribute("user_id", user_id);
				session.setAttribute("user_pw", user_pw);
				out.println("<a href='login3'>로그인 상태 확인</a>");
			} else {
				out.print("<a href='login3.html'>다시 로그인하세요!</a>");
				session.invalidate();
			}
		} else {
			user_id = (String) session.getAttribute("user_id");
			user_pw = (String) session.getAttribute("user_pw");
			if((user_id != null && user_id.length() != 0)&&(user_pw !=null && user_pw.length() !=0 )) {
				out.print("<h3>안녕하세요</h3><br>" + user_id + "님!");
			} else {
				out.print("<a href='login3.html'>다시 로그인하세요!</a>");
				session.invalidate();
			}
		}
	}

}

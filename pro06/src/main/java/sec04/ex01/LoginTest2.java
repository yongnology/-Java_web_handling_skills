package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginTest2")
public class LoginTest2 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
		
		if(id!= null && (id.length()!=0)) {
			if(id.equals("admin")) {
				out.print("<html><body>");
				out.print("<h2>관리자로 로그인 하셨습니다.<br><h2>");
				out.print("<input type='button' value= '회원정보 수정하기' />");
				out.print("<input type='button' value= '회원정보 삭제하기' />");
				out.print("</body></html>");
			} else {
				out.print("<html><body>");
				out.print(id + "님 로그인 하셨습니다.<br>반갑습니다.");
				out.print("</body></html>");
			}
			
		} else {
			out.print("<html><body>");
			out.print("<h2>아이디와 비밀번호를 입력해주세요</h2><br>");
			out.print("<a href='http://localhost:8090/pro06/test01/login2.html'>로그인창 이동</a>");
			out.print("</body></html>");
		}
		
	}

}

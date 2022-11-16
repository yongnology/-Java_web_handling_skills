// 세션 유효 시간 설정

package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sess2")
public class SesstionTest2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();	// 세션이 있으면 리턴, 없으면 생성
		out.println("세션 아이디 : " + session.getId() + "<br>");
		out.println("최초 세션 생성 시간 : " + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시간 : " + new Date(session.getLastAccessedTime()) + "<br>");
	
		out.print("기존 세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		// 세션 유효 시간을 따로 설정하지 않으면 톰켓에서 설정한 기본 유효시간 30분이 적용된다.
		session.setMaxInactiveInterval(5); // 세션 유효시간을 5초로 설정
		out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		if (session.isNew()) {
			out.print("새로운 세션이 만들어졌습니다.");
		}
	}

}

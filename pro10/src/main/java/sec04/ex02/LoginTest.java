package sec04.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login3")
public class LoginTest extends HttpServlet {
	
	ServletContext context = null;
	List user_list = new ArrayList();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		context = getServletContext();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		// 이벤트 핸들러를 생성한 후 세션에 저장
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		if (session.isNew() ) {
			session.setAttribute("loginUser", loginUser);
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		out.println("<html><head>");
		
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");	// 5초마다 서블릿에 재요청 현재 접속자 수 표시
		out.println("</script>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자수는 : "+LoginImpl.total_user+ "<br>");
		out.println("접속 아이디:<br>");
		List list =(ArrayList) context.getAttribute("user_list");
		for(int i=0; i<list.size(); i++) {
			out.println(list.get(i)+"<br>");
		}
		out.println("<a href='logout?user_id="+user_id+"'>로그아웃</a>");
		out.println("</body></html>");
	}

}

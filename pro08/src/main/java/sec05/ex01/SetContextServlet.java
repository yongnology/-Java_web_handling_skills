package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cset")
public class SetContextServlet extends HttpServlet {

	/*
	 * public void init(ServletConfig config) throws ServletException {
	 * System.out.println("init 메소드 호출"); }
	 */

	public void destroy() {
		System.out.println("destroy 메소드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List member = new ArrayList();
				//(ArrayList)context.getAttribute("member");
		member.add("이순신");
		member.add(30);
		context.setAttribute("member", member);
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
	}

}

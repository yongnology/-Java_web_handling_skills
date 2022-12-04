package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet("*.do")
@WebServlet("/*")
public class TestServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		String uri = request.getRequestURI();
		
		out.println("<html><heady>");
		out.print("<title>Test Servlet3</title>");
		out.print("</head>");
		out.print("<body bgcolor='red'>");
		out.print("<h1>TestServlet3입니다.</h1><br><br>");
		out.print("<b>컨텍스트명" + context + "<br><br>");
		out.print("<b>전체경로" + url + "<br><br>");
		out.print("<b>매핑명" + mapping + "<br><br>");
		out.print("<b>URI" + uri + "<br><br>");
		out.print("</body></html");
		
	}

}

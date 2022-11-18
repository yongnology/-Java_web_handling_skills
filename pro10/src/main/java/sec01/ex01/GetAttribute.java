package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/get")
public class GetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext ctx= getServletContext();
		HttpSession sess = request.getSession();
		
		String ctxMsg = (String) ctx.getAttribute("context");
		String sdssMsg = (String) sess.getAttribute("session");
		String reqMsg = (String) request.getAttribute("request");
		
		out.print("context값 : " + ctxMsg + "<br>");
		out.print("session값 : " + sdssMsg + "<br>");
		out.print("request값 : " + reqMsg + "<br>");
	}

}

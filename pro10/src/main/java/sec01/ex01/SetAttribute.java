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

@WebServlet("/set")
public class SetAttribute extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String ctxMsg = "context에 바인딩 됩니다.";
		String sesMsg = "session에 바인딩 됩니다.";
		String reqMsg = "request에 바인딩 됩니다.";
		
		// HttpServletContext 객체, HttpSession 객체, HttpServletRequest 객체를 얻은 후 속성을 바인딩
		ServletContext ctx = getServletContext();
		HttpSession session = request.getSession();
		ctx.setAttribute("context", ctxMsg);
		session.setAttribute("session", sesMsg);
		request.setAttribute("request", reqMsg);
		
		out.print("바인딩을수행합니다.");
	}

}

package sec03.ex01;
// 서버의 서블릿에서 웹 페이지로 JSON 형식의 회원 정보를 전송
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		
		JSONObject totalObject = new JSONObject();	// 전체 정보 객체
		JSONArray membersArray = new JSONArray();	// JSON 배열
		JSONObject memberInfo = new JSONObject();	// JSON 객체
		
		memberInfo.put("name", "박지성");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "남자");
		memberInfo.put("nickname", "날쎈돌이");
		// 배열에 입력
		membersArray.add(memberInfo);
		
		memberInfo = new JSONObject();
		memberInfo.put("name", "김연아");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "여자");
		memberInfo.put("nickname", "얼음공주");
		
		// 배열에 입력
		membersArray.add(memberInfo);
		
		totalObject.put("members", membersArray); // totalObject에 members라는 name으로 membersArray를 value로 저장
		
		String jsonInfo = totalObject.toJSONString();	// JSONObject를 문자열로 변환
		System.out.println(jsonInfo);
		out.print(jsonInfo);
		
	}

}

package sec03.ex01;
// 여러 개의 배열을 JSON으로 전달
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/json3")
public class JsonServlet3 extends HttpServlet {

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
		
		totalObject.put("members", membersArray); // 회원 정보를 저장한 배열을 배여 이름 members로 totalObject에 저장
		
		JSONArray bookArray = new JSONArray();
		JSONObject bookInfo = new JSONObject();
		bookInfo.put("title", "초보자를 위한 자바 프로그래밍");
		bookInfo.put("wrtier", "이병승");
		bookInfo.put("price", "30000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://127.0.0.1:8090/pro16/image/image1.jpg");
		// bookArray에 객체를 저장
		bookArray.add(bookInfo);
		
		bookInfo = new JSONObject();
		bookInfo.put("title", "모두의 파이썬");
		bookInfo.put("wrtier", "이승찬");
		bookInfo.put("price", "12000");
		bookInfo.put("genre", "IT");
		bookInfo.put("image", "http://127.0.0.1:8090/pro16/image/image2.jpg");
		// bookArray에 객체를 저장
		bookArray.add(bookInfo);
		
		totalObject.put("books", bookArray);
		
		String jsonInfo = totalObject.toJSONString();
		System.out.println(jsonInfo);
		out.print(jsonInfo);		
	}

}

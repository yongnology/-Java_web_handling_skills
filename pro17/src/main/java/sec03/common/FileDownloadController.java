package sec03.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownloadController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\study\\board\\article_image";
	// 글에 첨부한 이미지 저장 위치를 상수로 선언
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 이미지 파일 이름과 글 번호를 가져온다.
		String imageFileName = (String)request.getParameter("imageFIleName");
		String articleNO = request.getParameter("articleNO");
		
		System.out.println("imageFileName=" + imageFileName);
		OutputStream out = response.getOutputStream();
		
		String path = ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + imageFileName;
		File ImageFile = new File(path);
		
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition", "attachment;fileName=" + imageFileName);
		FileInputStream in = new FileInputStream(ImageFile);
		
		byte[] buffer = new byte[1024 * 8];
		while(true) {
			int count = in.read(buffer);
			if (count == -1)
				break;
			out.write(buffer, 0, count);
		}
		in.close();
		out.close();
	}

}

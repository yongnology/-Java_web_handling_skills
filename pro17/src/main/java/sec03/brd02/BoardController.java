package sec03.brd02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/board2/*")
public class BoardController extends HttpServlet {
	private static String ARTICLE_IMAGE_REPO = "C:\\study\\board\\article_image";
	// 글에 첨부한 이미지 저장 위치를 상수로 선언
	
	BoardService boardService;
	ArticleVO articleVO;

	public void init(ServletConfig config) throws ServletException {
		boardService = new BoardService();
		articleVO = new ArticleVO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String nextPage = "";
		String action= request.getPathInfo();		// 요청명 가져오기
		System.out.println("action : " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			// action이 아무것도 없다면 전체글
			if(action == null) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			} else if (action.equals("/") ) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
				
			// 요청 명이 listArticles.do 라면 전체글 불러오기
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board02/listArticles.jsp";
			
			// 요청명이 articleForm.do 라면 글쓰기창으로 이동
			} else if(action.equals("/articleForm.do") ) {
				nextPage = "/board02/articleForm.jsp";
			
			// 요청명이 addArticle.do 라면 새 글 추가 작업 수행
			} else if(action.equals("/addArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);	// 새 글의 부모 글 번호를 0으로 설정
				articleVO.setId("park");	// 새 글 작성자를 park으로 설정
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.addArticle(articleVO);
				nextPage = "/board2/listArticles.do";
				
			} else {
				nextPage = "/board02/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("===========================");
			System.out.println("BoardController에서 catch");
			e.printStackTrace();
		}
	}
	
	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding="utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);	// 글 이미지 젖아 폴더에 대해 파일 객체를 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++ ) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField() ) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding)	);
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파라미터이름 : " + fileItem.getFieldName()	);
					System.out.println("파일이름 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						articleMap.put(fileItem.getFieldName(), fileName);  //익스플로러에서 업로드 파일의 경로 제거 후 map에 파일명 저장
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleMap;
		
	}
}

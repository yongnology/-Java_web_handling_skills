package sec03.brd05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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
import org.apache.commons.io.FileUtils;

@WebServlet("/board5/*" )
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
		String action = request.getPathInfo();
		System.out.println("action : " + action);
		try {
			List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
			
			//action이 아무것도 없다면 전체글
			if( action == null ) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board05/listArticles.jsp";
			} else if (action.equals("/") ) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board05/listArticles.jsp";
			
			// 요청명이 listArticles.do 라면 전체글 불러오기
			} else if (action.equals("/listArticles.do")) {
				articlesList = boardService.listArticles();
				request.setAttribute("articlesList", articlesList);
				nextPage = "/board05/listArticles.jsp";
				
			// 요청명이 articleForm.do 라면 글쓰기창으로 이동
			} else if (action.equals("/articleForm.do")) {
				nextPage = "/board05/articleForm.jsp";
				
			// 요청명이 addArticle.do 라면 새 글 추가 작업 수행	
			} else if(action.equals("/addArticles.do")) {
				int articleNO = 0;
				Map<String, String> articleMap = upload(request, response);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);	// 새 글의 부모 글 번호를 0 으로 설정
				articleVO.setId("lee");		// 새 글 작성자를 lee 로 설정
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				
				articleNO = boardService.addArticle(articleVO);	// 테이블에 새 글을 추가한 후 새 글에 대한 글 번호르 가져온다.
				
				if(imageFileName != null && imageFileName.length() != 0) {
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + imageFileName);
					File desDir = new File(ARTICLE_IMAGE_REPO + "\\" +articleNO);
					desDir.mkdir();
					FileUtils.moveFileToDirectory(srcFile, desDir, true);
					srcFile.delete();
				}
				
				PrintWriter pw = response.getWriter();
				pw.print("<script>alert('새 글을 추가했습니다.');"
						+ " location.href='"
						+ request.getContextPath()
						+ "/board5/listArticles.do';" 
						+ "</script>"
						);
				return;
				
			// 요청명이 viewArticle.do 이면 상세 글 보기 작업 수행
			} else if(action.equals("/viewArticle.do")) {
				String articleNO = request.getParameter("articleNO");
				articleVO = boardService.viewArticle(Integer.parseInt(articleNO));
				request.setAttribute("article", articleVO);
				nextPage= "/board05/viewArticle.jsp";
				
			} else if (action.equals("/modArticle.do")) {
				Map<String, String> articleMap = upload(request, response);
				int articleNO = Integer.parseInt(articleMap.get("articleNO"));
				articleVO.setArticleNO(articleNO);
				String title = articleMap.get("title");
				String content = articleMap.get("content");
				String imageFileName = articleMap.get("imageFileName");
				
				articleVO.setParentNO(0);
				articleVO.setId("hong");
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setImageFileName(imageFileName);
				boardService.modArticle(articleVO);	// 전송된 글 정보를 이용해 글을 수정
				if (imageFileName != null && imageFileName.length() != 0) {
					String originalFileName = articleMap.get("originalFileName");
					File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" +imageFileName);
					File desDir = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO);
					desDir.mkdirs();
					FileUtils.moveFileToDirectory(srcFile, desDir, true);
					
					File oldFile = new File(ARTICLE_IMAGE_REPO + "\\" + articleNO + "\\" + originalFileName);
					oldFile.delete();
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" 
						+ " alert('글을 수정했습니다.');"
						+ " location.href='"
						+ request.getContextPath()
						+ "/board5/viewArticle.do?articleNO="
						+ articleNO
						+ "';"
						+ "</script>");
				return;
			} else if(action.equals("/removeArticle.do")) {
				int articleNO = Integer.parseInt(request.getParameter("articleNO"));
				List<Integer> articleNOList = boardService.removeArticle(articleNO);
				for (int _articleNO : articleNOList) {
					File imgDir = new File(ARTICLE_IMAGE_REPO + "\\" + _articleNO);
					if(imgDir.exists() ) {
						FileUtils.deleteDirectory(imgDir);
					}
							
				}
				PrintWriter pw = response.getWriter();
				pw.print("<script>" + " alert('글을 삭제했습니다.');" + " location.href='"
						+ request.getContextPath() + "/board5/listArticles.do';"
						+ "</script>");
				return;
			} else {
				nextPage = "/board05/listArticles.jsp";
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("-----------------------------");
			System.out.println("BoardController에서 catch 발생");
			e.printStackTrace();
		}
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);	// 글 이미지 찾아 폴더에 대한 객체를 생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for(int i=0; i<items.size(); i++ ) {
				FileItem fileItem = (FileItem) items.get(i);
				if(fileItem.isFormField() ) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
					
				} else {
					System.out.println("파라미터이름 : " + fileItem.getFieldName() );
					System.out.println("파일이름 : " + fileItem.getName());
					System.out.println("파일크기 : " + fileItem.getSize() + "bytes");
					
					if(fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if(idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}
						
						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명 : " + fileName);
						articleMap.put(fileItem.getFieldName(), fileName);
						File uploadFile = new File(currentDirPath + "\\" + fileName);
						fileItem.write(uploadFile);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("BoardController에서 Exception");
			e.printStackTrace();
		}
		return articleMap;
		
	}
	
}

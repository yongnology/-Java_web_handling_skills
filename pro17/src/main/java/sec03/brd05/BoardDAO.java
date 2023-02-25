package sec03.brd05;

import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataFactory;
	Connection conn;
	PreparedStatement pstmt;
	
	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			System.out.println("BoardDAO에서 BoardDAO 오류");
			e.getMessage();
			// e.printStackTrace();
		}
	}
	
	public List<ArticleVO> selectAllArticles() {
		List<ArticleVO> articlesList = new ArrayList<ArticleVO>();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LEVEL"
					+ ", articleNO"
					+ ", parentNO"
					+ ", title"
					+ ", content"
					+ ", id"
					+ ", writeDate"
					+ " from t_board"
					+ " START WITH parentNO=0"
					+ " CONNECT BY PRIOR articleNO=parentNO"
					+ " ORDER SIBLINGS BY articleNO DESC";
			System.out.println(query);
			pstmt= conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int level = rs.getInt("level");
				int articleNO = rs.getInt("articleNO");
				int parentNO = rs.getInt("parentNO");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String id = rs.getString("id");
				Date writeDate = rs.getDate("writeDate");
				
				ArticleVO articleVO = new ArticleVO();
				articleVO.setLevel(level);
				articleVO.setArticleNO(articleNO);
				articleVO.setParentNO(parentNO);
				articleVO.setTitle(title);
				articleVO.setContent(content);
				articleVO.setId(id);
				articleVO.setWriteDate(writeDate);
				articlesList.add(articleVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.getMessage();
			System.out.println("BoardDAO에서 selectAllArticles 오류");
			e.printStackTrace();
		}
		return articlesList;
	}
	
	private int getNewArticleNO() {
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT max(articleNO) from t_board ";	// 기본 글 번호 중 가장 큰 번호를 조회
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) 
				return(rs.getInt(1) + 1);	// 가장 큰 번호에 1을 더한 번호를 반환
			
				rs.close();
				pstmt.close();
				conn.close();
			
		} catch (Exception e) {
			e.getMessage();
			// e.printStackTrace();
		}
		return 0;
	}
	
	public int insertNewArticle(ArticleVO article) {
		int articleNO = getNewArticleNO();	// 새 글을 추가하기 전에 새 글에 대한 글 번호를 가져온다.
		try {
			conn = dataFactory.getConnection();
			int parentNO = article.getParentNO();
			String title = article.getTitle();
			String content = article.getContent();
			String id = article.getId();
			String imageFileName = article.getImageFileName();
			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id)"
					+ " VALUES (?, ? ,?, ?, ?, ?)";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.setInt(2, parentNO);
			pstmt.setString(3, title);
			pstmt.setString(4, content);
			pstmt.setString(5, imageFileName);
			pstmt.setString(6, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println("BoardDAO에서 insertNewArticle 중 오류");
			e.printStackTrace();
		}
		
		return articleNO;
	}

	public ArticleVO selectArticle(int articleNO) {
		ArticleVO article = new ArticleVO();
		try {
			conn = dataFactory.getConnection();
			
			// 전달받은 글 번호를 이용해 글 번호를 조회
			String query = "select articleNO,parentNO,title,content, NVL(imageFileName, 'null') as imageFileName,id, writeDate" + " from t_board"
					+ " where articleNO=?";
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  articleNO);
			ResultSet rs= pstmt.executeQuery();
			rs.next();
			
			int _articleNO = rs.getInt("articleNO");
			int parentNO = rs.getInt("parentNO");
			String title = rs.getString("title");
			String content = rs.getString("content");
			String imageFileName = URLEncoder.encode(rs.getString("imageFileName"), "UTF-8"); //파일이름에 특수문자가 있을 경우 인코딩합니다.
			if(imageFileName.equals("null")) {
				imageFileName = null;
			}
			
			String id =rs.getString("id");
			Date writeDate = rs.getDate("writeDate");
			
			article.setArticleNO(_articleNO);
			article.setParentNO(parentNO);
			article.setTitle(title);
			article.setContent(content);
			article.setImageFileName(imageFileName);
			article.setId(id);
			article.setWriteDate(writeDate);
			
			
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("BoardDAO에서 selectArticle 중 오류");
			e.printStackTrace();
		}
		return article;
	}

	public void updateArticle(ArticleVO article) {
		int articleNO = article.getArticleNO();
		String title = article.getTitle();
		String content = article.getContent();
		String imageFileName = article.getImageFileName();
		try {
			conn = dataFactory.getConnection();
			String query = "UPDATE t_board SET TITLE=?, CONTENT=?";
			if (imageFileName != null && imageFileName.length() != 0 ) {
				query += ", imageFileName =?";
			} else {
				query += " where articleNO = ?";
			}
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			
			if(imageFileName != null && imageFileName.length() != 0) {
				pstmt.setString(3, imageFileName);
				pstmt.setInt(4, articleNO);
			} else {
				pstmt.setInt(3, articleNO);
			}
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println("BoardDAO에서 updateArticle 중 오류");
			e.printStackTrace();
		}
	}

	public void deleteArticle(int  articleNO) {
		try {
			conn = dataFactory.getConnection();
			String query = "DELETE FROM t_board ";
			query += " WHERE articleNO in (";
			query += "  SELECT articleNO FROM  t_board ";
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR  articleNO = parentNO )";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Integer> selectRemovedArticles(int  articleNO) {
		List<Integer> articleNOList = new ArrayList<Integer>();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT articleNO FROM  t_board  ";
			query += " START WITH articleNO = ?";
			query += " CONNECT BY PRIOR  articleNO = parentNO";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNO);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				articleNO = rs.getInt("articleNO");
				articleNOList.add(articleNO);
			}
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleNOList;
	}
	

}

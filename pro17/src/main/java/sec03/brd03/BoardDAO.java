package sec03.brd03;

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
			e.printStackTrace();
		}
	}
	
	public List selectAllArticles() {
		List articlesList = new ArrayList();
		try {
			conn = dataFactory.getConnection();
			String query = "SELECT LEVEL,articleNO,parentNO,title,content,id,writeDate"
					+ " from t_board"
					+ " START with parentNO=0"
					+ " CONNECT BY PRIOR articleNO=parentNO"
					+ " ORDER SIBLINGS BY articleNO desc";
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
			e.printStackTrace();
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
			String imageFileName = article.getImageFileName();
			String id = article.getId();
			String query = "INSERT INTO t_board (articleNO, parentNO, title, content, imageFileName, id) VALUES (?, ?, ?, ?, ?, ?)";
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

}

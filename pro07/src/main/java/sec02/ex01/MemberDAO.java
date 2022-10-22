// DataSource로 연동해 회원 정보 조회 실습
package sec02.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	/*
	 * private static final String driver = "oracle.jdbc.driver.OracleDriver";
	 * private static final String url = "jdbc:oracle:thin:@localhost:1521:XE";
	 * private static final String user = "scott"; private static final String pwd =
	 * "tiger";
	 */
	private Connection con;
	private PreparedStatement pstmt;		// 다른 부분
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			System.out.println("데이터소스르르 받아오는 중 에러 발생(MemberDAO)");
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		try {
			con = dataFactory.getConnection();	// DataSource를 이용해 데이터 베이스에 연결
			String query= "select * from t_member";
			System.out.println("preparedStatement: " + query);
			pstmt = con.prepareStatement(query);	// SQL문을 전달해서 PreparedStatement 객체를 생성
			ResultSet rs = pstmt.executeQuery(query);	// 미리 설정한 SQL 문을 실행
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/*
	 * private void connDB() { try { Class.forName(driver);
	 * System.out.println("Oracle 드라이버 로딩 성공"); con =
	 * DriverManager.getConnection(url, user, pwd);
	 * System.out.println("Connection 생성 성공"); } catch (Exception e) {
	 * e.printStackTrace(); } }
	 */
}

package test0623_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Point {
	// Point 클래스 정의
	// 1. Point 읽어온다
	// 2. Point 적립한다.
	// 3. Point 사용한다.
	// 파라미터로 currentId를 받아온다. 


	int readPoint(String currentId) {
		int havePoint = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");


			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";


			conn= DriverManager.getConnection(jdbcUrl, user, pw);
			String readPoint = "select point from member where id = ?";
			pstmt= conn.prepareStatement(readPoint);

			pstmt.setString(1, currentId);
			rs = pstmt.executeQuery();


			while(rs.next()) {
				havePoint = rs.getInt("point");

			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}







		return havePoint;
	}







}

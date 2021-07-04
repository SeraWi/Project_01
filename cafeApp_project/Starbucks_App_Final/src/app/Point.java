package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Point {
	
/*	 Point 클래스 정의
	 공통: 파라미터로 currentId=회원아이디를 받아서 조회하고, 수정한다)
	 1. int readPoint(String currentId): 고객의 포인트를 int로 반환(회원용, 관리자용)
	 2. void savePoint(String currentId, int expectedPoint): 포인트 적립(회원용)
	 3. void usePoint(String currentId, int totalPrice): 포인트 사용(회원용)
	 4.  void usePoint2(String currentId) : 포인트 사용(회원용)
*/	
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// 1. point 읽어온다. Member DB에서 READ: SELECT
	int readPoint(String currentId) {
		int havePoint = 0;

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
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//System.out.println("현재 사용가능한 포인트: " + havePoint);
		return havePoint;
	}


	// 2.포인트를 적립한다. UPDATE: UPDATE
	// savePoint = 원래 가지고 있는 point +expectedPoint
	void savePoint(String currentId, int expectedPoint) {
		 //포인트를 적립한다. savePoint = 원래 가지고 있는 point +expectedPoint
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			String updatePoint = "update member set point= point + ? where id = ? ";
			pstmt = conn.prepareStatement(updatePoint);
			int result = 0;

			pstmt.setInt(1, expectedPoint);
			pstmt.setString(2, currentId);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("포인트가 "+expectedPoint+"점 적립되었습니다.");
		
	}


	// 3. 포인트를 사용한다. UPDATE: UPDATE
	// 가지고 있는 포인트가 결제 금액 보다 클 때 호출한다.
	// beforePoint >= totalPrice
	 void usePoint(String currentId, int totalPrice) {
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			// Point > toalPrice
			String updatePoint = "update member set point= point - ? where id = ? ";
			pstmt = conn.prepareStatement(updatePoint);
			int result = 0;
			
			
			//point = point -  havePoint 포인트 사용하기! 마이너스 시키기
			pstmt.setInt(1, totalPrice);
			pstmt.setString(2, currentId);

			result = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	// 4. 포인트를 사용한다. UPDATE: UPDATE
	// 가지고 있는 포인트보다 결제 금액이 클때 호출 ->모든 포인트 다쓰고 0이된다. point = 0
	// beforePoint < totalPrice
	 void usePoint2(String currentId) {
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			// Point > toalPrice
			String updatePoint = "update member set point= ? where id = ? ";
			pstmt = conn.prepareStatement(updatePoint);
			int result = 0;
			
			pstmt.setInt(1, 0);
			pstmt.setString(2, currentId);

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

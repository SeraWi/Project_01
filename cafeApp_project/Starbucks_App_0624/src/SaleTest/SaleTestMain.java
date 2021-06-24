package SaleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SaleTestMain {
	public static void main(String[] args) {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
		
		
		System.out.println("테스트 입니다.");
		System.out.println("오늘 판매액을 조회합니다.");
		
		SaleManager_test sm = new SaleManager_test(SaleDao_test.getInstance());
		
		System.out.println("오늘 판매액 : " + sm.totalSalePrice() );
		
		sm.menuSalePrice();
		
		
		
		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			
//			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
//			String user = "hr";
//			String pw = "tiger";
//			
//			
//			conn= DriverManager.getConnection(jdbcUrl, user, pw);
//			stmt = conn.createStatement();
//			
//			String getTotalSalePrice = "select sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8)";
//			
//			 //쿼리 실행하고 결과값 저장하기 ->
//			rs = stmt.executeQuery(getTotalSalePrice);
//			
//			//출력
//			while(rs.next()) {
//				System.out.println("오늘 판매액을 조회합니다.");
//				System.out.println("오늘 판매액 : " + rs.getInt(1));
//			}
//			
//			String getMenuSalePrice = "select sname, count(sname), sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8) group by sname order by sname";
//			
//			rs = stmt.executeQuery(getMenuSalePrice);
//			
//			
//			System.out.println("오늘 메뉴별  판매된 갯수 와 판매액을 조회합니다.");
//			System.out.println("------------------------------------------");
//			System.out.println("메뉴 \t              판매수 \t             판매액 ");
//			
//			while(rs.next()) {
//				if(rs.getString(1).equals("americano") || rs.getString(1).equals("sandwich")) {
//					System.out.println( rs.getString(1) + "\t" + rs.getInt(2) + "\t " + rs.getInt(3) );
//				}else {
//					System.out.println( rs.getString(1) + "\t\t" + rs.getInt(2) + "\t " + rs.getInt(3) );
//				}
//			}
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
	}
}

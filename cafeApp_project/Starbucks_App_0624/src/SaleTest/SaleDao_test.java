package SaleTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import test0624_01.Sale;

public class SaleDao_test {
	
	Statement stmt = null;
	ResultSet rs = null;
	
	private SaleDao_test() {
		
	}
	
	static private SaleDao_test dao = new SaleDao_test();
	
	public static SaleDao_test getInstance() {
		return dao;
	}
	// 오늘 전체 판매액 가져온다.
	int getTotalSalePrice(Connection conn) {
		int totalSalePrice = 0;
		
		try {
			stmt = conn.createStatement();
			
			String sql = "select sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8)";
			
			 //쿼리 실행하고 결과값 저장하기 ->
			rs = stmt.executeQuery(sql);
			
			
			//쿼리에서 totalSalePrice 가져와서 저장하기
			while(rs.next()) {
				totalSalePrice = rs.getInt(1); 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalSalePrice;
	}
	
	// 메뉴 당 판매수 와 판매액을 arrayList로 가져온다
	ArrayList<Menu_test> getMenuSalePrice(Connection conn) {
		ArrayList<Menu_test> list = null;
		
		
		
		try {
			stmt = conn.createStatement();

			String getMenuSalePrice = "select sname, count(sname), sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8) group by sname order by sname";


			//결과 받아오기
			rs = stmt.executeQuery(getMenuSalePrice);
			list = new ArrayList<>();

			//받아온 데이터를 sale 객체로 생성 ->list에 저장
			while(rs.next()) {
				list.add(new Menu_test(rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {


			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		return list;
	}

}

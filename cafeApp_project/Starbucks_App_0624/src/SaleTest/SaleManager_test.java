package SaleTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class SaleManager_test {
	//sale 테이블에서 오늘 총 매출을 조회하는 메소드
	// sale 테이블에서 오늘 메뉴별 판매액을 조회하는 메소드
	//sale 테이블에서 인기 상품 순대로 조회하는 메소드

	SaleDao_test dao;

	SaleManager_test(SaleDao_test dao){
		this.dao = dao;
	}


	
	

	// Connection 객체 생성 
	Connection conn = null;

	// 연결
	String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "tiger";



	int totalSalePrice() {
		int totalSalePrice = 0;

		try {
			conn= DriverManager.getConnection(jdbcUrl, user, pw);

			totalSalePrice= dao.getTotalSalePrice(conn);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return totalSalePrice;
	}


	void menuSalePrice() {
		

		try {
			conn= DriverManager.getConnection(jdbcUrl, user, pw);

			List<Menu_test> list = dao.getMenuSalePrice(conn);
			
			System.out.println("오늘 메뉴별  판매된 갯수 와 판매액을 조회합니다.");
			System.out.println("------------------------------------------");
			System.out.println("메뉴 \t              판매수 \t             판매액 ");
			
			
			
			for(Menu_test menu : list) {
				if(menu.getpName().equals("americano") || menu.getpName().equals("sandwich")) {
					System.out.println(menu.getpName() + "\t" + menu.getpNumSales()+ "\t" + menu.getpSalePrice());
				}else {
					System.out.println(menu.getpName() + "\t\t" + menu.getpNumSales()+ "\t" + menu.getpSalePrice());
				}
			}
			System.out.println("------------------------------------------");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}



}

package test0623_2;

import java.util.Scanner;

public class SaleMain {
	public static void main(String[] args) {
		
		SaleManager manager = new SaleManager(SaleDao.getInstance());
		Scanner scanner = new Scanner(System.in);
		
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			System.out.println("관리자가 판매 테이블을 조회합니다. ");
			
			manager.saleList();
			
			manager.order();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
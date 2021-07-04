package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {
		
/*		 AppMain
		 정의: 가장 메인화면을 보여준다
		 로그인과 회원가입을 할 수 있고 로그인시 관리자 아이디로 확인될 경우 관리자 모드 페이지로 이동한다.
		 관리자가 아닐 경우 고객 페이지로 이동한다. 
*/
		
		MemberManager memberManager = new MemberManager(MemberDao.getInstance());
		MenuManager menuManager = new MenuManager(MenuDao.getInstance());
		SaleManager saleManager = new SaleManager(SaleDao.getInstance(), MenuDao.getInstance());
		AdminPage adminPage = new AdminPage();
		MemberPage memeberPage = new MemberPage();
		Login login = new Login(MemberDao.getInstance());
		Point point = new Point();
		Scanner sc = new Scanner(System.in);

		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			while (true) {
				System.out.println();
				System.out.println("\t           스타벅스");
				System.out.println("\t***************  ");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println("\t   1. 회원가입");
				System.out.println("\t   2. 로그인");
				System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
				System.out.println();
				int num = Integer.parseInt(sc.nextLine().trim());
				switch (num) {
				case 1:
					memberManager.memAdd();
				case 2:				
					if (!login.chkLogin()) {
						continue;
					}
					if (login.currentId.equals("admin")) {
						adminPage.mainOpen();
					}
					memeberPage.memberPage();
					continue;
				default:
					System.out.println("잘못 선택하셨습니다.");
					continue;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

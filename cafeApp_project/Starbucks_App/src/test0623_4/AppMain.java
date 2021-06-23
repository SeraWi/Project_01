package test0623_4;

import java.util.Scanner;

public class AppMain {
	
	
	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager_edit saleManager = new SaleManager_edit(SaleDao.getInstance());
	static Point pManager = new Point();
	
	
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);

		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("로그인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 관리자모드");
			int num = Integer.parseInt(sc.nextLine().trim());
			switch (num) {
			case 1:
				memManager.memAdd();
				break;
			case 2:			
				memManager.chkLogin();
				break;
			case 3: 
				System.out.println("관리자 모든 입니다.");
				System.out.println("1. 전체 회원 보기");
				System.out.println("2. 전체 회원 보기");
				System.out.println("3. 전체 회원 보기");
				
				
				
			default :
				System.out.println("잘못 눌렀습니다.");
			}

			while (true) {
				System.out.println("1. 주문하기");
				System.out.println("2. 포인트확인");
				System.out.println("3. 내 정보 확인");
				num = Integer.parseInt(sc.nextLine().trim());

				switch (num) {
				case 1:
					// saleManager.order() -> point 수정 한다. 
					saleManager.order(memManager.currentId); 
				
					break;
				case 2:
					int havePoint = pManager.readPoint(memManager.currentId);
					System.out.println("현재 사용가능한 포인트 : " +havePoint);//Point인스턴스에서 readPoint 사용하기
					break;
				case 3:
					memManager.myInfo();
					System.out.println("1. 정보수정");
					System.out.println("2. 회원탈퇴");
					num = Integer.parseInt(sc.nextLine().trim());
					switch (num) {
					case 1:
						memManager.memEdit();
						break;
					case 2:
						memManager.memDel();
						return;				
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
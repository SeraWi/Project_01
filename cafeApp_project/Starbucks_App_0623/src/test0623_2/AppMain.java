package test0623_2;

import java.util.Scanner;

public class AppMain {
	
	
	static MemberManager memManager = new MemberManager(MemberDao.getInstance());
	static SaleManager saleManager = new SaleManager(SaleDao.getInstance());
	
	static String currentId;
	
	
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
				currentId = memManager.chkLogin(); // 로그인한후 id를 static 변수로 저장
				
				break;
			case 2:			
				memManager.chkLogin();
				break;
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
					saleManager.order(); //주문하기 -> 예상결제금액, 예상 적립 포인트 보여주기
					memManager.memPoint(); // 현재 가지고 있는 포인트 보여주기
					// 포인트 사용 하기
					break;
				case 2:
					memManager.memPoint();
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
package test02;

import java.util.Scanner;

public class MemberPage {

	MemberManager memberManager = new MemberManager(MemberDao.getInstance());
	SaleManager saleManager = new SaleManager(SaleDao.getInstance(), MenuDao.getInstance());
	Login login = new Login(MemberDao.getInstance());
	Point point = new Point();
	Scanner sc = new Scanner(System.in);

	void memberPage() {

		while (true) {
			System.out.println(login.currentId + "님 환영합니다.");
			System.out.println("현재 적립 포인트 " + point.readPoint(login.currentId) + "점");
			System.out.println("1. 주문하기");
			System.out.println("2. 포인트 확인");
			System.out.println("3. 내 정보 확인");
			System.out.println("4. 로그아웃");
			int num3 = Integer.parseInt(sc.nextLine().trim());

			switch (num3) {
			case 1:
				saleManager.order(login.currentId);
				saleManager.pay(login.currentId);
				continue;
			case 2:
				System.out.println("현재 사용가능한 포인트 : " +point.readPoint(login.currentId));
				break;
			case 3:
				memberManager.myInfo(login.currentId);
				System.out.println("1. 정보수정");
				System.out.println("2. 회원탈퇴");
				System.out.println("3. 이전 메뉴");
				num3 = Integer.parseInt(sc.nextLine().trim());
				switch (num3) {
				case 1:
					memberManager.memEdit(login.currentId);
					continue;
				case 2:
					memberManager.memDel(login.currentId);
					continue;
				case 3:
					continue;
				}
			case 4:
				login.logout();
				return;
			}
		}
	}
}

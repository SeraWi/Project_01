package test0624_02;

import java.util.Scanner;

public class AdminPage {

	Scanner sc = new Scanner(System.in);
	MemberManager memManager = new MemberManager(MemberDao.getInstance());
	SaleManager saleManager = new SaleManager(SaleDao.getInstance());

	void calling() {
		System.out.println("관리자  모드 입니다.");
		System.out.println("1. 회원 정보 보기");
		System.out.println("2. 판매 정보 보기");
		System.out.println("3. 메뉴 정보 보기");


		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1:
			memManager.memList();
			break;
		case 2:
			//			saleManager.saleList();
			//			break;
			// 2. 판매 정보 보기
			//      1. 판매 전체 리스트 보기
			//		2. 오늘 총판맥






		case 3:

			break;
		}
	}

}
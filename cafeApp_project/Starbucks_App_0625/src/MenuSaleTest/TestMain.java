package MenuSaleTest;

public class TestMain {
	public static void main(String[] args) {
		SaleManager sm = new SaleManager(SaleDao.getInstance());
		
		//sm.menuSalePrice();
		System.out.println("테스트 성공");
		
//		--------------------------------------
		
		//Sale DB에 insert할 때 현재 아이디 받아서 저장하기
		// ->고객별 판매액, 판매수 확인 가능
		
		
		sm.saleList();
		//sm.order("sera1");
		
		
		
		
	}
}

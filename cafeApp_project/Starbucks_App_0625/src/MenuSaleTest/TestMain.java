package MenuSaleTest;

public class TestMain {
	public static void main(String[] args) {
		SaleManager sm = new SaleManager(SaleDao.getInstance());
		
		sm.menuSalePrice();
		System.out.println("테스트 성공");
	}
}

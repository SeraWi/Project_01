package test0624_01;

public class AppMain_test {
	public static void main(String[] args) {
		SaleManager sm = new SaleManager(SaleDao.getInstance());
		
		int totalSalePrice = sm.totalSalePrice();
		
		System.out.println(" 오늘 총 판매액은 " +totalSalePrice);
		
		sm.menuSalePrice();
		
		
	}
}

package saleManager_test;

public class testMain {
	public static void main(String[] args) {
		SaleManager sm = new SaleManager(SaleDao.getInstance());
		
		
		sm.order("park1234");
		
		
		//sm.saleList();
		
		
	}
}

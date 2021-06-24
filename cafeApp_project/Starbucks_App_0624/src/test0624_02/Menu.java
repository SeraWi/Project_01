package test0624_02;

public class Menu {

	private int menuCode;
	private String mname;
	private int price;

	public Menu(int menuCode, String mname, int price) {
		this.menuCode = menuCode;
		this.mname = mname;
		this.price = price;
	}
	
	public Menu(String mname, int price) {
		this.mname = mname;
		this.price = price;
	}
	
	
	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", mname=" + mname + ", price=" + price + "]";
	}


}

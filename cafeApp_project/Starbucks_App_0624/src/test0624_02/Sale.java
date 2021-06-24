package test0624_02;

public class Sale {
	//판매 된 데이터 저장 하기 위해

	private int salecode;
	private String sname;
	private int price;
	private String saledate;
	private int count; 
	
	
	public Sale(int salecode, String sname, int price, String saledate) {
		this. salecode = salecode;
		this.sname = sname;
		this.price= price;
		this.saledate = saledate;
	}
	
	
	//생성자 오버로딩 2 ->SaleDB에 저장하게 될 때 사용자
	public Sale(String sname, int price) { 
		this.sname = sname;
		this.price= price;
	}
	// 생성자 오버로딩 3 -> saleBestManager에 쓸 수 있는 생성자
	
	public Sale( int count, String sname) {
		this.sname = sname;
		this.count = count;
	}
	
	//Getter, Setter
	public int getSalecode() {
		return salecode;
	}

	public void setSalecode(int salecode) {
		this.salecode = salecode;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSaledate() {
		return saledate;
	}

	public void setSaledate(String saledate) {
		this.saledate = saledate;
	}
	
	// 추가
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
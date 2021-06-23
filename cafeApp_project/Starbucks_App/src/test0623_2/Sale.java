package test0623_2;

public class Sale {
	//메뉴 세팅하고 ->DB에 저장
	
	//new Sale( )
	

	
	private int salecode;
	private String sname;
	private int price;
	private String saledate;
			
	public Sale(int salecode, String sname, int price, String saledate) {
		this. salecode = salecode;
		this.sname = sname;
		this.price= price;
		this.saledate = saledate;
	}
	
	//생성자 오버로딩
	public Sale(int salecode, String sname, int price) {
		this. salecode = salecode;
		this.sname = sname;
		this.price= price;
	}
	
	//생성자 오버로딩 2
	public Sale(String sname, int price) { 
		this.sname = sname;
		this.price= price;
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
	
	

	
	
}
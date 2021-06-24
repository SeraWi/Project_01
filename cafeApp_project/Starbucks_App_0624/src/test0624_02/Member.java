package test0624_02;

public class Member {

	private int memcode;
	private String name;
	private String id;
	private String pw;
	private String address;
	private String phone;
	private double point;

	public Member(int memcode, String name, String id, String pw, String address, String phone, double point) {
		super();
		this.memcode = memcode;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
		this.point = point;
	}
	
	public Member(String name, String id, String pw, String address, String phone) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public Member(String name, String pw, String address, String phone) {
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	public Member(String id) {
		this.id = id;
	}
	

	public int getMemcode() {
		return memcode;
	}

	public void setMemcode(int memcode) {
		this.memcode = memcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}



	@Override
	public String toString() {
		return "Member [memcode=" + memcode + ", name=" + name + ", id=" + id + ", pw=" + pw + ", address=" + address
				+ ", phone=" + phone + ", point=" + point + "]";
	}

}

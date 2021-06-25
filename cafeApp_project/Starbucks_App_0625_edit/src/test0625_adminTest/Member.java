package test0625_adminTest;

public class Member {

	private int memcode;
	private String name;
	private String id;
	private String pw;
	private String address;
	private String phone;
	private int point;

	// 생성자 1 : 관리자가 회원정보 확인할 때 사용
	public Member(int memcode, String name, String id, String pw, String address, String phone, int point) {
		super();
		this.memcode = memcode;
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
		this.point = point;
	}
	// 생성자 2: 회원이 자신의 정보 확인할 때 사용
	public Member(String name, String id, String pw, String address, String phone) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	// 생성자 3 : 회원이 자신의 정보 수젇할 때 사용
	public Member(String name, String pw, String address, String phone) {
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.phone = phone;
	}
	
	// 생성자 4: 아이디 체크
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}



	@Override
	public String toString() {
		return "Member [memcode=" + memcode + ", name=" + name + ", id=" + id + ", pw=" + pw + ", address=" + address
				+ ", phone=" + phone + ", point=" + point + "]";
	}

}

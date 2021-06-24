package test0624_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	private MemberDao dao;
	private Scanner sc;
	public static String currentId;

	public Login(MemberDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
	}

	void chkLogin() {
		
		// 객체 생성
		Connection con = null;

		// 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		ArrayList<Member> mem = new ArrayList<>();
		HashMap<String, String> map = new HashMap<>();

		try {
			con = DriverManager.getConnection(jdbcUrl, user, pw);
			mem = dao.getList(con);
			for (int i = 0; i < mem.size(); i++) {
				map.put(mem.get(i).getId(), mem.get(i).getPw());
			}
			while (true) {
				System.out.println("아이디와 비밀번호를 입력합니다.");
				System.out.print("아이디를 입력하세요 > ");
				currentId = sc.nextLine().trim();
				System.out.print("비밀번호를 입력하세요 > ");
				String password = sc.nextLine().trim();
				System.out.println();

				if (!map.containsKey(currentId)) {
					System.out.println("입력하신 아이디는 존재하지 않습니다. 다시 입력하세요.");
					continue;
				} else {
					if (!(map.get(currentId)).equals(password)) {
						System.out.println("비밀번호가 일치하지 않습니다. 다시 입력하세요.");
					} else {
						System.out.println("로그인하셨습니다.");
						break;
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
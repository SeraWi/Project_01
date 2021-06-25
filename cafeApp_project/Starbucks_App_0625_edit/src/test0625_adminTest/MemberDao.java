package test0625_adminTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDao {

	private PreparedStatement pstmt = null;
	
	private MemberDao() {}
	
	static private MemberDao dao = new MemberDao();
	
	public static MemberDao getInstance()	{
		return dao;
	}
	
	// 1. 전체 데이터 출력 : 관리자가 회원의 전체 데이트 출력
	ArrayList<Member> getList(Connection con){
		
		ArrayList<Member> list = null;
		ResultSet rs = null;
			
		try {
			// sql문
			String sql = "select * from member order by memcode";
			pstmt = con.prepareStatement(sql);
			// 결과 받아오기
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<>();
					
			// 리스트 저장
			while(rs.next()) {
				Member mem = new Member(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getString(6),
										rs.getInt(7));
				list.add(mem);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 2. 회원이 내 정보 확인 (회원 테이블에서 특정 아이디 값을 찾아서 가져온다)
	ArrayList<Member> getList(Connection con, String currentId){
		
		ArrayList<Member> list = null;
		ResultSet rs = null;
			
		try {
			// sql문
			String sql = "select * from member where id = " + "'" + currentId + "'";
			pstmt = con.prepareStatement(sql);
			// 결과 받아오기
			rs = pstmt.executeQuery(sql);
			
			list = new ArrayList<>();
					
			// 리스트 저장
			while(rs.next()) {
				Member mem = new Member(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getString(6),
										rs.getInt(7));
				list.add(mem);
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 3. 회원가입-> 회원 테이블에 insert
	int insertMem(Connection con, Member mem) {
		
		int result = 0;

		try {
			String sql = "insert into member (memcode, name, id, pw, address, phone) values (member_sq.nextval, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getId());
			pstmt.setString(3, mem.getPw());
			pstmt.setString(4, mem.getAddress());
			pstmt.setString(5, mem.getPhone());
			
			result = pstmt.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;						
	}
	
	// 4. 회원 정보 수정 -> 회원 테이블 update
	int editMem(Connection con, Member mem, String currentId) {
		
		int result = 0;		

		try {
			// 로그인 아이디를 where절 사용
			String sql = "update member set name = ?, pw =?, address = ?, phone = ? where id = " +"'"+currentId+"'";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getPw());
			pstmt.setString(3, mem.getAddress());
			pstmt.setString(4, mem.getPhone());
			
			result = pstmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	
	// 5. 회원 탈퇴 -> 회원 테이블 Delete
	int deleteMem(Connection con, String currentId) {
		
		int result = 0;
	
		try {
			String sql = "delete from member where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, currentId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {	
			close();
		}
		return result;				
	}
	
	void close() {
		if(pstmt != null) {
			try {
				pstmt.close();
				pstmt = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
package app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class SaleDao {
	
/*	 SaleDao class
	 정의 : sale table(DB)을 관리한다. (CRUD)
	 싱글톤 패턴
	 1. ArrayList <Sale> getSaleList(Connection conn): Sale DB에서 전체 정보를 가져온다(관리자용)
	 2. int insertSale(Connection conn, ArrayList<Sale> list, String currentid) : 회원이 메뉴 구매시 Sale DB에 저장한다.(관리자용)
	 3. int getTotalSalePrice(Connection conn): 당일 총 판매액 조회한다.(관리자용)
	 4. ArrayList<Sale> getMenuSalePrice(Connection conn) : 당일 메뉴당 판매수와 판매액을 조회한다. (관리자용)
	 5. ArrayList<Sale> getSaleBestList(Connection conn) : 당일 인기상품을 조회한다(관리자용)
*/
	
	// 싱글톤 패턴
	private SaleDao() {}
	static private SaleDao dao = new SaleDao();
	public static SaleDao getInstance() {
		return dao;
	}

	private PreparedStatement pstmt = null;
	private Statement stmt = null;
	private ResultSet rs = null;


	// 1.관리자가 전체 데이터 확인가능하도록 sale table 가져온다  READ : SELECT
	ArrayList <Sale> getSaleList(Connection conn){
		ArrayList<Sale> list = null;

		//데이터 베이스의 Sale테이블에서 select한 결과를  ->list에 저장한다.
		try {
			stmt = conn.createStatement();

			String sql = "select * from sale order by salecode";

			//결과 받아오기
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();

			//받아온 데이터를 sale 객체로 생성 ->list에 저장
			while(rs.next()) {
				list.add(new Sale(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {


			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	// 2. 회원이 산 메뉴를 판매 DB에 저장한다. CREATE : INSERT
	int insertSale(Connection conn, ArrayList<Sale> list, String currentid) {//sale 어레이 리스트 전달받기
		int result = 0 ;


		String sql = "insert into sale (salecode, sname, price, id, count) "
				+ "values(sale_sq.nextval, ?, ?, ?, ?)";


		try {

			pstmt= conn.prepareStatement(sql);
			for(int i = 0; i <list.size(); i++) {

				pstmt.setString(1,list.get(i).getSname());
				pstmt.setInt(2, list.get(i).getPrice());
				pstmt.setString(3, currentid);
				pstmt.setInt(4, list.get(i).getScount());
				result = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		return result;
	}

	// 3. Sale DB에서 Sum(Price) = 전체 판매액 가져 온다. Read: SELECT
	int getTotalSalePrice(Connection conn) {
		int totalSalePrice = 0;
		try {
			stmt = conn.createStatement();

			String sql = "select sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8)";

			//쿼리 실행하고 결과값 저장하기 ->
			rs = stmt.executeQuery(sql);

			//쿼리에서 totalSalePrice 가져와서 저장하기
			while(rs.next()) {
				totalSalePrice = rs.getInt(1); 
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return totalSalePrice;
	}


	// 4. Sale DB에서 메뉴당 판매수와 판매액을 가져온다. READ : SELECT 
	//   메뉴이름, 갯수, 판매액으로 sale객체에 저장한다.
	ArrayList<Sale> getMenuSalePrice(Connection conn) {
		ArrayList<Sale> list = null;

		try {
			stmt = conn.createStatement();

			String getMenuSalePrice = "select sname, count(sname), sum(price) from sale where substr(saledate,1,8) = substr(sysdate,1,8) group by sname order by sname";

			//결과 받아오기
			rs = stmt.executeQuery(getMenuSalePrice);
			list = new ArrayList<>();

			//받아온 데이터를 sale 객체로 생성 ->list에 저장
			while(rs.next()) {
				list.add(new Sale(rs.getString(1), rs.getInt(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {


			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	
	// 5. Sale DB에서 인기 상품을 가져온다 READ: SELECT
	ArrayList<Sale> getSaleBestList(Connection conn){
		ArrayList<Sale> list = null;

		try {
			stmt = conn.createStatement();
			String sql = "select  sname, count from (select distinct sname, count(sname) as count"
					+ " from sale group by sname order by count desc ) where rownum < 4";
			
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			while(rs.next()) {
				list.add(new Sale( rs.getInt(2), rs.getString(1)));
			}
					
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return list;
		
	}
	
}

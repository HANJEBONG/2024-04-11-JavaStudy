package com.sist.cal;
/*
 *     1366 * 768
 *     
 */
import java.util.*;
import java.sql.*;
// LIKE 활용
import java.text.*;
public class FindDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static FindDAO dao; // 싱글턴
	
	// 1. 드라이버 등록
			public FindDAO() {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				}catch(Exception ex) {}
			}
			// 2. 오라클 연결
			public void getConnection() {
				try {
					conn=DriverManager.getConnection(URL,"hr","happy");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			// 3. 오라클 해제
			public void disConnection() {
				try {
					if(ps!=null) {
						ps.close();
					}
					if(conn!=null) {
						conn.close();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			public static FindDAO newInstance() { // static을 활용해서
				if(dao==null) {
					dao=new FindDAO();
				}
				return dao; // null이 아니면 기존에 저장된 dao를 사용
			}
			// 4. 싱글턴 => 한사람당 한개의 DAO만 사용할 수 있게 만든다 => 메모리 누수현상을 제거
	public ArrayList<FindVO> schduleFindListData(String userid, String findinfo) {
		ArrayList<FindVO> list=new ArrayList<FindVO>();
		try {
			getConnection();
			String sql="SELECT schdule,date " // 저장된 일정과 날짜 컬럼명
					 + "FROM schdule " // 데이터를 가져올 테이블
					 + "WHERE schdule LIKE '%"+findinfo+"%'" // 검색어
					 + "AND userid=?"
					 + "ORDER BY date ASC"; // 로그인한 유저만의 데이터
			ps=conn.prepareStatement(sql); 
			ps.setString(1, userid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				FindVO vo=new FindVO();
				vo.setSch(rs.getString(1));
				vo.setDate(rs.getDate(2));
				list.add(vo);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}

package com.sist.cal;
/*
 *     1366 * 768
 *     
 */
import java.util.*;
import java.sql.*;
// LIKE 활용
public class FindDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static FindDAO dao; // 싱글턴
	
	// 1. 드라이버 등록
			public FindDAO() {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			// 2. 오라클 연결
			public void getConnection() {
				try {
					conn=DriverManager.getConnection(URL,"hr","happy");
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
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
					e.printStackTrace();
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
	public ArrayList<FindVO> schduleFindListData(String userid, String findInfo) {
		ArrayList<FindVO> list=new ArrayList<FindVO>();
		try {
			getConnection();
			String sql="SELECT schdule,schdate,TO_CHAR(schdate,'DY') " // 일정, 날짜 , 요일
					+ "FROM schdule "
					+ "WHERE schdule LIKE '%'||?||'%' " // 검색어
					+ "AND userid=? ";// 로그인한 유저 id
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, findInfo);
			ps.setString(2, userid);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				FindVO vo=new FindVO();
				vo.setSchtitle(rs.getString(1));
				vo.setDate(rs.getDate(2));
				vo.setWeek(rs.getString(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
//	 public String dateWeekData(int year,int month,int date) {
//			Calendar cal=Calendar.getInstance();
//			cal.set(year, month-1, date);
//			int week=cal.get(Calendar.DAY_OF_WEEK);
//			String weekInfo="";
//			switch(week) {
//			case 1:
//				weekInfo="일";
//				break;
//			case 2:
//				weekInfo="월";
//				break;
//			case 3:
//				weekInfo="화";
//				break;
//			case 4:
//				weekInfo="수";
//				break;
//			case 5:
//				weekInfo="목";
//				break;
//			case 6:
//				weekInfo="금";
//				break;
//			case 7:
//				weekInfo="토";
//				break;
//			}
//			return weekInfo;
//					
//		}
}

package com.sist.dao;
import java.util.*;
import java.sql.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@192.168.10.124:1521:XE";
	private static FoodDAO dao;
	// 1. 드라이버 등록 : 한번만 수행 (생성자) => 멤버변수의 초기화
	public FoodDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 2. 오라클 연결 => SQL 문장 => 재사용
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr1","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 3. 오라클 해제
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 4. 싱글턴
	public static FoodDAO newInstance() {
		if(dao==null) {
			dao=new FoodDAO();
		}
		return dao;
	}
	public int foodTotalPage() {
		int total=0;
		try {
			// 1. 연결
			getConnection();
			// 2. SQL 문장
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM FOOD_MENU_HOUSE";
			// 오라클로 전송
			ps=conn.prepareStatement(sql);
			// 4. sql문장 실행 결과를 가지고 온다 => 실행 결과를 저장 (ResultSet)
			ResultSet rs=ps.executeQuery();
			// 5. 커서위치를 데이터가 출력된 첫번째 위치로 변경
			rs.next();
			total=rs.getInt(1);
			// 6. 메모리를 닫는다
			// 쉬운 프로그램은 모든 개발자가 동일한 코딩 (표준화) => 패턴이 한개
			// -------- 라이브러리 (MyBatis) => Spring
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}
	public ArrayList<FoodVO> foodScoreListData(int page){
		ArrayList<FoodVO> list=new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="SELECT name,poster,type,score,num,address "
					 + "FROM (SELECT name,poster,type,score,rownum as num,address "
					 + "FROM (SELECT name,poster,type,score,address "
					 + "FROM food_menu_house "
					 + "ORDER BY score DESC)) "
					 + "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setName(rs.getString(1));
				vo.setPoster(rs.getString(2));
				vo.setType(rs.getString(3));
				vo.setScore(rs.getDouble(4));
				vo.setNo(rs.getInt(5));
				vo.setAddress(rs.getString(6));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}

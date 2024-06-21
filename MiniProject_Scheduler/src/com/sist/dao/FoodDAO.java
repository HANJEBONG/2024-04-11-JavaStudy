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
	public int findFoodTotalPage(String find) {
		int total=0;
		try {
			// 1. 연결
			getConnection();
			// 2. SQL 문장
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM FOOD_MENU_HOUSE "
					+ "WHERE theme LIKE '%"+find+"%'";
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
			String sql="SELECT name,poster,type,score,num,address,fno "
					 + "FROM (SELECT name,poster,type,score,rownum as num,address,fno "
					 + "FROM (SELECT name,poster,type,score,address,fno "
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
				vo.setFno(rs.getInt(7));
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
	public ArrayList<FoodVO> foodThemaListData(int page,String thema){
		ArrayList<FoodVO> list=new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="SELECT name,poster,type,num,address,fno,theme "
					 + "FROM (SELECT name,poster,type,score,address,fno,theme,rownum as num "
					 + "FROM (SELECT name,poster,type,score,address,fno,theme "
					 + "FROM food_menu_house WHERE theme LIKE '%"+thema+"%')) "
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
				vo.setAddress(rs.getString(5));
				vo.setFno(rs.getInt(6));
				vo.setTheme(rs.getString(7));

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
	public int findTotalPage(String find) {
		int total=0;
		try {
			// 1. 연결
			getConnection();
			// 2. SQL 문장
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM FOOD_MENU_HOUSE "
					+ "WHERE address LIKE '%"+find+"%' "
					+ "OR name LIKE '%"+find+"%'";
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
	public List<FoodVO> foodFindData(int page, String find){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="SELECT name,poster,type,num,address,fno,theme "
					+ "FROM (SELECT name,poster,type,score,address,fno,theme,rownum as num "
					 + "FROM (SELECT name,poster,type,score,address,fno,theme "
					 + "FROM food_menu_house WHERE address LIKE '%"+find+"%' "
					 + "OR name LIKE '%"+find+"%')) "
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
				vo.setNo(rs.getInt(4));
				vo.setAddress(rs.getString(5));
				vo.setFno(rs.getInt(6));
				vo.setTheme(rs.getString(7));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnection();
		}
		return list;
	}
	 public FoodVO foodDetailData(int fno) {
	      FoodVO vo = new FoodVO();
	      try {
	         getConnection();
	         // 조회수 증가
	         String sql = "SELECT fno, poster, type, name, score, theme, price, time, phone, address, link "
	                   + "FROM food_menu_house WHERE fno=?";
	         ps = conn.prepareStatement(sql);
	         // ?에 값을 채운다
	           ps.setInt(1, fno);

	         // 결과값
	         ResultSet rs = ps.executeQuery();
	         rs.next();
	         // 값을 VO에 저장
	         vo.setFno(rs.getInt(1));
	         vo.setPoster(rs.getString(2));
	         vo.setType(rs.getString(3));
	         vo.setName(rs.getString(4));
	         vo.setScore(rs.getDouble(5));
	         vo.setTheme(rs.getString(6));
	         vo.setPrice(rs.getString(7));
	         vo.setTime(rs.getString(8));
	         vo.setPhone(rs.getString(9));
	         vo.setAddress(rs.getString(10));
	         vo.setLink(rs.getString(11));
	         
	         rs.close();

	      } catch (Exception ex) {
	         ex.printStackTrace();
	      } finally {
	         disConnection();
	      }
	      return vo;
	   }
}
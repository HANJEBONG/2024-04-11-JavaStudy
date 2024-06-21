package com.sist.dao;
import java.util.*;
import javax.naming.spi.DirStateFactory.Result;
import java.sql.*;
public class CalendarDAO {
	private Connection conn; // Socket
	private PreparedStatement ps;
	private final String URL = "jdbc:oracle:thin:@192.168.10.124:1521:XE";
	private static CalendarDAO dao;
	
	public CalendarDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	
	// 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr1","happy");
			
		}catch(Exception ex) {}
	}
	
	// 오라클 닫기
	public void disConnection()	{
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex) {}
	}
	
	// 싱글턴
	public static CalendarDAO newInstance() {
		if(dao==null) 
			dao = new CalendarDAO();
		return dao;
	}
	public List<CalendarVO> calendarListData(int page){
		List<CalendarVO> list = new ArrayList<CalendarVO>();
		try {
			getConnection();
			String sql = "SELECT title, place, day, content, userId, num , no "
					+"FROM (SELECT title, place, day, content, userId, rownum as num, no "
					+"FROM (SELECT title, place, day, content, userId , no "
					+"FROM schedule ORDER BY no DESC))"
					+"WHERE num BETWEEN ? AND ?";
			
			ps = conn.prepareStatement(sql);
			
			int rowSize = 10;
			int start = (rowSize*page)-(rowSize-1);
			int end = rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				CalendarVO vo = new CalendarVO();
				vo.setTitle(rs.getString(1));
				vo.setPlace(rs.getString(2));
				vo.setDay(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setUserId(rs.getString(5));
				vo.setNo(rs.getInt(7));
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
	public int CalendarTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*) / 10.0) FROM schedule ";
			ps = conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total = rs.getInt(1);
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return total;
	}
	
	public void calendarInsert(CalendarVO vo){
		
		try {
			// 1. 연결
			getConnection();
			/*
			 * TITLE VARCHAR2(4000)
			 PLACE   VARCHAR2(4000)
			 DAY     DATE
			 CONTENT  VARCHAR2(4000)
			 USERID  NOT NULL VARCHAR2(4000)
			 */
			// 2. 오라클로 보낼 SQL 문장
			String sql = "INSERT INTO schedule(title, place, day, content, userId , no) "
					+ "VALUES(?,?,?,?,?,(SELECT MAX(no)+1 FROM schedule)) ";
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getPlace());
			ps.setString(3,vo.getDay());
			ps.setString(4, vo.getContent());
			ps.setString(5, vo.getUserId());
			ps.executeUpdate();
	
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		
	}
	// 3. 상세보기 기능 -> WHERE => 데이터 읽기 
	public CalendarVO calendarDetailData(int no) {
		CalendarVO vo = new CalendarVO();
		try {
			getConnection();
			/*
			String sql = "UPDATE calendar SET "
					+"WHERE no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			*/
			// 데이터 읽기 
			String sql = "SELECT title, place, day, content, userId , no"
					+"FROM schedule "
					+"WHERE no=? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setTitle(rs.getString(1));
			vo.setPlace(rs.getString(2));
			vo.setDay(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setUserId(rs.getString(5));
			vo.setNo(rs.getInt(6));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	// 4. 수정 -> 비밀번호 체크 => 비밀번호 체크 / 실제 수정 => 묻고 답하기 : SQL(5)
	// 4-1 기존의 데이터 읽기
	public CalendarVO calendarUpdateData(int no) {
		CalendarVO vo = new CalendarVO();
		try {
			getConnection();
			String sql = "SELECT title, place, day, content, userId "
					+"FROM schedule "
					+"WHERE no=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setTitle(rs.getString(1));
			vo.setPlace(rs.getString(2));
			vo.setDay(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setUserId(rs.getString(5));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	
	public void CalendarUpdate(CalendarVO vo) {
		vo = new CalendarVO();
		try {
			getConnection();
			String sql = "UPDATE schedule SET "
					+"title =?, place=?, day=?, content=? "
					+"WHERE no=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getPlace());
			ps.setString(3, vo.getDay());
			ps.setString(4, vo.getContent());
			ps.setInt(5, vo.getNo());
			
			ps.executeUpdate();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
	
	public void calendarDelete(int no) {
		try {
			getConnection();
			String sql = "DELETE FROM schedule "
					+ "WHERE no=? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
	
	}
	
	
	
	
	
}
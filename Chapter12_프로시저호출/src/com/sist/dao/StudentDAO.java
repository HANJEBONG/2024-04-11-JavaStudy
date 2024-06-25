package com.sist.dao;
import java.sql.*;
import java.util.*;
import oracle.jdbc.*;
public class StudentDAO {
	private Connection conn;
	private CallableStatement cs;
	/*
	 *	CallableStatement :  프로시저 호출시에 사용
	 *		= SELECT , INSERT , UPDATE , DELETE => executeQuery() 만 사용
	 *  PrepareStatement 	
	 *  	= executeQurey() => SELECT문장으로 실행 결과값을 가지고 출력 사용
	 *  	= executeUpdate() => 오라클에 있는 데이터 변경 (INSERT , UPDATE , DELETE)
	 */
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static StudentDAO dao;
	
	public StudentDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void disConnection() {
		try {
			if(cs!=null)cs.close();
			if(conn!=null)conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static StudentDAO newInstance() {
		if(dao==null) {
			dao=new StudentDAO();
		}
		return dao;
	}
	// 기능 수행
	/*
       CREATE OR REPLACE PROCEDURE studentAllData(
       pResult OUT SYS_REFCURSOR
       )
       IS
       BEGIN
	   OPEN pResult FOR
       SELECT * FROM student;
       END;

	 */
	public List<StudentVO> studentAllData(){
		List<StudentVO> list=new ArrayList<StudentVO>();
		try {
			getConnection();
			String sql="{CALL studentAllData(?)";
			cs=conn.prepareCall(sql);
			// ? 에 값을 채운다 => IN변수는 기존 동일 , OUT은 저장하는 공간을 지정
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			// 실행 요청
			cs.executeQuery();
			ResultSet rs=(ResultSet)cs.getObject(1);
			while(rs.next()) {
				StudentVO vo=new StudentVO();
				vo.setHakbun(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setKor(rs.getInt(3));
				vo.setEng(rs.getInt(4));
				vo.setMath(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
	public void studentDelete(int hakbun) {
		try {
			getConnection();
			String sql="{CALL studentDelete(?)}";
			cs=conn.prepareCall(sql);
			// ? 에 값을 채운다 => IN변수는 기존 동일 , OUT은 저장하는 공간을 지정
			cs.setInt(1, hakbun);
			// 실행 요청
			cs.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	public void studentInsert(StudentVO vo) {
		try {
			getConnection();
			String sql="{CALL studentinsert(?,?,?,?)}";
			cs=conn.prepareCall(sql);
			// ? 에 값을 채운다 => IN변수는 기존 동일 , OUT은 저장하는 공간을 지정
			cs.setString(1, vo.getName());
			cs.setInt(2, vo.getKor());
			cs.setInt(3, vo.getEng());
			cs.setInt(4, vo.getMath());
			// 실행 요청
			cs.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
	}
	public void studentUpdate(StudentVO vo) {
		try {
			getConnection();
			String sql="{CALL studentUpdate(?,?,?,?,?)}";
			cs=conn.prepareCall(sql);
			cs.setInt(1, vo.getHakbun());
			cs.setString(2, vo.getName());
			cs.setInt(3, vo.getKor());
			cs.setInt(4, vo.getEng());
			cs.setInt(5, vo.getMath());
			
			cs.executeQuery();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
}

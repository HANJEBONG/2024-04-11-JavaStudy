package com.sist.dao;
// => 기능 (오라클 연결 => 사용자 요청에 맞는 데이터를 찾아본다)
import java.util.*; // ArrayList
import java.sql.*; // 오라클 연결하는 라이브러리
/*
 *     데이터베이스 연동
 *     jdbc => dbcp => orm
 *                     ------- MyBatis (SQL문장이 있다 => 반복기능 제거) / JPA(SQL없이 수행)
 *     | 1차    | 2차           | 3차                                  | 개인
 */
public class ZipcodeDAO {
	// 오라클 연결 클래스
	private Connection conn;
	// SQL 전송하는 클래스 (결과값 받기)	
	private PreparedStatement ps;
	// 오라클 연결 => URL (오라클 주소) thin => 연결만 하는 드라이버
	/*
	 *  localhost => 본인 컴퓨터 => IP
	 *  1521:PORT , 1433(MS-SQL) , 3306(MySQL,MariaDB)
	 *  XE : table 이 저장된 데이터베이스 => ORCL/ORA
	 *  -------- 연습용 => 무료
	 */
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록 => 한번만 등록 => 생성자
	public ZipcodeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			// conn hr/happy
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 3. 오라클 연결해제
	public void disConnection() {
		try {
			if(ps!=null) ps.close(); // 통신중단
			if(conn!=null) conn.close(); // conn(전화기)
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// --------------------------------------------------- 공통 사항 => 클래스화 => 라이브러리로 제작 .jar
	// 4. 기능 설정
	// => 우편검색 / 우편번호 검색 갯수
	public ArrayList<ZipcodeVO> postFind(String dong){
		ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			// 오라클 연결 => 값을 읽기
			// 1. 오라클 연결
			getConnection();
			// 2. SQL 문장
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					    +"FROM zipcode "
					    +"WHERE dong LIKE '%'||?||'%'";
						// WHRER dong LIKE CONCAT('%',?,'%') => MyBatis MariaDB
						// NVL => ISNULL
			ps=conn.prepareStatement(sql); // 미리 SQL문장을 전송하고 나중에 값을 채워준다
														// 		-------
			ps.setString(1, dong); // ?에 값을 채워서 실행 요청
			// 오라클에 실행 요청 => 결과값을 메모리에 저장 => ResultSet
			ResultSet rs=ps.executeQuery();
			// 메모리를 실행하다 보면 커서의 위치가 맨 마지막에 있을것 => 처음 줄로 이동시켜야한다 => next()
			while(rs.next()) {
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(); // 에러확인
			// TODO: handle exception
		}finally {
			disConnection(); // 종료
		}
		return list;
	}
}

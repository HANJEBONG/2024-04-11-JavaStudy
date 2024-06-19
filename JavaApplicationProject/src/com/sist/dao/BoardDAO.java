package com.sist.dao;
/*
 *     DQL / DML : 자바에서 수행 ==> DDL,DCL,TCL : 오라클에서 수행
 *                                       ---- 오라클 명령어로 사용하는것이 아니라 메소드로 되어 있다 ( COMMIT , ROLLBACK )
 *                                       | 설정이 없으면 AutoCommit()
 *                                       
 *        => 프로그램 : 데이터 관리
 *        			---------- CRUD (SELECT / INSERT / UPDATE / DELETE ) => 핵심 : 게시판
 *        1. DQL : 데이터 검색 (SELECT)
 *           자바 =====> 오라클
 *               SQL 문장
 *               --------> 오라클 문법에 맞춘다
 *           SELECT
 *           ------
 *             형식) SELECT * | column1 , column2...
 *                  FROM table_name | view_name | (SELECT ~~)
 *                                               ------------
 *                                               1. 페이지 나누기
 *                                               2. 인기 순위
 *                                               ------------ rownum(가상 컬럼 => INSET마다 번호를 자동 지정)
 *                                                             => 1번부터 => 인라인 뷰
 *                  [
 *                      WHERE 조건문 (연산자) => 컬럼(함수) 연산자 값
 *                         								  -- 직접대입 , 사용자 입력값 , (SELELCT~) => 뷰
 *                      GROUP BY 그룹컬럼(함수) => 관리자 => 통계 (지정된 그룹별로 따로 설정)
 *                      HAVING 그룹조건 => 반드시 GROUP BY를 동반
 *                             ------ 집합함수 (COUNT,AVG,SUM)
 *                      ORDER BY 컬럼(함수) (ASC|DESC)
 *                        => 처리하는 속도가 늦다 => INDEX
 *                      => 다음주 : 오라클 고급 / 화면 출력 (HTML/CSS)
 *                                INDEX / PLSQL / 데이터베이스 설계 ==> DBA
 *                  ] 
 *             => 1. 형식 => 화면 설계 , 2. 연산자 (조건에 맞는 데이터 추출) , 3. 내장 함수
 *                4. 정렬 => 최신 데이터 => DESC
 *                -----------------------------------------------------------
 *             DML : 데이터 조작언어
 *             INSERT => 데이터를 저장하는 목적으로 만듬
 *               => 형식)
 *                      1. 컬럼 전체에 값을 저장
 *                         INSERT INTO table_name VALUES(값...)
 *                              숫자 : 10 , 20 ...
 *                              문자 : ''
 *                              날짜 : SYSDATE(현재날짜) , 'YY/MM/DD'
 *                      2. 원하는 컬럼에만 값 저장
 *                         INSERT INTO table_name(컬럼명,컬럼명...) VALUES(값...)
 *                           => 컬럼에 null값 허용 / default가 있는 경우
 *             UPDATE => 데이터 수정
 *                => 형식)
 *                        UPDATE table_name SET
 *                        컬럼명=값 , 컬럼명=값
 *                        WHERE 조건문
 *             DELETE => 데이터 삭제
 *                => 형식)
 *                        DELETE FROM table_name
 *                        WHERE 조건문
 *                        
 *             = 주의점
 *               문자열 => ""
 *               ------------ 1. 공백 , 2. ' ' , 3. ; 사용시 오류 => 자동으로 ; 을 붙여준다
 *               ------------ autoCOMMIT => 잘못된 데이터가 저장이 될때 복구를 할 수 없다
 *               --> 조인 / 서브쿼리 / NULL 값 처리 => NVL()
 *               --> '' => NULL , ' '
 *               String sql="SELECT "
 *                         +"FROM "
 *                         +"WHERE ~"
 *        
 *        
 */
// 1. 목록 : 번호 / 제목 / 이름 / 작성일 / 조회수
/*
 *     게시판 => 흐름 (웹 : 로직이 없다) , 데이터베이스 연동 => 이동
 *     			목록								상세보기
 *     			 |								  |
 *     		----------						---------------------
 *     		|		 |						|			|		|
 *        글쓰기	  상세보기 => 이동			   수정		   삭제 	   이동 => 목록으로 이동
 *        	|								|			|        
 *        완료=> 목록으로 이동				  완료 => 상세보기 완료 => 목록
 *        
 *        => VO / DAO / Service / Config 
 *          ---------- --------- Open API
 *          장점 : 윈도우 / 모바일 / 웹 => 상관없이 소스가 동일 => 운영체제와 관계없다
 *          										   -------------- 개발(윈도우) , 호스팅 : 리눅스
 */

import java.sql.*;
import java.util.*;
import java.text.*;

public class BoardDAO {
	// 오라클 연결 객체
	private Connection conn; // Socket
	// 오라클 송수신 => Socket / OutputStream , BufferedReader => NetWork
	private PreparedStatement ps;
	// 오라클 주소 : 상수형
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 객체 한번만 생성 => 싱글턴
	private static BoardDAO dao;
	// 드라이버 등록 = 오라클 연결 = SQL문장 전송 = 결과값 읽기 = 데이터 모아서 = 윈도우로 전송
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	// 오라클 닫기
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}
	// 싱글턴
	public static BoardDAO newInstance() {
		if(dao==null) {
			dao=new BoardDAO();
		}
		return dao;
	}
	///////////////////////////////// 공통 기반 => 웹 (클래스 => jar) => 라이브러리화
	// 기능 => 리턴형 (어떤 데이터를 보내줄지) , 매개변수 (사용자로부터 어떤 값을 받을지)
	// 1. 목록 => 페이지 나누기 (인라인뷰)
	// VO => 한개의 게시물 정보 => 컬렉션 / 배열
	public List<BoardVO> boardListData(int page){
		// 리턴형 => return
		List<BoardVO> list=new ArrayList<BoardVO>(); // VO(게시물 1개) -> VO 여러개를 보내준다
		try {
			// 1. 연결
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit,num "
					 + "FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					 + "FROM (SELECT no,subject,name,regdate,hit "
					 + "FROM Board ORDER BY no DESC)) "
					 + "WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			// 실행 요청전에 => ? 에 값채우기
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				BoardVO vo=new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
			}
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			// 닫기
			disConnection();
		}
		
		return list;
	}
	// 1-1 총 페이지
	public int boardTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) "
					 + "FROM board ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}
	// 2. 글쓰기 => 시퀀스 사용법 => 매개변수는 특별한 경우 외에는 세개이상 초과하게 되면 반드시 배열이나 클래스 객체이용
	public void boardInsert(BoardVO vo) {
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장
			String sql="INSERT INTO board(no,name,subject,content,pwd) "
					 + "VALUES(board_no_seq.nextval,?,?,?,?)";
			// 3. 전송
			ps=conn.prepareStatement(sql);
			// 4. 실행요청
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());

			ps.executeUpdate();
			/*
			 *    excuteQuery() => 결과값이 있다 => SELECT
			 *    excuteUpdate() => 결과값이 없다 => commit() => INSERT / UPDATE / DELETE
			 */
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
	// 3. 상세보기 => WHERE => 조회수 증가 / 데이터 읽기
	public BoardVO boardDetailData(int no) {
		// 한개의 게시물에 대한 구분자 => no
		BoardVO vo=new BoardVO();
		try {
			getConnection();
			// 조회수 증가
			String sql="UPDATE board SET "
					+ "hit=hit+1 "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			// 데이터 읽기
			sql="SELECT no,name,subject,content,regdate,hit "
					+ "FROM board "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	// 4. 수정 => 비밀번호 체크 => 비밀번호 체크 / 실제 수정 => 묻고 답하기 : SQL(5)
	public BoardVO boardUpdateData(int no) {
		BoardVO vo=new BoardVO();
		try {
			getConnection();
			String sql="SELECT no,name,subject,content "
					+ "FROM board "
					+ "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	// 실제 수정
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FROM board "
					 + "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			// 확인
			if(db_pwd.equals(vo.getPwd())){
				bCheck=true;
				// 데이터 베이스 수정
				sql="UPDATE board SET "
						+ "name=? , subject=? , content=? "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnection();
		}
		return bCheck;
	}
	// 5. 삭제 => 비밀번호 체크 => 비밀번호 체크 / 실제 삭제 => 묻고 답하기 : SQL(7)
	public boolean boardDelete(int no,String pwd) {
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FROM board "
					 + "WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd==pwd) {
				bCheck=true;
				// 실제 삭제
				sql="DELECT FROM board "
						+ "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ps.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			disConnection();
		}
		return bCheck;
	}
	// 기능 수행을 위해서는 SQL문장이 1개가 아닐 수 있다 => 여러개의 SQL문장을 사용 할 수 있다
}

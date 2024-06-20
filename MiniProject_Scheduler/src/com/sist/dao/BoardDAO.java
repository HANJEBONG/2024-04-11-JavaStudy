package com.sist.dao;
/*
 *      DQL / DML 수행 => DDL, DCL, TCL : 오라클에서 작업
 *      --------- 				  ---- 오라클 명령어로 사용하는것이 아니다 => 메소드 (commit(), rollback())
 *      							└ 설정이 없으면 AutoCommit()
 *      => 프로그램 : 데이터 관리
 *      		   ----------> CRUD (SELECT / INSERT / UPDATE / DELETE) => crud 의 핵심프로그램 : 게시판
 *      게시판 만큼은 만들 수 있어야 한다!
 *      
 *       1. DQL : 데이터 검색 (SELECT)
 *          자바 ====> 오라클
 *          	SQL 문장
 *              --------> 오라클 문법에 맞춘다
 *          SELECT
 *          ------ 형식) SELECT * | cloumn1, cloumn2 ...
 *          			FROM table_name | view_name | (SELECT ~~)
 *          										  -----------
 *           										  1. 페이지 나누기   
 *           										  2. 인기 순위        이때 사용하는게
 *          										  --------------  rownum ( 가상컬럼 => INSERT 마다 번호를 자동 지정 )
 *          														  => 1번부터 => 인라인 뷰
 *          			[												페이지를 어떻게 나눴냐? 라는 질문에는 인라인 뷰를 설명한다
 *          			    WHERE 조건문 (연산자) => 컬럼 (함수) 연산자 값
 *          												   --- 직접대입, 사용자 입력값, (SELECT~) => 뷰
 *          				GROUP BY 그룹컬럼(함수) => 관리자 => 통계 (지정된 그룹별로 따로 설정)
 *          				HAVING 그룹조건 => 반드시 GROUP BY 를 동반
 *                          	   ------ 집합함수 (COUNT, AVG, SUM)
 *                          ORDER BY 컬럼 (함수) (ASC | DESC)
 *                            => 처리하는 속도가 늦다 => INDEX
 *                          => 다음주 : 오라클 고급 / 화면출력 (HTML / CSS)
 *                          		   INDEX / PLSQL / 데이터베이스 설계 ==> DBA
 *                          	-----------------------------------
 *          		( 오라클 공부 )	]
 *          ==> 1. 형식 -> 화면 설계, 2. 연산자 ( 조건에 맞는 데이터 추출 ), 3. 내장 함수
 *              4. 정렬 -> 최신 데이터를 먼저 출력 => DESC
 *              ----------------------------------------------------------
 *          DML : 데이터 조작 언어
 *          INSERT => 데이터 저장
 *          	=> 형식 )
 *          			1. 컬럼 전체에 값을 저장
 *          				INSERT INTO table_name VALUES (값...)
 *          				      숫자 : 10, 20 ...
 *                                문자 : ' '
 *                                날짜 : SYSDATE (현재날짜) , 'YY/MM/DD'
 *                      2. 원하는 컬럼에만 값 저장
 *                      	INSERT INTO table_name ( 컬럼명, 컬럼명...) VALUES(값...)
 *                      		=> 컬럼에 null 값 허용 / default 가 있는 경우
 *          UPDATE => 데이터 수정
 *          	=> 형식)
 *          			UPDATE table_name SET
 *          			컬럼명 = 값, 컬럼명 = 값 ...
 *          			[WHERE 조건문]
 *          DELECT => 데이터 삭제
 *          	=> 형식)
 *          			DELETE FROM table_name
 *          			[WHERE 조건문]
 *          = 주의점
 *            문자열 => " "
 *            ------------- 1. 공백, 2. ' ' , 3. ;을 사용하면 오류 => 자동으로 ; 을 붙여준다 
 *            ------------- AutoCommit() => 잘못된 데이터가 저장 => 복구할 수 없다
 *            ---> 조인 / 서브쿼리 / NULL 값 처리 NVL()
 *            								----- NVL('') ==> null 출력
 *            								----- NVL(' ') ==> 공백 출력    
 *            
 */
//  1. 목록 : 번호 / 제목 / 이름 / 작성일 / 조회수 
/*
 *   게시판 ==> 흐름 ( 웹 : 로직(x) , 데이터베이스 연동 => 이동 )
 *   			목록							상세보기
 *   		_____|_____ 				______|_____________
 *   	   |           |               |             |      |
 *       글쓰기         상세보기-> 이동     수정           삭제     목록-> 목록 이동
 *        |                            |             |
 *       완료 -> 목록이동             완료->상세보기       완료-> 목록
 *   
 *   	=> VO / DAO / Service / Config
 *   	   --------   ------ Open API
 *   		장점 : 윈도우 / 모바일 / 웹 상관없이 소스가 동일 => 운영체제와 관계 없다
 *   												-------------- 개발 (윈도우), 호스팅 :리눅스   
 *   
 */
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
public class BoardDAO {
	// 오라클 연결 객체
	private Connection conn; //Socket
	// 오라클 송수신 => Socket / OutputStream, BufferdeReader => NetWork
	private PreparedStatement ps;
	// 오라클 주소는 상수형으로
	private final String URL = "jdbc:oracle:thin:@192.168.10.124:1521:XE"; // xe ==> 테이블이 저장된 데이터베이스 (폴더)
	// 객체 한번만 생성 => 싱글턴
	private static BoardDAO dao;
	// 드라이버 등록 -> 오라클 연결 -> SQL 문장 전송 -> 결과값 읽기 -> 데이터 모아서 윈도우로 전송
	public BoardDAO() {
		// 시작과 동시에 수행문장 , 멤버변수 초기화 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
		 
	}
	// 오라클 연결 
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr1","happy");
			// 대문자 구분
			// 오라클로 명령 => conn hr/happy
		}catch (Exception ex) {}
	}
	/*
	 * connection
	 * prepardStatement
	 * ResultSet
	 * 
	 * ResultSet.close()
	 * PrepardStatement.close()
	 * Connection.close()   열기와 역순으로 닫아준다
	 */
	// 오라클 닫기
	public void disconnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex) {}
	}
	// 싱글턴
	public static BoardDAO newInstance() {
		if(dao == null)
			dao = new BoardDAO();
		return dao;
	}
	/////////////////////////// 여기까지는 공통     웹 (클래스 => jar ) => 라이브러리화
	// 기능   기능을 만들때  리턴형(어던 데이터를 보내줄것인지), 매개변수 (사용자로부터 무슨 값을 받아올지)
	// 1. 목록 출력 기능 -> 페이지 나누기 (인라인뷰)
	// VO => 한개의 게시물 정보 => 컬렉션 / 배열 을 이용해서 여러개를 묶어서 전송
	/*
	 *   Collection
	 *       Collection
	 *      ______|__________________
	 *     |            |            |
	 *    List         set          Map  ==> interface
	 *    							=> Map map = new
	 *    			   => Set set = new Hash Set
	 *   => List list = new ArrayList()
	 *     |            |            | 
	 *   ArrayList    HashSet       HashMap
	 *   ----------   --------     ---------
	 *                              => 클래스 관리 / SQL 문장 관리
	 *                              => 키, 값 => 두개를 동시에 저장
	 *                                 키(중복이 없다), 값(중복이 가능) => Cookie / Session
	 *   			  => 웹 실시간 채팅 (사용자 정보)
	 *                   순서는 없다
	 *                   데이터중복 허용하지 않음
	 *  => 데이터베이스에서 데이터를 모아서 저장
	 *     순서가 존재 (인덱스)
	 *     데이터 중복을 허용
	 *     비동기 방식 => ORDER BY 를 사용하지 않으면 순서가 일정하지 않는다
	 *       
	 */
	public List<BoardVO> boardListData(int page) {
		List<BoardVO> list = new ArrayList<BoardVO>(); // VO ( 게시물 1개 ) 니까 VO 여러개를 보내준다 
		try {
			// 1. 연결
			getConnection();
			// 2. 오라클로 보낼 sql 문장
            String sql = "SELECT no, subject, name, regdate, hit, num "
                    + "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
                    + "FROM (SELECT no, subject, name, regdate, hit "
                    + "FROM board ORDER BY no DESC)) "
                    + "WHERE num BETWEEN ? AND ?";
			// 1page => 1~10
			// 2page => 11~20
			ps = conn.prepareStatement(sql);// 먼저 전송
			// 실행 요청 전에 ? 에 값을 채운다
			int rowSize = 10;
			int start = (rowSize*page)-(rowSize-1); // 10-9 = 1 ~
			int end = rowSize*page; // 10
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			//실행 
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setNo(rs.getInt(1));
				vo.setSubject(rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setRegdate(rs.getDate(4));
				vo.setHit(rs.getInt(5));
				list.add(vo);
				
			}
			rs.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		return list;
	}
	// 1-1 총 페이지
	public int boardTotalPage() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT CEIL(COUNT(*) / 10.0) FROM board ";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		return total;
	}
	// SELECT 외에는 => 오라클 자체 처리 => 결과값이 없다
	// 2. 글쓰기 기능 -> 시퀀스 사용법 => 매개변수는 특별한 경우 외에는 3개이상 초과시는 반드시 배열, 클래스 객체
	public void boardInsert(BoardVO vo) {
		try {
			// 1. 연결
			getConnection();
			// 2. SQL 문장
			String sql = "INSERT INTO board(no, name, subject, content, pwd) "
						+"VALUES(board_no_seq.nextval,?,?,?,?)";
//								 -------------------- 자동증가 번호
			// 3. 전송
			ps = conn.prepareStatement(sql);
			// 4. 실행 요청
			// ? 에 값 채우기
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();
			/*
			 * executeQuery() => 결과값이 있다 => SELSECT
			 * executeUpdate() => 결과값이 없다 => commit() => INSERT / UPDATE / DELETE
			 */
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
	}
	// 3. 상세보기 기능 -> WHERE => 조회수 증가 / 데이터 읽기 
	public BoardVO boardDetailData (int no) {
		// 한개의 게시물에 대한 구분자 => no
		BoardVO vo = new BoardVO();
		try {
			getConnection();
			String sql = "UPDATE board SET "
						+"hit = hit+1 "
					    +"WHERE no =? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			
			//데이터 읽기
			sql ="SELECT no, name, subject, content, regdate, hit "
				+"FROM board "
				+"WHERE no=? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		return vo;
	}
	// 4. 수정 -> 비밀번호 체크 => 비밀번호 체크 / 실제 수정 => 묻고 답하기 : SQL(5)
	// 4-1 기존의 데이터 읽기
	public BoardVO boardUpdateData (int no) {
		// 한개의 게시물에 대한 구분자 => no
		BoardVO vo = new BoardVO();
		try {
			getConnection();
			String sql = "UPDATE board SET "
						+"hit = hit+1 "
					    +"WHERE no =? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();
			
			//데이터 읽기
			sql ="SELECT no, name, subject, content, regdate, hit "
				+"FROM board "
				+"WHERE no=? ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setSubject(rs.getString(3));
			vo.setContent(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setHit(rs.getInt(6));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		return vo;
	}
	// 체크 => boolean => pwd,no
	// 목록 => List => page
	// 상세보기 => VO => primary key
	// 찾기 => List => 검색어
	// 추가 => void => VO
	// 4-2 실제 수정
	
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck = false;
		try {
			getConnection();
			// 1. 비밀번호 체크
			String sql = "SELECT pwd FROM board "
						+"WHERE no =?";
			
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			// 확인 
			if (db_pwd.equals(vo.getPwd())) {
				bCheck = true;
				sql = "UPDATE board SET "
					+ "name =?, subject =?, content=? "
					+ "WHERE no =?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				
				ps.executeUpdate();
			}
			else {
				bCheck = false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		
		
		return bCheck;
	}
	// 5. 삭제 -> 비밀번호 체크 => 비밀번호 체크 / 실제 삭제 => 묻고 답하기 삭제 : SQL(7)
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck = false;
		try {
			getConnection();
			String sql = "SELECT pwd FROM board "
						+" WHERE no = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String db_pwd = rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(pwd)) {
				bCheck = true;
				// 실제 삭제
				sql = "DELETE FROM board "
					+ "WHERE no =? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, no);
				ps.executeUpdate();
				
			}
			else {
				bCheck = false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disconnection();
		}
		return bCheck;
	}
	// 기능 수행을 위해서는 SQL 문장이 1개가 아닐 수 있다 ==> 여러개의 SQL 문장을 사용할 수 있다
	
	
}
	





package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@192.168.10.124:1521:XE";
	private static MemberDAO dao; // 싱글턴
	
	// 1. 드라이버 등록
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 2. 오라클 연결
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
	// 4. 싱글턴 => 한사람당 한개의 DAO만 사용할 수 있게 만든다 => 메무리 누수현상을 제거
	public static MemberDAO newInstance() { // static을 활용해서
		if(dao==null) {
			dao=new MemberDAO();
		}
		return dao; // null이 아니면 기존에 저장된 dao를 사용
	}
	/////////////////////////////////// 모든 DAO에 공통 사항
	// 기능
	// 1. 로그인 처리
	/*
	 *    리턴형 => 경우의 수
	 *    = 사번이 없는 경우           => 0 => NOSABUN
	 *    = 사번은 존재 이름이 틀린 경우  => 1	=> NONAME
	 *    = 사번은 존재 , 이름도 동일    => 2  => OK
	 *    ------------------------------- String / int
	 */
	public String memberLogin(String id,String pwd) {
		String result="";
		try {
			// 1. 연결
			getConnection();
			// 2. SQL문장
			String sql="SELECT COUNT(*) FROM member WHERE id=?"; // 사번이 있는지 확인
			// 3. 오라클로 SQL문장 전송
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setString(1, id);
			// 4. 결과값을 받는다
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1); // 0,1
			rs.close();
			if(count==0) { // id가 없는 경우
				result="NOID";
			}else {// 사번이 있는경우
				sql="SELECT pwd FROM member WHERE id=?";
				// 오라클로 전송
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				// 결과값 받기
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				rs.close();
				
				if(db_pwd.equals(pwd)) { // 로그인
					result="OK";
				}else { // 이름이 없음
					result="NOPASSWORD";
				}
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();// 오류 확인
		}finally {
			// 오라클 해제
			disConnection();
		}
		return result;
	}
	// 1-1 회원 정보 읽기
	public MemberVO memberInfo(String id) {
		MemberVO vo=new MemberVO();
		try {
			getConnection();
			String sql="SELECT id,name,sex,admin FROM member WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setId(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setSex(rs.getString(3));
			vo.setAdmin(rs.getString(4));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	public MemberVO memberInfo2(String id) {
		MemberVO vo=new MemberVO();
		try {
			getConnection();
			String sql="SELECT name,sex,addr1,phone,content,email FROM member WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setAddr1(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setContent(rs.getString(5));
			vo.setEmail(rs.getString(6));
			rs.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vo;
	}
	// 2. 회원가입 => 아이디 중복 체크 / 우편번호 검색
	/*
	 *  ID
 PWD
 NAME
 SEX
 BIRTHDAY
 POST
 ADDR1
 ADDR2
 PHONE
 EMAIL
 CONTENT
 REGDATE
 ADMIN
	 */
	public String memberInsert (MemberVO vo) {
		String result=" ";
		try {
			getConnection();
			String sql="INSERT INTO member VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE,'n')";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPwd());
			ps.setString(3, vo.getName());
			ps.setString(4, vo.getSex());
			ps.setString(5, vo.getBirthday());
			ps.setString(6, vo.getPost());
			ps.setString(7, vo.getAddr1());
			ps.setString(8, vo.getAddr2());
			ps.setString(9, vo.getPhone());
			ps.setString(10, vo.getEmail());
			ps.setString(11, vo.getContent());
			
			// 추가 요청
			
			ps.executeUpdate(); // auto commit 이 포함되어 있다
			
			result="yes";
		} catch (Exception e) {
			// TODO: handle exception
			result=e.getMessage();
			e.printStackTrace();
		}finally {
			disConnection();
		}
		
		return result;
	}
	
	// 아이디 중복 체크
	public int memberIdCheck(String id) {
		int count=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM member "
					+ "WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return count;
	}
	// 3. 회원수정
	// 4. 회원탈퇴
	// SQL문장 제작 => 웹도 가능 => DAO 변경이 없다
	// 5. 우편번호 검색
	public ArrayList<ZipcodeVO> postFindData(String dong){
		ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			getConnection();
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					  + "FROM zipcode "
					  + "WHERE dong LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, dong); // 검색
			ResultSet rs=ps.executeQuery();
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
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}
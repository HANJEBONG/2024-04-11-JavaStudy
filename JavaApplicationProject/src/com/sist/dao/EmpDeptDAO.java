package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDeptDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDeptDAO dao; // 싱글턴
	
	// 1. 드라이버 등록
	public EmpDeptDAO() {
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
	public static EmpDeptDAO newInstance() { // static을 활용해서
		if(dao==null) {
			dao=new EmpDeptDAO();
		}
		return dao; // null이 아니면 기존에 저장된 dao를 사용
	}
	// 4. 싱글턴 => 한사람당 한개의 DAO만 사용할 수 있게 만든다 => 메무리 누수현상을 제거
	public ArrayList<EmpVO> empListData(){
		ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		try {
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,dname,loc "
					 + "FROM emp,dept "
					 + "WHERE emp.deptno=dept.deptno";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.getDvo().setDname(rs.getString(5));
				vo.getDvo().setLoc(rs.getString(6));
				
				list.add(vo);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			disConnection();
		}
		return list;
	}
}

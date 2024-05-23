package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("ID 입력:");
		String id=scan.next();
		
		System.out.print("비밀번호 입력:");
		String pwd=scan.next();
		
		System.out.print("이름 입력:");
		String name=scan.next();
		
		System.out.print("성별 입력:");
		String sex=scan.next();
		
		System.out.print("나이 입력:");
		int age=scan.nextInt();
		
		System.out.print("전화번호 입력:");
		String tel=scan.next();
		
		System.out.print("주소 입력:");
		String addr=scan.next();
		
		String sql="INSERT INTO member VALUES('"
				   +id+"','"+pwd+"','"+name
				   +"','"+sex+"',"+age+",'"+tel+"','"+addr+"')";
		System.out.println(sql.toString());
		
		sql="INSRET INTO member VALUES(''{0}'',''{1}'',''{2}'',''{3}'',''{4}'',''{5}'',''{6}'')";
		Object[] obj= {id,pwd,name,sex,age,tel,addr,sql};
		
		System.out.println(MessageFormat.format(sql, obj));
		// => 오라클 => 저장 => 출력 형식을 만들어서 처리 => MessageFormat
		/*
		 *     ***날짜 => SimpleDateFormat
		 *     ***정수 => DecimalFormat
		 *     출력 => MessageFormat
		 *     
		 *     => util
		 *        = Random
		 *        = StringTokenizer => 네트워크 (채팅)
		 *          ---------------- 갯수가 적은 것은 상관없다 , 많은 경우에 문제 발생
		 */
	}

}

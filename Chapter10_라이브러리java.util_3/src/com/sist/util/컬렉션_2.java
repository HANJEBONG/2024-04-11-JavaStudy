package com.sist.util;
import java.util.*;
public class 컬렉션_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		ArrayList<String> names=new ArrayList<String>();
		// 추가 => 문자열만 추가
		names.add("홍길동");
		names.add("박문수");
		names.add("심청이");
		names.add("이순신");
		names.add("을지문덕");
		
		for (int i=0;i<names.size();i++) {
			System.out.println(names.get(i).toString());
		}
		System.out.println("====== 데이터 추가후에 인덱스 확인 =====");
		// 추가 => 마지막에 추가를 해야 속도가 빨라진다
		names.add("호랭이");
		for (int i=0;i<names.size();i++) {
			System.out.println(i+" "+names.get(i).toString());
		}
		System.out.println("===== 지정된 위치에 추가 =====");
		names.add(2,"강낭콩"); // index 2번 자리
		for (int i=0;i<names.size();i++) {
			System.out.println(i+" "+names.get(i).toString());
		}
		System.out.println("===== 데이터 수정 =====");
		names.set(3, "이차돌"); // index 3번 자리
		for (int i=0;i<names.size();i++) {
			System.out.println(i+" "+names.get(i).toString());
		}
		System.out.println("===== 데이터 삭제 =====");
		System.out.print("삭제할 번호를 입력");
		int user=scanner.nextInt();
		
		names.remove(user);
		for (int i=0;i<names.size();i++) {
			System.out.println(i+" "+names.get(i).toString());
		}
		
	}

}

package com.sist.util;
import java.util.*;
public class 컬렉션_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("홍길동");
		names1.add("박문수");
		names1.add("치킨");
		names1.add("돈-까스");
		names1.add("김치-찌개");
		System.out.println("===== names1 출력 =====");
		for(String name:names1) {
			System.out.println(name);
		}
		ArrayList<String> names2=new ArrayList<String>();
		names2.add("홍짜장");
		names2.add("계란말이");
		names2.add("치킨");
		names2.add("치즈돈-까스");
		names2.add("오모리김치-찌개");
		System.out.println("===== names2 출력 =====");
		for(String name:names2) {
			System.out.println(name);
		}
		System.out.println("===== 데이터 복사 =====");
		ArrayList<String> temp=new ArrayList<String>();
		temp.addAll(names1); // 전체를 데이터 추가
		for(String name:temp) {
			System.out.println(name);
		}
		System.out.println("===== 데이터 주소 =====");
		System.out.println("temp "+temp.hashCode());
		System.out.println("names1 "+names1.hashCode());
		System.out.println("names2 "+names2.hashCode());
		System.out.println("===== 교집합 ====="); // 오라클 => INTERSECT => JOIN (INNER JOIN)
		temp.retainAll(names2);
		for(String name:temp) {
			System.out.println(name);
		}
		System.out.println("===== 차집합 ====="); // 오라클 => MINUS => OUTER JOIN (LEFT , RIGHT)
		temp.addAll(names1);
		ArrayList<String> temp2=new ArrayList<String>();
		temp2.addAll(names2);
		temp2.removeAll(temp);
		for(String name:temp2) {
			System.out.println(name);
		}
		ArrayList<String> names3=new ArrayList<String>(names1.subList(0, 3));
		// 마지막 인덱스 번호 제외 0 1 2
		System.out.println("===== 부분적 복사 =====");
		for(String name:names3) {
			System.out.println(name);
		}
		// JOIN => ArrayList
	}

}

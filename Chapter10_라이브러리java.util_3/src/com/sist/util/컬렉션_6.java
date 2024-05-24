package com.sist.util;

import java.util.*;

// 정렬
// Collection.sort()
public class 컬렉션_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// <> => 제네릭 => 반드시 클래스만 저장이 가능
		// <int> <double> => 오류
		// <Integer> <Double>
		// Wrapper => 제네릭에 첨부 , 기능 부여
		ArrayList<Integer> list=new ArrayList<Integer>();
		// 정수 10
		Random r=new Random();
		for(int i=0;i<10;i++) {
			list.add(r.nextInt(100)+1); // 1~100
		}
		System.out.println("===== list 데이터 출력 =====");
		// 언박싱 int a=i
		for(int i:list) {
			System.out.println(i);
		}
		System.out.println("====== 정렬 ======");
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i);
		}
		ArrayList<Integer> list2=new ArrayList<Integer>(list.subList(0, 5));
		// list => 데이터 5개 복사
		System.out.println("===== 5개 복사된 데이터 출력 =====");
		for(int i:list2) {
			System.out.println(i);
		}
		// 5개 추가
		for(int i=0;i<5;i++) {
			list2.add(r.nextInt(100)+1);
		}
		System.out.println("===== list2에 있는 모든 데이터 출력 =====");
		for(int i:list2) {
			System.out.println(i);
		}
		System.out.println("====== list2 정렬 ======");
		Collections.sort(list2);
		for(int i:list2) {
			System.out.println(i);
		}
	}

}

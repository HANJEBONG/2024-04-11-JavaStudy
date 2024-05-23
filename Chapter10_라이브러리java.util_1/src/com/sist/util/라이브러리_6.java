package com.sist.util;

import java.util.StringTokenizer;
import java.util.concurrent.CountDownLatch;

// StringTokenizer : 문자열 분리
/*
 *     nextToken() => 분리된 데이터를 가지고 오는 경우
 *     hasMoreTokens() => 분리된 데이터만큼 루프
 *     countToken() => 분리된 갯수
 */
public class 라이브러리_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String color="red,green,yello,blue,white,black";
		StringTokenizer st=new StringTokenizer(color,",");
		System.out.println("color의 갯수:"+st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}

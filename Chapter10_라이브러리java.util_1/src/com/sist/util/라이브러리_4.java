package com.sist.util;

import java.util.Arrays;
import java.util.Random;

// Arrays
/*
 *     toString() => 배열의 데이터 출력
 *     sort() => 데이터 정렬(ASC) => 올림차순
 *     ---------------------------------
 */
public class 라이브러리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		int[] arr=new int[7];
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
		}
		System.out.print("정렬전:");
		System.out.println(Arrays.toString(arr));
		System.out.print("정렬후:");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

	}

}

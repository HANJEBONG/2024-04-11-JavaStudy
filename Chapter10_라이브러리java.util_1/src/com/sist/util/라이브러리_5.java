package com.sist.util;

import java.util.Arrays;
import java.util.Random;

public class 라이브러리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열의 크기 => 작은 배열 , 큰 배열 => 고정 (한번 저장하면 변경할 수 없다)
		// 변경이 있는 경우에는 새로운 배열을 만들어서 처리 => copyOf()
		Random r=new Random();
		int[] arr=new int[7];
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		int[] sub=Arrays.copyOf(arr, 3);
		

	}

}

/*
 *     정렬
 *     ---
 *      선택 정렬
 *              30 20 40 10 50 => ASC(올림차순) / DESC(내림차순)
 *                                             => 50 40 30 20 10
 *                              =>10 20 30 40 50 
 *              ASC
 *              30 20 40 10 50
 *              -- --
 *              20 30
 *              --    --
 *              20    40
 *              --       --
 *              10       20
 *              --          --
 *              10          50
 *              ------------------ 1round  << 앞에서 부터 고정
 *      버블 정렬
 */

import java.util.*;

public class 중첩_for_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {30,20,40,10,50};
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i]; // **임시변수
					arr[i]=arr[j];
					arr[j]=temp; 
				}
				
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}

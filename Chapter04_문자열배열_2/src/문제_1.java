/*
 * 1. (1차배열)1번 학생 100점 2번 학생 90점 3번학생 85점이다. 점수를 score 배열 변수에 저장하고 
 * 1) 아래와 같이 출력하시오.
   1번 학생 : 100점  
   2번 학생 : 90점  
   3번 학생 : 85점  

   2) 학생들의 총점을 출력하시오.
   
      배열 생성             선언 예
      데이터형[] 배열명       int[] score => 권장
      ------- 배열데이터형    
      데이터형 배열명[]       int score[]
      
      초기화 => 사용할 수 있게 값을 배열 공간에 첨부
      데이터형[] 배열명;
      배열명=new 데이터형[]{값.......}
                       ---------
      데이터형[] 배열명=new 데이터형[갯수첨부]
                             ------- 기능은 없다 , 데이터를 묶어서 쉽게 관리가 가능
                                     => 변수/배열 => 읽기/쓰기
 */
 import java.util.*;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score= {100,90,85};
		int sum=0;
		for(int i=0;i<score.length;i++) {
			System.out.println((i+1)+"번 학생: "+score[i]+"점");
			sum+=score[i];
		}
		System.out.println("총점: "+sum);
		
	}

}

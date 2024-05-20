package com.sist.main;
/*
 *     예외 : 프로그램에 의도하지 않은 문제 발생
 *     
 *     => 문제가 발생
 *        = 사용자의 부주의(입력을 잘못하는 경우)
 *        = 프로그램의 결함 (프로그래머 실수)
 *        = 해결책
 *          1. 조건문 사용
 *          2. 조건문이 안되는 경우 => 예외처리를 사용한다
 */
import java.util.*;

public class 예외처리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("첫번째 정수 입력:");
        // 문자열로 받는다 (윈도우, 웹 => 정수가 없다 => 묹자열로 받는다)
        String num1=scan.next();
        System.out.print("두번째 정수 입력:");
        String num2=scan.next();
        
        int n1=Integer.parseInt(num1);
        int n2=Integer.parseInt(num2);
        
        System.out.println("n1"+n1);
        System.out.println("n2"+n2);
        
	}

}

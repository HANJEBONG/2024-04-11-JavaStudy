package com.sist.main;
/*
 *     throw : 임의로 에러 발생
 *             형식)
 *                  throw new 예외클래스() => catch 로 이동
 *                  => 코딩이 불가능
 *              catch 는 예외처리 크기에 따라 순서가 존재 => 상속도
 *              throws 문장에는 예외처리 순서가 없다 => ,
 *              
 *     try
 *     {
 *         1
 *         2
 *         3
 *         ------------------------
 *         4 => error => catch 로 이동
 *         5
 *         6
 *         7
 *         ------------------------ skip
 *     }catch(Exception e){8}
 *     9
 *     10
 *     
 *     자바는 => 다시 올라오지 않는다
 *     
 *     1
 *     2
 *     3
 *     4 => 1 이동 => 반복문 , 메소드
 */
import java.util.*;
public class 예외처리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("양수만 입력:");
		int no=scan.nextInt();
		try {
			// 예외처리 발생한 것이 아니라 => 임의로 발생
			if(no<0) {
				// 견고한 프로그램 => 에러발생시에 처리가 되고 있는지 => 테스트
				// 애플리케이션 테스트 
				// 개발자 => 단위 테스트 => JUnit
				System.out.println("throw 위에 있다");
				throw new IllegalArgumentException("음수는 사용할 수 없다");
				// 예외를 던진다 => 직접 예외의 catch 를 호출이 가능
				//System.out.println("앙");
			}
			if(no==0) {
				throw new IllegalArgumentException("0은 사용할 수 없다");
				// 예외를 던진다 => 직접 예외의 catch 를 호출이 가능
			}
			System.out.println("no="+no);
//		}catch(IllegalArgumentException e) { // 입력값이 잘못되었을 경우
//			// 음수는 사용할 수 없다 => getMessege()
//			System.out.println(e.getMessage());
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
	    }catch(Exception e) {
			System.out.println(e.getMessage());
     	}
		// 반드시 실행되어야 하는 문장이 있는 경우
		System.out.println("프로그램 종료");
	}

}

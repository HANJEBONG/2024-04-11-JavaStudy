package com.sist.main;

public class 예외처리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
        	System.out.println("문장1");
        	System.out.println("문장2");
        	System.out.println("문장3");
        	System.out.println(10/0);
        	System.out.println("문장4");
        	System.out.println("문장5");
        }catch(ArithmeticException e){
        	System.out.println("에러발생 => 복구");
        }
        System.out.println("문장6");
        System.out.println("문장7");
        System.out.println("프로그램 종료");
	}

}

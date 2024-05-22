package com.sist.main;
/*
 *     멀티 예외처리
 *     ---------
 *     catch 를 여러개 사용 => catch (1개로 통합)
 */
public class 예외처리_4 {
	// throws 뒤에 있는 예외가 예상된다 => 사용시는 예외처리후에 사용한다 => 에러발생시 대처가 쉽다
	// => 처리는 개발자에게 맡기는 프로그램 => 떠맡기기
    public void display() throws NumberFormatException,NullPointerException,ArithmeticException{
    	
    }
    public void print() throws  NumberFormatException,NullPointerException,ArithmeticException {
    	display();
    }
    public void print2() throws Exception{
    	display();
    }
    public void print3() {
    	try {
    		display();
    	}catch(ArithmeticException e) {
    		
    	}catch(NullPointerException e) {
    		
    	}catch(NumberFormatException e) {
    		
    	}
    }
    public void print4() {
    	try {
    		display();
    	}catch(Exception e) {
    		
    	}
    }
    public void print5() {
    	try {
    		display();
    	}catch(ArithmeticException | NullPointerException | NumberFormatException e) {
    		
    	}
    }
    // => throws (알림) => 알림,직접처리가 가능하다
    // => try => 직접 처리 => 알림을 줄 필요가 없다
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.sist.main;
/*
 *    에러 확인
 *    getMessage() : 에러내용만 출력
 *    printStackTrace() => 권장 사항 => 에러 위치 확인
 */
class AAA{
	
}
class BBB extends AAA{
	
}
public class 예외처리_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// int a=Integer.parseInt(" 10");
			AAA a=new AAA();
			BBB b=(BBB)a;
		}catch (Exception e) {
			// Exception => 자바에서 지원하는 모든 오류 처리가 가능 => Throwable : Error도 출력 => 웹
			e.printStackTrace();
			// System.out.println(ex.getMessage());
			// error 가 자주 나는 경우 => try ~ catch
		}


	}

}

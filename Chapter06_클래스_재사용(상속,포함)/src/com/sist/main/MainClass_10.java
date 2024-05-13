package com.sist.main;
/*
 *    206page / 207 page
 *    오버라이딩 : 기존의 클래스를 상속받아 재정의 (메소드 기능을 변경)
 *              -------------          -------------
 *    --------------------------------------------------
 *                 오버로딩                오버라이딩
 *    --------------------------------------------------
 *     상태       같은 클래스내에서          
 *    --------------------------------------------------
 *     메소드명       동일                     동일
 *    --------------------------------------------------
 *     매개변수    갯수 , 데이터형이 다르다         동일
 *    --------------------------------------------------
 *     리턴형        관계없다                   동일
 *    --------------------------------------------------
 *     접근지정어     관계없다                  확대만 가능
 *    --------------------------------------------------
 *    
 *    오버라이딩 => 상속
 *              예외조건)
 *                      static : 상속은 안된다 => 사용이 가능하게 만든다 (공유)
 *                      private : 상속은 가능 => 접근이 불가능
 *                          => protected
 *             
 *             메소드 종류
 *             1. 인스턴스메소드 : new에 의해서 딸라 저장
 *             2. 공통메소드 : static => 상속의 예외 조건 => 변경 (전체 변경) => 오버라이딩이 안된다
 *             3. 종단메소드 : 확장이 불가능 => 변경이 불가능 => final
 *             -------------------------------------------------
 *              권장) 메소드의 접근지정어는 가급적이면 public
 *              --------------------------------------
 *              
 *              접근지정어
 *              -------
 *               public : 생성자 , 클래스 , 메소드 , 인터페이스
 *                        => 다른 클래스와 연결
 *               private : 멤버변수 => 데이터 노출 방지 (데이터 보호)
 *                         => 다른 클래스에서 사용
 *                           => 변수 기능의 메소드 제작
 *                              -----------------
 *                              메모리 저장 / 메모리에 읽어오기
 *                              setter     getter
 */
class ABC{
	public void display() {} // 멤버 메소드
	public static void display2() {} // 공통메소드
	public final void display3() {} // 종단메소드 => 변경할 수 없는 메소드
}
class BCD extends ABC{
	public void display() {} // 멤버 메소드
	public static void display2() {} // 공통메소드
	//public final void display3() {} // 종단메소드
}
class DGB{
	private String name;
	private boolean login;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
}
public class MainClass_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

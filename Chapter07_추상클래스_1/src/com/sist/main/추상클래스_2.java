package com.sist.main;
abstract class Button{
	public abstract void click();
	public void link() {
		System.out.println("링크");
	}
}
class Login extends Button{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("로그인 요청");
		link();
	}
}
class Join extends Button{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("회원 가입 요청");
        link();
	}
	
}
// 결합성이 낮은 프로그램을 만들 수 있다
public class 추상클래스_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Button btn=new Login();
		btn.click();
		btn=new Join();
		btn.click();

	}

}

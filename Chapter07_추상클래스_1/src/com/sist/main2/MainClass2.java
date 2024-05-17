package com.sist.main2;
// 추상클래스의 단점
// => 상속을 내리는 클래스 => 상속을 받을 수 없다
abstract class AAA{
	int a;
	public abstract void aaa();
	public void bbb() {
		
	}
}
class B extends AAA{
	// => a,bbb() => 구현(오버라이딩)
	int b;
	public void ccc() {
		
	}
	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AAA aa=new B();
	}

}

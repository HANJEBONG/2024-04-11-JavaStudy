
package com.sist.main3;
interface A{
	public void aaa();
}
interface B{
	public void bbb();
}
class C implements A,B{
	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		System.out.println("C:bbb() Call...");
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		System.out.println("C:aaa() Call...");
	}

}

public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		C c=new C();
		c.aaa();

	}

}


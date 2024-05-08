package com.sist.main;
class A{
	public A() {
		System.out.println("메모리에 저장");
	}
	protected void finalize() throws Throwable{
		System.out.println("메모리 해제");
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		a=null;
		System.gc();

	}

}

package com.sist.main2;
class A{
	int c;
	public int add(int a, int b) {
		int c=a+b;
		return c;
	}
	public void plus(int a, int b) {
		c=a+b;
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		System.out.println(a.add(10, 20)); // c변수 회수
		a.plus(10, 20);
		System.out.println(a.c);

	}

}

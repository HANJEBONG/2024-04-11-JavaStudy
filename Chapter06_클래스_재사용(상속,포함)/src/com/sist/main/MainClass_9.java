package com.sist.main;
class Movie{
	void display() {
		
	}
}
class MegaBox extends Movie {
	//int display() {} => 리턴형이 동일해야한다 // 오버라이딩
	int display(int a) {
		return 10;
	} // => 오버로딩
	void display() {
		
	}
}
public class MainClass_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

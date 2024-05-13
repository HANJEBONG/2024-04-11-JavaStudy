package com.sist.main;
// 메소드 오버라이딩 ==> 204page => 가장 많이 사용
class Music{
	int count=10;
	public void list() {
		System.out.println("목록 출력");
	}
	public void detail() {
		System.out.println("상세보기");
	}
	public void find() {
		System.out.println("뮤직 검색");
	}
}
class Genie extends Music{
    int musiccount=200;
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Genie뮤직에서 검색 수행");
	}
	// 목록 출력
	// 상세보기
	// 검색
	
}
class Melon extends Music{
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Melon뮤직에서 검색 수행");
	}
	// 목록 출력
	// 상세보기
	// 검색
}
class Mnet extends Music{
	@Override
	public void list() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 목록 출력");
	}

	@Override
	public void detail() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 상세보기");
	}

	@Override
	public void find() {
		// TODO Auto-generated method stub
		System.out.println("Mnet뮤직에서 검색 수행");
	}
	// 목록 출력
	// 상세보기
	// 검색
}
public class MainClass_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("======= 지니뮤직 =======");
		Music m=new Genie();
		m.detail();
		m.find();
		m.list();
		System.out.println("======= 멜론 =======");
		m=new Melon();
		m.detail();
		m.find();
		m.list();
		System.out.println("======= Mnet =======");
		m=new Mnet();
		m.detail();
		m.find();
		m.list();

	}

}

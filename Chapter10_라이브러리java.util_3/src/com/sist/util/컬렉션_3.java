package com.sist.util;
// 사용자 정의
import java.util.*;
class Student{
	private int hakbun;
	private String name;
	private int kor,eng,math;
	// 읽기 / 쓰기 기능 추가 => 다른 클래스에서 접근이 가능하게 해준다
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	// 자동으로 디폴트 생성자가 생성이 안된다 ...
	// 사용자 입력값을 받아서 초기화
	public Student(int hakbun, String name, int kor, int eng, int math) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Student() {
		// 초기화 => 모든 학생 정보가 같은 값을 가지고 저장이 된다
	}
	// 매개변수가 있는 생성자가 있는 경우에는 디폴트 생성자를 만들어야 제어가 편리하다
	// 데이터 추가
}
class A{
	int a,b;
	public A() {
		a=10;
		b=20;
	}
}
/*
 *    A aa=new A();
 */
public class 컬렉션_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list=new ArrayList<Student>();
		// Object =< Student 변경
		list.add(new Student(1,"홍길동",90,80,70));
		list.add(new Student(2,"서동",80,67,95));
		list.add(new Student(3,"이명박",45,22,35));
		list.add(new Student(4,"짜장",78,98,99));
		list.add(new Student(5,"짬뽕",78,75,82));
		System.out.println("===== 데이터 출력 =====");
		// 배열 / 컬렉션 => for-each 를 이용해서 출력
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
		System.out.println("===== 데이터 추가1 =====");
		Student s=new Student();
		s.setHakbun(7);
		s.setName("이만덕");
		s.setKor(85);
		s.setMath(96);
		s.setEng(100);
		list.add(s);
		
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
		System.out.println("===== 데이터 추가2 =====");
		list.add(new Student(9,"유린기",73,79,82));
		
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
		System.out.println("===== 데이터 출력 =====");
		for(Student std:list) {
			System.out.println(std);
		}
		for(int i=0;i<list.size();i++) {
			Student p=list.get(i);
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",p.getHakbun(),p.getName(),p.getKor(),p.getMath(),p.getEng());
		}
		System.out.println("===== 데이터 삭제 =====");
		list.remove(3);
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
		System.out.println("===== 학생 수정 =====");
		list.set(1, new Student(2,"동서",85,79,45));
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
		System.out.println("===== 학생 졸업 =====");
		list.clear();
		for(Student std:list) {
			// 서식이 있는 출력 => 출력 형식을 만들어서 처리
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",std.getHakbun(),std.getName(),std.getKor(),std.getMath(),std.getEng());
		}
	}

}

package com.sist.main;
/*
 *     194page
 *     
 *     201page => 단일상속
 *             => 확장
 *                ----- 변경해서 사용 => 오버라이딩(변수오버라이딩 , 메소드 오버라이딩)
 *                ----- 추가
 *      
 *      추가                       변경(수정)
 *      ---                       ------
 *                     오버로딩        오버라이딩(덮어쓰기)
 *      -----------------------------------------               
 *       상태           같은 클래스내에서만  상속이 된 상태
 *                     ------------   ----------
 *                                    ** 익명의 클래스 => 상속없이 오버라이딩이 가능              
 *      -----------------------------------------
 *       메소드명         동일             동일
 *      -----------------------------------------
 *       매개변수         갯수/데이터형     갯수나 데이터형 동일
 *                      이 다르다 
 *      -----------------------------------------
 *       리턴형          관계없다           동일
 *      -----------------------------------------
 *       접근지정어       관계없다          축소하지 못한다 / 확대는 가능하다
 *      -----------------------------------------
 *        접근지정어
 *                       ---------> 확대
 *          **private < default < protected < public
 *                    축소 <-------------
 *      -----------------------------------------
 */
// 변수오버라이딩
import java.util.*;
class Parent{
	String name;
	int age;
	
	public Parent() {
		name="홍길동";
		age=25;
		System.out.println("Parent 클래스 메모리 할당!!");
	}
}
class Child extends Parent{
	// String name , int age
	String name;
	int age;
	public Child() {
		this.name="박문수"; // 자신 => this => 지역변수와 구분
		this.age=45;
		super.name="심청이"; // 상위 클래스
		super.age=17;
		System.out.println("Child 클래스 메모리 할당!!");
	}
}
/*
 *  Child c=new Child();
 *  Parent p=new Child()
 *  ----------------------- 클래스 여러개를 한개의 이름으로 제어
 */
class KKK{
	public void display() {
		System.out.println("KKK:display Call...");
	}
}
class AAA extends KKK{
	public void display() {
		System.out.println("AAA:display Call...");
	}
}
class BBB extends KKK{
	public void display() {
		System.out.println("BBB:display Call...");
	}
}
class CCC extends KKK{
	public void display() {
		System.out.println("CCC:display Call...");
	}
}
class DDD extends KKK{
	public void display() {
		System.out.println("DDD:display Call...");
	}
}
class EEE extends KKK{
	public void display() {
		System.out.println("EEE:display Call...");
	}
}
public class MainClass_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Child c=new Child();
		System.out.println("Child 나이: "+c.age);
		System.out.println("Child 이름: "+c.name);
//		Scanner scan=new Scanner(System.in);
//		System.out.print("AAA(1),BBB(2),CCC(3),DDD(4)EEE(5)");
//		int no=scan.nextInt();
//		
//		KKK k=(null);
//		switch(no) {
//		case 1:
//			k=new AAA();
//			break;
//		case 2:
//			k=new BBB();
//			break;
//		case 3:
//			k=new CCC();
//			break;
//		case 4:
//			k=new DDD();
//			break;
//		case 5:
//			k=new EEE();
//			break;
//		}
//		k.display();
//		
//		if(no==1) {
//			AAA a=new AAA();
//			a.display();
//		}else if(no==2) {
//			BBB b=new BBB();
//			b.display();
//		}else if(no==3) {
//			CCC c=new CCC();
//			c.display();
//		}else if(no==4) {
//			DDD c=new DDD();
//			c.display();
//		}else if(no==5) {
//			EEE c=new EEE();
//			c.display();
//		}

	}

}

/*
 *     변수 => 초기화 ( 프로그램에 필요한 데이터 값을 지정)
 *     | 필요한 값을 지정
 *     ----------------------------
 *     | 파일 읽기
 *     | 웹 읽기 (크롤링)
 *     | 메소드를 이용하는 방법
 *     | 입력값을 받아서 처리
 *     ---------------------------- 선언이 아니라 구현
 *                                  ------------- 클래스 {} 안에서는 사용이 불가능
 *                                  | 초기화 블록 / 생성자
 *      = 선언과 동시에 값을 지정
 *        나중에 값을 대입하는건 불가능하다
 *      = 모든 클래스에서는 생성자가 반드시 1개이상이 존재한다
 *      = 생성자가 없는 경우에는 컴파일시에 자동으로 하나 추가 한다
 *      
 *      *** 자바 프로그램에서 자동으로 추가되는 내용
 *      1. import java.lang.*;
 *                ------------
 *                String , Math , System
 *      2. extends Object : 모든 클래스는 Object 
 *      3. 메소드 => void => return 생략
 *      4. 모든 클래스 생성자가 없는 경우 => 자동 추가
 */
class Student
{
	// 변수
	String name="고길동";
	int hakbun=1;
	String school_name="SIST";
	String subject="컴퓨터";
	int year=2;
}
public class 클래스_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 학생 생성
		Student hong=new Student();
		//                 생성자 => 리턴형이 없다 / 클래스명과 동일 => 외부에서 데이터 읽어서 변수에 대입
		//                 사용자로부터 입력값을 받아서 초기화
		//                 시작과 동시에 연결 => 자바 구동 , 화면 UI , 데이터베이스 연동
		//                 생략이 가능 => 자동으로 컴파일러가 추가
		System.out.println("이름:"+hong.name);
		System.out.println("학년:"+hong.year);
		System.out.println("학과:"+hong.subject);
		
		Student shim=new Student();
		shim.name="심청이";
		shim.year=3;
		shim.subject="자바";
		System.out.println("이름:"+shim.name);
		System.out.println("학년:"+shim.year);
		System.out.println("학과:"+shim.subject);
		
		Student park=new Student();
		park.name="박문수";
		park.year=1;
		park.subject="파이썬";
		System.out.println("이름:"+park.name);
		System.out.println("학년:"+park.year);
		System.out.println("학과:"+park.subject);

	}

}

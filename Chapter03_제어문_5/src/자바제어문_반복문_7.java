/*
 *   알파벳을 입력을 받아서
 *      => 대문자 : 소문자
 *      => 소문자 : 대문자 출력
 *   => 결과값을 출력 위치
 *      => for 에서 출력 => for문 안에 변수 설정
 *      => for 종료 후에 출력 => for 위에설정
 *   => 변수 유지하는 범위 => 블록을 열고 닫았을때 {} => 블록변수,지역변수
 *                                          ------------- 사용전에 반드시 초기화
 *                                          
 *   => 멤버변수 , 공유변수 , 지역변수
 *      -------------- 초기화가 되어있다
 *      
 *      class A{
 *          int a; => 0
 *          static int b; => 0
 *          
 *          public static void main(String[] args){
 *          
 *          }
 *      }
 *      1~4장 => 자바의 기본 문법
 *      5~7장 => 객체지향 프로그램
 *      8장 : 예외처리 => 프로그램을 종료하지 않게 만든다
 *      ------------------------------------- 자바 기초
 *      9장 ~ 라이브러리 (조합식) => 암기
 *      모든 프로그램
 *      ---------
 *       | 마지막 단위 (오라클 연동) => JDBC ( 웹 : 85% )
 *         웹 개발자 : Java , 데이터베이스 , Spring
 *                  JavaScript => VueJS,react
 *       | C/C++ => 네트워크
 */
import java.util.Scanner;
public class 자바제어문_반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	    for(int i=0;i<5;i++) {
	    	System.out.print("알파벳을 하나 입력하시오 :");
			char ch=scan.next().charAt(0);  // 5번의 메모리가 만들어 진다 (메모리 할당)
			// for 한바퀴때마다 사라지고 다시 만들어 진다
			
			if(ch>='A' && ch<='Z') {
				System.out.println(ch+"의 소문자는 "+(char)(ch+32)+"입니다");
			}
			else if(ch>='a' && ch<='z') {
				System.out.println(ch+"의 대문자는 "+(char)(ch-32)+"입니다");
			}
			else {
				System.out.println("알파벳이 아닙니다");
			}// ch변수는 사용이 가능 => for문 안쪽임
	    }// ch변수는 사용 불가능 => for문 바깥임
		

	}

}

/*
 *      1. 년도 / 월 => year / month
 *      2. 요일 => year / month / week / i
 *      3. 출력 => year / month / week / i => 루프변수 (지역변수)
 */
import java.util.*;
// 문법 => C
// 메소드 => C++
// 전역 ==> 메소드 => 자바 ==> 5장 자바
/*
 *     사람 ========= 자판기
 *     ===
 *     지역변수 => 동전
 */
// 문법 => 메소드 (재사용) = 실제 프로그램 (객체 지향) => 전역변수 (멤버변수,공유변수)
//                      5장~12장 => 웹 프로그램
// 5장 => 기술면접
public class 달력만들기_절차적언어 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 사용자 입력 => default => Date
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
				
		System.out.print("월 입력:"); // final
		int month=scan.nextInt();
		// 2. 요일 구하기 => 사용자 정의 / 라이브러리
		Calendar cal=Calendar.getInstance(); // 싱글턴
		// Calendar 클래스 메모리 할당
		// 추상클래스
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.MONTH, month-1); // 0번부터
		cal.set(Calendar.DATE, 1);
		
		// 요일
		int week=cal.get(Calendar.DAY_OF_WEEK); // 1번부터
		week=week-1;
		// 마지막 날
		int lastday=cal.getActualMaximum(Calendar.DATE);
		// 3. 달력 출력
		String[] strweek= {"일","월","화","수","목","금","토"};
		System.out.println(year+"년도 "+month+"월");
		for(String s:strweek) {
			System.out.print(s+"\t");
		}
		System.out.println("\n");
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
		}
	}

}

package com.sist.main;
/*
 *    메소드
 *      => 문장 => 단락
 *      => 기능별 분리 => 오류 처리
 *         -------- 1. 재사용
 *                  2. 수정이 쉽다
 *                  3. 추가가 가능
 *                  4. 유지보수
 *                  5. 분업 => 나눠서 작업 => 일이 줄어준다...
 *                     --------------
 *                     | 인원
 *     => 역할 : 다른 클래스와 연결해서 사용
 *        사람클래스 ========= 자판기 클래스
 *                 동전 투입 => 음료수 선택
 *                           음료수 뽑기
 *                           잔돈을 돌려준다 => 동작
 *        객체지향 프로그램 = 여러개의 클래스를 만들어서 상호 연결해서 사용
 *        
 *      => 사이트 분석
 *         ---------
 *         1. 데이터 확인
 *         2. 기능 확인 ====> 데이터 추출
 */
import java.util.*;
class Diary{
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+"입력");
		return scan.nextInt();
				
	}
	public int getweek(int year,int month) {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		
		return week-1;
	}
	public int getLastDay(int year,int month) {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		return lastday;
		
	}
	public void print(int year,int month,int week,int lastday) {
		System.out.println(year+"년도"+month+"월");
		String[] strweek= {"일","월","화","수","목","금","토"};
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
	public void process() {
		int year=input("년도");
		int month=input("월");
		int week=getweek(year, month);
		int lastday=getLastDay(year, month);
		print(year, month, week, lastday);
	}
}
public class 클래스구성요소_메소드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diary d=new Diary();
		Scanner scan=new Scanner(System.in);
		while(true) {
			d.process();
			System.out.println();
			System.out.print("종료할까요?(y/n):");
			char end=scan.next().charAt(0);
			if(end=='y'||end=='Y') {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}

}

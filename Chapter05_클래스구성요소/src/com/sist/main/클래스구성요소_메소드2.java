package com.sist.main;
import java.util.*;

class Diary2{
	private int year;
	private int month;
	private int week;
	private int lastday;
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+"입력");
		return scan.nextInt();
				
	}
	public void getweek() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);
		
		week=cal.get(Calendar.DAY_OF_WEEK)-1;
		lastday=cal.getActualMaximum(Calendar.DATE);
	}
	public void print() {
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
		year=input("년도");
		month=input("월");
        getweek();
		print();
	}
}
public class 클래스구성요소_메소드2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Diary2 d=new Diary2();
		d.process();

	}

}

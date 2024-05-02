/*
 * 년도를 입력 받아 윤년여부를 확인하는 프로그램 작성
   년도 입력 메소드
   윤년 처리 
   출력 

 */
import java.util.Scanner;
public class 문제_3 {
    static int 년도_입력() {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("년도 입력: ");
    	int year=scan.nextInt();
    	return year;
    }
    static boolean 윤년_처리(int year) {
    	boolean bCheck=false;
    	if((year%4==0 && year%100!=0)||year%400==0) {
    		bCheck=true;
    	}
    	return bCheck;
    }
    static void 출력(int year) {
    	boolean bCheck=윤년_처리(year);
    	if(bCheck) {
    		System.out.println(year+"년은 윤년입니다");
    	}else {
    		System.out.println(year+"년은 윤년이 아닙니다");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        출력(년도_입력());
	}
}

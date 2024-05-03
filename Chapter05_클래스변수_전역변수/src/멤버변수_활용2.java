/*
 *     달력 만들기
 *     1. 년도 / 월 year/month
 *     2. 요일 => year/month/week
 *     3. 출력 => year/month/week
 */
// 멤버변수 없이 메소드 => 리턴형 / 매개변수
import java.util.*;
public class 멤버변수_활용2 {
	static int year,month,day,week;
    static int input(String msg) {
    	Scanner scan=new Scanner(System.in);
    	System.out.print(msg+"입력:");
    	return scan.nextInt();
    }
    static int getweek() {
    	Calendar cal=Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);
    	cal.set(Calendar.DATE, day);
    	int week=cal.get(Calendar.DAY_OF_WEEK);
    	return week;
    }
    static void print() {
    	String[] strweek= {"","일","월","화","수","목","금","토"};
    	System.out.printf("%d년도 %d월 %d일 %s요일입니다\n",
    			   		 	year,month,day,strweek[week]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		year=input("연도");
		month=input("월");
		day=input("일");
		week=getweek();
		print();

	}

}

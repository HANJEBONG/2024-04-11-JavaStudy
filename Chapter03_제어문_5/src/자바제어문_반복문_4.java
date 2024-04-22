/*
 *   1~100 사이의 정수 중 10개 추출
 *   => 최대값 / 최소값 구한다
 *      ----    ----
 *   => for 10바퀴
 */
import java.util.Scanner;
public class 자바제어문_반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int max=1; // 가장 낮은 수 설정
		int min=100; // 가장 높은 수 설정
		
		// 반복 수행 => 임의의 정수 10개 추출
		for (int i=1;i<=10;i++) { // 출력하고 상관이 없다
			int num=(int)(Math.random()*100)+1;
			System.out.print(num+" ");
			// 1~100 사이 정수 임의로 추출
			// 최대값,최소값
			if(max<num)
				max=num;
			if(min>num)
				min=num;
		}
		/*
		 * int max=1;
		 * int a=10;
		 * int b=20;
		 * int c-30;
		 * 
		 * if (max<num)
		 * max=num;
		 * 
		 * 
		 */
		 System.out.println("\n최대값: "+max+"\n최소값: "+min);

	}

}

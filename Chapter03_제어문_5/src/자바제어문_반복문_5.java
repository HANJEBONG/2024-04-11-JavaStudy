/*
 *   A~Z 사이에서 => 사용자가 입력한 알파벳이 몇 번째 있는지 확인
 */
import java.util.Scanner;
public class 자바제어문_반복문_5 {

	public static void main (String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("알파벳을 입력하시오");
		char user=scan.next().charAt(0);
		
		
//		for(char c='A';c<='Z';c++) {
//			if(c==user) {
//				System.out.println((c-64)+"번째 알파벳입니다");
//			}
//		}
		int a=0;
		for(char c='A';c<='Z';c++) {
			
			if(c<=user) {
				a++;
			}
		}
		System.out.println(a+"번째 알파벳입니다");
		
			

	}

}



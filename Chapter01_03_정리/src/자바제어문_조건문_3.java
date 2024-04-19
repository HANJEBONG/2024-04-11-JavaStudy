/*
 *   == 선택문
 *      if(조건문){
 *          조건문 true일때 수행되는 문장
 *      }
 *      else{
 *          조건문이 false일때 수행하는 문장
 *      }
 */
import java.util.Scanner;
public class 자바제어문_조건문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("알파벳 입력:");
		char c=scan.next().charAt(0);
		if(c<='A' && c<='Z') {
			System.out.println(c+"는(은) 대문자");
			System.out.println(c+"의 소문자는 "+((char)(c+32)));
		}
		else {
			System.out.println(c+"는(은) 소문자");
			System.out.println(c+"의 대문자는 "+((char)(c-32)));
		}
		// 대문자와 소문자의 차이가 32

	}

}

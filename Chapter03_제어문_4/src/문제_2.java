/*
 * 정수 2개와 연산자(+,-,*,/)를 입력 받아 사칙 연산하는 
프로그램을 만들어라 (switch~case 사용) 

 */
import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		System.out.print("첫번째 정수를 입력하시오:");
		int num1=scan.nextInt();
		
		System.out.print("연산자(+,-,*,/)를 입력하시오:");
		char op=scan.next().charAt(0);
		
		System.out.print("두번째 정수를 입력하시오:");
		int num2=scan.nextInt();
		
		switch(op) {
		case '+':
			System.out.printf("%d %c %d = %d\n",num1,op,num2,(num1+num2));
			break;
		case '-':
			System.out.printf("%d %c %d = %d\n",num1,op,num2,(num1-num2));
			break;
		case '*':
			System.out.printf("%d %c %d = %d\n",num1,op,num2,(num1*num2));
			break;
		case '/':
			if(num2==0) {
				System.out.println("0으로 나눌 수 없습니다");
			}
			else {
			System.out.printf("%d %c %d = %.2f\n",num1,op,num2,((double)num1/num2));
			}
			break;
			default:
				System.out.println("잘못된 입력입니다");
		}

	}

}

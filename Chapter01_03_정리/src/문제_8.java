/*
 *    갯수를 센다 count
 *    합을 구한다 sum
 *    숫자를 받는다 num
 */

import java.util.Scanner;
public class 문제_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num;
		int sum3=0;
		int sum5=0;
		
		for(int i=1;i<=10;i++) {
			System.out.print(i+"번째 정수를 입력하시오:");
			num=scan.nextInt();
			if(num%3==0) {
				sum3++;
			}
			if(num%5==0) {
				sum5++;
			}
			
		}
		System.out.println("==========결과==========");
		System.out.println("3의 배수 갯수는 "+sum3+"개 이고"+" 5의 배수 갯수는 "+sum5+"개 입니다");

	}

}

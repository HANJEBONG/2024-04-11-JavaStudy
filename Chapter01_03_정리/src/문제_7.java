import java.util.Scanner;
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num;
		int sum=0;
		
		for(int i=1;i<=10;i++) {
			System.out.print(i+"번 정수를 입력하시오:");
			num=scan.nextInt();
			if(num%2==0) {
				sum++;
			}
			
		}
		System.out.println("==========결과==========");
		System.out.println("총 짝수의 갯수는 "+sum+"개 입니다");
		
		
	
		

	}

}

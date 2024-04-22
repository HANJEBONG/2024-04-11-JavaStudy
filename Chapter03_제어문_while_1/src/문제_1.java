import java.util.Scanner;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num=0;
		System.out.println("두자리 정수를 입력하시오");
		num=scan.nextInt();
		
		if(num%11==0) {
			System.out.println("일의자리수와 십의 자리수가 같습니다");
		}
		else {
			System.out.println("일의자리수와 십의 자리수가 같지 않습니다");
		}

	}

}

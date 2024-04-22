//11.	정수 입력을 받아서 60이상 합격 =>불합격  if~else
import java.util.Scanner;
public class 문제_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		System.out.print("점수를 입력하시오:");
		int score=scan.nextInt();
		
		if (score>=60) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
		

	}

}

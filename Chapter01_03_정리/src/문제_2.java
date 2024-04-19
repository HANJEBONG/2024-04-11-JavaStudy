import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num1,num2,gop=1;
		System.out.print("첫번째 정수를 입력하시오:");
		num1=scan.nextInt();
		System.out.print("두번째 정수를 입력하시오:");
		num2=scan.nextInt();
		
//		System.out.println(num1+"*"+num2+"="+(num1*num2));
		for(int i=num1;i<=num2;i++) {
			gop*=i;
			if(i!=num2) {
			    System.out.print(i+" * ");
			}
			else {
				System.out.print(i+" = "+gop);
			}
		}
//		System.out.println(num1+"부터 "+num2+"까지의 곱은:"+gop);
		

	}

}

package 연습장;
import java.util.Scanner;
public class 연습_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);

		int[] num=new int [10];
		
		System.out.print("양의 정수 10개를 입력하시오");

		for(int i=0;i<num.length;i++){
		    num[i]=scan.nextInt();
		}
		System.out.print("입력하신 정수 중 3의 배수인 정수는: ");
		for(int i=0;i<num.length;i++){
		    if(num[i]%3==0){
		    	
			    System.out.print(num[i]+" ");
		    }
		}
		System.out.print("입니다");

	}

}

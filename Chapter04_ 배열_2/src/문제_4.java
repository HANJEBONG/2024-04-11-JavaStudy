import java.util.Arrays;
import java.util.Scanner;

public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 1. 정수 10개를 저장하는 공간 => 배열

		int[] num=new int [10];
		// 2. 초기화
		System.out.print("양의 정수 10개를 입력하시오");

		for(int i=0;i<num.length;i++){
		    num[i]=scan.nextInt();
//               if(num[i]%3==0){
//			    System.out.print(num[i]+" ");
//               }
		}
		System.out.println(Arrays.toString(num));
		System.out.print("입력하신 정수 중 3의 배수인 정수는: ");
		// 출력
//		for(int i=0;i<num.length;i++){
//		    if(num[i]%3==0){
//		    	
//			    System.out.print(num[i]+" ");
//		    }
//		}
		for(int i:num) {
			if(i%3==0) {
				System.out.print(i+" ");
			}
		}
		
		System.out.print("입니다");

	}

}

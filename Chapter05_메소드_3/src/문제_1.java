/*
 * 정수를 입력 받아서 이진법을 출력하는 메소드 작성(3개의 메소드)
    정수 입력 
    이진법 처리
    출력
*/
import java.util.Scanner;
public class 문제_1 {
	static int 정수_입력() {
		Scanner scan=new Scanner(System.in);
		System.out.println("0~32767까지의 정수 입력:");
		return scan.nextInt();
	}
	static int[] 이진법_처리(int n) {
		int[] e=new int[16];
		int index=15;
		while(true) {
			e[index]=n%2;
			n=n/2;
			if(n==0)
				break;
			index--;
		}
		return e;
	}
	static void 출력(int[] a) {
		for(int i=0;i<a.length;i++) {
			if(i%4==0 && i>=4) {
				System.out.print(" ");
			}
			System.out.print(a[i]);
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=정수_입력();
		int[] e=이진법_처리(a);
		출력(e);
		

	}

}

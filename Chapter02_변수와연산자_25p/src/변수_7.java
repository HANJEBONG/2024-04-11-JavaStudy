/*
 *     값을 교환
 *     
 *     int a=100;
 *     int b=200;
 *     int temp=a;
 *     a=b
 *     b-temp
 */
public class 변수_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
		int b=200;
		int temp=a; // 임시 저장
		a=b;
		b=temp;
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		char c1='A';
		char c2='B';
		char temp=c1;
		c1=c2;
		c2=temp;
		

	}

}

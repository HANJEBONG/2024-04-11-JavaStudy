package 연습장;

public class 연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		outer : for (int i = 1 ; i <= 5 ; i++) {
//			for(int j = 1; j<=5;j++) {
//				if(j>i){
//					break outer;
//				}
//				System.out.print('#');
//			}
//			System.out.println();
//		}
//		String a="앙 기모띠";
//		String b;
//		b=a;
//		b="앙 기모뤼";
//		System.out.println(a);
//		System.out.println(b);
		String[] a={"앙 기모뤼","앙 기모띠"};
		a=new String[2];
				
		
		String[] b;
		b=a;
		b[1]="기모띠"; 
		
		System.out.println(a);
		System.out.println(b);
		

	}

}

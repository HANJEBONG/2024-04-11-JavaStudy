// 구구단
/*
 *    줄수 => 1차 for ==> 9번 수행
 *    
 *    2*1=2 .....  9*1=9 
 *    ..
 *    ..
 *    ..
 *    2*9=18 ..... 9*9=81
 */
public class 중첩_for_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
//				System.out.print(j+"*"+i+"="+j*i+"\t");
				System.out.printf("%2d * %2d = %2d\t",j,i,j*i);
			}
			System.out.println();
		}

	}

}

/*
 * 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
 */
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++) {
			if(i==10) {
				System.out.print(i*5);
			}
			else {
			    System.out.print(i*5+",");
			}
		}

	}

}

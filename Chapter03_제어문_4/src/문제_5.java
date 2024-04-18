/*
 * B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
 */
public class 문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char a='B';a<='N';a+=2) {
			if(a=='N') {
				System.out.print(a);
			}
			else {
			    System.out.print(a+",");
			}     
		} 

	}

}

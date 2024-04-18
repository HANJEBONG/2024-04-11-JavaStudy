/*
 * 1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
 */
public class 문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1;
		int num2; 
		int	num3;
		for (int i=1;i<=30;i++) {
			if(i%2==0) {
				num1=i;
				num2=i+2;
				num3=i+4;
				i=num3;
				System.out.printf("%d %d %d\n",num1,num2,num3);
				/*
				 *  if(i%3==0) {
				 *      System.out.println();
				 *  }
				 */
						
			}
		}

	}

}

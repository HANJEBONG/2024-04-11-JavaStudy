
public class 문제_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0; 
		int sum2=0;
		
		for(int i=3;i<=4462;i++) {
			if(i%2==0) {
				sum+=i;
			}
			else {
				sum2+=i;
			}
		}
		System.out.println("3~4462에서 짝수인 정수의 합은: "+sum);
		System.out.println("3~4462에서 홀수인 정수의 합은: "+sum2);

	}

}

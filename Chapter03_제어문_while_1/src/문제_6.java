//6.	100~999 사이의 4의배수가 아닌 수의 갯수,합을 출력하는 프로그램 작성
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int cnt=0;
		
		for(int i=100;i<=999;i++) {
			if(i%4!=0) {
				sum+=i;
				cnt++;
			}
		}
		System.out.println("4의 배수가 아닌것들의 합:"+sum);
		System.out.println("4의 배수가 아닌것들의 갯수:"+cnt);

		

	}

}


public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		for(int i=1;i<=100;i++) {
			if(i%4==0) {
				num+=i;
			}
		}
		System.out.println("1~100까지의 정수 중 4의 배수의 합계:"+num);

	}

}

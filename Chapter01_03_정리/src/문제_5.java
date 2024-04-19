//1~100까지 7의배수 9의 배수의 합
public class 문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		
		for(int i=0;i<=12;i++) {
			if(i%2==0 || i%3==0) {
				num+=i;
			}
		}
		System.out.println("0~12까지의 2의 배수와 3의 배수의 합은: "+num);
		
		for(int i=1;i<=100;i++) {
			if(i%2==0 || i%3==0) {
				num+=i;
			}
		}
		System.out.println("0~12까지의 2의 배수와 3의 배수의 합은: "+num);

	}

}

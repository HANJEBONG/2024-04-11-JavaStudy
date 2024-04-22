//13.	정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 
//배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.

public class 문제_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1;i<=10;i++) {
			int num=(int)(Math.random()*10)+1;
			sum+=num;
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.printf("평균:%.2f",sum/10.0);

	}

}

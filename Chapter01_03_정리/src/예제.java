// 1~45까지의 정수 중 랜덤하게 6개 출력
public class 예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=6;i++) {
			int num=(int)(Math.random()*45)+1;
			System.out.print(num+" ");
		}

	}

}

//5. 정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라. 
import java.util.Arrays;
public class 문제_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num=new int[10];
		// 1. 배열 선언, 변수 선언
		int total=0;
		// 2. 초기화 => 인덱스를 필요로 한다



         for(int i=0;i<num.length;i++) {
			num[i]=(int)(Math.random()*10)+1;
			total+=num[i];
		 }
         // 3. 요청 처리
         // 4. 결과 출력
   
		 System.out.println(Arrays.toString(num));
		 System.out.printf("\n위 숫자들의 평균은: %.2f",(total/(double)num.length));
		

	}

}

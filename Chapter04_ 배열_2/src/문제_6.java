//6. int[] num = { 94, 85, 95, 88, 90 }; 다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
public class 문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 생성과 동시에 초기화
		int[] num= {94,85,95,88,90};
		// 최소값,최대값 구하기 => 요청처리
		int max=num[0];
		int min=num[0];
		
		for(int i=0;i<num.length;i++) {
			if(num[i]>max) {
				max=num[i];
			}
			if(num[i]<min) {
				min=num[i];
			}
		}
		System.out.println("최대값은:"+max+" 최소값은:"+min);
		
		

	}

}

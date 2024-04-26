// 중복이 없는 난수
// 1~10 => 10개의 난수 발생 => 중복없이
public class 중첩_for_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 용도가 같은 정수 10개
		// 인덱스 번호는 0번 부터
		// 제어하기 편리하다 (읽기/쓰기) => 반복문을 사용하기 때문에 소스 코딩을 줄일수있다
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*10)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--; // 다시 난수 발생
					break; // 2차 for 문만 제어
				}
			}
		}
		// 초기화가 완료
		for(int i:arr) {
			System.out.print(i+" ");
		}

	}

}

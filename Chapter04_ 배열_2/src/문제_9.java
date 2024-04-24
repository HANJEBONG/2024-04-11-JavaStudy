/*
 * arr 배열 중에서 값이 60인 곳의 인덱스를 출력해보자. 
   int[] arr = { 10, 20, 30, 50, 3, 60, -3 };  

 */
import java.util.Arrays;
public class 문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,50,3,60,-3};
		int index=0;
//		int i;
//		for(i=0;i<arr.length;i++) {
//		    
//			if(arr[i]==60) {
//			    System.out.println(i);
//			}
//		}
		for(int i:arr) {
			if(i==60) 
				break;
				index++;
			
		}
		//*** for each 문에서 변수는 배열이나 컬렉션의 '값'(리터럴)을 가져온다



        System.out.println(Arrays.toString(arr).indexOf(60));
		System.out.println((char)60);

	}

}

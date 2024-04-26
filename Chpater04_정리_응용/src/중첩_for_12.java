/*
 *     정렬
 *     --- 버블 정렬 (인접한 수끼리 비교) ==> 뒤에 부터 고정
 *     [15, 16, 39, 37, 29, 25] ==> 15 16 25 29 37 39 => ASC (올림차순)
 *     
 *      15  16  39  37  29  25
 *      --  --
 *      15  16
 *          --  --
 *          16  39
 *              --  --
 *              37  39
 *                  --  --
 *                  29  39
 *                      --  --
 *                      25  39
 *      ------------------------------- 1round (for 1)
 *      15  16  37  29  25  (39) 고정
 *      --  --
 *      15  16
 *          --  --
 *          16  37
 *              --  --
 *              29  37
 *                  --  --
 *                  25  37
 *      -------------------------------- 2round (for 2)
 *      15  16  29  25  (37  39)
 *      ..
 *      ..
 *      ..
 *      i   j => j=6-i
 *      1   5
 *      2   4
 *      3   3
 *      4   2
 *      5   1
 *      
 *      
 */
import java.util.*;
public class 중첩_for_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



        int[] arr= {15,  16,  39,  37,  29,  25};
        System.out.println("정렬 전");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬 후");
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
							
				}
				
			}
			System.out.println((i+1)+" round"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
		
		// DESC
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]<arr[j+1]) {
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
							
				}
				
			}
			System.out.println((i+1)+" round"+Arrays.toString(arr));
		}
		System.out.println(Arrays.toString(arr));
		

	}

}

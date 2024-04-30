/*
 *    5개 정수 => 넘겨주면 => 정렬
 *                       ASC (올림차순)
 *                       DESC (내림차순)
 *    = 선택정렬 : 1개를 선택해서 변경
 *    = 버블정렬 : 인접한 데이터끼리 변경
 *    --------------------------- sort reserve , 오라클 : ORDER BY
 *    ..로직 (프로그램 => 2차 for)
 *    
 *    1) 이차 for
 *       for (초기값;조건식;증가식){
 *           for(초기값;조건식;증가식{
 *               반복 출력 문장
 *           }
 *       }
 */
public class 메소드_6 {
	static int[] sort(String type,int[] arr) {
		boolean bCheck=false;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(type.equals("DESC"))
					bCheck=arr[i]>arr[j];
				else
					bCheck=arr[i]<arr[j];
				if(bCheck) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		return arr; // 정렬된 배열을 전송
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("==============변경전==============");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("==============변경후==============");
		arr=sort("ACS",arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		

	}

}

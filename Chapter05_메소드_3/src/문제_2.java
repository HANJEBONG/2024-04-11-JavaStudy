/*임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램 작성 
  임의의 정수 입력 (배열 생성후)
  정렬 처리
  출력 
*/
public class 문제_2 {
	static int[] 정수() {
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬전:");
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
		return arr;
	}
	static int[] 정렬(String o,int[] arr){
		int[] a=new int[arr.length];
		if(o=="ASC") {
			System.out.println("오름차순 정렬:");
		    for(int i=0;i<arr.length-1;i++) {
			    for(int j=0;j<arr.length-1-i;j++) {
				    if(arr[j]>arr[j+1]) {
					    int temp=arr[j];
					    arr[j]=arr[j+1];
					    arr[j+1]=temp;
				    }
			    }
			
		    }
		}else {
			System.out.println("내림차순 정렬:");
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<i;j++) {
					if(arr[i]>arr[j]) {
						int temp=arr[i];
						arr[i]=arr[j];
						arr[j]=temp;
					}
				}
				
			}
		}
		
		return arr;
	}
	static void 출력(int[] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=정수();
		출력(정렬("ASC",arr));
		출력(정렬("DESC",arr));
		

	}

}

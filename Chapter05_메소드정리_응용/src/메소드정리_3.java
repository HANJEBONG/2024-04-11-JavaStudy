
public class 메소드정리_3 {
    static void swap(int[] arr) {
    	// 메모리 주소 자체를 넘겨준다 => 같은 메모리에서 값 변경 => 원본 자체 변경
    	System.out.println("변경전: arr[0]="+arr[0]+" arr[1]="+arr[1]);
    	int temp=arr[0];
    	arr[0]=arr[1];
    	arr[1]=temp;
    	System.out.println("변경후: arr[0]="+arr[0]+" arr[1]="+arr[1]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// call by reference 방식 => 메모리 주소 자체를 변경
		// => 배열 / 클래스
		int[] temp={1000,200};
		swap(temp);
		System.out.println(temp[0]+" "+temp[1]);
	}

}

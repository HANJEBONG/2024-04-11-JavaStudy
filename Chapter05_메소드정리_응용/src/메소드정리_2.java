
public class 메소드정리_2 {
    static void swap(int a , int b) {
    	// 매개변수 전송법 => 메소드 안에서만 변경 => Call by value
    	System.out.println("번경전 a="+a+" , b="+b);
    	int temp=a;
    	a=b;
    	b=temp;
    	System.out.println("변경후 a="+a+" , b="+b);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=100;
		int b=200;
		swap(a,b);
		System.out.println(a+" "+b);
		// 원본이 저장된 메모리와 => 전송받은 메모리가 따로 생성한다 => 영향이 없다
		// => 기본형 , String
	}

}

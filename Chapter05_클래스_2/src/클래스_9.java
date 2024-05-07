// 122page
/*
 *    객체 생성
 *    -------
 *     형식) new 생성자()
 *             ---------- 클래스명과 동일
 *     예)
 *         class A
 *         {
 *         }
 *         
 *         A a=new A();
 *           -  객체 => 멤버변수/멤버메소드를 관리
 *           
 *        배열
 *            int[] arr=new int[2];
 *        클래스
 *            classs A
 *            {
 *                String name;
 *                int age;
 *            }
 *            
 *            A a=new A();
 *                --- ---
 *                     | 생성자 => 멤버변수의 초기값을 대입해 주는 역할 => 같이 다닌다
 *                |클래스에 있는 멤버변수를 저장할 수 있는 공간을 만들어 준다
 *                 a라는 공간에 저장된 메모리 주소를 넘겨주는 역할
 *                ** 생성자 호출시에는 반드시 new 생성자()
 *                                    -----------
 *              | 저장되어 있는 변수나 메소드를 관리 => 객체 => 설계(클래스)
 *              
 *              1. 설계 => class
 *              2. 메모리 지정 => new
 *              3. 활용 => new 부터 받은 메모리를 이용해서 활용 => 객체
 *                 ----------------------------------------- 객체 지향 프로그램
 *                 주목적 : 재사용 , 수정-추가 편리하게 만든다
 *                 
 *                 => 객체 사용
 *                    1. 생성
 *                      A a=new A();
 *                      ------------
 *                      A a;
 *                      a=new A();
 *                      ------------
 *                    2. 사용시에는
 *                       a.변수
 *                       a.메소드
 *                       ------------------ .은 메모리 주소 접근 연산자
 *                                         ---------------------
 *                    => 참조변수 (객체) => 메모리 주소를 이용하는 방식
 *                    => 일반변수 => 메모리에 저장된 값을 이용하는 방식
 *                    
 *                    int a=10;
 *                    int b=a;   => 
 *                    
 */
class A{
	String name;
	int age;
}
public class 클래스_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		System.out.println("a="+a);
		a.name="박문수";
		a.age=30;
		System.out.println("a.name:"+a.name);
		System.out.println("a.age="+a.age);
		
		// 메모리 주소를 받는 경우
		A b=a;
		System.out.println("b="+b);
		b.name="이순신";
		b.age=45;
		System.out.println("a.name:"+a.name);

	}

}

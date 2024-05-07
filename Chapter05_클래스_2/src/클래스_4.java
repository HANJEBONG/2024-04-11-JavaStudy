// 초기화 블록 => 자동 호출 클래스 블록안에{}
import java.util.Scanner;
class Sawon{
	int sabun;
	String name;
	String dept;
	String job;
	String loc;
	int pay;
	
   
	// 초기화 => 파일읽기 , 라이브러리 , 데이터베이스 연결 => {} 구현
	{
		/*sabun=1;
		name="홍길동";
		dept="개발부";
		job="대리";
		loc="서울";
		pay=3600;*/
		for(int i=0;i<10;i++){
		    	sabun=i;
		}
	}
	
	// 생성자
	/*
	 *    => 멤버변수의 초기화
	 *    => 메모리에 저장시에 호출되는 메소드
	 *    => 모든 클래스에 1개 이상 존재
	 *    => 없는 경우에는 자동으로 추가
	 *    특징
	 *    => 리턴형이 없다
	 *    => 클래스명과 동일
	 *    => 생성자는 하나가 아니라 여러개일수도 있다
	 */
	// 생성자가 아니라 일반 메소드
	void Sawon() {
		
	}
	// 생성자 => 생성자는 반드시 호출시에 new가 붙는다
	/*
	 *     기본 초기값 = 명시적 초기화 = 초기화 블록 =생성자
	 *                             |  {}
	 *     관련된 데이터가 여러개 저장시에는 => 메모리 주소를 이용해서 접근한다 => 참조변수
	 *                                                         -------
	 *                                                         배열/클래스
	 *     일반 1개의 변수만 이용
	 *     ** 객체 지향 프로그램은
	 *        여러개의 데이터 + 여러개의 메소드를 한곳에 저장한 후에 동시에 제어
	 *        ------------------------- 저장 공간을 객체
	 *                                          ---- 한번에 기능을 만덜어서 사용
	 *                                          1. 재사용
	 *                                          ---------
	 *                                          2. 수정 / 추가 편리
	 *                                          3. 데이터를 보호
	 */
	Sawon(){
		//System.out.println("메모리에 저장 완료");
		Scanner scan=new Scanner(System.in);
		System.out.print("사번 입력:");
		sabun=scan.nextInt();
		System.out.print("이름 입력:");
		name=scan.next();
		System.out.print("부서 입력:");
		dept=scan.next();
	}
}
public class 클래스_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sawon hong=new Sawon();  // 저장
		System.out.println("사번:"+hong.sabun);
		System.out.println("이름:"+hong.name);
		System.out.println("부서:"+hong.dept);

	}

}

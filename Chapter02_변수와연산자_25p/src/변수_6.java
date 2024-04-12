
public class 변수_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte byte_value=10;  // 구분이 없다 => -128~127 사이의 정수
		//byteValue
		int intValue=20;  // 컴퓨터에서 모든 숫자를 => int로 인식한다(21억 4천을 넘으면 안됨)
		// 4byte
		long longValue=30L;  // 구분 => 숫자뒤에 L,1 
		// 8byte
		float floatValue=10.5F;  // 4byte => 소수점 6자리까지 계산
		double doubleValue=10.5; //10.5D 10.5d => D,d는 생략가능
		// 실수의 디폴트
		// 정수 => int , 실수 => double
		// 실제 프로그램에서는 int , double 이 가장 많이 사용된다
		// 변수 => 계속 상태가 변경 ... / 고정 => 상수
		boolean booleanValue=true;
		// => 조건식 1byte => 저장은 true/false만 저장이 가능
		char charVlaue='A';
		// 문자 1개 저장 공간 => 2byte (0~65535)
		/*
		 *    byte = **char = int = long = double
		 *    boolean   |
		 *            String
		 *            된장국 끓이는 법 시금치 된장국 시금치국
		 */
		char c1='된';
		char c2='장';
		char c3='국';
		char c4=' ';
		char c5='끓';
		char c6='이';
		char c7='는';
		char c8=' ';
		char c9='법';
		System.out.println(c1+""+c2+c3+c4+c5+c6+c7+c8+c9);
		
		String s="된장국 끓이는 법";
		System.out.println(s);

	}

}

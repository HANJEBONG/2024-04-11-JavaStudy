/*
 *     Object  : 객체와 관련된 메소드를 가지고 있다
 *     생성 = 소멸 , 객체 비교 , 객체 복제 => 새롭게 생성 ...
 *     Object 는 모든 객체의 기능을 가지고 있다 => 모든 클래스에 상속을 내려서 사용
 *     
 *       => 소멸자 : finalize()
 *       => 복제 : clone()
 *       => toString ====> 거의 모든 프로그램의 오버라이딩
 *         ---------- 라이브러리는 오버라이딩이 되어 있다
 *       => 모든 클래스는 extends Object
 *       => 모든 데이터형 , 클래스는 Object로 묶어서 사용이 가능
 *          ----------------------------------------
 *          => 형변환을 해서 사용한다
 *          => 상속을 내리면
 *              => 상속을 받은 클래스의 추가적인 변수/메소드에는 접근이 불가능하다
 */
class Sawon{
	int mno;
	String name;
	
	public Sawon(int mno,String name) {
		this.mno=mno;
		this.name=name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "사원번호:"+mno+" , 이름:"+name;
	}
	
}
class Member{
	int mno;
	String name;
	
	public Member(int mno,String name) {
		this.mno=mno;
		this.name=name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "회원번호:"+mno+" , 이름:"+name;
	}
	
}
public class 라이브러리_활용_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj=new Member(1, "심청이");
		System.out.println(obj);
		
		obj=new Sawon(3, "박문수");
		System.out.println(obj);

	}

}

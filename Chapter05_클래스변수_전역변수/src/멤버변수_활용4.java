class Human{
    String name;
	String sex; // new 사용시 다른 메모리 생성
	// static => 공통으로 사용하는 메모리 생성
}
public class 멤버변수_활용4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human hong=new Human();
		hong.name="홍길동";
		hong.sex="남자";
		Human sim=new Human();
		sim.name="심청이";
		sim.sex="여자";
		
		System.out.println(hong.name);
		System.out.println(hong.sex);

	}

}

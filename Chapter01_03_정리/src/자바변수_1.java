/*
 *     돈까스 : 8000
 *     칼국수 : 6000
 *     왕만두 : 5000
 *     -------------
 *      주문 돈까스 => 16인분
 *          칼국수 => 8인분
 *          왕만두 => 1인분
 *     ------------------------ 총 계산서를 출력하는 프로그램을 작성
 */
import java.util.Scanner;
public class 자바변수_1 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int 돈까스,칼국수,왕만두;
		
		System.out.print("돈까스 주문수:");
		돈까스=scan.nextInt();
		돈까스*=8000;
		
		System.out.print("칼국수 주문수:");
		칼국수=scan.nextInt();
		칼국수*=6000;
		
		System.out.print("왕만두 주문수:");
		왕만두=scan.nextInt();
		왕만두*=5000;
		
		System.out.println("총 주문 금액:"+(돈까스+칼국수+왕만두)+"원");
		
		
	}

}

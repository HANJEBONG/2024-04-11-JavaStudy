import java.util.Scanner;
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num;
		System.out.print("달을 입력하세요>>");
		num=scan.nextInt();
		
		if (num>=3 && num<=5) {
			System.out.println("봄입니다");
		}
		else if (num>=6 && num<=8) {
			System.out.println("여름입니다");
		}
		else if (num>=9 && num<=11) {
			System.out.println("가을입니다");
		}
		else {
			switch(num) {
			case 12: case 1: case 2:
				System.out.println("겨울입니다");
				break;
			default:
				System.out.println("잘못된 입력입니다");
			}
		}
		
	}

}

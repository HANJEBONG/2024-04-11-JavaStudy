import java.util.Scanner;
public class 자바제어문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		boolean run=true;
		int balance=0;
		while(run) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("메뉴 선택>>");
			int menu=scan.nextInt();
//			switch(menu) {
//			case 1:
//				System.out.print("예금액>");
//				balance+=scan.nextInt();
//				break;
//			case 2:
//				System.out.print("출금액>");
//				int input=scan.nextInt();
//				if(balance<input)
//					System.out.println("잔액이 부족합니다");
//				else balance-=input;
//				break;
//			case 3:
//				System.out.print("잔고>");
//				System.out.println(balance);
//				break;
//			case 4:
//				run=false;
//				break; // 자신의 제어문에서만 작동 => switch 에서만 벗어난다 (while 에서는 벗어날 수 없다)
//			default:
//				System.out.println("잘못된 입력입니다");
//				break;
//			}
			if(menu==1) {
				System.out.print("예금액>");
				balance+=scan.nextInt();
			}
			else if(menu==2) {
				System.out.print("출금액>");
				int input=scan.nextInt();
				if(balance<input)
					System.out.println("잔액이 부족합니다");
				else balance-=input;
			}
			else if(menu==3) {
				System.out.print("잔고>");
				System.out.println(balance);
			}
			else if(menu==4) {
				run=false;
			}
			else {
				System.out.println("잘못된 입력입니다");
			}
		}
		System.out.println("프로그램 종료");

	}

}

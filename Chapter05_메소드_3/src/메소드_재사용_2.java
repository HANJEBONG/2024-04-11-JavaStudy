// 년도를 입력 받아 윤년인지 아닌지 확인하는 프로그램
/*
 *    년도입력:2024
 *    윤년입니다
 */
public class 메소드_재사용_2 {
	static void 윤년판별프로그램() {
		int year=메소드_7.input("년도");
		boolean bCheck=메소드_7.isYear(year);
		if(bCheck) {
			System.out.println("윤년입니다");
		}else {
			System.out.println("윤년이 아닙니다");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 *    ★★★★★
 *    ★★★★★
 *    ★★★★★
 *    ★★★★★
 *    1차 => 줄수 4 => 1~4
 *    2차 => ★ ==> 5개 => 1~5
 */
public class 중첩_for_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3&&i==3) {
					System.out.print("○");
				}else {
				    System.out.print("★");
				}
			}
			System.out.println();
		}
		System.out.println();
		char c='A';// for문 갯수만큼 전부 증가한다
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1;i<=4;i++) {
			for(char f='A';f<='D';f++) { // 2차 for문 내에서 증가한 후 1차 for문에서 초기화 된다
				System.out.print(f);
			}
			System.out.println();
		}
		System.out.println();
		
//		int i=(int)(Math.random()*10)+1;
//		int j=(int)(Math.random()*10)+1;
//		for(int k=1;k<=i;k++) {
//			for(int l=1;l<=j;l++) {
//				if(k==l||(k+l==j+1)) {
//					System.out.print("○");
//				}else {
//					System.out.print("●");
//				}
//			}
//			System.out.println();
//		}
		for(int i=1;i<=4;i++) {
			String[] img= {"♠","♥","♣","◈"};
			for(int j=0;j<4;j++) {
//				switch(j) {
//				case 1:
//					System.out.print("♠");
//					break;
//				case 2:
//					System.out.print("♥");
//					break;
//				case 3:
//					System.out.print("♣");
//					break;
//				case 4:
//					System.out.print("◈");
//					break;
//				}
				System.out.print(img[j]);
			}
			System.out.println();
		}
		

	}

}

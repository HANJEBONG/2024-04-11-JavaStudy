/*
 *    ★
 *    ★★
 *    ★★★
 *    ★★★★
 *    
 *    ★★★★
 *    ★★★
 *    ★★
 *    ★
 *    ------------------
 *       ★
 *      ★★★
 *     ★★★★★
 *    ★★★★★★★    
 *     ★★★★★
 *      ★★★
 *       ★
 *          i     j
 *          5     7
 *          6    67
 *          7   567
 */
public class 중첩_for_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for(int i=1;i<=4;i++) {
//			for(int j=1;j<=5-i;j++) {
//				
//					System.out.print("★");
//				
//			}
//			System.out.println();
//		}
//		for(int i=1;i<=4;i++) {
//			for(int j=1;j<=4;j++) {
//				if((i+j)<5) {
//					System.out.print(" ");
//				}else {
//					System.out.print("★");
//				}
//			}
//			System.out.println();
//		}
		for(int i=1;i<=7;i++) {
			for(int j=1;j<=7;j++) {
				if((i+j)<5) {
					System.out.print(" ");
				}else if((j-i)>3){
					System.out.print(" ");
				}else if((i-j)>3) {
					System.out.print(" ");
				}else if((i+j)>11) {
					System.out.print(" ");
				}
				else {
					System.out.print("★");
				}
			}
			System.out.println();
		}
	

	}

}

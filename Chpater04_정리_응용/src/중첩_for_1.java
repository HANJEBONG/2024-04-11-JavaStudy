/*
 *   중첩 for => 반복문 : 웹에서는 사용 빈도가 거의 없다
 *   --------
 *     1) 코딩 테스트 / 정보처리
 *     2) 솔루션
 *     
 *   중첩
 *   ---
 *     조건문
 *       if(){ => 1차
 *           if{ => 2차
 *           
 *           }
 *       }
 *     선택문
 *       switch(){
 *            case :
 *              switch(){
 *              
 *              }
 *       }
 *     반복문 : 주로 => for
 *     for() {-----------------> 줄수
 *         for(){ -------------> 출력 갯수
 *         }
 *     }
 *     1번째 줄 ==> 5
 *     2번째 줄 ==> 4...
 *     
 *     형식)          | false 종료
 *              1    2  
 *         for(초기값;조건식;증가식){
 *                   | true 
 *             ------------------------
 *                  1    2  <--4--------      
 *             for(초기값;조건식;증가식){
 *                       | true
 *                     문장 수행 3
 *             }
 *         }
 *         
 *         예) 
 *            1. 몇 줄 출력
 *            2. 출력은 몇 개.... 가로
 *            for(int i=1;i<=3;i++){
 *                for(int j=1;i<=3;i++){
 *                
 *                }
 *            }
 *            i=1 => j=1 -> j=2 -> j=3 => i++
 *            i=2 => j=1 -> j=2 -> j=3 => i++
 *            i=3 => j=1 -> j=2 -> j=3 => i++
 *            i=4 => 종료
 *            
 *            *****
 *            *****
 *            *****
 *            *****
 *            
 *            1. 줄수 : 4 (1-4)
 *            2. 출력물 : * 5개 (1-5)
 */
public class 중첩_for_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 실행 순서
//		for(int i=0;i<4;i++) {
//			for(int j=0;j<5;j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		for(int i=1;i<=5;i++) { // 줄수
			for(int j=1;j<=5;j++) { // 출력
				System.out.print("i="+i+" , j="+j+" ");
			}
			System.out.println();
		}
		// i=1 => j=1 j=2 j=3 j=4 j=5
		// i=2 => j=1 j=2 j=3 j=4 j=5
		// i=3 => j=1 j=2 j=3 j=4 j=5
		// i=4 => j=1 j=2 j=3 j=4 j=5
		// i=5 => j=1 j=2 j=3 j=4 j=5
		// 종료
	}

}

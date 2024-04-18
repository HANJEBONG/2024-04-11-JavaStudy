//65page
/*
 *    반복 제어문
 *    ***= for => 화면 출력 = 갯수 확정 => 반복 횟수가 지정
 *          형식)            | true =>반복
 *                          | false =>종료
 *                   1     2    4
 *              for(초기값;조건식;증가식){ ==> 2차 for => 코딩테스트
 *                    반복 수행문장 3
 *              }
 *    = while => 데이터베이스 = 무한 스크롤 => 반복 횟수 지정이 없는 상태
 *               초기값 ----------1
 *               while(조건식){ --------2 => false 면 종료
 *                   반복 수행문장 ---------3
 *                   증가식 ---------4 => 조건식으로 이동
 *               }
 *    ---------------------------------------- 한번도 수행을 안할때가 있다
 *      => 조건 : 선조건
 *    = do~while => 빈도수가 거의 없다
 *               초기값
 *               do {
 *                   반복문장
 *                   증가식
 *               }while(조건식)    
 *    ---------------------------------------- 무조건 한번 이상 수행
 *     => 조건 : 후조건
 *     => 자바의 모든 프로그램은 변수/연산자/if,for ==> 알파벳
 *                        ----------------
 *     => 관련된 내용끼리 묶어서 사용 : 배열/클래스/메소드 => 재사용
 *                             단어 / 문장 / 회화
 *                             
 *     ** for : 반복문 => 가장 많이 사용되는 반복문
 *       => for-each
 *       
 *       1) 형식
 *          for(초기값;조건식;증감식){
 *              반복수행문장
 *          }
 *          --------------------
 *          초기값 : 시작점 int i=1
 *          조건식 : 종료지점 i<=10
 *          증감식 : i++
 *       2) 동작 순서      | false 면 수행 종료
 *          for(①초기값;②조건식;③증감식){
 *                      | true 면 반복
 *              ④반복수행문장
 *          }
 *          ① -> ② -> ④ -> ③ -> ② -> ④ -> ③-> ② -> ④ -> ③
 *              ------------    -----------   ----------- ② false 면 종료
 *       3) 구현
 */
public class 제어문_반복문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");
		System.out.println("Hello Java!!");*/
		/*for(int i=1;i<=10;i+=2) { // 증가식은 프로그램에 따라서 달라질수도 있다
			System.out.println(i+"Hello Java!!");
		}*/
		for(int i=10;i>=1;i--) { // 초기값은 첫번째 값, 마지막 값, 증감식 => -- , ++
			System.out.println(i+"Hello Java!!");
		}
		// 방문 => cookie에 저장된 순서대로 열림


		


	}

}

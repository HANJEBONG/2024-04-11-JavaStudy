/*
 *    1. 중복없는 난수 => 응용
 *    -----------------------
 *    숫자 야구 게임
 *    1. 난수 => 3개 3 6 9
 *    2. 사용자 입력
 *       789 => 3 6 9 => 1s - 2b
 *    3. 힌트
 *       같은 자리 => 스트라이크
 *       다른 자리 => 볼
 *       
 */
/*
 *    2장 / 3장 / 4장
 *               --------------> 묶음
 *    연산자 제어문
 *    1. 묶음
 *       변수 여러개를 묶어서 관리
 *       변수 여러개 => 제어문 사용이 어렵다
 *       ------- 평문을 사용한다
 *       
 *       *** 배열은 변수가 3개 이상 일 경우
 *          *** 3개 => 사용 용도가 같을 경우
 *          나이 , 학번 , 학년
 *       ==> 다음
 *           명령문 : 메소드
 *           한개에 대한 정보 묶기
 *           클래스
 *           ------------------- = 프로그램 1개 완성
 *    ====================================================       
 *    대입 연산자 : = , += , -=
 *    int a=10; => a라는 변수에 10의 값을 넣는다 (x)
 *                 10의 값을 a라는 변수에 대입한다
 *    int a=10
 *    int b=20
 *    int c=a+b
 *    대입연산자는 마지막에 처리된다
 *    
 *    ==> 산술연산자 ==> 대입연산자
 *    ==> 제어문 : 비교연산자 , 증감연산자 ( 반복문)
 *              -----------------
 *              조건문 : 비교 , 분리
 *   --------------------------------------------------------- 자바 연산자
 *   3장 제어문 : 프로그램을 제어
 *             = 반복 수행
 *               for : 반복횟수가 있는 경우 => 2차 for
 *               while : 반복횟수를 모르는 경우
 *               ---------------------------------------
 *               do~while : 반복횟수를 모르는 경우 => 반드시 한번 이상 수행
 *             = 건너뛴다 : 단일 조건문
 *             = 선택한 내용만 처리 : 다중 조건문 , 선택문
 *             = 오류 처리
 *             
 *             = 반복문에 제어
 *               종료 : break => 반복문 , 선택문에서만 사용이 가능
 *               제외 : continue => 반복문에서만 사용이 가능
 *    ----------------------------------------------------------
 *    => 조건문
 *    => 1. 단일조건문
 *    1. 제어문 형식
 *       if(조건) 조건이 true 일 경우에 실행
 *       {
 *          조건이 true일때만 수행
 *          false면 => 건너뛴다
 *       }
 *    2. 동작 순서
 *       => 조건이 맞는 경우에만 실행
 *    3. 사용 위치
 *       => 오류처리 => 사용자 입력값을 받은 경우에 주로 처리
 *    4. 조건 설정  
 *       => 비교연산자 / 논리연산자
 *                    ------- 범위 지정할 경우
 *       ** if 를 여러개 사용하면 독립적이기 때문에 모든 조건을 검색 => 속도가 느려질 수 있다
 *       ** 여러 문장을 동시에 수행이 가능
 *         if~else => 선택 조건문
 *         true/false에 해당되는 소스 코딩
 *         
 *         ==> 한줄 : 삼항연산자
 *                  => combobox , 페이지 지정....
 *         ==> 두개로 나눠져 있는 경우
 *             로그인 / 아이디 중복 / 회원가입여부 / 검색어 입력 여부 ...
 *             웹 => 무조건 동작
 *       
 *       다중조건문 => 해당 조건문장만 수행 => 키보드 입력 (게임) , 메뉴
 *         if(조건문){
 *            조건문 true => 수행 => 종료
 *                 false => 다음 조건문을 찾는다
 *         }else if(조건문){
 *             조건문 true => 수행 => 종료
 *                 false => 다음 조건문을 찾는다
 *         }else if(조건문){
 *             조건문 true => 수행 => 종료
 *                 false => 다음 조건문을 찾는다
 *         }else{
 *             해당 조건이 없을때 처리한다 (생략가능)
 *         }
 *         --------------------- 단순화 => 선택문
 *         switch(정수,문자,문자열){
 *            case 1:
 *            case 2:
 *            처리문장   // 1번과 2번의 처리문장이 같은 경우
 *            break;
 *            case 3:
 *            처리문장
 *            break;
 *            default:생략이 가능
 *         }
 *  
 */
import java.util.Arrays;
import java.util.Scanner; // 사용자 입력
public class 중첩_for_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. 컴퓨터가 난수 발생 => 1~9 사이의 중복이 없는 숫자 => 3개
		int[] com=new int[3];
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1; // 1~9
			// 중복 여부 확인
			for(int j=0;j<i;j++) { // 생성된 난수 만큼만 비교
				if(com[j]==com[i]) { // 같은 수가 있는지 확인
					i--; // 다시 난수를 발생한다
					break; // 종료 j가 있는 2차 for문만 종료
				}
			}
		}
		Scanner scan=new Scanner(System.in);
		int[] user=new int[3];
		// 2. 사용자 입력 요청
		while(true) {
			
			System.out.print("세자리 정수를 입력해주세요");
			
//			for(int i=0;i<user.length;i++) {
//				user[i]=scan.nextInt();
////				System.out.println((i+1)+"번째 숫자: "+user[i]);
//				if(!(user[i]>=1&&user[i]<=9)) {
//					System.out.println("잘못된 입력입니다 다시 입력해주세요");
//					i--;
//				}
//			}
//			System.out.print("입력하신 숫자: ");
//			for(int i:user) {
//				System.out.print(i+" ");
//			}
			int input=scan.nextInt();
			if(input<100||input>999) {
				System.out.println("알림☞세자리 정수만 입력해야 합니다");
				continue;
				/*
				 * continue
				 * while => 조건식으로 이동
				 * for => 증가식으로 이동
				 * break
				 * 상관없이 종료
				 */
			}
			System.out.println("입력한 정수: "+input);
			// 3. 비교 후 힌트 제공
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			if(user[0]==user[1]||user[0]==user[2]||user[1]==user[2]) {
				System.out.println("알림 ☞ 중복된 수는 사용할 수 없습니다");
				continue;
			}
			if(user[1]==0||user[2]==0) {
				System.out.println("알림 ☞ 0은 사용 할 수 없습니다");
				continue;
			}
			
			int strike=0;
			int ball=0;
			for(int i=0;i<com.length;i++) {
				for(int j=0;j<user.length;j++) {
					if(com[i]==user[j]) { // 같은 수가 존재하는 경우
						if(i!=j) { // 자리수가 다른가
							ball++;
						}else { // 자리수가 같은가
							strike++;
						}
					}
				}
			}
			System.out.println();
			System.out.println(strike+" 스트라이크 , "+ball+" 볼 ");
			// 4. 정답 여부 확인 => 정답이면 종료 / 오답이면 다시 입력
			if(strike==3) {
				System.out.print("정답: ");
//				for(int i:com) {
//					System.out.print(i+" ");
//				}
//				System.out.println();
				System.out.println(Arrays.toString(com));
				System.out.println("당신의 승리입니다!!");
				break;
				
//			}else {
//				System.out.println("틀렸당께 다시 입력하십시오");
//				continue;
			}
		}

	}

}

/*
 *     소스가 많은 경우 => 나열(x) => 기능별 분리
 *     문장 => 단락을 나눠서 처리
 *     ---------------------------------
 *     오류 => 해당 메소드만 찾는다
 *     수정하기 편리하다
 *     --------------------------------- 구조적인 프로그램
 *     메소드
 *       = 재사용 => 다른 클래스와 연결
 *         ---- 1. 신뢰성이 뛰어나다 (검증이 된 상태)
 *         ---- 2. 소스량을 줄일 수 있다
 *         ---- 3. 개발 속도가 빠르다 (조립=>약간의 수정)
 *         ---- 4. 메가박스
 *                 CGV / 롯데시네마
 *                 => 지니뮤직 / 멜론
 *                 => 영화 예매 / 항공 예약 / 맛집 예약
 *       = 반복 제거
 *         같은 내용 소스 코딩 => 한개 통합
 *         수정하기 편리하다
 *         == 개발 / 유지보수
 *            SI     SM
 *            => 1년 => 개발
 *            => 10~15년 => 유지보수
 *       =
 *       
 */
// 국어 , 영어 , 수학 , 물리 , 국사 , 화학 점수를 입력 받아서 출력
import java.util.*;
public class 메소드_구조적프로그램 {
    static int input(String msg) {
    	Scanner scan=new Scanner(System.in);
    	System.out.print(msg+" 입력:");
    	return scan.nextInt();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor=input("국어");
		int eng=input("영어");
		int math=input("수학");
		int psy=input("물리");
		int his=input("국사");
		int chami=input("화학");
        /*Scanner scan=new Scanner(System.in);
        
        System.out.print("국어 입력:");
        int kor=scan.nextInt();
        System.out.print("영어 입력:");
        int eng=scan.nextInt();
        System.out.print("수학 입력:");
        int math=scan.nextInt();
        System.out.print("물리 입력:");
        int pyh=scan.nextInt();
        System.out.print("국사 입력:");
        int his=scan.nextInt();
        System.out.print("화학 입력:");
        int cham=scan.nextInt();
      */
	}

}

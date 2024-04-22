/*
 * 1)	100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
 * 
 * if문의 조건문과 다르게 case를 사용 => case 에 사용할 수 있는것 : 정수 , 문자 , 문자열
 * => 값을 한개 지정
 * => 값이 입력 => switch에 값을 받는다
 *    switch(op)
 * => 해당 문자 , 정수를 찾아서 문장을 수행
 * => case를 찾아서 처리하고 break가 없는 경우에는 break가 있는 곳까지 문장을 수행
 *    int a=3;
 *    switch(a) {
 *       case 1:
 *           문장1
 *       case 2:
 *           문장2
 *       case 3:
 *           문장3
 *       case 4:
 *           문장4
 *           break;
 *       case 5:
 *           문장5
 *     }
 *     
 *     *** 찾은 case부터 break가 있는 case까지 수행
 *     *** 해당 case에 없는 경우에는 default (생략이 가능) => case이다 break;
 *     *** break는 switch~case를 종료
 *     
 *     *** 보통 프로그램에서는 if를 많이 사용한다
 *         경우의 수가 많은 경우에는 switch를 주로 이용한다 (게임,메뉴)
 *         => switch가 if보다 간결하다
 *         => 네트워크
 *     *** if => 범위가 있는 경우
 *         if(score>=90 && score<=100)
 *     *** 값 1개씩 여러개인 경우 => switch
 *         switch(score) {
 *         case 100: case 99: case 98: ... case 90:  // /10 => 10,9
 *         } 
 *     *** switch(정수,문자,문자열)만 사용이 가능하다
 */
import java.util.Scanner;
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int score;
		for(;;) {
		
		System.out.print("점수 입력 :");
		score=scan.nextInt();
		
		char a=' ';
		
		if(score<0 || score>100) {
			System.out.println("잘못된 점수 입력입니다 다시 입력하랑께");
			continue;
		}
		//유효성 검사
		
		
		switch(score/10) {
		case 10: case 9:
			a='A';
			break;
		case 8:
			a='B';
			break;
		case 7:
			a='C';
			break;
		case 6:
			a='D';
			break;
		case 5: case 4: case 3: case 2: case 1: case 0:
			a='F';
			break;
		}
		System.out.println(a+"학점");
		System.exit(0);
		}

	}

}

// 사용자로부터 2~9사이의 정수를 입력받아서 구구단 출력
// 단 입력이 2~9까지 아닐 경우에는 다시 입력을 하게 만든다
import java.util.Scanner;
public class 자바제어문_반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int num;
		// 프로그램에 필요한 데이터를 사용자로부터 받아서 => 오류 체크
		/*
		 *  for(int i=0;i<10;i++){
		 *      int j=10;
		 *  } 
		 *  for 종료시까지만 사용가능한 변수 => i,j
		 *  for 안에서 변수를 설정
		 *  블록변수 => ()를 벗어나면 자동으로 삭제
		 */
		for(;;) {
			System.out.print("2~9까지의 정수중 하나를 입력하시오 : ");
			num=scan.nextInt();
			if(num>=2 && num<=9) {
				System.out.print(num+"단: ");
				for(int i=1;i<=9;i++) {
					System.out.print(num+"*"+i+"="+(num*i)+" ");
					
				}
				
				break;
			}
			else {
				System.out.println("다시 입력하시오");
			}
		}

	}

}

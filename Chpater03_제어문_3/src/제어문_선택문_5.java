// 국어 영어 수학 => 총점 , 평균 (연산자) , 학점 (if , switch)
import java.util.Scanner;
//AI
public class 제어문_선택문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in); 
		int kor,eng,math;
		
		System.out.print("국어 점수:");
		kor=scan.nextInt();
		System.out.print("영어 점수:");
		eng=scan.nextInt();
		System.out.print("수학 점수:");
		math=scan.nextInt();
		
		System.out.println("===== 결과 =====");
		System.out.println("총점: "+(kor+eng+math));
		System.out.printf("평균: %.2f\n",((kor+eng+math)/3.0));
		//int avg=(kor+eng+math)/3;
		char score=' ';
		
		switch((kor+eng+math)/30) {
		  case 10:
		  case 9:
			  score='A';
			  break;
		  case 8:
			  score='B';
			  break;
		  case 7:
			  score='C';
			  break;
		  case 6:
			  score='D';
			  break;
			  default:
				  score='F';
		}
		System.out.println("학점: "+score);
		// 프로그램은 결과값 => 정답은 없다 => 여러가지 경우의 수


	}

}

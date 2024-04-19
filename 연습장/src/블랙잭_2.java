import java.util.Scanner;
public class 블랙잭_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		int card=0;
		int score=0;
		int com=0;
		char user=' ';

		
		System.out.println("블랙잭 게임 스타트!!");
		for(;;) {
			
		
			
		    card=(int)(Math.random()*12)+1;
			if(card>=2 && card<=9) {
				card=card;
			}
			else if(card>9) {
				card=10;
			}
			else if(card==1) {
					
			}
			com+=card;
			
			
			card=(int)(Math.random()*12)+1;
			if(card>=2 && card<=9) {
				card=card;
			}
			else if(card>9) {
				card=10;
			}
			else if(card==1) {
				
			}
			score+=card;
			
			
			System.out.println("당신의 패의 총 합은 "+score+"입니다");
			System.out.println("카드를 더 뽑으시겠습니까?(y/n)");
			user=scan.next().charAt(0);
			
			switch(user) {
			case 'y':
				break;
			case 'n':
				
				default:
					System.out.println("잘못된 대답입니다 다시 입력해주세요");
					continue;
			}
			System.out.print("게임을 다시 시작하시겠습니까?(y/n)");
			user=scan.next().charAt(0);
			
			switch(user) {
			case 'y':
				break;
			case 'n':
				System.exit(0);
				default:
					System.out.println("잘못된 대답입니다 다시 입력해주세요");
					continue;
				
			}
			
		}
		

	}


}
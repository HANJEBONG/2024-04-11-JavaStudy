import java.util.Scanner;
public class 블랙잭_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int card=0;
		int user=0;
		int score=0;
		int com=0;
		char anw=' ';
		
		System.out.println("블랙잭 게임 시작");
		for(;;) {
		    for(int j=0;j<=2;j++) {
		    	card=(int)(Math.random()*12)+1;
			    if(card>=2 && card<=9) {
			    	com=card;
			    }
			    else if(card>=10 && card<=13) {
			    	card=10;
			    }
			    else {
			    	if(com<=10) {
			    		card=11;
			    	}
			    	else {
			    		card=1;
			    	}
			    }
			    com+=card;
		    	
		    }
		    
		    for(score=0;score<=21;) {
		    	for(int i=0;i<=2;i++) {
		    		card=(int)(Math.random()*12)+1;
				    if(card>=2 && card<=9) {
				    	user=card;
				    }
				    else if(card>=10 && card<=13) {
				    	card=10;
				    }
				    else {
				    	System.out.print("A카드가 나왔습니다 1과 11 중 어떤 수로 플레이할지 입력해주세요");
				    	user=scan.nextInt();
				    	while(true) {
				    		if(user==1 || user==11) {
				    			card=user;
				    			break;
				    		}
				    		continue;
				    	}
				    }
		    	}
		    	score+=card;
		    	System.out.println("당신의 패는"+score+"입니다");
		    	if(score<=21) {
			    	System.out.println("다음 패를 뽑으시겠습니까?(y/n)");
				    anw=scan.next().charAt(0);
				    if(anw=='y') {
				    	continue;
				    }
				    if(anw!='y') {
				    	break;
				    }
			    }
			    if(score>21) {
			    	break;
			    }
		    	if(score<=21){
		    		card=(int)(Math.random()*12)+1;
				    if(card>=2 && card<=9) {
				    	user=card;
				    }
				    else if(card>=10 && card<=13) {
				    	card=10;
				    }
				    else {
				    	System.out.print("A카드가 나왔습니다 1과 11 중 어떤 수로 플레이할지 입력해주세요");
				    	user=scan.nextInt();
				    	while(true) {
				    		if(user==1 || user==11) {
				    			card=user;
				    			break;
				    		}
				    		continue;
				    	}
				    }
				    score+=card;
				    System.out.println("당신의 패는"+score+"입니다");
				    if(score<=21) {
				    	System.out.println("다음 패를 뽑으시겠습니까?(y/n)");
					    anw=scan.next().charAt(0);
					    if(anw=='y') {
					    	continue;
					    }
					    if(anw!='y') {
					    	break;
					    }
				    }
				    if(score>21) {
				    	break;
				    }
				    
		    	}
		    	
	
		    }
		    System.out.println("딜러의 패는 "+com+"입니다");
		    
		    if(score<=21 && score>com) {
		    	System.out.println("당신의 승리입니다!!");
		    }
		    else if(score==com) {
		    	System.out.println("비겼습니다.");
		    }
		    else {
		    	System.out.println("당신의 패배랑께?");
		    }
		    System.out.println("다시 하시겠습니까?(y/n)");
	    	anw=scan.next().charAt(0);
	    	if(anw=='y') {
	    		continue;
	    	}
	    	if(anw=='n') {
	    		System.exit(0);
	    	}
		}
		

	}

}
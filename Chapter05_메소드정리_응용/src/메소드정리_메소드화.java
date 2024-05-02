import java.util.Scanner;

public class 메소드정리_메소드화 {
	// 난수 발생
    static int[] rand(int[] com) {
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*9)+1; // 1~9사이 정수 => 중복 없이
			// 중복 체크
			for(int j=0;j<i;j++) {
				if(com[j]==com[i]) {
					i--; // 다시 발생 (원상 복귀)
					break;
				}
			}
		}
		return com;
    }
    // 사용자 입력값
    static void inPutData() {
    	int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("세자리 정수 입력: ");
			int input=scan.nextInt();
			if(input<100 ||input>1000) {
				// || 범위를 벗어나는 경우
				System.out.println("세자리 정수만 사용이 가능합니다!!");
				// 처음 상태로 돌아간다
				continue;
			}
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			// 오류 처리
			if(user[0]==0 || user[1]==0 || user[2]==0) {
				System.out.println("0은 사용할 수 없다!!");
				continue;
			}
			if(user[0]==user[1] || user[0]==user[2] || user[1]==user[2]) {
				System.out.println("같은 수는 사용 할 수 없다!!");
				continue;
			}
			break;
		}	
    }

	static int compare(int[] com,int[] user) {
		int s=0,b=0;
		for(int i=0;i<com.length;i++) {
			for(int j=0;j<user.length;j++) {
				if(com[i]==com[j]) {
					if(i==j) {
						s++;
					}else {
						b++;
					}
				}
			}
		}
		hint(user,s,b);
		return s;
	}
	// 힌트
	static void hint(int[]user , int s , int b) {
		System.out.printf("Input numer:%d %d %d,Result: %dS - %dB\n",user[0],user[1],user[2],s,b);
	}
	static boolean isEnd(String answer) {
		boolean bCheck=true;
		Scanner scan=new Scanner(System.in);
		System.out.println("프로그램을 종료하시겠습니까?(예/아니오)");
		answer=scan.next();
		if(answer=="예") {
			bCheck=false;
		}
		return bCheck;
	}
	
	static void process() {
	    int[] com=new int[3];
	    int[] user=new int[3];
	    // 난수
	    rand(com);
	    //
	    inPutData();
	    compare(com,user);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			process();
		
	}

}

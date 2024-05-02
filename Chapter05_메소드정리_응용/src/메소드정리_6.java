import java.util.Scanner;

public class 메소드정리_6 {
    // 이 영역에 선언하면 모든 메소드가 사용 가능 => 멤버 변수
	static int[] kor=new int[3];
	static int[] eng=new int[3];
	static int[] math=new int[3];
	static int[] total=new int[3];
	static double[] avg=new double[3];
	static int[] rank=new int[3];
	static char[] score=new char[3];
	static void userInput() {
		Scanner scan=new Scanner(System.in);
        for(int i=0;i<kor.length;i++) {
        	System.out.print((i+1)+"번째 국어:");
        	kor[i]=scan.nextInt();
        	
        	System.out.print((i+1)+"번째 영어:");
        	eng[i]=scan.nextInt();
        	
        	System.out.print((i+1)+"번째 수학:");
        	math[i]=scan.nextInt();
        	
        	total[i]=kor[i]+eng[i]+math[i];
        	avg[i]=total[i]/3.0;
        	
        	switch(total[i]/30) {
        	case 10: case 9:
        		score[i]='A';
        		break;
        	case 8:
        		score[i]='B';
        		break;
        	case 7:
        		score[i]='C';
        		break;
        	case 6:
        		score[i]='D';
        		break;
        	default:
        		score[i]='F';
        	}
        }
	}
	static void rankChage() {
		for(int i=0;i<total.length;i++) {
        	rank[i]=1;
        	for(int j=0;j<total.length;j++) {
        		if(total[i]<total[j]) {
        			rank[i]++;
        		}
        	}
        }
	}
	static void print() {
		for(int i=0;i<3;i++) {
        	System.out.printf("총점: %d 평균: %.2f 학점: %c 등수: %d\n",total[i],avg[i],score[i],rank[i]);
        }
	}
	static void process() {
		userInput();
		rankChage();
		print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		process();

	}

}

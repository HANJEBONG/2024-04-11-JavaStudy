import java.util.*;
public class 문제 {
	static void 문제_1() {
		for(int i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
	}
	static int 문제_2() {
		int sum=0;
		for(int i=1;i<=10;i++) {
			sum+=i;
		}
		return sum;
	}
	static int 문제_3(int n) {
		int sum=0;
		for(int i=1;i<=n;i++) {
			sum+=i;
		}
		return sum;
	}
	static double 문제_4(int a, int b) {
		double div=0.0;
		try {
			div=a/(double)b;
		}catch(Exception e) {
			System.out.println("0으로 나눌수 없다!");
		}
		return div;
	}
	static String 문제_5(String alpha) {
		alpha=alpha.toUpperCase();
		return alpha;
		/*
		 *  String res="";
		 *  for(int i=0;i<str.length();i++){
		 *      char c=str.charAt(i);
		 *      if(c>='A'&& c<='Z'){
		 *          res+=c;
		 *      }else if(c>='a' && c<='z'){
		 *          res+=(char)(c-32);
		 *      }else{
		 *          res+=c;
		 *      }
		 *  }
		 */
	}
	static boolean 문제_6(String a) {
		boolean bCheck=true;
		for(int i=0;i<(a.length()/2);i++) {
			if(a.charAt(i)!=a.charAt((a.length()-1)-i)) {
				bCheck=false;
				break;
			}
		}
		return bCheck;
	}
	static void 문제_6_1(String msg) {
		if(msg.length()%2!=0) {
			System.out.println("잘못된 입력입니다");
			return; // 메소드 종료 => return은 원하는 위치에서 사용이 가능
		}
		
	}
	static void 문제_7(String msg) {
		for(int i=msg.length()-1;i>=0;i--) {
			System.out.print(msg.charAt(i));
		}
		System.out.println();
		System.out.println(new StringBuffer(msg).reverse());
	}
	static String 문제_8(int[] arr) {
		String score="";
		int total=0;
		for(int i=0;i<arr.length;i++) {
			total+=arr[i];
		}
		double avg=total/(double)(arr.length);
		switch((int)avg/10) {
		case 10: case 9:
			score="A학점";
			break;
		case 8:
			score="B학점";
			break;
		case 7:
			score="C학점";
			break;
		case 6:
			score="D학점";
			break;
		default:
			score="F학점";
		}
		
		return score;
	}
	static boolean 문제_9(int year) {
		boolean bCheck=false;
		if((year%4==0 && year%100!=0) || year%400==0) {
			bCheck=true;
		}
		return bCheck;
	}
	static void 문제_10(int a, int b) {
		if(a>b) {
			System.out.println(a);
		}else if(a<b) {
			System.out.println(b);
		}else {
			System.out.println("잘못된 입력입니다");
		}
	}
	static String 문제_11(int num) {
		String a="";
		if(num%2==0) {
			a="짝수입니다";
		}else if(num%2!=0) {
			a="홀수입니다";
		}else {
			a="잘못된 입력입니다";
		}
		return a;
	}
	static String 문제_12(int num) {
		String num3="";
		if(num%3==0) {
			num3="3의 배수입니다";
		}else if(num%3!=0) {
			num3="3의 배수가 아닙니다";
		}else if(-3<num&&num<3){
			num3="지금 뭐하는 거냥께?";
		}else {
			num3="잘못된 입력입니다";
		}
		return num3;
	}
	static String 문제_13() {
		String a="";
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.print("달 입력:");
		int month=scan.nextInt();
		System.out.print("일 입력:");
		int day=scan.nextInt();
		int date=0;
		for(int i=1;i<=year-1;i++) {
		    if((year%4==0&&year%100!=0)||year%400==0) {
			
		    }
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("문자열 입력");
		String srt=scan.next();
		문제_7(srt);
//		String a= "ABDGadf";
//		System.out.println(문제_5(a));
		// 리턴형이 있는 경우 => 결과값을 받는다
//		int sum=문제_2();
//		System.out.println(sum);
//		System.out.println(문제_4(3,0));
//		Scanner scan=new Scanner(System.in);
//	    System.out.println("대칭 비교를 위해 문자열을 입력해주세요:");
//	    
//	    String a=scan.next();
//	    System.out.println(문제_6(a));
		boolean year=문제_9(2024);
	    System.out.println(year);
	    int a=scan.nextInt();
	    int b=scan.nextInt();
	    문제_10(a,b);
	    System.out.println(문제_11(12));

	}

}

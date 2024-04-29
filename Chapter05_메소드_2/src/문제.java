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
	static boolean isYear(int year) {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
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
	    

	}

}

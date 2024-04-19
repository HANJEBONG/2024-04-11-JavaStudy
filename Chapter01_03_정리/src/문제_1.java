
public class 문제_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=1;
		int num2=1;
		for(num1=1;num1<=6;num1++) {
			for(num2=1;num2<=6;num2++) {
				if((num1+num2)==6) {
					System.out.println("6이 나오는 경우의 수: "+num1+ "," +num2);
				}
			}
		}

	}

}

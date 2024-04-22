//12.	5개으 정수를 임의로 추출하여 
//최대값,최소값을 출력하는 프로그램을 작성하시오

public class 문제_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max;
		int min;
		
		int i=1;
		
		int num=(int)(Math.random()*2100004000);
		System.out.println(num);
		
		
		max=num;
		min=num;
		do {
			num=(int)(Math.random()*2100004000);
			System.out.println(num);
			
			if (max>num) {
				max=num;
			}
			if(min<num) {
				min=num;
			}
			i++;
				
		}while(i<=4);
		System.out.println("최대값"+max);
		System.out.println("최소값"+min);

		

	}

}

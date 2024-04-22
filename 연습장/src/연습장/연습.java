package 연습장;

public class 연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		outer : for (int i = 1 ; i <= 5 ; i++) {
			for(int j = 1; j<=5;j++) {
				if(j>i){
					break outer;
				}
				System.out.print('#');
			}
			System.out.println();
		}

	}

}

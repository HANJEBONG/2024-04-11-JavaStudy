/*
 * . 1월달 사원(1번부터 5번사원)의 실적이 50 45 35 12 70 이다. (실적 0~100)
 * 1) 사번별 실적을 출력하시오.사원(1) 50..
 * 2) 1월 실적의 총점과 평균을 출력하시오.
   3) 실적이 제일 큰 사원의 사번과 실적, 작은 사원의 사번과 실적을 출력하시오.

 */
public class 문제_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



        int[] work=new int[5];
        for(int i=0;i<work.length;i++) {
        	work[i]=(int)(Math.random()*100)+1;
        	
        }
        
		int total=0;
		int max=work[0];
		int min=work[0];
		for(int i=0;i<work.length;i++) {
			System.out.println("사원("+(i+1)+")"+work[i]);
			total+=work[i];
			if(max<work[i]) {
				max=work[i];
			}
			if(min>work[i]) {
				min=work[i];
			}
			
		}
		double avg=total/(double)work.length;
		
		System.out.println("총점: "+total);
		System.out.println("평균: "+avg);
		for(int i=0;i<work.length;i++) {
			if(work[i]==max) {
				System.out.println("가장 실적이 좋은 사원:"+(i+1)+"  실적: "+max);
			}
			if(work[i]==min) {
				System.out.println("가장 실적이 나쁜 사원:"+(i+1)+"  실적: "+min);
			}

		}
	

	}

}

// 5개의 난수 발생 => 출력 / 평균출력
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a1=(int)(Math.random()*100)+1;
       /* int a2=(int)(Math.random()*100)+1;
        int a3=(int)(Math.random()*100)+1;
        int a4=(int)(Math.random()*100)+1;
        int a5=(int)(Math.random()*100)+1;
        
        System.out.println(a1+" "+a2+" "+a3+" "+a4+" "+a5);
        System.out.printf("평균:%.2f\n",(a1+a2+a3+a4+a5)/5.0);*/
        // 배열
        int[] arr=new int[5]; // new를 이용하면 자동으로 0값 초기화
        for(int i=0;i<5;i++) {
        	arr[i]=(int)(Math.random()*100);
        }
        // 출력 ==> 향산된 for문 => for-each => 데이터 출력 =>  배열,컬렉션에서만 사용이 가능
        // 값 추가 , 수정 ... 불가능 => 출력만 담당 => 데이터가 모아져 있어야 상용이 가능
        for(int i:arr) {
        	System.out.print(i+" ");
        }
        /*
         *   new를 이용해 메모리 할당
         *   => 자동 초기화
         *   int => 0
         *   double => 0.0
         *   long => 0L
         *   float => 0.0F
         *   boolean => false
         *   char =>'\0'
         *   String => null
         *   
         *   배열 , 클래스
         *   ----------
         *   메모리 구조 => 관리(JVM)
         *   ----------------------
         *    Method Area/static
         *    main ================> 5장
         *   ----------------------
         *    Stack => 지역변수 => 관리(메모리 자체 관리)
         *          => {}이 종료되면 자동으로 사라짐
         *   ----------------------
         *    Heap => 배열의 실제값 , 클래스 실제값 => 관리(프로그래머)
         *         => 프로그래머가 관리를 소홀시한다
         *            --------------------- 자동 메모리 회수 (가비지 컬렉션)
         *                            | 바로 회수하지 않고 => 프로그램 종료시에 회수
         *                            | 메모리 누수 현상 |
         *   ----------------------
         *   int[] arr=new int[5]
         *       new => 요청한 메모리를 생성 => 생성된 위치의 주소값을 배열변수에 넘겨준다
         *       stack                    heap
         *                        100  104 108 112 116
         *   arr =0x100           --------------------
         *      ===============>   0 | 0 | 0 | 0 | 0  
         *                  |     |-------------------
         *                         |   |   |   |   |
         *                         0   1   2   3   4
         *             100 ----- arr+0*4
         *              100+4 ----- arr+1*4
         *                100+4*2 ----- arr+2*4
         *                                  arr+3*4
         *                                     arr+4*4
         *                                           --
         *                                           int
         *    주소 참조 변수          0x100
         *                       => 연속적인 메모리 구조 
         *                  | arr의 첫번째 값 요청 => arr[0] => 일반변수와 동일한 역할
         *                  | arr의 두번째 값 요청 => arr[1] 
         *                  | arr의 세번째 값 요청 => arr[2]
         *                  | ...
         *                  | ...
         *                   => 해당 위치의 값을 인덱스로 표현한다 (0번부터 시작)
         *                   => 일단 생성이 되면 삭제 , 추가 => 불가능(고정)
         *                   => 인덱스 번호가 0부터 순차적으로 만들어진다
         *                     => 반복문 처리가 편리하다
         *    int[] arr=new int[3];
         *    => arr[0] arr[1] arr[2]
         *    int a,b,c;
         *    a=100
         *    b=200
         *    c=300
         *    
         *    arr[0]=100
         *    arr[1]=200
         *    arr[2]=300
         */
        /*
         *    for-each
         *    --------
         *    int[] arr
         *    double[] arr
         *    char[]
         *    for(데이터형 변수:배열명)
         *        ---------
         *        int
         *        double
         *        char
         *    배열에 저장된 실제 데이터값을 읽어온다
         *    ============ 배열의 모든 값을 읽으면 자동 종료
         *    예)
         *       int[] arr=(10,20,30,40,50)
         *       --- 데이터형 일치 => 배열명
         *       for(int i:arr)
         *           i=10
         *           i=20
         *           i=30
         *           i=40
         *           i=50==> for 종료
         *       char[] arr={'A','B','C'}
         *       => 가능 : 데이터형 크면 가능
         *       for (char c:arr)
         *           c='A'
         *           c='B'
         *           c='C' ===> 종료
         *           
         *       ==> 사용 => 출력과 관련 (브라우저에서 목록)
         *       
         *       char[] arr={'A','B','C'}
         *       for(int i:arr)
         *       
         *       byte < char < int < long < float < double
         *       => 형변환은 사용할 수 없다
         *       
         *       (double)int a;(X)
         *       int a=(int)10.5
         *       
         *       
         */
	}

}

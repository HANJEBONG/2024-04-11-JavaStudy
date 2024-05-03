/*
 *     class Sawon => 한명의 사원에 대한 정보를 모아둔다
 *     {
 *         String name;
 *         String dept;
 *     }
 *     ----------------------------- 변수가 아니라 데이터형 ( Sawon 데이터형) => 사용자 정의 데이터형
 *     public class MainClass
 *     {     
 *           Sawon s=new Sawon(); => 모든 메소드에서 사용이 가능 
 *           static void aaa()
 *           {
 *                Sawon s=new Sawon();
 *           }
 *           static void bbb() 
 *           {                         
 *               Sawon s=new Sawon(); -------- => 메소드안에 있는 변수는 호출후에 사라진다
 *           }                                 => 다른 변수
 *           static void ccc()
 *           {
 *               Sawon s=new Sawon();
 *           }
 *     }
 */
public class 멤버변수_활용 {
	static int a;
	static int b;
    static void aaa() {
    	b=100;
    	System.out.println("aaa():a= "+b);
    }
    static void bbb() {
    	//int a=200;
    	System.out.println("bbb():a= "+a);
    }
    static void ccc() {
    	int a=300;
    	System.out.println("ccc():a== "+a);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aaa();
		bbb();
		ccc();
	}

}

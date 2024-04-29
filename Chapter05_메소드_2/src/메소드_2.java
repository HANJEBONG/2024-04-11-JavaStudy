
public class 메소드_2 {
	static void aaa() {
		System.out.println("aaa() 진입");
		System.out.println("aaa() 기능처리");
		bbb();
		System.out.println("aaa() 종료");
	}
	static void bbb() {
		System.out.println("bbb() 진입");
		System.out.println("bbb() 기능처리");
		ccc();
		System.out.println("bbb() 종료");
	}
	static void ccc() {
		System.out.println("ccc() 진입");
		System.out.println("ccc() 기능처리");
		ddd();
		System.out.println("ccc() 종료");
	}
	static void ddd() {
		System.out.println("ddd() 진입");
		System.out.println("ddd() 기능처리");
		System.out.println("ddd() 종료");
	}
	// => LIFO => stack
	// 호출 영역 => call stack
	/*                                    
	 *     -------------
	 *                                               ddd()  ====> 메모리 해제
	 *     -------------
	 *                                       ccc()   ccc()  ====> 메모리 해제
	 *     -------------
	 *                               bbb()   bbb()   bbb()  ====> 메모리 해제
	 *     -------------
	 *                       aaa()   aaa()   aaa()   aaa()  ====> 메모리 해제
	 *     -------------
	 *         main          main    main    main    main   ====> 메모리 해제 프로그램 종료
	 *     -------------
	 *       CALL Stack
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		aaa();

	}

}

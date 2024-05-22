package com.sist.lang;
/*
 *    String :  문자열 관리 => char[] 을 제어
 *              => 오버라이딩이 불가능하다 (제공한 그대로 사용한다)
 *              => 종단 클래스 (final) => 상속이 불가능한 클래스
 *                 ----------------
 *                 Math,System,StringBuffer,Wrapper
 *              => 암기용
 *    => String 에 문자열을 저장하는 방법
 *       일반 기본형처럼 사용
 *       String s="";
 *       객체 생성
 *       String s=new String("");
 *       *** 문자열은 자체가 메모리 주소
 *           -------------------
 *           "Hello" => 메모리 주소 => ('H','e'...)
 *           String s1="Hello"
 *           String s2="Hello"
 *           
 *           s1==s2 => 같다 ===========> ==는 메모리 주소값을 비교
 *                                     equals() : 실제 저장된 문자열을 비교
 *                                     
 *     => 기능(메소드)
 *        1. public char charAt(int index) : 원하는 위치의 문자 한개를 가지고 올때 사용
 *        문자열은 char[] => index 번호는 0번부터 시작한다
 *        "Hello Java"
 *         0123456789
 *         
 *         charAt(6) ==> 'J'
 *        ***2. length() : 문자의 갯수를 가지고 온다
 *           => public int length();
 *            "Hello Java"
 *             0123456789 => 10 => 영문 / 한글 => 글자수 (공백을 포함한다)
 *                                                   --- space 문자
 *           => ... , 비밀번호 확인 / MMS
 *        3. toUpperCase() / toLowerCase()
 *           대문자변환 / 소문자변환
 *           public String toUpperCase()
 *           public String toLowerCase()
 *        ----------------------------------------------
 *        검색
 *        4. startsWith() : 시작하는 문자열이 같은 경우
 *           public  boolean startsWith(String start)
 *            => 서제스트를 만드는 경우에 주로 사용
 *              ------- 자동 완성 기능
 *            => cookie 저장 => cookie 읽기
 *               => 문자열만 저장이 가능
 *               => 방문 맛집 , 레시피
 *                  ------   ----
 *                  food_    recipe_
 *               => ^A (정규식) => A% (오라클)
 *        5. endsWith() : 끝나는 문자열이 같은 경우
 *           public boolean endsWith(String end)
 *           => 확장자 찾기
 *           => 그림파일 => gif / jpg / png / bmp ....
 *           => A$ (정규식) => A% (오라클)
 *           => img[src$='jpg|gif|png']
 *        ***6. contains() : 포함된 단어
 *           => 검색
 *           public boolean contains(String s)
 *           => 사이트에 나오는 모든 검색
 *           => [A](정규식) , %A% (오라클)
 *           => img[src*='A']
 *        ***7. equals() : 문자열이 같을때
 *              public boolean equals (String s)
 *              => 주로 사용 : 로그인 , 아이디 찾기 , 비밀번호
 *              ** equalsIgnoreCase()
 *              ** equals() , equalsIgnoreCase()
 *                 --------   -------------------
 *                            | 대소문자를 구분하지 않는다 (검색)
 *                 | 대소문자를 구분 (로그인 , 아이디 찾기...)
 *        ***8. indexOf() : 앞에서부터 찾기 (일반문자열)
 *              public int indexOf(찾는 문자 , 찾는 문자열)
 *        ***9. lastIndexOf() : 뒤에서부터 찾기 (경로명 , 확장자)
 *              public int lastIndexOf(찾는 문자 , 찾는 문자열)
 *        변경
 *        ***10. replace() : 문자나 문자열을 변경할때 사용
 *               => 크롤링 => 오라클에 저장할때 자주 사용
 *                  ------------
 *                   => || , & ... ==> 이미지가 있는 경우
 *                      --   --
 *                           Scanner
 *                      문자열 결합
 *               => 오버로딩
 *               public String replace(char c1,char c2)
 *                                    --------- --------
 *                                   변경문자(대상) 변경할 문자
 *               public String replace(String s1,String s2)
 *        ***11. replaceAll()
 *        ***12. substring()
 *        ***13. valueOf()
 *        ******** 웹은 모든 데이터가 String
 *        ***14. split()
 *        ***15. trim()
 *               
 *        
 */
public class String_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 문자열 저장 공간 만들기
		String s1="Hello";
		String s2=new String("Hello");
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같다");
		}else {
			System.out.println("s1과 s2는 다르다");
		}
	}

}


public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1="Hello";
        String s2="hello";
        
        /*
         *  equalsIgnoreCase : 대소문자 구분없이 비교 => 검색기
         *  equals : 대소문자 구분 => 비밀번호
         *  
         *  ==> 결과값 : true/false => 조건문에서 주로 사용
         */
        
       /* if(s1.equalsIgnoreCase(s2)) { // 같은 경우 true / 다른 경우 false
        	System.out.println("s1 과 s2가 같다");
        }
        else {
        	System.out.println("s1 과 s2가 다르다");
        }*/
        
        String msg="Hello Java";
        for(int i=msg.length()-1;i>=0;i--) {
        	System.out.print(msg.charAt(i));
        }
        // length() 문자갯수 => index=0 부터 시작한다
	}

}

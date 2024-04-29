// char  리턴 ==> 알파벳을 전송 => 대문자 => 소문자 , 소문자 => 대문자
public class 메소드_7 {
	static char upper(char c) {
		return(char)(c-32);
	}
	static char lower(char c) {
		return(char)(c+32);
	}
	static char upperLower(char c) {
		char res=' ';
		if(c>='A'&&c<='Z') {
			res=(char)(c-32);
		}
		else
			res=(char)(c+32);
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c=upperLower('B');
		System.out.println(c);

	}

}

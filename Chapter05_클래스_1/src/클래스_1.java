/*
 *    클래스 
 *     = 사용자 정의 데이터형 : 데이터만 모아서 관리
 *                        ----- 다른 데이터를 모아서 관리
 *     = 액션 클래스 : 메소드를 여러개 모아서 관리
 *     
 *     ** 클래스는 한개에 대한 정보
 *     class 사원 {
 *         이름
 *         부서
 *         근무지
 *         입사일
 *         직위
 *         연봉
 *         성과급
 *         ....
 *     }
 *     
 *     class 학생 {
 *         이름
 *         학년 int
 *         학점 char
 *         주소 String...
 *         전화
 *         나이
 *         ...
 *     }
 */
// 데이터형 => 형변환
// 개발자마다 틀리다 (프로그램에 맞게)
class Student{
	String name;
	int age;
	String school_name;
}
// => 저장
public class 클래스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student hong=new Student();
        hong.name="홍길동";
        hong.age=24;
        hong.school_name="쌍용";
        // name , age , school_name
        Student shim=new Student();
        shim.name="심청이";
        shim.age=17;
        shim.school_name="SIST";
        // name , age , school_name
        Student park=new Student();
        park.name="박정희";
        park.age=57;
        park.school_name="SIST 강북";
        // name , age , school_name
        System.out.println("========= 홍의 영역 ==========");
        System.out.println("이름: "+hong.name);
        System.out.println("나이: "+hong.age);
        System.out.println("학교 이름: "+hong.school_name);
        
	}

}

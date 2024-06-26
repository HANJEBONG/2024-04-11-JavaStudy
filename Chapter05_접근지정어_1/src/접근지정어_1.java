/*
 *     객체 지향 프로그램 => 자바 (CBD) => 데이터 관리
 *     -------------          => 이미 필요한 기능은 존재 => 조립해서 만드는 프로그램 (레고)
 *     1. 클래스
 *        = 변수 설정 (어떤 데이터가 필요한지) : 캡슐화 (데이터 보호) => getter/setter
 *          ------
 *          기본형 => 정수,실수,논리,문자
 *          배열 
 *          클래스 => 포함 클래스 : String => 데이터형
 *         1) 요구사항
 *            => 데이터 선언
 *            => 데이터 선언 => 데이터 수집 => 데이터 분석 => 데이터 분리 => 데이터 예측
 *            ---------------------------------------------------------- 머신러닝 / 딥러닝
 *                                                                      -------------
 *                                                                      |예측 => 프로그램 제작
 *         2) 기능 설정 : 목록/상세/예약/결제 .... 메소드
 *         ------------------------------------
 *         변수 + 메소드 => 한개의 기능 => 설계 (클래스) => 활용 => 객체
 *                | 기능이 변경 => 사용자가 요구 (오버라이딩)
 *         ------------- 객체에 의해 관리
 *        = 변수에 초기값 : 생성자 => 서버 / 데이터베이스 (미리 연결)
 *        = 변수를 활용 : 메소드 => 기능 (수정,추가) => 다형성 (오버로딩 / 오버라이딩)
 *     2. 접근지정어 => public / private / protected / default (접근 범위 지정) => 127page
 *     3. 상속 / 포함 => 재사용 기법
 *                     있는 그대로 사용 : 포함 => Spring => POJO
 *                     변경해서 사용 : 상속 => 윈도우 , 네트워크 , 스레드
 *     -------------------- 객체 지향의 3대 특성 (캡슐화,상속,다형성) => 면접 99%
 *     4. 클래스 종류
 *         ***= 일반 클래스
 *         = 추상 클래스
 *         ***= 인터페이스
 *         = 내부 클래스
 *            ***= 멤버 클래스
 *            ***= 익명의 클래스
 *            = 지역 클래스
 *         = 종단 클래스
 *     5. 조립법
 *         = 패키지 => 관련 클래스끼리 모아서 관리 : import
 *           ---- 폴더 java , javax
 *           
 *     6. 예외처리 : 프로그램의 비정상종료를 방지 , 사전에 에러 방지
 *                                       ------------
 *                                       파일 : 경로명,파일명
 *                                             
 *                                       네트워크 : URL / Server IP
 *                                               --- Jsoup
 *                                               
 *     ------------------------- 기본 문법(8장) => 프로그램 개발
 *     7. 라이브러리 (자바) , 외부에서 지원 (Jsoup, lombok)
 *                      ---------------------------
 *                      mvnrepository.com
 *      J2SE
 *     -------------------------------------------------------
 *     J2EE : 웹 개발=> JSP / Srvlet (기업용 환경)
 *     --------------------------------------- maven , spring-boot
 *     => 기본 이론 , 구현 => 웹(구현)
 *        ------- 면접
 *    1) 클래스의 구조 (설계)
 *    2) 객체 생성
 *       클래스명 변수명(객체) = new 클래스명()
 *              --------- 변수 , 메소드 => 동시에 관리 => 객체
 *    3) 객체 활용
 *       객체명.변수명 , 객체명.메소드명() ==> . (연결된 주소에 접속하는 연산자)
 *    4) 객체 소멸
 *       개체명 = null => 연결된 주소를 지워준다 ( 사용x => 가비지 컬렉션 대상
 *                                                --------- 주소가 null인 경우 , 사용하지 않는 경우
 *                                                --------- 메모리를 자동으로 회수
 *                                                
 *    --------------------------------------------------------------------------------------
 *    패키지가 만들어진 경우
 *    ----------------
 *     연결 (조립) => 접근의 문제
 *    ---------------------------------------- 접근 지정어
 *    --------------------------------------------------------------------------------------
 *                     자신의 클래스      같은 패키지     같은 패키지+상속(다른 패키지)        모든 클래스
 *    --------------------------------------------------------------------------------------
 *     ** private         O
 *    --------------------------------------------------------------------------------------
 *     ** default         O               O
 *    --------------------------------------------------------------------------------------
 *     protected          O               O                O                 
 *    --------------------------------------------------------------------------------------
 *     ** public          O               O                O                        O
 *    --------------------------------------------------------------------------------------
 *    
 *    ** 클래스 : public 으로 선언
 *    ** 메소드 : 다른 클래스와 통신 => public
 *    ** 변수 : 다른 클래스에 사용이 단되게 만든다 => private ==> 은닉화
 *             -------- 사용 할 수도 있다 => getter/setter
 *    ** 생성자 : 다른 클래스에서 메모리 담당 => public
 *    
 *    접근 범위의 크기
 *    private < default < protected < public
 *    
 *    1. 자바 프로그램은 모아서 관리
 *       -------------------
 *          1) 변수
 *          2) 연산자
 *          3) 제어문
 *          ------------- 문법 사항
 *          
 *          묶음 => 한개의 이름으로 제어
 *          1) 변수 => 여러개 (변수가 여러개 있는 경우 => 제어)
 *                    => 한개의 이름으로 제어가 가능하게 만든다
 *                    => 배열 => 이름은 1개 인덱스
 *                       단점) 고정적 , 연속적으로 메모리를 설정 => 같은 크기(데이터형)만 모아서 관리
 *                    => 보완 => 클래스 (.) => 다른 데이터형을 모아서 관리 (제한이 없다)
 *          2) 명령문 => 연산자/제어문 => 단점 (중복 , 다시 처음으로 돌아 갈 수 없다)
 *                     ----------------------------------------------
 *                     묶어서 사용 => 메소드
 *          -------------------------------------------------- + 클래스
 *             클래스
 *               => 변수만 묶어서 사용 : 사용자 정의 데이터형
 *               => 관련된 메소드만 묶어서 사용 : 액션 클래스
 *               => 변수 + 메소드 = 혼합 
 *             클래스 => 기능별로 다시 묶어서 사용
 *                     ---
 *                     게시판 / 회원가입 / 맛집 / 여행 ... 패키지 => 다른 패키지면 같은 이름의 클래스명 사용이 가능
 *                                                  ---
 *                                                  | 교보서적
 *                                                  | 헌책방
 */
class Sawon{
	private int hakbun;
	private String name;
	private String sex;
	// 읽기 getter / 쓰기 setter	
}
public class 접근지정어_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

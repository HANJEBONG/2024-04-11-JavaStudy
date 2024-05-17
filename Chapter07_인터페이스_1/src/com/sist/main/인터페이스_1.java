package com.sist.main;
/*
 *     1. 인터페이스란?
 *         => 추상클래스의 일종 => 특수한 클래스 => 상속시에 상위 클래스 역할
 *            ------------
 *            | 미완성된 클래스 => 상속을 내려서 구현해서 사용
 *              ----------
 *              | 자신이 메모리 할당을 할 수 없다
 *            => 추상클래스의 단점을 보완
 *               ----------------- 단일 상속 => 다중 상속으로 변경
 *               ----------------- 추상클래스는 구현된 메소드 / 구현이 안된 메소드 => 인터페이스 (구현이 안된 메소드만)
 *            => 역할
 *               1) 서로 다른 클래스를 연결해서 사용
 *               2) 관련 클래스를 묶어서 한개의 객체명으로 제어
 *               3) 설계와 관련 => 재사용 (기능 설계)
 *               4) -------------------------- 모든 개발자가 동일한 메소드를 재정의 : 표준화
 *                  표준화 : 라이브러리
 *                         System.out.println()
 *                         Math.random()
 *                         nextInt()
 *                  ----- 소스의 통일화 => 분석이 쉽다 : 유지보수가 쉽게 만들기 때문에
 *                        --------- 스프링
 *            => 요구사항 분석 => 인터페이스
 *            
 *            => 아이템 선정 => 참조할 사이트 (벤치마킹) => 기능 추출 / 필요한 데이터 추출
 *                                               |인터페이스 |크롤링 (사용자 정의 데이터형)
 *                                               ----------------
 *            => 사이트에 데이터 크롤링 => 오라클에 저장
 *               데이터베이스 설계 => 데이터 수집
 *            => 구현 => JSP / Spring
 *            => 테스트 => 오류 발생 여부 확인
 *            => 배포 => 발표
 *     2. 인터페이스의 구성요소
 *        [접근지정어] interface interface면
 *                 ----------
 *            | default / public => 다른 클래스를 묶어서 관리 => public
 *        {
 *            -----------------------------------
 *             변수 : => 상수
 *             int a; => 오류 발생
 *             int a=10; => 초기화를 반드시 한다
 *             => 생략
 *                (public static final) int a=10;
 *                          |           ----------
 *                      자동 추가
 *            -----------------------------------
 *             구현이 안된 메소드
 *             => void aaa();
 *                void bbb();
 *             => 생략
 *                (public abstract) void aaa();
 *                -----------------
 *                        |
 *                     자동 추가
 *            -----------------------------------
 *             JDK 1.8
 *             구현된 메소드
 *             => default void ccc()
 *                -------
 *                {
 *                    구현이 가능
 *                }
 *              => public default void ccc()
 *                 ------- 컴파일러에 의해서 자동으로 public 추가
 *              => 오버라이딩 : 접근지정어를 축소할 수 없다
 *            -----------------------------------
 *            *** 인터페이스는 상수 / 메소드 => public
 *            *** 단점
 *                => 관련된 클래스를 모아서 관리
 *                => 결합성이 낮은 프로그램
 *                   ---------------- 클래스와 클래스 연결 => 수정할때 에러부분
 *                   => 인터페이스는 고정 => 수정
 *                      --------------------> default 메소드 제공
 *        }
 *     3. 인터페이스의 장점
 *        => 기능 설계 => 메소드 설계 => 개발기간을 단축할 수 있다
 *        => 메소드가 동일하다 (모든 개발자가 동일한 메소드 구현) => 표준화 (분석하기 쉽다)
 *        => 인터페이스 한개로 여러개 클래스를 관리 할 수 있다
 *        => 유지보수가 쉽다
 *        => 독립적으로 사용이 가능 (클래스 == 클래스)
 *                                  | 리모콘의 역할을 수행한다 (원격)
 *                                  | 카페 
 *        => 면접 => 98%
 *        => 클래스가 여러개 (관련) => 게시판 , 갤러리 게시판 , 댓글 ... => 사이트 (게시판=> 4개)
 *                               ----------------------- CRUD
 *        => 결합성이 낮은 프로그램
 *        => 표준화 작업
 *        
 *     4. 인터페이스 상속 => 249page
 *        => 인터페이스와 인터페이스 상속
 *           interface A
 *           interface B extends A
 *                       -------
 *                       
 *           interface A
 *           interface B extends A
 *           interface C extends B
 *           -------------------------- 단일 상속
 *           
 *           interface A
 *           interface B
 *           interface C extends A,B
 *           -------------------------- 다중 상속
 *        => 인터페이스의 클래스 상속
 *           interface A
 *           class B implements A
 *                   ---------- A가 가지고 있는 메소드를 구현해서 사용한다
 *        => 다중 상속
 *           interface A
 *           interface B
 *           class C implements A,B
 *                   ----------
 *                   
 *           interface A
 *           interface B
 *           class C
 *           class D extends C implements A,B
 *                   -------   --------------
 *                     | 클래스 상속  | 인터페이스 상속
 *                     
 *           => 윈도우
 *           class A extends JFrame implements ActionListener,KetListener,MouseListener
 *                                            ------------------------------------------
 *                                            이벤트 (사용자의 행위) => 인터페이스로 제작되어 있다
 *           => 컬렉션 => interface로 되어 있다
 *           
 *           1. 클래스 상속 =====> extends
 *           2. 인터페이스 상속 ===> implements
 *           -------------------------------
 *                   extends (확장)
 *           ** 클래스 ======> 클래스
 *                     implements (구현)
 *           ** 인터페이스 =======> 클래스
 *                     extends
 *           ** 인터페이스 =====> 인터페이스
 *           ** 클래스 =====> 인터페이스 상속 ======> 존재하지 않는다
 *     5. 인터페이스 활용
 *     ---------------------------------> 객체지향의 마지막
 *     => 예외처리 (형식)
 *     => 라이브러리 (암기) => 메소드 => 기능 , 원형 (리턴형 / 매개변수)
 *        ------------ 컬렉션 (배열 대신) => 웹
 *                     | 고정이 아니다 => 갯수 => 제네릭스 (자동 형변환)
 *     => 웹 (데이터베이스 연동)
 *           ------------- 브라우저 => 데이터형 클래스
 *     => 틀을 만든다 : 스프링 (메인보드)
 *                  -------------- 스프링부트 (단점 => 교재)
 *     => AWS 에 호스팅 => 리눅스 명령어 약간
 *     
 *     * 웹 프로그램
 *       자바 : 변수 (데이터형) , 연산자 , 제어문
 *             = 묶어서 사용
 *               --------
 *               1) 명령문 묶기 => 메소드
 *               2) 변수 묶기 => 배열 (1차원) , 클래스
 *             = 객체지향프로그램 : 권장
 *               1) 데이터 보호 : 캡슐화 => getter/setter => 웹사이트 => 자주 데이터 추출
 *                             => 크롤링
 *               2) 인터페이스 : 클래스 여러개를 묶어서 관리 = 결합성이 낮은 프로그램
 *               3) 오버라이딩 => 인터페이스는 오버라이딩을 주로 사용
 *             = 프로그램이 비정상 종료 방지 : 예외처리
 *             = 사용자 정의 + 라이브러리 => 조립
 *               -------------------------- 사용처
 *             = 2차 자바 : 오라클 연동 => JDBC 
 *             = 3차 자바 : 웹 연동 => J2EE (JSP)
 *                                 ----------- JSP가 사라지는 느낌 : 타임리프 , VueJS
 *                                 => 1차 프로젝트
 *             = 4차 자바 : 스프링,스프링부트 : 어노테이션 / XML
 *                               => 2차 프로젝트
 *             = 서버단
 *               개인 프로젝트
 *               스프링부트 => React-Query
 *               -----------------------
 *               장고     => Redux
 *               --- 파이썬 => 예측 , 통계
 *               -----------------------
 */
interface 도형{
	String COLOR="black";
	// public static final String COLOR="black";
	// ------------------- 자동 추가
	// 그리다
	void draw();
	// public abstract void draw();
    
	
}
class 선 implements 도형{
	public void draw() {
		System.out.println("선을 그린다!!");
	}
}
class 사각 implements 도형{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그린다!!");
	}
	
}
public class 인터페이스_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		도형 b=new 사각();
		b.draw();
		
		b=new 선();
		b.draw();

	}

}

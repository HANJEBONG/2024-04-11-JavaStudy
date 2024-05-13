package com.sist.main;
/*
 *     상속을 내리는 클래스 : Super 클래스 , base 클래스 , 부모 클래스 , 상위 클래스
 *     상속 받는 클래스 : Sub 클래스 , 파생 클래스 , 자식 클래스 , 하위 클래스
 *     
 *     class 게시판
 *     {
 *         글쓰기()
 *         상세보기()
 *         검색()
 *         수정()
 *         추가()
 *         삭제()
 *     }
 *     class 묻고 답하기 extends 게시판
 *     {
 *         묻기() => 글쓰기 변경 => 오버라이딩
 *         답하기()
 *     }
 *     class 댓글 extends 게시판
 *     {
 *       
 *         댓글()
 *     }
 *     class 갤러리게시판 extends 게시판
 *     {
 *        
 *         파일업로드() => 이미지
 *     }
 */
public class MainClass_4 {
    static class Super{
    	int a;
    	int b;
    }
    static class Sub extends Super{
    	//int a,b;
    	int c;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        Super su=new Super();
//        System.out.println(su.a);
		Super su=new Sub(); // 가장 많이 사용되는 형태
		// 상위        하위
		// double     int
		Sub sub=(Sub)su;
		System.out.println(sub.a);
		// int  double
		// int a, b, c
		// 클래스에 따라 => 접근 변수가 달라진다
		// => 인터페이스 => 상위 클래스로 처리 => 형변환
		// 앞에 받는 클래스에 따라 접근할 수 있는 범위가 달라진다
	}
	

}

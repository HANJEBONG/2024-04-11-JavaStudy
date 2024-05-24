package com.sist.util;
/*
 *      ArrayList
 *      ---------
 *        1. 데이터 중복 허용 (오라클은 데이터 중복을 허용)
 *          ------------
 *          => 중복이 허용되면 구분자가 꼭 있어야 한다 : 인덱스로 구별 (자동 추가 , 자동 관리) => 0 ~ (순차적으로 만들어 준다)
 *             오라클
 *             ----
 *              => id , 게시물번호 , 영화번호 , 장바구니 번호
 *              => 중복이 없는 데이터 첨부 => PRIMARY KEY
 *              => 오라클은 자동으로 인덱스번호 추가가 안된다
 *        
 *        2. 기능 (메소드) => 라이브러리는 메소드
 *           ***1) 추가 => add(데이터)
 *           2) 수정 => set(int index , 데이터)
 *           3) 삭제 => remove(int index)
 *           ***4) 저장갯수 => size() => 댓글 , 장바구니 ...
 *           ***5) 읽기 => get(int index)
 *           ***6) 전체 삭제 : clear()
 *           ***7) 데이터 존재 여부 : isEmpty()
 *        3. ArrayList가 여러개인 경우
 *           영화목록 / 예약목록
 *           쇼핑목록 / 결제
 *           -----   --- 상품번호 / ID
 *           1. 상품명
 *           2. 가격...
 *           3. 상품번호
 *           ----------------------------------
 *           => retainAll() => 교집합
 *           => addAll()    => 전체복사
 *           => removeAll() => 차집합
 *           => subList()   => 부분적 복사
 *           ---------------------------------- JOIN , SUBQUERY => 여러개의 테이블 연동
 *        
 *        
 *        
 *        
 */
import java.util.*;
public class 컬렉션_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		list.add("홍길동");
		list.add("홍길동");
		list.add("짜장");
		list.add("짬뽕");
		list.add("홍길동");
		System.out.println("현재 저장된 갯수 :"+list.size());
		list.remove("홍길동");
		System.out.println("현재 저장된 갯수 :"+list.size());
	}

}

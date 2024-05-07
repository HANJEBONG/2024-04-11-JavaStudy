// 벤치마킹 => 프로그램에 맞는 데이터만 설정 => 메소드 설정
/*
 *     프로젝트
 *       => 모방 CGV
 *       => 상반된 부분 / 추가되는 내용
 *                      | 카페 / 술집 / 맛집
 *          --------------------
 *       => 캠핑장 예약
 *          --------- 맛집 / 레시피
 *       => 맛집
 *          --------- 근처 공원 , 명소 , 여행지...
 *       => 잡포탈
 *          --------- 자소서 쓰는 요령
 */
class Recipe{
	// 멤버 변수
	String title;
	String chef;
	String star;
	int hit;
}
// 레시피가 많은 경우
// Recipe[] r1=new Recipe[200]; => 데이터형이랑 배열 사용이 가능...
// 사용자 정의 데이터형 => 배열 / 형변환 => 일반 변수와 동일하게 취급
public class 클래스_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Recipe r1=new Recipe();
		r1.title="도시락 반찬으로 하죠! 스펨감자조림";
		r1.chef="냠냠간단요리";
		r1.star="★★★★★";
		r1.hit=46000;

	}

}

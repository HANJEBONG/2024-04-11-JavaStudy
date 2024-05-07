/*
 *    static / instance 변수의 차이점
 *    ------
 *    | 메모리 공간은 1개 생성 => 모모든 객체가 공유
 */
class Member{
	String name;
	String address;
}
class MemberSystem{
	Member[] members=new Member[3];
	//null,null,null
	int index=0;
}
public class 클래스_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberSystem ms1=new MemberSystem();
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="홍길동";
		ms1.members[ms1.index].address="서울";
		ms1.index++;
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="심청이";
		ms1.members[ms1.index].address="경기";
		ms1.index++;
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="석문수";
		ms1.members[ms1.index].address="인천";
		
		for(Member m:ms1.members) {
			System.out.println(m.name+","+m.address);
		}
		

	}

}

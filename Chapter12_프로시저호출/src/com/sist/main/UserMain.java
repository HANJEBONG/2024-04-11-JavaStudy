package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentDAO dao=StudentDAO.newInstance();
		List<StudentVO> list=new ArrayList<StudentVO>();
		for(StudentVO vo:list) {
			System.out.println(vo.getHakbun()+" "
					+vo.getName()+" "
					+vo.getKor()+" "
					+vo.getEng()+" "
					+vo.getMath());
		}
		System.out.println("=====================================");
		Scanner scan=new Scanner(System.in);
//		StudentVO vo=new StudentVO();
//		System.out.print("이름:");
//		String name=scan.next();
//		vo.setName(name);
//		
//		System.out.print("국어 영어 수학점수(90 90 90):");
//		vo.setKor(scan.nextInt());
//		vo.setEng(scan.nextInt());
//		vo.setMath(scan.nextInt());
//		dao.studentInsert(vo);
//		System.out.println("추가완료");
//		list=dao.studentAllData();
//		
//		for(StudentVO v:list) {
//			System.out.println(v.getHakbun()+" "
//					+v.getName()+" "
//					+v.getKor()+" "
//					+v.getEng()+" "
//					+v.getMath());
//		}
//		System.out.println("삭제할 학번:");
//		int hakbun=scan.nextInt();
//		dao.studentDelete(hakbun);
//		list=dao.studentAllData();
//		for(StudentVO vo:list) {
//			System.out.println(vo.getHakbun()+" "
//					+vo.getName()+" "
//					+vo.getKor()+" "
//					+vo.getEng()+" "
//					+vo.getMath());
//		}
		System.out.print("수정");
		StudentVO vo=new StudentVO();
		System.out.print("학번:");
		int hak=scan.nextInt();
		vo.setHakbun(hak);
		
		System.out.print("이름:");
		String name=scan.next();
		vo.setName(name);
		
		System.out.print("국어 영어 수학 (90 90 90):");
		vo.setKor(scan.nextInt());
		vo.setEng(scan.nextInt());
		vo.setMath(scan.nextInt());
		
		dao.studentUpdate(vo);
		list=dao.studentAllData();
		for(StudentVO v:list) {
			System.out.println(vo.getHakbun()+" "
					+vo.getName()+" "
					+vo.getKor()+" "
					+vo.getEng()+" "
					+vo.getMath());
		}
	}

}

package com.sist.user;
import java.util.*;
import com.sist.manager.MovieManager;
import com.sist.vo.*;
// 클라이언트 => 접속자 => 윈도우 , JSP , Spring , Kotlin => 화면 출력
public class UserMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		MovieManager m=new MovieManager(); 
        while(true) {
        	System.out.println("======== 메뉴 ========");
        	System.out.println("1.페이지보기");
        	System.out.println("2.검색으로 영화찾기");
        	System.out.println("3.영화 상세보기");
        	System.out.println("4.프로그램 종료");
        	System.out.println("=====================");
        	System.out.print("메뉴 선택:");
        	int menu=scan.nextInt();
        	if(menu==1) {
        		int total=m.movieTotalPage();
        		System.out.print("1~"+total+"페이지 입력:");
        		int page=scan.nextInt();
        		
        		Movie[] movie=m.movieListData(page);
        		
        		for(Movie mm:movie) {
        			System.out.println(mm.getRank()+"."+mm.getTitle());
        		}
        	}else if(menu==2) {
        		System.out.print("검색어 입력:");
        		String title=scan.next();
        		Movie[] movie=m.movieFindData(title);
        		for(Movie mm:movie) {
        			System.out.println(mm.getRank()+"."+mm.getTitle());
        		}
        	}else if(menu==3) {
        		System.out.print("상세 영화번호:");
        		int mno=scan.nextInt();
        		
        		Movie mmm=m.movieDetailData(mno);
        		System.out.println("순위: "+mmm.getRank());
        		System.out.println("제목: "+mmm.getTitle());
        		System.out.println("장르: "+mmm.getGenre());
        		System.out.println("포스터: "+mmm.getPoster());
        		System.out.println("배우: "+mmm.getActor());
        		System.out.println("개봉날짜: "+mmm.getRegdate());
        		System.out.println("등급: "+mmm.getGrade());
        		System.out.println("감독: "+mmm.getDirector());
        	}else if(menu==4) {
        		System.out.println("프로그램 종료");
        		break;
        	}else {
        		System.out.println("잘못된 입력입니다");
        	}
        }
	}

}

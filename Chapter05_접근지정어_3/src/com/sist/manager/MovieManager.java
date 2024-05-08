package com.sist.manager;
import com.sist.vo.*; // Movie

import java.io.FileReader;
// 패키지가 다르면 => import를 이용해서 클래스 읽기를 한다
/*
 *       접근지정어
 *      ------------------------------------------------------------------
 *        종류      자신의 클래스   같은 패키지                  모든 클래스
 *      ------------------------------------------------------------------
 *      **private      O
 *      ------------------------------------------------------------------
 *      default        O         O
 *      ------------------------------------------------------------------
 *      protected      O         O     +  다른 패키지 => 상속을 받은 경우
 *      ------------------------------------------------------------------
 *      **public       O         O                          O
 *      ------------------------------------------------------------------
 *      
 *      멤버변수 => 데이터 보호 목적 => private
 *        = 인스턴스
 *        = 정적 (공유)
 *      메소드 : 다른 클래스와 통신을 담당 (연결) => public
 *      클래스 : 메소드를 이용하거나 멤버변수를 사용 => 다른 클래스에서 사용 => 메모리 할당 => public
 *      생성자 : 메모리 할당시 호출 => public
 *      -----------------
 */
import java.util.*;
public class MovieManager {
    public static Movie[] movies=new Movie[1938]; // 자동으로 메모리 할당
    // static은 변경이 없는 경우
    // 데이터가 여러개일때 메모리 공간을 한개만 이용
    // 인스턴스변수는 각각 따로 저장 (new) => 보안 => private를 이용해서 저장 => 은닉화
    // 초기화
    /*
     *  생성자 : 초기화 => 인스턴스 변수에 대한 초기화
     *  초기화 블록 : static 블록을 사용하는것이 편리하다
     *  ----------------------------------------
     *  static은 new를 사용하지 않는다
     */
    //static에 대한 초기화 블록
    static { // 컴파일러에 의해 자동 처리 => 호출하지 않는다 (생성자는 호출해야한다)
    	try {
    		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
    		StringBuffer sb=new StringBuffer();
    		int i=0; //read() => char를 읽지 않고 ASC를 읽어 온다 => 문자 번호를 읽어온다
    		// A => 65 => i는 읽어온 정수를 저장할 변수 => char로 변환
    		while((i=fr.read())!=-1) {
    			sb.append((char)i);
    		}
    		fr.close(); // 파일 닫기
    		
    		//읽어온 데이터를 movies에 저장
    		String[] strMovie=sb.toString().split("\n"); // 한줄씩 배열에 저장
    		for(String movie:strMovie) {
    			String[] m=movie.split("\\|");
    			movies[i].setMno(m[0]);
    			movies[i].setTitle(m[1]);
    			movies[i].setGenre(m[2]);
    			movies[i].setPoster(m[3]);
    			movies[i].setActor(m[4]);
    			movies[i].setRegdate(m[5]);
    			movies[i].setGrade(m[6]);
    			movies[i].setDirector(m[7]);
    		}
    	}catch (Exception ex) {}
    	
    }
    public static Movie[] getMovieData(int page) {
    	int total=movieTotalPage();
    	int leng=20;
    	if(page==total)
    		leng=18;
    	Movie[] movie=new Movie[20];
    	
    	int j=0;
    	int rowSize =20;
    	int pagecnt=(page*rowSize)-rowSize;
    	for(int i=0;i<movies.length;i++) {
    		if(j<20 && i>=pagecnt) {
    			movie[j]=new Movie();
    			movie[j]=movies[i];
    			j++;
    		}
    	}
    	return movie;
    }
    static int movieTotalPage() {
    	return (int)(Math.ceil(movies.length/20.0));
    }
}

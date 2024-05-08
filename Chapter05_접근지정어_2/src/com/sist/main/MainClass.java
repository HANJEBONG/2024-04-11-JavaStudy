package com.sist.main;
import com.sist.vo.*;
// 클래스가 다른 패키지에 저장된 경우는 반드시 import를 이용해서 불러온다
/*
 *     private / public
 *     
 *     변수 => private => 데이터 공개 (x)
 *           => 접근이 가능하게 만든다
 *           => getXxx() , setXxx()
 *     메소드 / 클래스 / 생성자 => 다른 클래스에서 연결시 => public
 *     
 *     127 page 
 */
import java.util.*;
import java.sql.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//메모리에 저장
		java.sql.Date date=new java.sql.Date(0);
        Movie movie=new Movie();
        //데이터 초기화
        movie.setRank(1);
        System.out.println("순위:"+movie.getRank());
	}

}

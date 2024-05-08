package com.sist.vo;

import lombok.Data;

@Data
public class Movie {
    private int rank;
    private String title;
    private String actor;
    private String director;
    private String grade;
    private String genre;
    private String regdate;
    public Movie()
    {
    	System.out.println("Movie() Call... ");
    }
    /*
     *    실제 데이터값은 은닉화
     *    ---------- 읽기/변경 => 메소드를 이용해서 접근이 가능하게 만든다 : 캡슐화
     *    변수에 대한 기능을 부여
     *    ------------------ 읽기 / 쓰기
     *                   getXxx() setXxx()
     */
}

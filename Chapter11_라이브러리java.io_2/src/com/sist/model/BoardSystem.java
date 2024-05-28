package com.sist.model;
/*
 *     1. 목록 출력 => 검색 => SELECT ==> READ	
 *     2. 게시물 추가 => 추가 => INSERT ==> CREATE
 *     3. 상세보기 => 조건 => SELECT ==> READ
 *     4. 수정 => 수정 => UPDATE ==> UPDATE
 *     5. 삭제 => 삭제 => DELETE ==> DELETE
 *     ---------------------------------------- CRUD : 메모리 / 파일 / 데이터베이스
 *                                                     ----  ----  --------- 오라클
 *                                                     컬렉션   ObjectInput / Output
 */

import java.util.*;

import java.io.*;
public class BoardSystem {
	// 데이터 저장 => 모든 "사용자"가 공통으로 사용
	private static ArrayList<Board> list=new ArrayList<Board>();
	
	public BoardSystem() {
		Board b=new Board();
		b.setNo(1);
		b.setName("홍길동");
		b.setSubject("파일을 이용한 CRUD 배우기");
		// 프로그램 => 데이터 관리 (JSP,Spring,VueJS,ReactJS)
		// ==> 데이터분석 ===> 머신러닝 / 딥러닝 ===> AI
		b.setContent("파일을 이용한 CRUD => 데이터베이스(오라클):읽기,검색,추가,수정,삭제:메모리(컬렉션),파일,데이터베이스");
		b.setRegdate(new Date());
		b.setHit(0);
		b.setPwd("1234");
		list.add(b);
		boardGetData();
	}
	public void boardGetData() {
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(list); // 파일을 객체 단위로 저장
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	// 저장
	public void boardSave() {
		ObjectOutputStream oos=null;
		try {
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(list); // 파일을 객체 단위로 저장
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	public void boardInsert(Board board) {
		board.setNo(boardSequence()+1);
		list.add(board);
		boardSave();
	}
	// 목록 => 페이지 나누기 => ***면접 => 인라인뷰
	public ArrayList<Board> boardList(int page){
		 ArrayList<Board> bList=new ArrayList<Board>();
		   int j=0; // 10개씩 => j<10 => j++
		   int pagecnt=(page*10)-10; // 시작위치 
		   /*
		    *    (page*10)-10  => 1=>0
		    *                  => 2=>10   
		    *    1page => 0~9
		    *    2page => 10~19
		    *    3page => 20~29 
		    *    
		    *    WHERE rownum BETWEEN 1 AND 10 ORDER BY no DESC
		    */
		   ArrayList<Board> temp=
				   new ArrayList<Board>();
		   for(int i=list.size()-1;i>=0;i--)
		   {
			   temp.add(list.get(i));
		   }
		   // sort => 
		   for(int i=0;i<temp.size();i++)
		   {
			   
			   if(j<10 && i>=pagecnt)
			   {
				   Board b=temp.get(i);
				   bList.add(b);
				   j++;
			   }
		   }
		   return bList;
	}
	public int boardTotalpage() {
		// SELECT CEIL(COUNT(*)10.0) FROM board
		return (int)(Math.ceil(list.size()/10.0));
	}
	// 상세보기
	public Board boardDetail(int no) {
		Board board=new Board();
		for(Board b:list) {
			if(b.getNo()==no) {
				b.setHit(b.getHit()+1);
				board=b;
				boardSave();
				break;
			}
		}
		return board;
	}
	// 추가 => 게시물 / 장바구니 / 예약
	// 수정 => 장바구니 / 예약
	public void boardUpdate(int no,Board board) {
		int index=0;
		for(int i=0;i<list.size();i++) {
			Board b=list.get(i);
			if(b.getNo()==no) {
				index=i; // 인덱스 번호 구하기
				break;
			}
		}
		list.set(index, board);
		boardSave();
	}
	public Board boardUpdateData(int no) {
		Board board=new Board();
		
		for(Board b:list) {
			if(b.getNo()==no) {
				board=b;
				break;
			}
		}
		return board;
	}
	// 삭제 => 취소
	public void boardDelete(int no) {
		int index=0;
		for(int i=0;i<list.size();i++) {
			Board b=list.get(i);
			if(b.getNo()==no) {
				index=i;
				break;
			}
		}
		list.remove(index);
		// 파일에 다시 저장
		boardSave();
		/*
		 *     1. 메소드
		 *        = 기능 설정 => 기능에 관련된 명령문을 모아서 관련 => 재사용이 가능
		 *        = 반복을 제거
		 *        = 에러처리 , 수정이 편리하게 만든다
		 */
	}
	// 검색 => 영화 / 상품 / 게시물
	public ArrayList<Board> boardFind(String subject){
		ArrayList<Board> bList=new ArrayList<Board>();
		for(Board b:list) {
			if(b.getSubject().contains(subject)) {
				bList.add(b);
			}
		}
		return bList;
	}
	// sequence => 자동 증가번호
	public int boardSequence() {
		int max=0;
		try {
			// list 처음에는 null
			for(Board b:list) {
				if(b.getNo()>max) {
					max=b.getNo();
				}
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return max;
	}
}

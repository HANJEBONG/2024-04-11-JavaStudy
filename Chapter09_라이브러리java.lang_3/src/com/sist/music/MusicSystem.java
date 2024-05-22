package com.sist.music;
import java.io.*;
public class MusicSystem {
    // Music 데이터 공유 => 모든 유저가 같은 데이터를 사용하게 만든다
	private static Music[] musics=new Music[200];
	
	// 파일 읽기 => 데이터 저장
	// 클래스 영역에서는 사용이 불가능
	// 초기화
	static {
		FileReader fr=null;
		try {
			// CheckedException
			// 초기화블록은 throws는 사용이 불가능하다
			fr=new FileReader("c:\\javaDev\\genie.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			// 데이터 문자열 결합이 많은 경우 => StringBuffer / StringBulider
			//                              비동기           동기
			//                            ArrayList      Vector
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			String data=sb.toString();
			// 분리 \n
			String[] temp=data.split("\n");
			i=0;
			for(String s:temp) {
				String[] m=s.split("\\|"); // |=> 정규식 기호 => 일반문자로 연결 => \\|
				// 정규식 => . , + , * , | , ? , ^ , $
				musics[i]=new Music();
				musics[i].setMno(Integer.parseInt(m[0]));
				musics[i].setTitle(m[1]);
				musics[i].setSinger(m[2]);
				musics[i].setAlbum(m[3]);
				musics[i].setPoster(m[4]);
				musics[i].setKey(m[5]);
				i++;
			}
		}catch (Exception e) {
			// 에러 발생시 복구 => 확인
			e.printStackTrace(); // FileNotFoundException / IOException => Exception
		}finally{
			try {
				fr.close();
			}catch (Exception e) {}
		}
	}
	public int mucisTotalPage() {
		return (int)(Math.ceil(musics.length/20.0));
		//                올림함수 이용
	}
	public Music[] musicListData() {
		return musics;
	}
	public Music musicDetailData(int mno) {
		Music m=new Music();
		for(Music mm:musics) {
			if(mm.getMno()==mno) {
				m=mm;
				break;
			}
		}
		return m;
	}
	public Music[] musicFindData(String fd) {
		int count=0;
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) {
				count++;
			}
		}
		int i=0;
		Music[] mm=new Music[count];
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) {
				mm[i]=m;
				i++;
			}
		}
		return mm;
	}
}

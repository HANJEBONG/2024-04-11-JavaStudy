package com.sist.melon;

import java.io.FileReader;

public class MusicSystem {
	private static Music[] musics=new Music[100];
	static {
		FileReader fr=null;
		try {
			fr=new FileReader("c:\\javaDev\\Melon.txt");
			StringBuffer sb=new StringBuffer();
			int i=0;
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			i=0;
			String data=sb.toString();
			
			String[] temp=data.split("\n");
			for(String s:temp) {
				String[] m=s.split("\\|");
				musics[i]=new Music();
				musics[i].setMno(Integer.parseInt(m[0]));
				musics[i].setTitle(m[1]);
				musics[i].setSinger(m[2]);
				musics[i].setAlbum(m[3]);
				musics[i].setPoster(m[4]);
				i++;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				fr.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public Music[] musicListData() {
		return musics;
	}
	public Music musicDetailData(int mno) {
		Music m=new Music();
		
		for(Music mm:musics) {
			if(mno==mm.getMno()) {
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

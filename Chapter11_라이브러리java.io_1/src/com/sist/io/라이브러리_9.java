package com.sist.io;
// 파일 쓰기 => 문자 스트림 (2byte) => 한글 사용이 편리
// FileWriter
import java.io.*;
public class 라이브러리_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try {
			fw=new FileWriter("c:\\java_data\\board.txt"); // 없는 경우에는 자동 생성
			// 폴더는 생성하지 않는다
			String msg="ABCDEFGHIJKLMNOPQRSTUVWXYZ\r\n";
			fw.write(msg);
			System.out.println("저장완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(Exception ex2) {}
		}
	}

}

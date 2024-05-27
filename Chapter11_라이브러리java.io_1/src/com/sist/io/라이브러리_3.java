package com.sist.io;
import java.io.*;
public class 라이브러리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir=new File("c:\\java_project");
		/*if(!dir.exists()) {
			dir.mkdir();
			System.out.println("폴더 생성 완료!!");
		}else {
			System.out.println("이미 폴더가 만들어져있습니다!!");
		}*/
		if(dir.exists()) {
			dir.delete();
			System.out.println("폴더가 삭제되엇습니다");
		}else {
			System.out.println("존재하지 않는 폴더입니다");
		}
	}

}

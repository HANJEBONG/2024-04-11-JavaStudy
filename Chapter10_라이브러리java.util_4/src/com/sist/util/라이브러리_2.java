package com.sist.util;
import java.util.*;
import java.io.*;
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Properties 크랠스 생성 => CheckedException => 무조건 예외처리를 하고 사용
		try {
			Properties prop=new Properties(); // Map key=값 (key눈 중복할 수 없다)
			// 파일 읽기
			prop.load(new FileInputStream("c:\\java_data\\db.properties")); 
			// 값 읽기
			String driver=prop.getProperty("driver");
			String url=prop.getProperty("url");
			String username=prop.getProperty("username");
			String password=prop.getProperty("password");
			System.out.println("Driver:"+driver);
			System.out.println("URL:"+url);
			System.out.println("UserName:"+username);
			System.out.println("Password:"+password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Map 방식 => 구분자 , 값을 동시에 저장
	}

}

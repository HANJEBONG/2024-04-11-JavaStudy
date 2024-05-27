package com.sist.io;
/*
 *      File
 *      InputStream      OutputStream ============> 바이트 스트림
 *        |                  |
 *      FileInputStream  FileOUtputStream
 *        => 파일 읽기          => 파일 쓰기       => 1byte씩 읽어서 출력 / 입력
 *        => read()         => write()       => close()
 *        
 *      Reader        Writer ============> 문자 스트림
 *        |             |
 *      FileReader    FileWriter
 *        => 파일 읽기     => 파일 쓰기
 *        => read()     => write()      => 2byte씩 읽어서 출력 / 입력 => close()
 *      --------------------------------------------------- 한글이 포함된 데이터 입출력
 *       ** 한글은 한글자당 2byte 
 *       
 *      바이트 스트림 : 1byte 전송 (파일) => 파일업로드 , 네트워크 송수신 (인코딩 , 디코딩)
 *      문자 스트림 : 2byte 전송 (파일을 제어)
 *      필터 스트림 : 실제 하드디스크에 있는 모든 내용을 메모리에 올려놓고 시작 => 속도가 빠르다
 *      ----------- BufferedInputStream / BufferedOutputStream
 *      ----------- BufferedReader / BufferedWriter
 *      IO
 *         => 메모리 입출력
 *            ---------
 *              표준 입출력
 *                 System.out : 출력 => print() , println() printf()
 *                 System.in : 입력 => read()
 *                 ---------- 예외처리가 필요 , read() => 문자의 번호 (int)
 *         => 파일 입출력
 *         => 네트워크 입출력
 *         => 단점 : 단방향 통신을 한다
 *            -------------------- 읽기/쓰기 따로 만들어진다
 *            => 빨대
 *            => 만약에 양방향으로 통신 => 프로그램을 두개 동장 (읽기/쓰기)
 *                                  -------------- 쓰레드 (네트워크)
 */
//파일 입출력
import java.io.*;
public class 라이브러리_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//FileInputStream fis=null;
		FileReader fis=null; // 한글 포함 텍스트를 제어
		try {
			File file=new File("C:\\javaDev\\javaStudy\\Chapter11_라이브러리java.io_1\\src\\com\\sist\\io\\라이브러리_1.java");
			fis=new FileReader(file);
			int i=0; // 문자 번호를 읽어 온다 A => 65
			while((i=fis.read())!=-1) { // -1 EOF End Of File
				System.out.print((char)i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			// 정상수행 / 오류 발생 상관없이 무조건 수행하는 문장
			try {
				fis.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

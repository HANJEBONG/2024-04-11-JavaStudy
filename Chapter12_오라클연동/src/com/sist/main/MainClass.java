package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("동/읍/면 입력: ");
		String dong=scan.next();
		ZipcodeDAO dao=new ZipcodeDAO();
		ArrayList<ZipcodeVO> list=dao.postFind(dong);
		
		// 출력
		for(ZipcodeVO vo:list) {
			System.out.println(vo.getZipcode()+" "+vo.getAddress());
		}
	}

}

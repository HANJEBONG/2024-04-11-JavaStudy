package com.sist.main;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set_5 music=new Set_5();
		
		Set<String> genie=music.genieData();
		System.out.println("======================= 지니뮤직 =========================");
		for(String title:genie) {
			System.out.println(title);
		}
		
		Set<String> melon=music.melonData();
		System.out.println("======================= 멜론뮤직 =========================");
		for(String title:melon) {
			System.out.println(title);
		}
		System.out.println("================== 지니뮤직에만 있는 곡 =====================");
		Set<String> temp =new HashSet<String>();
		temp.addAll(genie);
		temp.removeAll(melon);
		for(String title:temp) {
			System.out.println(title);
		}
		System.out.println("================== 멜론에만 있는 곡 =====================");
		temp.clear();
		temp.addAll(melon);
		temp.removeAll(genie);
		for(String title:temp) {
			System.out.println(title);
		}
		System.out.println("=================== 지니뮤직+멜론 ======================");
		
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(genie);
		list.addAll(melon);
		
		for(String t:list) {
			System.out.println(t);
		}
         System.out.println("=================== 지니뮤직+멜론 (중복없이)======================");
		
		Set<String> list2=new HashSet<String>();
		list2.addAll(genie);
		list2.addAll(melon);
		
		for(String t:list2) {
			System.out.println(t);
		}

	}

}

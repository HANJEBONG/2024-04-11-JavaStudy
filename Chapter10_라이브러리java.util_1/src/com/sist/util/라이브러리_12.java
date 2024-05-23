package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		StringTokenizer st=new StringTokenizer(today,"-");
		int year=Integer.parseInt(st.nextToken());
		int month=Integer.parseInt(st.nextToken());
		int day=Integer.parseInt(st.nextToken());
		
		System.out.printf("%d년도 %d월 %d일\n",year,month,day);
		
		
		String[] strweek= {"일","월","화","수","목","금","토"};
		for(String s:strweek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1); // 0
		cal.set(Calendar.DATE, 1);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		week=week-1; // week=1
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			week++;
			if(week>6) {
				week=0;
				System.out.println();
			}
		}

	}

}

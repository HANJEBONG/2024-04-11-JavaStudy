package com.sist.util;
import java.text.*;
// DecimalFormet
public class 라이브러리_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
		int[] won= {1000,10000,1000000,100000};
		DecimalFormat df=new DecimalFormat("###,###,###");
		for(int i=0;i<won.length;i++) {
			System.out.println(df.format(won[i])+"원");
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

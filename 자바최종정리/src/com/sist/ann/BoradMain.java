package com.sist.ann;
import java.lang.reflect.Method;
import java.util.*;
public class BoradMain {
	public static void main(String args[]) throws Exception{
		Scanner scan=new Scanner(System.in);
		System.out.print("URL 주소 입력:");
		String url=scan.next();
		
		Class cls=Class.forName("com.sist.ann.BoradSystem");
		Object obj=cls.getDeclaredConstructor().newInstance();
		
		Method[] methods=cls.getDeclaredMethods();
		for(Method m:methods) {
			RequestMapping rm=m.getAnnotation(RequestMapping.class);
			if(url.equals(rm.value())){
				m.invoke(obj, null);
				break;
			}
		}
	}
}

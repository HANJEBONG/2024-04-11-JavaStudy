// 알파벳 10개 난수 => 버블 정렬 (DESC)
// 중복없는 알파벳

import java.util.*;

public class 중첩_for_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 알파벳 10개를 저장할 공간을 만든다
		char[] alpha=new char[10];
		// 알파벳 10개를 지정한다
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)(Math.random()*26+65);
			// 알파벳에 중복이 발생시 다시 지정한다
			for(int j=0;j<i;j++) {
				if(alpha[j]==alpha[i]) {
					i--; // 원상 복귀
					break;
				}
			}
		}
		System.out.println("정렬 전");
		// 배열 출력
		System.out.println(Arrays.toString(alpha));
		
		System.out.println("정렬 후");
		// 알파벳 비교 후 정렬
		for(int i=0;i<alpha.length-1;i++) {
			for(int j=0;j<alpha.length-(i+1);j++) {
				// 바로 다음 알파벳과 크기 비교 (만약 다음 알파벳보다 작다면 자리를 바꾼다)
				if(alpha[j]<alpha[j+1]) {
					char temp=alpha[j];
					alpha[j]=alpha[j+1];
					alpha[j+1]=temp;
				}
			}
		}
		System.out.println(Arrays.toString(alpha));
				

	}

}

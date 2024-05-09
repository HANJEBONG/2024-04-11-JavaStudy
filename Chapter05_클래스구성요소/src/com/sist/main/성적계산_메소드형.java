package com.sist.main;
// 국어,영어,수학 점수를 입력받아 => 메소드
// 총점 평균 학점 출력 => 4개
import java.util.*;
class Student{
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	//총점
	public int totalData(int kor,int eng,int math) {
		return kor+eng+math;
	}
	//평균
	public double avgData(int total) {
		return total/3.0;
	}
	//학점
	public char scoreData(int avg) {
		char a='A';
		switch(avg/10) {
		case 10:
		case 9:
			a='A';
			break;
		case 8:
			a='B';
			break;
		case 7:
			a='C';
			break;
		case 6:
			a='D';
			break;
		default:
			a='F';
		}
		return a;
	}
	public void print(int kor,int eng,int math,int total,double avg,char score) {
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+total);
		System.out.printf("평균:%.2f\n",avg);
		System.out.println("학점:"+score);
	}
	public void process() {
		int kor=input("국어");
		int eng=input("영어");
		int math=input("수학");
		int total=totalData(kor, eng, math);
		double avg=avgData(total);
		char score=scoreData((int)avg);
		
		print(kor,eng,math,total,avg,score);
	}
}
public class 성적계산_메소드형 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Student d=new Student();
		d.process();
	}

}

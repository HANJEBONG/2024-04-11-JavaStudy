package com.sist.io;
import java.io.*;
import java.util.*;
/*
 *     ObjectInputStream / ObjectOutputStream
 *     => 객체 단위 지정
 *       -----------
 *       직렬화              역직렬화
 *                       ----------
 *                         ------
 *                         ------
 *                         ------
 *                         ------
 *      ----------------------------
 *          |   |   |   |   |   |     => 직렬화
 *      ----------------------------
 */
class Student implements Serializable{
	private int hakbun;
	private String name;
	private int kor,eng,math;
	public Student(int hakbun, String name, int kor, int eng, int math) {
		super();
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public Student() {}
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
}
public class 라이브러리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(new Student(1,"홍길동",70,80,90));
		list.add(new Student(2,"이창",80,98,78));
		list.add(new Student(3,"가락국수",45,56,78));
		list.add(new Student(4,"짬뽕",45,66,68));
		list.add(new Student(5,"돈까스",46,80,90));
		// 객체 단위 저장 => list를 통으로 저장
		ObjectOutputStream oos=null;
		try {
			File file=new File("c:\\java_data\\std.txt");
			if(!file.exists()) {
				file.createNewFile();
			}
			// ObjectOutputStream => FileOutputStream 객체를 매개변수로 전송
			FileOutputStream fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos);
			// 객체단위 파일 저장
			oos.writeObject(list);
			System.out.println("객체단위 저장 완료!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

}

package com.sist.set;
import java.util.*;
class Student{
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public Student() {
		
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (name+age).hashCode(); // 메모리 주소
		// 같은 변수면 같은 헤쉬코드를 리턴해라
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Student) {
			// instanceof => 객체비교
			// 오른쪽이 크거나 같으면 true
			// 객체명 instanceof 클래스
			Student s=(Student)obj;
			return name.equals(s.name) && age==s.age;
		}
		return false;
	}
	
}
public class Set_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> set=new HashSet<Student>();
		Student s1=new Student("홍길동",20);
		Student s2=new Student("홍길동",20);
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		set.add(s1);
		set.add(s2);
		
		for(Student ss:set) {
			System.out.println(ss.getName()+","+ss.getAge());
		}
		
		String ss="";
		Object obj=new Object();
		StringBuffer sb=new StringBuffer();
		if (ss instanceof Object) {
			System.out.println("String은 Object보다 작다");
		}
		if(obj instanceof String) {
			System.out.println("Object는 String보다 작다");
		}
		if(sb instanceof Object) {
			System.out.println("StringBuffer는 Object보다 작다");
		}
		/*
		 *        Object
		 *          |
		 *      --------------------------
		 *      |                        |
		 *     String                StringBuffer
		 *     ---------------------------------- 비교가 불가능 => 클래스 비교 (상속,포함)
		 *        상속 : 상속을 내리는 클래스 > 상속을 받는 클래스
		 *     ----------------------------------
		 *        포함 : 
		 */
		
	}

}

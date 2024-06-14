package com.sist.server;
class myThread extends Thread{
	// Thread 사용시 => run()에서 동작 구현
	public void run() {
		try {
			for(int i=1;i<=10;i++) {
				System.out.println(i+":"+getName());
				Thread.sleep(200);
			}
		}catch(Exception ex) {}
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myThread m1=new myThread(); // Thread - 0
		myThread m2=new myThread(); // Thread - 1
		myThread m3=new myThread(); // Thread - 2
		
		m1.start();
		m2.start();
		m3.start();
	}

}

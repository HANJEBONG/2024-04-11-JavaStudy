package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.dao.*;
/*
 *    Server
 *      1. 접속을 받는 클래스 => 접속을 받아서 클라이언트 정보 저장
 *      							  ---------- IP , PORT (연결)
 *      							  --------------------------
 *      							  IP => 전화번호 , PORT => 전화선
 *                                    --------------------------- 전화기 => 소켓
 *      2. 접속된 클라이언트마다 통신담당 클래스
 *         ------------- 따로 제작 => 한번에 제작 여러개가 동시에 수행 => 쓰레드
 *         
 *      => 자바 : 두개 쓰레드 => 시 분할
 *      		main / gc
 */
public class Server implements Runnable{
	// 접속담당 => 교환 소켓
	/*
	 *      1. ServerSokcet을 생성
	 *         -------------
	 *            bind ==> 연결 => 전화기 개통
	 *            				  -------- 전화/전화선 매칭
	 *            			bind(ip,port)
	 *            listen => 대기상태
	 *      2. 대기중에 클라이언트 접속
	 *         -----------------
	 *           accept() => 사용자 정보를 수집 => 메모리에 저장
	 *                       ------------
	 *                       | 쓰레드 매칭후에 통신	                        
	 *      3. 종료 요청시에는
	 *         Thread 종료
	 */
	/*
	 *      결정 : 서버 컴퓨터 , 연결선 (숫자) => 0~65535
	 *                                    -------- 0~4156 사용중
	 *                                    21 => FTP
	 *                                    23 => TELNET
	 *                                    25 => SMTP
	 *                                    80 => 웹
	 *                                    8080 => 프록시
	 *                                    1521 => 오라클
	 *                                    1433 => MSSQL
	 *                                    4000 => 머드서버
	 *                                    3306 => MySQL / MariaDB
	 */
	private ServerSocket ss;
	private final int PORT=11010;
	// 클라이언트의 네트워크 정보 저장 => IP , PORT , id , name , sex
	//                                       --- Oracle 에서 정보를 가지고 온다
	private Vector<Client> waitVC=new Vector<Client>();
	public Server() {
		try {
			ss=new ServerSocket(PORT); // 개통 (PORT , 값(디폴트 : 50))
			System.out.println("Server Start...");
			// 클라이언트 접속을 대기 ...
			// 50명까지만 접속이 가능
			// TomCat => Web Server (50명)
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 접속시에 클라이언트 정보 확인 => 정보 저장
	// Thread가 동작하는 메소드
	public void run() {
		try {
			while(true) {
				// 접속이 된 경우
				Socket s=ss.accept(); // 접속자의 IP를 받아서 저장
				// Socket => 클라이언트의 정보가 들어가있다(ip,port)
				/*
				 *   서버 : ServerSocket => PORT : 고정
				 *   클라이언트 : Socket => PORT 자동 설정
				 */
				/*
				System.out.println("IP : "+s.getInetAddress().getHostAddress());
				System.out.println("PORT : "+s.getPort());
				// 서버에서 클라이언트로 값을 보냄
				OutputStream out=s.getOutputStream();
				out.write("서버에 접속됐습니다!!\n".getBytes());
				*/
				Client client=new Client(s);
				waitVC.add(client);
				client.start();
			}
		} catch (Exception e) {
			
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start();
	}
	// 통신 담당
	// 프로그램안에서 여러개의 프로그램을 동시 수행 => 프로세스 => 여러개 쓰레드가 동시 수행
	// => 서버가 가지고 있는 모든 변수/메소드를 마음대로 사용할 수 있다
	// => 한개의 검퓨터에서 Server는 1개 동작이 가능
	// Server => 고정 IP를 가지고 있어야 한다
	class Client extends Thread{
		String id;
		Socket s;
		OutputStream out; // 클라이언트 전송
		BufferedReader in; // 클라이언트 요청 받기
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 통신 역할
		public void run() {
			try {
				while(true) {
					// 1. 클라이언트 요청값을 받는다
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					// 2. 서버에서 응답
					for(Client client:waitVC) {
						client.out.write((msg+"\n").getBytes());
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}

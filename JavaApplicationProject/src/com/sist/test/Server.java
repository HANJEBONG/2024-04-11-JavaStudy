package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;

import com.sist.commons.Function;
import com.sist.dao.*;
public class Server implements Runnable{
	// 접속 담당
	private ServerSocket ss;
	// 포트번호=> 0~ 65535 0~1023
	private final int PORT=11010;
	private MemberDAO dao;
	// 저장공간 (접속자)
	private Vector<Client> waitVc=new Vector<Client>();
	public Server() {
		// 시작과 동시에 서버 구동
		try {
			ss=new ServerSocket(PORT);
			dao=MemberDAO.newInstance(); // 데이터베이스 객체
			System.out.println("Server Start...");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	// 접속시 접속자 정보 저장
	public void run() {
		while(true) {
			try {
				Socket s=ss.accept();
				// 접속이 된 경우에만 호출
				// s=> 클라이언트 정보 => 발신자 정보 => IP,PORT
				Client client=new Client(s);
				// 통신을 시작
				client.start();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server=new Server();
		new Thread(server).start(); // run 호출
	}
	/*
	 *     클래스의 종류
	 *       = 추상 클래스
	 *       = 보완 => 인터페이스
	 *       = 내부 클래스
	 *         --------- 클래스의 메모리 할당 없이 모든 변수 / 메소드에 접근 가능
	 *         1) 멤버 클래스 : 네트워크 , 쓰레드 ...
	 *            class A
	 *            {
	 *               데이터
	 *               class B
	 *               {
	 *                  A가 가지고 있는 모든 데이터를 공유
	 *               }
	 *            }
	 *         2) 익명의 클래스 : 스프링 , 데이터 분석
	 *            => 상속 없이 오버라이딩이 가능 => 생성자에서 메소드 변경 , 메소드 추가
	 */
	// 통신
	class Client extends Thread{
		Socket s; // 클라이언트와 통신하는 통신 기기
		OutputStream out; // 클라이언트에게 전송
		BufferedReader in; // 클라이언트로부터 요청값 받기
		// 개인 정보
		String id,name,sex,pos,admin;
		public Client(Socket s) {
			// 변수 초기화
			try {
				this.s=s;
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				out=s.getOutputStream();
				
				// 네트워크 전송 => 1byte로 전송
				// 값을 받는 경우는 => 2byte로 받는다
				// 1->2 로 변경해서 받는 클래스 : 필터 스트림
				// InputStreamReader
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		// 통신을 시작
		public void run() {// 클라이언트마다 따로 동작을 한다 => 쓰레드
			while(true) {
				try {
					// 클라이언트의 요청값을 받는다
					String msg=in.readLine();
					StringTokenizer st=new StringTokenizer(msg,"|");
					// 100|id
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol) {
					case Function.LOGIN:{
						// id를 받는다
						id=st.nextToken();
						// 정보
						MemberVO vo=dao.memberInfo(id);
						name=vo.getName();
						sex=vo.getSex();
						pos="대기실";
						admin=vo.getAdmin();
						
						// 이미 접속된 회원에게 지금 접속한 회원의 정보를 전송
						messageALL(Function.LOGIN+"|"+id+"|"+name+"|"+sex+"|"+pos+"|"+admin);
						messageALL(Function.CHAT+"|[☞알림]"+name+"님이 입장하셧습니다");
						// 서버에 저장
						waitVc.add(this);
						
						// 1. 창 갱신
						messageTO(Function.MYLOG+"|"+id+"|"+name);
						// 2. 이미 접속된 회원의 모든 정보를 받는다
						for(Client client:waitVc) {
							messageTO(Function.LOGIN+"|"+client.id+"|"+client.name+"|"+client.sex+"|"+client.pos+"|"+client.admin);
						}
						// 3. 개설된 방정보
					}
					break;
					// 나가기 요청
					/*
					 *     로그인
					 *     ------
					 *         로그인 하는 사람 => MYLOG
					 *         로그인 된 사람 => LOGIN
					 *     나가기
					 *     --------
					 *         로그인 하는 사람 => EXIT
					 *         실제 나가는 사람 => MYEXIT
					 */
					case Function.EXIT:{ // 나기기 처리
						messageALL(Function.EXIT+"|"+id); // 테이블에서 제거
						messageALL(Function.CHAT+"|[☞알림]"+name+"님이 퇴장하셨습니다");
						// 남아있는 사람 처리
						for(Client client:waitVc) {
							if(client.id.equals(id)) {
								messageTO(Function.MYEXIT+"|"); // 윈도우창 종료
								waitVc.remove(client);
								in.close();
								out.close();
							}
						}
					}
					break;
					case Function.CHAT:{
						String message=st.nextToken();
						messageALL(Function.CHAT+"|["+name+"]"+message);
					}
					break;
					/*
					 *  클라이언트 : 요청 / 응답 출력
					 *  서버 : 요청받기
					 *        응답하기
					 *        저장하기
					 *        수정기능
					 *        삭제기능
					 *        찾기기능
					 */
					case Function.INFO:{
						String yid=st.nextToken();
						MemberVO vo=dao.memberInfo2(yid);
						messageTO(Function.INFO+"|"
								+vo.getName()+"|"
								+vo.getSex()+"|"
								+vo.getAddr1()+"|"
								+vo.getPhone()+"|"
								+vo.getContent()+"|"
								+vo.getEmail());
						
					}
					break;
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		// 접속자 전체로 전송
		public synchronized void messageALL(String msg) {
			// synchronized => 동기화 (한명씩 전송) 터지지 않기위해
		
				try {
					for(Client client:waitVc) {
						client.messageTO(msg);
					}
				}catch(Exception ex) {}
			
		}
		// 접속자에게만 전송
		public synchronized void messageTO(String msg) {
			try {
				out.write((msg+"\n").getBytes());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}

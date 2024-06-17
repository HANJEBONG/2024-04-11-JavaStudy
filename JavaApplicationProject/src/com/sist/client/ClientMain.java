package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.sist.commons.Function;
import com.sist.dao.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;
public class ClientMain extends JFrame implements ActionListener,MouseListener,Runnable{
	CardLayout card=new CardLayout();
	MenuPanel mp=new MenuPanel();
	LoginPanel lp=new LoginPanel();
	ControlPanel cp=new ControlPanel();
	JoinPanel jp=new JoinPanel();
	PostFindFrame post=new PostFindFrame();
	IdCheckFrame idfrm=new IdCheckFrame();
	// 네트워크에 필요한 객체
	Socket s;
	OutputStream out;
	BufferedReader in;
	String myid;
	/*
	 * 	1. 클라이언트 : 서버의 정보 (IP,PORT)
	 * 	-- PORT 는 자동 생성 => 유동이 가능
	 * 2. 서버 : 클라이언트의 정보
	 * 		-- PORT/IP을 직접 생성
	 */
	// 개인마다 필요한 변수
	public ClientMain() {
		setLayout(null);
		
		mp.setBounds(300,15,600,35);
		add(mp);
		cp.setBounds(10,60,930,600);
		add(cp);
		
		
		setTitle("냐옹");
		setSize(960 , 750);
		//setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		lp.loginBtn.addActionListener(this); // 로그인
		lp.joinBtn.addActionListener(this); // 회원가입
		lp.cancelBtn.addActionListener(this); // 종료
		mp.exitBtn.addActionListener(this);
		jp.b2.addActionListener(this);// 우편번호 검색
		jp.b4.addActionListener(this);// 취소
		
		post.b1.addActionListener(this); // 우편번호 검색 버튼
		post.b2.addActionListener(this); // 취소
		post.tf.addActionListener(this); // 우편번호 입력창
		post.table.addMouseListener(this);
		
		jp.b1.addActionListener(this); // 아이디 중복체크
		jp.b3.addActionListener(this);
		
		idfrm.b1.addActionListener(this);
		idfrm.b2.addActionListener(this);
		
		mp.exitBtn.addActionListener(this);
		mp.chatBtn.addActionListener(this);
		mp.homeBtn.addActionListener(this);
		
		cp.chatp.tf.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jcom.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (Exception e) {
			// TODO: handle exception
		}
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==lp.cancelBtn) {
			dispose();
			System.exit(0);
		}else if(e.getSource()==jp.b1) {
			idfrm.tf.setText("");
			idfrm.b2.setVisible(false);
			idfrm.la3.setText("");
			idfrm.setVisible(true);
		}else if(e.getSource()==idfrm.b1){
			String id=idfrm.tf.getText();
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요"); // alret()
				idfrm.tf.requestFocus();
				return;
			}
			// 입력된 상태
			// 오라클 연결
			MemberDAO dao=MemberDAO.newInstance();
			int count=dao.memberIdCheck(id);
			
			if(count==0) {
				idfrm.la3.setText(id+"는(은) 사용 가능한 아이디입니다");
				idfrm.b2.setVisible(true);
			}else {
				idfrm.la3.setText(id+"는(은) 이미 사용중인 아이디입니다");
				idfrm.b2.setVisible(false);
				idfrm.tf.setText("");
				idfrm.tf.requestFocus();
			}
		}else if(e.getSource()==idfrm.b2){
			String id=idfrm.tf.getText();
			jp.idtf.setText(id);
			idfrm.setVisible(false);
		}else if(e.getSource()==lp.loginBtn) {
			// 1. 입력한 사번 / 이름을 가지고 온다
			try {
				// 유효성 검사
				String id=lp.tf.getText();
				if(id.length()<1) {
					JOptionPane.showMessageDialog(this, "아이디를 입력해라");
					lp.tf.requestFocus();
					return;
				}
				String name=String.valueOf(lp.pf.getPassword());
				if(name.length()<1) {
					JOptionPane.showMessageDialog(this, "비밀번호를 입력해라");
					lp.pf.requestFocus();
					return;
				}
				// 오라클 연결
				MemberDAO dao=MemberDAO.newInstance();
				String result=dao.memberLogin(id, name.toUpperCase());
				if(result.equals("NOID")) {
					// 사번이 없는경우
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않는다");
					lp.tf.setText("");
					lp.pf.setText("");
					lp.tf.requestFocus();
				}else if(result.equals("NOPASSWORD")) {
					// 이름이 틀린경우
					JOptionPane.showMessageDialog(this, "비밀번호가 틀리다");
					lp.pf.setText("");
					lp.pf.requestFocus();
				}else {
					try {
						s=new Socket("192.168.0.104",11010); // 조별 사용
						out=s.getOutputStream();
						in=new BufferedReader(new InputStreamReader(s.getInputStream()));
						out.write((Function.LOGIN+"|"+id+"\n").getBytes());
					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
					}
					new Thread(this).start();;
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "사번은 정수여야 합니다..");
				return; // 메소드 종료
			}
			
		}else if(e.getSource()==mp.exitBtn) {
			dispose();
			System.exit(0);
		}else if(e.getSource()==lp.joinBtn) {
			jp.setVisible(true);
			lp.setVisible(false);
		}else if(e.getSource()==jp.b2) {
			for(int i=post.model.getRowCount()-1;i>=0;i--) {
				post.model.removeRow(i);
			}
			post.tf.setText("");
			post.setVisible(true);
		}else if(e.getSource()==jp.b4) {
			jp.setVisible(false);
			lp.setVisible(true);
		}else if(e.getSource()==post.b1||e.getSource()==post.tf) {
			String dong=post.tf.getText();
			if(dong.length()<1) {
				JOptionPane.showMessageDialog(this, "동/읍/면을 입력하세요");
				post.tf.requestFocus();
				return;
			}
			MemberDAO dao=MemberDAO.newInstance();
			ArrayList<ZipcodeVO> list=dao.postFindData(dong);
			if(list.size()==0) {
				JOptionPane.showMessageDialog(this, "검색결과가 없습니다");
				post.tf.setText("");
				post.tf.requestFocus();
				return;
			}else {
				for(int i=post.model.getRowCount()-1;i>=0;i--) {
					post.model.removeRow(i);
				}
				for(ZipcodeVO vo:list) {
					String[] data= {vo.getZipcode(),vo.getAddress()};
					post.model.addRow(data);
				}
			}
		}else if(e.getSource()==post.b2) {
			post.setVisible(false);
		}else if(e.getSource()==jp.b3) {
			String id=jp.idtf.getText();
			if(id.length()<1) {
				jp.idtf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(jp.pf.getPassword());
			if(id.length()<1) {
				jp.pf.requestFocus();
				return;
			}
			String name=jp.nametf.getText();
			if(id.length()<1) {
				jp.nametf.requestFocus();
				return;
			}
			String sex=" ";
			if(jp.rb1.isSelected()) {
				sex="남자";
			}else {
				sex="여자";
			}
			String birth=jp.birthtf.getText();
			if(birth.length()<1) {
				jp.birthtf.requestFocus();
				return;
			}
			String post=jp.posttf.getText();
			if(post.length()<1) {
				jp.posttf.requestFocus();
				return;
			}
			String addr1=jp.addrtf1.getText();
			if(addr1.length()<1) {
				jp.addrtf1.requestFocus();
				return;
			}
			String phone1=jp.box.getSelectedItem().toString();
			String phone2=jp.teltf.getText();
			if(phone2.length()<1) {
				jp.teltf.requestFocus();
				return;
			}
			String phone=phone1+")"+phone2;
			String email=jp.emailtf.getText();
			if(email.length()<1) {
				jp.emailtf.requestFocus();
				return;
			}
			String addr2=jp.addrtf2.getText();
			String content=jp.cta.getText();
			// phone => NOT NULL => 반드시 입력....
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setSex(sex);
			vo.setBirthday(birth);
			vo.setPost(post);
			vo.setAddr1(addr1);
			vo.setAddr2(addr2);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setContent(content);
			
			MemberDAO dao=MemberDAO.newInstance();
			String res=dao.memberInsert(vo);
			
			if(res.equals("yes")) {
				JOptionPane.showMessageDialog(this, "회원가입을 축하합니다...");
				jp.setVisible(false);
				lp.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다...\n"+res);
			}
		}else if(e.getSource()==cp.chatp.tf) {
			String msg=cp.chatp.tf.getText();
			if(msg.length()<1) {
				return;
			}
			String color=cp.chatp.box1.getSelectedItem().toString();
			try
			{
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());
			}catch(Exception ex){}
			
			cp.chatp.tf.setText("");
			cp.chatp.tf.requestFocus();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==post.table) {
			if(e.getClickCount()==2) {
				int row=post.table.getSelectedRow();
				String zip=post.model.getValueAt(row, 0).toString();
				String addr=post.model.getValueAt(row, 1).toString();
				
				jp.posttf.setText(zip);
				jp.addrtf1.setText(addr);
				
				
				post.setVisible(false);
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int delimit=Integer.parseInt(st.nextToken());
				switch(delimit) {
				case Function.LOGIN:{
					String[] data= {st.nextToken(),st.nextToken(),st.nextToken()};
					cp.chatp.model.addRow(data);
					String admin=st.nextToken();
					
					if(!myid.equals(data[0])&&admin.equals("y")) {
						cp.chatp.box2.addItem(data[0]);
					}
				}
				break;
				case Function.MYLOG:{
					myid=st.nextToken();
					String name=st.nextToken();
					setTitle(name+"님의 채팅창");
					lp.setVisible(false);
					setVisible(true);
				}
				break;
				case Function.CHAT:{
					String message=st.nextToken();
					String color=st.nextToken();
					cp.chatp.initStyle();
					
					cp.chatp.append(message, color);
				}
				break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

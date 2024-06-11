package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.sist.dao.*;
import javax.swing.*;
public class ClientMain extends JFrame implements ActionListener{
	CardLayout card=new CardLayout();
	LoginPanel lp=new LoginPanel();
	MainPanel mp=new MainPanel();
	ControlPanel cp=new ControlPanel();
	JoinPanel jp=new JoinPanel();
	PostFindFrame post=new PostFindFrame();
	public ClientMain() {
		setLayout(card);
		
		add("LOGIN",lp);
		add("MP" , mp);
		add("JOIN", jp);
		
		setTitle("냐옹");
		setSize(960 , 750);
		setVisible(true);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		lp.loginBtn.addActionListener(this); // 로그인
		lp.joinBtn.addActionListener(this); // 회원가입
		lp.cancelBtn.addActionListener(this); // 종료
		mp.mp.exitBtn.addActionListener(this);
		jp.b2.addActionListener(this);// 우편번호 검색
		jp.b4.addActionListener(this);// 취소
		
		post.b1.addActionListener(this); // 우편번호 검색 버튼
		post.b2.addActionListener(this); // 취소
		post.tf.addActionListener(this); // 우편번호 입력창
		
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
				}else if(result.equals("OK")){
					// 로그인
					System.out.println("로그인 완료");
					card.show(getContentPane(),"MP");
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "사번은 정수여야 합니다..");
				return; // 메소드 종료
			}
			
		}else if(e.getSource()==mp.mp.exitBtn) {
			dispose();
			System.exit(0);
		}else if(e.getSource()==lp.joinBtn) {
			card.show(getContentPane(),"JOIN");
		}else if(e.getSource()==jp.b2) {
			for(int i=post.model.getRowCount()-1;i>=0;i--) {
				post.model.removeRow(i);
			}
			post.tf.setText("");
			post.setVisible(true);
		}else if(e.getSource()==jp.b4) {
			card.show(getContentPane(),"LOGIN");
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
		}
	}

}

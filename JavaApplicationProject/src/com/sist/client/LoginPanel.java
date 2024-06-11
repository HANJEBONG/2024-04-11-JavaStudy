package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class LoginPanel extends JPanel{
	Image back;
	JLabel idLa,pwdLa;
	JTextField tf;
	JPasswordField pf;
	JButton loginBtn , joinBtn , cancelBtn;
	// 스킨 => 이미지배경 =>
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
	}

	public LoginPanel() {
		back=Toolkit.getDefaultToolkit().getImage("c:\\javaDev\\back.jpeg");
		
		idLa=new JLabel("아이디",JLabel.RIGHT);
		pwdLa=new JLabel("비밀번호",JLabel.RIGHT);
		
		tf=new JTextField();
		pf=new JPasswordField();
		
		loginBtn=new JButton("로그인");
		joinBtn=new JButton("회원가입");
		cancelBtn=new JButton("종료");
		
		// 배치
		setLayout(null);
		idLa.setBounds(650, 545, 80, 30);
		tf.setBounds(735,545,180,30);
		add(idLa); add(tf);
		
		pwdLa.setBounds(650, 580, 80, 30);
		pf.setBounds(735,580,180,30);
		add(pwdLa); add(pf);
		
		JPanel p=new JPanel();
		p.add(loginBtn);
		p.add(joinBtn);
		p.add(cancelBtn);
		p.setOpaque(false);
		
		p.setBounds(650,620,265,35);
		add(p);
	}
}
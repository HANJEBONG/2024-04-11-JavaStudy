package com.sist.user;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardUpdate extends JPanel{
	JLabel titleLa,nameLa,subLa,contLa,pwdLa,noLa;
	JTextField nameTf,subTf;
	JPasswordField pwdPf;
	JTextArea ta;
	JButton b1,b2;
	public BoardUpdate() {
		titleLa=new JLabel("수정하기",JLabel.CENTER);
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30));
		setLayout(null);
		titleLa.setBounds(10,15,620,50);
		add(titleLa);
		
		noLa=new JLabel();
		noLa.setBounds(150,70,20,30);
		add(noLa);
		noLa.setVisible(false);
		
		nameLa=new JLabel("이름",JLabel.CENTER);
		nameTf=new JTextField();
		nameLa.setBounds(10,70,80,30);
		nameTf.setBounds(95,70,450,30);
		add(nameTf); add(nameLa);
		
		subLa=new JLabel("글쓰기",JLabel.CENTER);
		subTf=new JTextField();
		subLa.setBounds(10,105,80,30);
		subTf.setBounds(95,105,450,30);
		add(subLa);add(subTf);
		
		contLa=new JLabel("내용",JLabel.CENTER);
		ta=new JTextArea();
		JScrollPane js=new JScrollPane(ta);
		contLa.setBounds(10,140,80,30);
		js.setBounds(95,140,450,250);
		add(contLa); add(js);
		
		pwdLa=new JLabel("비밀번호",JLabel.CENTER);
		pwdPf=new JPasswordField();
		pwdLa.setBounds(10,395,80,30);
		pwdPf.setBounds(95,395,150,30);
		add(pwdLa);add(pwdPf);
		
		b1=new JButton("수정하기");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(10, 435, 535, 35);
    	add(p);
}
}

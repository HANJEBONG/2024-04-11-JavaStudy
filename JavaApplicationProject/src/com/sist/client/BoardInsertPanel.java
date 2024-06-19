package com.sist.client;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;

public class BoardInsertPanel extends JPanel implements ActionListener{
	JLabel titleLa,nameLa,subLa,contLa,pwdLa;
	JTextField nameTf,subTf;
	JPasswordField pwdPf;
	JTextArea ta;
	JButton b1,b2;
	ControlPanel cp;
	BoardDAO dao;
	public BoardInsertPanel(ControlPanel cp) {
		this.cp=cp;
		dao=BoardDAO.newInstance();
		titleLa=new JLabel("글쓰기",JLabel.CENTER);
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30));
		setLayout(null);
		titleLa.setBounds(10,15,620,50);
		add(titleLa);
		
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
		
		b1=new JButton("글쓰기");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(10, 435, 535, 35);
    	add(p);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2) {
			cp.card.show(cp, "LIST");
		}else if(e.getSource()==b1) {
			String name=nameTf.getText();
			if(name.length()<1) { // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
				nameTf.requestFocus();
				return;
			}
			String sub=subTf.getText();
			if(sub.length()<1) { // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
				subTf.requestFocus();
				return;
			}
			String content=ta.getText();
			if(content.length()<1) { // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
				ta.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(pwdPf.getPassword());
			if(pwd.length()<1) {
				pwdPf.requestFocus();
				return;
			}
			
			// 데이터를 모아서 DAO로 전송
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(sub);
			vo.setContent(content);
			vo.setPwd(pwd);
			
			dao.boardInsert(vo);
			
			// 이동
			cp.bp.print();
			cp.card.show(cp, "LIST");
			
		}
	}
		
		
}
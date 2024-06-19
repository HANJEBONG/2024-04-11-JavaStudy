package com.sist.client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sist.dao.*;



public class BoardUpdatePanel extends JPanel implements ActionListener{
	JLabel titleLa,nameLa,subLa,contLa,pwdLa,noLa;
	JTextField nameTf,subTf;
	JPasswordField pwdPf;
	JTextArea ta;
	JButton b1,b2;
	ControlPanel cp;
	BoardDAO dao;
	int no;
	public BoardUpdatePanel(ControlPanel cp) {
		this.cp=cp;
		dao=BoardDAO.newInstance();
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
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(b1==e.getSource())
			{
			// 입력값을 읽기 
						String name=nameTf.getText();
						if(name.length()<1) // 입력이 안된 경우
						{
							nameTf.requestFocus();
							JOptionPane.showMessageDialog(this, "이름을 입력해주세요!!");
							return;
						}
						
						String subject=subTf.getText();
						if(subject.length()<1) // 입력이 안된 경우
						{
							subTf.requestFocus();
							JOptionPane.showMessageDialog(this, "제목을 입력해주세요!!");
							return;
						}
						
						String content=ta.getText();
						if(content.length()<1) // 입력이 안된 경우
						{
							ta.requestFocus();
							JOptionPane.showMessageDialog(this, "내용을 입력해주세요!!");
							return;
						}
						
						String pwd=String.valueOf(pwdPf.getPassword());
						if(pwd.length()<1) // 입력이 안된 경우
						{
							pwdPf.requestFocus();
							JOptionPane.showMessageDialog(this, "비밀번호를 입력해주세요!!");
							return;
						}
						
						BoardVO vo=new BoardVO();
						vo.setName(name);
						vo.setContent(content);
						vo.setPwd(pwd);
						vo.setSubject(subject);
						vo.setRegdate(new Date());
						vo.setHit(0);
						vo.setNo(no);
						
						boolean bCheck=dao.boardUpdate(vo);
						if(bCheck==true) {
							JOptionPane.showMessageDialog(this, "수정완료");
							cp.bdp.print(no);
							cp.card.show(cp, "DETAIL");
						}
						// 이동 
						cp.card.show(cp, "LIST");
						
						
		}else if(b2==e.getSource())
		{
			cp.card.show(cp, "DETAIL");
		}
	}
}

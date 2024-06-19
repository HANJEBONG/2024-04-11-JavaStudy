package com.sist.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.*;
import com.sist.dao.*;
public class BoardDetailPanel extends JPanel implements ActionListener{
	JLabel titleLa,nameLa,noLa,subLa,dayLa,hitLa;
	JLabel name,no,sub,day,hit;
	JTextArea ta;
	JButton b1,b2,b3; // 수정 / 삭제 / 목록
	ControlPanel cp;
	BoardDAO dao;
	public BoardDetailPanel(ControlPanel cp) {
		this.cp=cp;
		dao=BoardDAO.newInstance();
		titleLa=new JLabel("게시판",JLabel.CENTER);
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30));
		setLayout(null);
		titleLa.setBounds(120,15,620,50);
		add(titleLa);
		
		noLa=new JLabel("번호",JLabel.CENTER);
		noLa.setOpaque(false);
		noLa.setBackground(new Color(75,255,247));
		noLa.setBounds(130,75,80,30);
		no=new JLabel("",JLabel.CENTER);
		no.setBounds(215,75,120,30);
		add(noLa);
		add(no);
		
		dayLa=new JLabel("작성일",JLabel.CENTER);
		dayLa.setBounds(340,75,80,30);
		dayLa.setOpaque(false);
		dayLa.setBackground(new Color(75,255,247));
		day=new JLabel("",JLabel.CENTER);
		day.setBounds(425,75,200,30);
		add(day);
		add(dayLa);
		
		nameLa=new JLabel("이름",JLabel.CENTER);
		nameLa.setBounds(130,110,80,30);
		nameLa.setOpaque(false);
		nameLa.setBackground(new Color(75,255,247));
		name=new JLabel("",JLabel.CENTER);
		name.setBounds(215,110,120,30);
		add(nameLa);
		add(name);
		
		hitLa=new JLabel("조회수",JLabel.CENTER);
		hitLa.setBounds(340,110,80,30);
		hitLa.setOpaque(false);
		hitLa.setBackground(new Color(75,255,247));
		hit=new JLabel("",JLabel.CENTER);
		hit.setBounds(425,110,200,30);
		add(hit);
		add(hitLa);
		
		subLa=new JLabel("제목",JLabel.CENTER);
		subLa.setBounds(130,145,80,30);
		subLa.setOpaque(false);
		subLa.setBackground(new Color(75,255,247));
		sub=new JLabel("");
		sub.setBounds(215,145,400,30);
		add(sub);
		add(subLa);
		
		ta=new JTextArea();
		ta.setEditable(false); // 비활성화
		ta.setBounds(130,180,485,270);
		add(ta);
		
		JPanel p=new JPanel();
		b1=new JButton("수정");
		b2=new JButton("삭제");
		b3=new JButton("목록");
		p.add(b1);p.add(b2);p.add(b3);
		p.setBounds(130,460,485,35);
		add(p);
		
		b1.addActionListener(this); // 수정
		b2.addActionListener(this); // 삭제
		b3.addActionListener(this); // 목록
	}
	public void print(int no) {
		BoardVO vo=dao.boardDetailData(no);
		this.no.setText(String.valueOf(vo.getNo()));
		name.setText(vo.getName());
		sub.setText(vo.getSubject());
		hit.setText(String.valueOf(vo.getHit()));
		day.setText(String.valueOf(vo.getRegdate()));
		ta.setText(vo.getContent());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) { // 수정
			BoardVO vo=dao.boardUpdateData(Integer.parseInt(no.getText()));
			cp.bup.no=vo.getNo();
			cp.bup.nameTf.setText(vo.getName());
			cp.bup.subTf.setText(vo.getSubject());
			cp.bup.ta.setText(vo.getContent());
			cp.card.show(cp, "UPDATE");
		}else if(e.getSource()==b2) { // 삭제
			cp.bdelp.pf.setText("");
			cp.bdelp.no=Integer.parseInt(this.no.getText());
			cp.card.show(cp,"DELETE");
			
		}else if(e.getSource()==b3) { // 목록
			cp.card.show(cp, "LIST"); // <input type=button value="목록" onclick="javascript:history>
		}
	}
}

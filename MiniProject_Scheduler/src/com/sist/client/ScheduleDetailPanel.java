package com.sist.client;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.*;
import com.sist.dao.*;

public class ScheduleDetailPanel extends JPanel implements ActionListener{
	JLabel subLa, dayLa, noLa;
	JLabel place, sub, day, no;
	JTextArea ta;
	JButton b1, b2, b3; // 1. 수정 2. 삭제 3. 목록
	ControllPanel cp;
	CalendarDAO dao;
	JLabel Tl, Ll, DetailL, DateL, etc, etc2;
    JTextField Tf, Lf;
	
	
	
	public ScheduleDetailPanel(ControllPanel cp) {

		this.cp = cp;
		dao = CalendarDAO.newInstance();
		
		Tl = new JLabel("일정", JLabel.CENTER);// <table>
		Tl.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // <h3></h3>
		setLayout(null);
		Tl.setBounds(120, 15, 620, 50);
		add(Tl);
		sub = new JLabel("");
		sub.setBounds(205, 140, 400, 30);
		add(sub);

		dayLa = new JLabel("날짜", JLabel.CENTER);
		dayLa.setBounds(330, 75, 80, 30);
		day = new JLabel("", JLabel.CENTER);
		day.setBounds(415, 75, 200, 30);
		add(dayLa);
		add(day);

		Ll = new JLabel("위치", JLabel.CENTER);
		Ll.setBounds(120, 110, 80, 30);
		place = new JLabel("", JLabel.CENTER);
		place.setBounds(205, 110, 120, 30);
		add(Ll);
		add(place);
		
		/*
		noLa = new JLabel("번호", JLabel.CENTER);
		noLa.setBounds(120, 75, 80, 30);
		no = new JLabel("", JLabel.CENTER);
		no.setBounds(205, 75, 120, 30);
		add(noLa);
		add(no);
		*/
		
		ta = new JTextArea();
		ta.setEditable(true); // 비활성화
		ta.setBounds(120, 180, 485, 250);
		add(ta);

		JPanel p = new JPanel();
		b1 = new JButton("수정");
		b2 = new JButton("삭제");
		b3 = new JButton("목록");
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.setBounds(120, 440, 485, 35);
		add(p);
		
		b1.addActionListener(this);
	    b2.addActionListener(this);
	    b3.addActionListener(this);
		
	
	}
	public void print(int no) {
	      CalendarVO vo = dao.calendarDetailData(no);
	      //this.no.setText(String.valueOf(vo.getNo()));
	      sub.setText(vo.getTitle());
	      place.setText(vo.getPlace());
	      day.setText(vo.getDay().toString());
	      ta.setText(vo.getContent());
	   }
	@Override
	   public void actionPerformed(ActionEvent e) {
	      if(e.getSource() == b3) {
	         cp.card.show(cp, "MY");
	      } else if (e.getSource() == b2) {
	         cp.sdp.no=Integer.parseInt(no.getText());
	         cp.card.show(cp, "SCH_DELETE");
	      } else if (e.getSource() == b1) {
	    	  
	    	  CalendarVO vo = dao.calendarUpdateData(Integer.parseInt(no.getText()));
	    	  
	    	  //cp.bup.no = vo.getNo();
	    	  cp.sp.Tf.setText(vo.getTitle());
	    	  cp.sp.Lf.setText(vo.getPlace());
	    	  cp.sp.DetailA.setText(vo.getContent());
	          cp.card.show(cp, "SCH_UPDATE");
	      }
	   }

	   
}
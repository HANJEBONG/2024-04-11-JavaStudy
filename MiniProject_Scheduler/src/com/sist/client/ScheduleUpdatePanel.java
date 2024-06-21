package com.sist.client;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sist.dao.BoardDAO;
import com.sist.dao.BoardVO;
import com.sist.dao.CalendarDAO;
import com.sist.dao.CalendarVO;

public class ScheduleUpdatePanel extends JPanel implements ActionListener{
	/* 
	JLabel titleLa,nameLa,subLa,contLa,pwdLa;
	    JTextField nameTf,subTf;
	    JPasswordField pwdPf;
	    JTextArea ta;
	    JButton b1,b2;
	    ControllPanel cp;
	    BoardDAO dao;
	    */
	    JLabel Tl, Ll, DetailL, DateL, etc, etc2;
	    JTextField Tf, Lf;
	    JTextArea DetailA;
	    JComboBox<String> DateB, DateB2;
	    JButton b1, b2;
	    int day;
	    int no = 0;
	    JTextArea infoArea;
	    JLabel dateLabel, timeLabel, titleLabel;
	    CalendarDAO dao;
	    ControllPanel cp;
	    
	    public ScheduleUpdatePanel(ControllPanel cp)
	    {
	    	this.cp=cp;
	    	dao = CalendarDAO.newInstance();
	    	
	    	Tl=new JLabel("수정하기",JLabel.CENTER);// <table>
	    	Ll=new JLabel("위치",JLabel.CENTER);
	    	Tl=new JLabel("일정",JLabel.CENTER);
	    	Tf=new JTextField();
	    	Lf=new JTextField();
	    	DetailL=new JLabel("내용",JLabel.CENTER);
	    	DetailA=new JTextArea();
	    	
	    	Ll.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
	    	setLayout(null);
	    	Ll.setBounds(120, 15, 620, 50);
	    	add(Ll);
	    	
	    	
	    	Tl.setBounds(120, 70, 80, 30);
	    	Tf.setBounds(205, 70, 150, 30);
	    	add(Tl);add(Tf);
	    	
	    	
	    	
	    	Ll.setBounds(120, 105, 80, 30);
	    	Lf.setBounds(205, 105, 450, 30);
	    	add(Ll);add(Lf);
	    	
	    	
	    	JScrollPane js=new JScrollPane(DetailA);
	    	DetailL.setBounds(120, 140, 80, 30);
	    	js.setBounds(205, 140, 450, 250);
	    	add(DetailL);add(js);
	 
	    	
	    	b1=new JButton("수정");
	    	b2=new JButton("취소");
	    	
	    	JPanel p=new JPanel();
	    	p.add(b1);p.add(b2);
	    	p.setBounds(120, 435, 535, 35);
	    	add(p);
	    	
	    	b1.addActionListener(this);
	    	b2.addActionListener(this);
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == b2) {
				cp.card.show(cp, "SCH_DETAIL");
			}
			else if(e.getSource() == b1) {
				String title = Tf.getText();
				if(title.length() < 1) {
					Tf.requestFocus();
					return;
				}
				String content = DetailA.getText(); 
				if(content.length() < 1) {
					DetailA.requestFocus();
					return;
				}
				String place = Lf.getText(); 
				if(place.length() < 1) {
					Lf.requestFocus();
					return;
				}
				String userId="";
				
				// 데이터를 모아서 DAO 로 전송
				CalendarVO vo = new CalendarVO();
				vo.setTitle(title);
				vo.setPlace(place);
				vo.setContent(content);
				vo.setUserId(userId);
				dao.calendarInsert(vo);
				
				//데이터베이스 연동
				//이동
				if(e.getSource()==b1) {
					JOptionPane.showMessageDialog(this, "수정이 완료되었습니다");
					cp.my.print();
					cp.card.show(cp, "MY");
				}
					
				
				
			}
		}
}
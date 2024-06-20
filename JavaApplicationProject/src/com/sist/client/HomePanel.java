package com.sist.client;


import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sist.dao.*;
import com.sist.commons.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.net.*;
public class HomePanel extends JPanel implements ActionListener,MouseListener{
	JPanel pan=new JPanel();
	JButton b1,b2;
	JLabel la=new JLabel("0 page / 0 page");
	
	JLabel[] imgs=new JLabel[12];
	int curpage=1; // 현재 페이지
	int totalpage=0; // 총 페이지
	// 데이터 베이스 연동
	GoodsDAO dao;
	ControlPanel cp;
	String myId;
	// 초기화
	public HomePanel(ControlPanel cp) {
		this.cp=cp;
		dao=GoodsDAO.newInstance();
		
		
		setLayout(new BorderLayout());
		add("Center",pan);
		
		b1=new JButton("이전");
		b2=new JButton("다음");
		JPanel p=new JPanel();
		p.add(b1);p.add(b2);p.add(la);
		
		add("South",p);
		b1.addActionListener(this);
		b2.addActionListener(this);
		print();
		
	}
	public void print() {
		totalpage=dao.goodsTotalPage();
		ArrayList<GoodsVO> list=dao.goodsListData(curpage);
		for(int i=0;i<list.size();i++) {
			GoodsVO vo=list.get(i);
			try {
				URL url=new URL(vo.getGoods_poster()); // 포스터 이미지를 링크 걸어서 이미지를 가지고 옴
				Image img=imageChange.getImage(new ImageIcon(url), 240, 200);
				// 이미지 크기 축소
				imgs[i]=new JLabel(new ImageIcon(img));
				imgs[i].setToolTipText(vo.getGoods_name()+"^"+vo.getNo());
				pan.add(imgs[i]);
				
				imgs[i].addMouseListener(this);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		la.setText(curpage+" / "+totalpage);
	}
	public void init() {
		for(int i=0;i<imgs.length;i++) {
			imgs[i]=new JLabel("");
		}
		pan.removeAll();
		pan.validate();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			if(curpage>1) {
				curpage--;
				init();
				print();
			}
		}else if(e.getSource()==b2) {
			if(curpage<totalpage) {
				curpage++;
				init();
				print();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				if(e.getClickCount()==2) {
					String no=imgs[i].getToolTipText();
					no=no.substring(no.lastIndexOf("^")+1);
					cp.dp.print(Integer.parseInt(no));
					cp.card.show(cp, "DP");
				}
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
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				imgs[i].setBorder(new LineBorder(Color.red,3));
			}
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				imgs[i].setBorder(null);
			}
		}
	}
}

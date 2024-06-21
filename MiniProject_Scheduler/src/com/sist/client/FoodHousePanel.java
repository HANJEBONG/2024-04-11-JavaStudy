package com.sist.client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sist.commons.ImageChange;
import com.sist.dao.*;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;

public class FoodHousePanel extends JPanel implements ActionListener,MouseListener{
	JTable table;
	DefaultTableModel model;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	FoodDAO dao;
	ControllPanel cp;
	TableColumn column;
	JLabel pageLa,la1;
	JTextField findTf;
	int curpage=1;
	int totalpage=5;
	String thema;
	String find;
	
	public FoodHousePanel(ControllPanel cp) {
		dao=FoodDAO.newInstance();
		this.cp=cp;
		setLayout(null);
		
		la1=new JLabel("평점 TOP 50");
		la1.setFont(new Font("맑은 고딕",Font.BOLD,30));
		la1.setBounds(220,50,750,170);
		add(la1);
		
		
		JPanel t=new JPanel();
		b3=new JButton("가족외식");
		b4=new JButton("전통 한국 음식");
		b5=new JButton("외국 현지 음식");
		b6=new JButton("일상데이트");
		b7=new JButton("소개팅");
		b8=new JButton("점심식사");
		b9=new JButton("야외테라스");
		b10=new JButton("특별한 날엔");
		b11=new JButton("검색");
		b11.setBounds(160,65,60,30);
		add(b11);
		findTf=new JTextField();
		findTf.setBounds(230,65,250,30);
		add(findTf);
		b3.setFont(new Font("맑은 고딕",Font.BOLD,20));
		b4.setFont(new Font("맑은 고딕",Font.BOLD,14));
		b5.setFont(new Font("맑은 고딕",Font.BOLD,14));
		b6.setFont(new Font("맑은 고딕",Font.BOLD,15));
		b7.setFont(new Font("맑은 고딕",Font.BOLD,20));
		b8.setFont(new Font("맑은 고딕",Font.BOLD,20));
		b9.setFont(new Font("맑은 고딕",Font.BOLD,15));
		b10.setFont(new Font("맑은 고딕",Font.BOLD,15));
		
		t.add(b3);t.add(b4);t.add(b5);t.add(b6);
		t.add(b7);t.add(b8);t.add(b9);t.add(b10);
		t.setLayout(new GridLayout(2,4,5,5));
		t.setBounds(500,20,550,150);
		
		add(t);
		
		
		////////////////////////////////////////////////////////// 테마
		
		String[] col= {"순위","","상호","업종","지역","fno"};
		Object[][] row=new Object[0][6];
		
		model=new DefaultTableModel(row,col) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0, columnIndex).getClass();
			}
			
		};
		table=new JTable(model);
		table.getColumn("fno").setWidth(0);
		table.getColumn("fno").setMinWidth(0);
		table.getColumn("fno").setMaxWidth(0);
		//출처: https://blaseed.tistory.com/9 [양자심리학 권위자:티스토리]
		table.setRowHeight(80);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼 순서 변경 금지
		table.setShowVerticalLines(false);// 버티칼 선만 지움
		JScrollPane js=new JScrollPane(table);
		js.setBounds(150,175,900,450);
		add(js);
		
		for(int i=0;i<col.length;i++) {
			column=table.getColumnModel().getColumn(i);
			if(i==0)
				column.setPreferredWidth(30);
			else if(i==1)
				column.setPreferredWidth(70);
			else if(i==2)
				column.setPreferredWidth(150);
			else if(i==3)
				column.setPreferredWidth(30);
			else if(i==4)
				column.setPreferredWidth(180);

		}
		////////////////////////////////////////////////////////////////// 스코어 top 50
		pageLa=new JLabel(curpage+" page / "+totalpage+" pages");
		b1=new JButton("이전");
		b2=new JButton("다음");
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		table.addMouseListener(this);
		p.setBounds(220,650,750,700);
		add(p);
		print();
	}
	public void print() {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		
		ArrayList<FoodVO> list=dao.foodScoreListData(curpage);
		for(FoodVO vo:list) {
			try {
				URL url=new URL("https://www.menupan.com"+vo.getPoster());
				Image img=ImageChange.getImage(new ImageIcon(url), 70, 70);
				Object[] obj= {
						vo.getNo(),
						new ImageIcon(img),
						vo.getName(),
						vo.getType(),
						vo.getAddress(),
						vo.getFno()
						
				};
				model.addRow(obj);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) {
			if(e.getClickCount()==2) {
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 5).toString();

				cp.dp.print(Integer.parseInt(no));
				cp.card.show(cp, "DP");
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			if(curpage>1) {
				curpage--;
				print();
				pageLa.setText(curpage+" page / "+totalpage+" pages");
			}
		}else if(e.getSource()==b2) {
			if(curpage<totalpage) {
				curpage++;
				print();
				pageLa.setText(curpage+" page / "+totalpage+" pages");
			}

		}
		else if(e.getSource()==b3) {
			thema="가족외식";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
			cp.tp.themaprint(thema);
		}else if(e.getSource()==b4) {
			thema="전통 한국 음식";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b5) {
			thema="외국 현지 음식";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b6) {
			thema="일상데이트";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b7) {
			thema="소개팅";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b8) {
			thema="점심식사";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b9) {
			thema="야외테라스";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);	
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b10) {
			thema="특별한 날엔";
			cp.tp.themeLa.setText(thema);
			cp.tp.totalpage=dao.findFoodTotalPage(thema);
			cp.tp.themaprint(thema);		
			cp.card.show(cp, "THEMA");
		}else if(e.getSource()==b11) {
			find=findTf.getText();
			if(find.length()<1) {
				JOptionPane.showMessageDialog(this, "검색을 입력해주세요");
				return;
			}
			List<FoodVO> list=dao.foodFindData(1, find);
			if(list.size()<1) {
				JOptionPane.showMessageDialog(this, "검색결과가 없습니다");
				return;
			}
			cp.fp.findLa.setText(find);
			cp.fp.totalpage=dao.findTotalPage(find);
			cp.fp.print(find);
			cp.card.show(cp, "FIND");
			
		}
		
	}
}
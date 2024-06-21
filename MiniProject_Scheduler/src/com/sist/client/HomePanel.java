package com.sist.client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sist.commons.ImageChange;
import com.sist.dao.*;


import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.*;

public class HomePanel extends JPanel implements ActionListener,MouseListener{
	JTable table;
	DefaultTableModel model;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
	FoodDAO dao;
	ControllPanel cp;
	TableColumn column;
	JLabel pageLa,la1;
	int curpage=1;
	int totalpage=5;
	public HomePanel(ControllPanel cp) {
		dao=FoodDAO.newInstance();
		this.cp=cp;
		setLayout(null);

		
		String[] col= {"순위","","상호","업종","지역",""};
		Object[][] row=new Object[0][5];
		
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
			else if(i==5)
				column.setPreferredWidth(0);

		}
		pageLa=new JLabel(curpage+" page / "+totalpage+" pages");
		b1=new JButton("이전");
		b2=new JButton("다음");
		la1=new JLabel("평점이 높은 식당");
		JPanel p=new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		b1.addActionListener(this);
		b2.addActionListener(this);
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
	}
}
package com.sist.client;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sist.commons.imageChange;
import com.sist.dao.*;


import java.awt.BorderLayout;
import java.awt.Image;
import java.net.URL;
import java.util.*;

public class HomePanel extends JPanel{
	JTable table;
	DefaultTableModel model;
	FoodDAO dao;
	ControlPanel cp;
	TableColumn column;
	public HomePanel(ControlPanel cp) {
		dao=FoodDAO.newInstance();
		this.cp=cp;
		setLayout(null);

		
		String[] col= {"번호","","가게명",","별점"};
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
		js.setBounds(150,70,800,500);
		add(js);
		
		for(int i=0;i<col.length;i++) {
			column=table.getColumnModel().getColumn(i);
			if(i==0)
				column.setPreferredWidth(30);
			else if(i==1)
				column.setPreferredWidth(100);
			else if(i==2)
				column.setPreferredWidth(400);
			else if(i==3)
				column.setPreferredWidth(100);
			else if(i==4)
				column.setPreferredWidth(30);
		}
		print();
	}
	public void print() {
		ArrayList<FoodVO> list=dao.foodScoreListData(10);
		for(FoodVO vo:list) {
			try {
				URL url=new URL("https://www.menupan.com"+vo.getPoster());
				Image img=imageChange.getImage(new ImageIcon(url), 35, 35);
				Object[] obj= {
						vo.getNo(),
						new ImageIcon(img),
						vo.getName(),
						vo.getAddress(),
						vo.getType(),
						vo.getScore()
						
				};
				model.addRow(obj);
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}

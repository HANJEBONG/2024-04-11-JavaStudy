package com.sist.client;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sist.commons.imageChange;
import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
public class ThemaPanel extends JPanel implements ActionListener{
	JTable table;
	DefaultTableModel model;
	TableColumn column;
	FoodDAO dao;
	ControlPanel cp;
	JButton b1,b2;
	JLabel pageLa=new JLabel(" 0 page / 0 pages");
	JLabel themeLa;
	int curpage=1;
	int totalpage=0;
	public ThemaPanel(ControlPanel cp) {
		
		this.cp=cp;
		dao=FoodDAO.newInstance();
		
		setLayout(null);
		String[] col= {"","상호","업종","지역","테마"};
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
		js.setBounds(100,150,900,500);
		add(js);
		
		for(int i=0;i<col.length;i++) {
			column=table.getColumnModel().getColumn(i);

			if(i==0)
				column.setPreferredWidth(70);
			else if(i==1)
				column.setPreferredWidth(150);
			else if(i==2)
				column.setPreferredWidth(30);
			else if(i==3)
				column.setPreferredWidth(180);
			else if(i==4)
				column.setPreferredWidth(180);
		}
		themeLa=new JLabel();
		themeLa.setFont(new Font("맑은 고딕",Font.BOLD,40));
		themeLa.setBounds(475,50,500,100);
		add(themeLa);
		b1=new JButton("이전");
		b2=new JButton("다음");
		b1.addActionListener(this);
		b2.addActionListener(this);
		JPanel p=new JPanel();
		p.add(b1);
		p.add(pageLa);
		p.add(b2);
		p.setBounds(400,675,350,50);
		add(p);
		

		
	}
	public void themaprint(String thema) {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		};
		ArrayList<FoodVO> list=dao.foodThemaListData(curpage, thema);
		for(FoodVO vo:list) {
			try {
				URL url=new URL("https://www.menupan.com"+vo.getPoster());
				Image img=imageChange.getImage(new ImageIcon(url), 70, 70);
				Object[] obj= {
						new ImageIcon(img),
						vo.getName(),
						vo.getType(),
						vo.getAddress(),
						vo.getTheme()
				};
				model.addRow(obj);
				pageLa.setText(curpage+" page / "+totalpage+" pages");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

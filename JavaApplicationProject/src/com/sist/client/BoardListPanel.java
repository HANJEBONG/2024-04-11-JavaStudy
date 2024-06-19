package com.sist.client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.TabExpander;

import com.sist.dao.*;
/*
 *    1. JButton , JMenu , JTextField => ActionListener
 *    2. JTable , JLabel => MouseListener
 *    3. JComboBox => ItemListener
 */
public class BoardListPanel extends JPanel implements ActionListener,MouseListener{
	JLabel titleLa,pageLa;
	JButton b1,b2,b3;
	JTable table;
	DefaultTableModel model;
	ControlPanel cp;
	BoardDAO dao;
	TableColumn column;
	
	int curpage=1; // 현재 페이지
	int totalpage=0; // 총 페이지
	public BoardListPanel(ControlPanel cp) {
		this.cp=cp;
		dao=BoardDAO.newInstance();
		

				b1=new JButton("새글"); // <input type=button value="새글">
				b2=new JButton("이전");
				b3=new JButton("다음");
				pageLa=new JLabel(curpage +" page / "+totalpage+"pages");// <label>0 page / 0 pagers</label>
				titleLa=new JLabel("게시판",JLabel.CENTER); // <table>
				titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); // <h3></h3>
				
				String[] col={"번호","제목","이름","작성일","조회수"}; // <tr><th></th>....</tr>
				String[][] row=new String[0][5];
				
				model=new DefaultTableModel(row,col){

					@Override
					public boolean isCellEditable(int row, int column) {
						// TODO Auto-generated method stub
						return false;
					}
					
				};
				table=new JTable(model);
				JScrollPane js=new JScrollPane(table);
				for(int i=0;i<col.length;i++) {
					column=table.getColumnModel().getColumn(i);
					if(i==0) {
						column.setPreferredWidth(50);
					}else if(i==1) {
						column.setPreferredWidth(350);
					}else if(i==2) {
						column.setPreferredWidth(100);
					}else if(i==3) {
						column.setPreferredWidth(150);
					}else if(i==4) {
						column.setPreferredWidth(50);
					}
				}
				table.getTableHeader().setReorderingAllowed(false);
				table.setShowVerticalLines(false);
				table.setRowHeight(30);
				table.getTableHeader().setBackground(Color.pink);
				
				// 배치
				setLayout(null);
				titleLa.setBounds(10,15,620,50);
				b1.setBounds(10,70,100,30);
				js.setBounds(10,110,600,330);
				add(titleLa); add(b1); add(js);
				
				JPanel p=new JPanel();
				p.add(b2);
				p.add(pageLa);
				p.add(b3);
				
				p.setBounds(10,450,600,35);
				add(p);
				print();
				
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				table.addMouseListener(this);
	}
	public void print() {
		// 1. 테이블 지우기
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		
		// 데이터 읽기
		List<BoardVO> list=dao.boardListData(curpage);
		totalpage=dao.boardTotalPage();
		
		for(BoardVO vo:list) {
			String[] data= {
					String.valueOf(vo.getNo()),
					vo.getSubject(),
					vo.getName(),
					vo.getRegdate().toString(),
					String.valueOf(vo.getHit())
			};
			model.addRow(data);
			
			pageLa.setText(curpage + " page / " + totalpage + " page");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1) {
			cp.bip.nameTf.setText("");
			cp.bip.subTf.setText("");
			cp.bip.ta.setText("");
			cp.bip.pwdPf.setText("");
			cp.card.show(cp,"INSERT");
			cp.bip.nameTf.requestFocus();
		}else if(e.getSource()==b2) {
			if(curpage>1) {
				curpage--;
				print();
			}
		}else if(e.getSource()==b3) {
			if(curpage<totalpage) {
				curpage++;
				print();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) {
			if(e.getClickCount()==2) {
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 0).toString();
				// 데이터를 출력
				// 이동
				cp.bdp.print(Integer.parseInt(no));
				cp.card.show(cp, "DETAIL");
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
}

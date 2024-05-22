package com.sist.melon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MusicMain extends JFrame implements ActionListener,MouseListener{
	JTextField tf;
    JButton b,b1;
    JTable table;
    DefaultTableModel model;
    
    public MusicMain() {
    	tf=new JTextField(20);
    	b=new JButton("검색");
    	b1=new JButton("목록");
    	JPanel p=new JPanel();
    	p.add(tf); p.add(b); p.add(b1);
    	
    	add("North",p);
    	
    	String[] col= {"번호","노래명","가수명"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
    		// 익명의 클래스 => 상속없이 오버라이딩이 가능
    	};
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	add("Center",js);
    	
    	musicData();
    	setSize(500,450);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	
    	b.addActionListener(this);
    	b1.addActionListener(this);
    }
    public void musicData() {
    	for(int i=model.getRowCount()-1;i>=0;i--) {
    		model.removeRow(i);
    	}
    	
    	MusicSystem ms=new MusicSystem();
    	com.sist.melon.Music[] music=ms.musicListData();
    	
    	for(com.sist.melon.Music m:music) {
    		String[] data= {String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
    		model.addRow(data);
    	}
    }
    public void musicFindData(String fd) {
    	for(int i=model.getRowCount()-1;i>=0;i--) {
    		model.removeRow(i);
    	}
    	
    	MusicSystem ms=new MusicSystem();
    	com.sist.melon.Music[] music=ms.musicFindData(fd);
    	
    	for(com.sist.melon.Music m:music) {
    		String[] data= {String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
    		model.addRow(data);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MusicMain();

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
		if(e.getSource().equals(b)) {
			// 입력한 값 읽기
			String fd=tf.getText();
			if(fd.trim().length()<1) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return;  // 메소드 종료
			}
			musicFindData(fd.trim()); //*********************
		}else if(e.getSource().equals(b1)) {
			musicData();
		}
	}

}

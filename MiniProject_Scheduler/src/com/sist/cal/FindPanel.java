package com.sist.cal;
/*
 *     1366 * 768
 *     
 */   
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class FindPanel extends JPanel{
	JLabel titleLa=new JLabel("게시판",JLabel.CENTER);
    JLabel pageLa=new JLabel("0 page / 0 pages");
    JButton findBtn,b2,b3;
    JTextField findTf;
    JTable table; // table 모양
    DefaultTableModel model; // 데이터 관리
    // 모양 => 필요한 클래스를 포함 => 변경하지않고 있는 그대로 사용
    // 1. 초기화 , 화면 UI => 시작과 동시에 처리 => 생성자
    public FindPanel() {
 
    	b2=new JButton("이전");
    	b3=new JButton("다음");
    	String[] col ={"날짜","요일","일정"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col);
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	///////////////////////////////////////////////////////
    	// 네트워크 서버
    	//배치
    	setLayout(null); // 직접 배치를 하겟다
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,35));
    	titleLa.setBounds(10,15,1600,40);
    	add(titleLa); // JFrame 에 추가
    	
    	findBtn=new JButton("검색");
    	findBtn.setBounds(1600,15,80,40);
    	add(findBtn);
    	
    	js.setBounds(10,105,1570,500);
    	add(js);
    	
    	JPanel p=new JPanel();
    	p.add(b2);
    	p.add(pageLa);
    	p.add(b3);
    	
    	p.setBounds(10,650,1570,35);
    	add(p);
    }
}

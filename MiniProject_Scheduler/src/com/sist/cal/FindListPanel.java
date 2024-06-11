package com.sist.cal;
/*
 *     1366 * 768
 *     
 */   
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class FindListPanel extends JPanel{

    JButton findBtn;
    JTextField findTf;
    JTable table; // table 모양
    DefaultTableModel model; // 데이터 관리
    // 모양 => 필요한 클래스를 포함 => 변경하지않고 있는 그대로 사용
    // 1. 초기화 , 화면 UI => 시작과 동시에 처리 => 생성자
    public FindListPanel() {
 
    	String[] col ={"날짜","요일","일정"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col);
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	///////////////////////////////////////////////////////
    	// 네트워크 서버
    	// 배치
    	setLayout(null); // 직접 배치를 하겟다
    	
    	
    	findBtn=new JButton("검색");
    	findBtn.setBounds(950,80,60,25);
    	add(findBtn);
    	
    	findTf=new JTextField();
    	findTf.setBounds(1030,80,200,25);
    	add(findTf);
    	
    	js.setBounds(200,105,300,500);
    	
    	add(js);
    	// 데이터 저장
    	FindDAO dao=FindDAO.newInstance();
    	String findinfo=findTf.getText();
    	
    	ArrayList<FindVO> list=dao.schduleFindListData();
    	
    	
    }
}

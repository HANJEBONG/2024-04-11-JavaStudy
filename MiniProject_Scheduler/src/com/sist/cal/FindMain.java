package com.sist.cal;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/*
 *     1366 * 768
 *     
 */
public class FindMain extends JFrame implements ActionListener{
	CardLayout card=new CardLayout();
	FindListPanel find=new FindListPanel();
	public FindMain() {
		setLayout(card);
		
		add("FIND",find);
		
		
		find.findBtn.addActionListener(this); // 버튼반응
		find.findTf.addActionListener(this);//엔터시 반응
		
		setSize(1366, 768);		// 사용자 정의 ==> 윈도우 크기를 설정합니다.
		setVisible(true);		// 윈도우를 화면에 표시합니다.
		setResizable(false);	// 윈도우의 크기를 고정합니다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// x 버튼 클릭 시 메모리를 회수합니다 ==> 종료 버튼.
	}
	
	public static void main(String arg[]) {
		new FindMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==find.findBtn||e.getSource()==find.findTf) {
			String userid="user"; // 로그인 한 유저의 ID
			String findInfo=find.findTf.getText();
			if(findInfo.length()<1) {
	    		JOptionPane.showMessageDialog(this, "검색어를 입력해주세요");
	    		find.findTf.requestFocus();
	    		return;
	    	}
			FindDAO dao=FindDAO.newInstance();
	    	ArrayList<FindVO> list=dao.schduleFindListData(userid,findInfo);
	    	if(list.size()==0) {
				JOptionPane.showMessageDialog(this, "검색결과가 없습니다");
				find.findTf.setText("");
				find.findTf.requestFocus();
				return;
			}else {
				for(int i=find.model.getRowCount()-1;i>=0;i--) { // 먼저번 검색했던 일정 리스트 제거
					find.model.removeRow(i);
				}
				for(FindVO vo:list) {
					String[] data= {vo.getDate().toString(),vo.getWeek()+"요일",vo.getSchtitle()};
					find.model.addRow(data);
				}
			}
	    	
		}
	}

}
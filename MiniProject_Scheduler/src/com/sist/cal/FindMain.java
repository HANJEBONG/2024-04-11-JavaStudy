package com.sist.cal;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class FindMain extends JFrame{
	CardLayout card=new CardLayout();
	FindPanel find=new FindPanel();
	public FindMain() {
		setLayout(null);
		find.setBounds(0, 150, 1600, 750);
		add(find);
		
		setSize(1600, 900);		// 사용자 정의 ==> 윈도우 크기를 설정합니다.
		setVisible(true);		// 윈도우를 화면에 표시합니다.
		setResizable(false);	// 윈도우의 크기를 고정합니다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// x 버튼 클릭 시 메모리를 회수합니다 ==> 종료 버튼.
	}
	
	public static void main(String arg[]) {
		new FindMain();
	}
}
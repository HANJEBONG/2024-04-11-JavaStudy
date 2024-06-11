package com.sist.cal;
import java.awt.CardLayout;
import java.util.*;
import javax.swing.*;
import java.awt.*;
/*
 *     1366 * 768
 *     
 */
public class FindMain extends JFrame{
	CardLayout card=new CardLayout();
	FindListPanel find=new FindListPanel();
	public FindMain() {
		setLayout(card);
		
		add("FIND",find);
		
		setSize(1366, 768);		// 사용자 정의 ==> 윈도우 크기를 설정합니다.
		setVisible(true);		// 윈도우를 화면에 표시합니다.
		setResizable(false);	// 윈도우의 크기를 고정합니다.
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// x 버튼 클릭 시 메모리를 회수합니다 ==> 종료 버튼.
	}
	
	public static void main(String arg[]) {
		new FindMain();
	}
}
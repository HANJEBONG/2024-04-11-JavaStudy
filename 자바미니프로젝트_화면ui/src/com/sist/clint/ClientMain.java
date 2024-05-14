package com.sist.clint;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ClientMain extends JFrame implements ActionListener{
    public MenuPanel mp=new MenuPanel();
    public ControlPanel cp=new ControlPanel();
    public ClientMain() {
    	// => North , South , West , East , Center => BorderLayout (JFrame)
    	// 배치
    	setLayout(null);
    	mp.setBounds(300, 30, 600, 50);
    	add(mp);
    	cp.setBounds(0, 100, 1000, 600);
    	add(cp);
    	//add("North",mp);
    	//add("Center",cp);
    	// 윈도우 크기
    	setSize(1000, 700);
    	setVisible(true);
    	setResizable(false);// 윈도우 크기 고정
    	setDefaultCloseOperation(EXIT_ON_CLOSE);// *** x누르면 프로그램 종료 (메모리 해제)
    	
    	mp.b1.addActionListener(this); // b1 버튼을 누르면 => actionPerformed 를 호출
    	mp.b2.addActionListener(this);
    	mp.b6.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
		}catch (Exception ex) {
		}
		new ClientMain();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(mp.b1==e.getSource()) { // 메뉴 1번 버튼을 눌렀을때
			cp.card.show(cp, "HOME");
			
		}else if(mp.b2==e.getSource()) {
			cp.card.show(cp, "FIND");
		}else if(mp.b6==e.getSource()) {
			JOptionPane.showMessageDialog(this, "프로그램을 종료합니다");
			System.exit(0);
		}
	}

}

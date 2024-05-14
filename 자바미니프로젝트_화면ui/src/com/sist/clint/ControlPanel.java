package com.sist.clint;
import java.awt.CardLayout;
import java.awt.Color;
// 기능별로 나눠서 처리 => 분업
import javax.swing.*;
public class ControlPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomePanel hp=new HomePanel();
	public FindPanel fp=new FindPanel();
    public ControlPanel() {
    	setLayout(card);
    	add("HOME",hp);
    	add("FIND",fp);
    }
}

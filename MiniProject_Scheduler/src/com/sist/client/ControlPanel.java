package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel hp;
	ChatPanel chatP=new ChatPanel();
	FindPanel fp;
	ThemaPanel tp;
	public ControlPanel() {
		setBackground(Color.CYAN);
		setLayout(card);
		hp=new HomePanel(this);
		tp=new ThemaPanel(this);
		fp=new FindPanel(this);
		add("HP",hp);
		add("CHAT",chatP);
		add("THEMA",tp);
		add("FIND",fp);
	}
}

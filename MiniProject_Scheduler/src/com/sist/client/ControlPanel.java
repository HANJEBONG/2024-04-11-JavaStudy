package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	FoodHousePanel hp;
	ChatPanel chatP=new ChatPanel();
	FindPanel fp;
	ThemaPanel tp;
	ClientMain cMain;
	public ControlPanel(ClientMain cm) {
		cMain=cm;
		setBackground(Color.CYAN);
		setLayout(card);
		hp=new FoodHousePanel(this);
		tp=new ThemaPanel(this);
		fp=new FindPanel(this);
		add("HP",hp);
		add("CHAT",chatP);
		add("THEMA",tp);
		add("FIND",fp);
	}
}

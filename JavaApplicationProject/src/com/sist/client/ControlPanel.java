package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel hp;
	ChatPanel chatP=new ChatPanel();
	GoodsDetailPanel dp;
	FindPanel fp;
	public ControlPanel() {
		setBackground(Color.CYAN);
		setLayout(card);
		hp=new HomePanel(this);
		dp=new GoodsDetailPanel(this);
		fp=new FindPanel(this);
		add("HP",hp);
		add("CHAT",chatP);
		add("DP",dp);
		add("FP",fp);
	}
}

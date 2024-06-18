package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel hp;
	ChatPanel chatP=new ChatPanel();
	FindPanel fp;
	public ControlPanel() {
		setBackground(Color.CYAN);
		setLayout(card);
		hp=new HomePanel(this);

		fp=new FindPanel(this);
		add("HP",hp);
		add("CHAT",chatP);

		add("FP",fp);
	}
}

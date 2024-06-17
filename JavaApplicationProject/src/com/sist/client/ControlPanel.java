package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel home=new HomePanel();
	ChatPanel chatp=new ChatPanel();
	public ControlPanel() {
		setBackground(Color.CYAN);
		setLayout(card);
		add("CHAT",chatp);
		add("HOME",home);
	}
}

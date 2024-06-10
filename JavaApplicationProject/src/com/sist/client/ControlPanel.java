package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	EmpListPanel ep=new EmpListPanel();
	public ControlPanel() {
		setBackground(Color.CYAN);
		setLayout(card);
		add("EP", ep);
	}
}

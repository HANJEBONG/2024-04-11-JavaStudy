package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class ControlPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel hp;
	ChatPanel chatP=new ChatPanel();
	GoodsDetailPanel dp;
	BoardListPanel bp;
	BoardInsertPanel bip;
	BoardDetailPanel bdp;
	BoardDeletePanel bdelp;
	BoardUpdatePanel bup;
	MypagePanel mpp;
	FindPanel fp;
	ClientMain cMain;
	
	public ControlPanel(ClientMain cm) {
		cMain=cm;
		setBackground(Color.CYAN);
		setLayout(card);
		hp=new HomePanel(this);
		dp=new GoodsDetailPanel(this);
		fp=new FindPanel(this);
		bp=new BoardListPanel(this);
		bip=new BoardInsertPanel(this);	
		bdp=new BoardDetailPanel(this);
		bdelp=new BoardDeletePanel(this);
		bup=new BoardUpdatePanel(this);
		mpp=new MypagePanel(this);
		add("HP",hp);
		add("CHAT",chatP);
		add("DP",dp);
		add("FP",fp);
		add("LIST",bp);
		add("INSERT",bip);
		add("DETAIL",bdp);
		add("DELETE",bdelp);
		add("UPDATE",bup);
		add("MYPAGE",mpp);
	}
}

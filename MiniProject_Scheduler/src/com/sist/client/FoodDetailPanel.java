package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

import com.sist.dao.*;
import com.sist.commons.*;

public class FoodDetailPanel extends JPanel implements ActionListener{
   JLabel la1, la2, la3, la4, la5, la6, la7, la8, la9;
   JButton b1, b2;
   ControllPanel cp; // 화면 이동
   FoodDAO dao;
   


   public FoodDetailPanel(ControllPanel cp) {
      dao = FoodDAO.newInstance();

      this.cp = cp;
      setLayout(null);

      // 메인 사진
      la1 = new JLabel();
      la1.setBounds(0, 80, 683, 400);
      add(la1);

      // 가게 명
      la3 = new JLabel();
      Font font = la3.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la3.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la3.setBounds(100, 490, 400, 60);
      add(la3);
            
      // 평점
      la4 = new JLabel();
      font = la4.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la4.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la4.setBounds(100, 560, 200, 45);
      add(la4);
      
      // 업종
      la2 = new JLabel();
      font = la2.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la2.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la2.setBounds(100, 600, 600, 45);
      add(la2);
            
      
      
      // 가게 설명
      la5 = new JLabel();
      font = la5.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la5.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la5.setBounds(500, 50, 650, 200);
      add(la5);

      // 가격대
      la6 = new JLabel();
      font = la6.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la6.setFont(new Font(font.getName(), Font.BOLD, 30)); 
      la6.setBounds(500, 250, 600, 45);
      add(la6);
      
      // 영업 시간
      la7 = new JLabel();
      font = la7.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la7.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la7.setBounds(500, 325, 600, 45);
      add(la7);
      
      // 가게 전화번호
      la8 = new JLabel();
      font = la8.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la8.setFont(new Font(font.getName(), Font.BOLD, 30)); 
      la8.setBounds(500, 400, 600, 45);
      add(la8);
      
      // 주소
      la9 = new JLabel();
      font = la9.getFont(); // 글씨 크기를 키우기 위해 폰트 설정 추가
      la9.setFont(new Font(font.getName(), Font.BOLD, 25)); 
      la9.setBounds(500, 430, 650, 200);
      add(la9);
      
      // 예약하기 버튼
//      b1 = new JButton("예약하기");
      b2 = new JButton("돌아가기");
      b2.setBounds(533, 600, 100, 50);
      b2.addActionListener(this);
      add(b2);

        
   } 

   public void print(int no) {
      
      // 1. 오라클에서 값을 받는다
      FoodVO vo = dao.foodDetailData(no);
      try {
         URL url = new URL("https://www.menupan.com" + vo.getPoster());
         Image img = ImageChange.getImage(new ImageIcon(url), 450, 550);
         la1.setIcon(new ImageIcon(img));
      } catch (Exception ex) {}
      
      String msg = vo.getName();
      String temp = "";
      
      int a = msg.indexOf("(");
      if (a > 0) {
         temp = msg.substring(0, msg.indexOf("(")) + "<br>" + msg.substring(msg.lastIndexOf("("));
      } else {
         temp = msg;
      }
      
      if (vo.getPrice() == null || vo.getPrice().isEmpty()) {
            vo.setPrice("매장에 문의해주시기 바랍니다.");
        }
      
      
      la3.setText("<html><b>" + temp +"</b></html>");
      la2.setText("<html><font color = gray>" + vo.getType() + "</font></html>");
      la4.setText("<html><b> ★★★★★ " + "<font color = red>" + vo.getScore()
               + "<font color = black> 점 </b></html>");
      la5.setText("<html><b>" + "가게 설명 <br><font color = gray> " + vo.getTheme() + "</font></b></html>");

      la6.setText("<html><b>" + "가격대 : " + vo.getPrice() + "</b></html>");
      la7.setText("<html><b>" + "영업 시간 : " + vo.getTime() + "</b></html>");
      la8.setText("<html><b>" + "매장 전화번호 : " + vo.getPhone() + "</b></html>");
      la9.setText("<html><b>" + "매장 주소 : " + vo.getAddress() + "</b></html>");

      
      
      
   }


   @Override
   public void actionPerformed(ActionEvent e) {

      if (e.getSource() == b2) {
         cp.card.show(cp, "FHP");

      }
   }

}
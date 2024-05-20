package com.sist.main;
// UpDown 게임
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class 예외처리_응용 extends JFrame implements ActionListener{
    JTextField tf;
    JButton b1,b2;
    JLabel la=new JLabel("",JLabel.CENTER);
    int com; // 난수
    int user; // 사용자 입력갑ㅄ
    public 예외처리_응용() {
    	tf=new JTextField();
    	b1=new JButton("시작");
    	b2=new JButton("종료");
    	
    	// 배치
    	setLayout(null);
    	tf.setBounds(10 , 15, 150, 30);
    	// 윈도우 추가
    	add(tf);
    	b1.setBounds(165, 15, 100, 30);
    	add(b1);
    	b2.setBounds(270, 15, 100, 30);
    	add(b2);
    	la.setBounds(10, 55, 360, 30);
    	add(la);
    	
    	// 버튼 클릭 => 메소드 자동 호출
    	tf.addActionListener(this); // 여기서 this는 이 클래스 (자신)가 가지고 있는 actionPerformed 호출
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	
    	// 윈도우 크기
    	setSize(400, 135);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void getRand() {
    	
    	   com=(int)(Math.random()*9)+1;
    	   
    	 	
    }
    public void compare() {
    	if(com>user) {
    		la.setText("입력값보다 큰 값을 입력하세요!!");
    		tf.setText("");
    		tf.requestFocus();
    	}else if(com<user) {
    		la.setText("입력값보다 작은 값을 입력하세요!!");
    		tf.setText("");
    		tf.requestFocus();
    	}else {
    		int no=JOptionPane.showConfirmDialog(this, "종료할까요?","종료",JOptionPane.YES_NO_OPTION);
    		if(no==JOptionPane.YES_OPTION) {
    			System.exit(0);
    		}else {
    			tf.setText("");
    			tf.setEnabled(false);
    			b1.setEnabled(true);
    			la.setText("");
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 예외처리_응용();

	}
	// 예외 처리는 클래스 블록에서는 사용이 불가능
	// => 초기화 블록 , 메소드 , 생성자에서만 사용이 가능
	// 버튼이나 JTextField처리(엔터) => 고정 => 구현을 할 수 없어서 선언만 남겨준다 => 프로그램에 맞게 구현해서 써라
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(b2== e.getSource()) {
			System.exit(0);
		}else if(b1 == e.getSource()) {
			getRand(); // com에 난수 발생
			JOptionPane.showMessageDialog(this, "게임을 시작합니다!!");
			tf.setEnabled(true);
			tf.requestFocus();
			b1.setEnabled(false);
		}else if(tf==e.getSource()) { // 입력후에 엔터라면
			String no=tf.getText(); // 입력값을 읽어 온다
			// 예외처리
			try {
				user=Integer.parseInt(no);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다!!");
				tf.setText("");
				tf.requestFocus();
				// 다시 처음부터 동작을 하게 만든다
				return; // 메소드에서 return을 사용하면 => 메소드가 종료된다
			}
			// 비교
			compare();
		}
	}

}

package com.sist.main;
// UpDown 게임
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class 예외처리_응용2 extends JFrame implements ActionListener{
    JTextField tf;
    JButton b1,b2;
    JTextArea ta=new JTextArea();
    int[] com=new int[3]; // 난수
    int[] user=new int[3]; // 사용자 입력값
    int s,b;
    
    public 예외처리_응용2() {
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
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta);
    	js.setBounds(10, 55 , 360, 300);
    	add(js);
    	
    	// 버튼 클릭 => 메소드 자동 호출
    	tf.addActionListener(this); // 여기서 this는 이 클래스 (자신)가 가지고 있는 actionPerformed 호출
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	
    	// 윈도우 크기
    	setSize(400, 400);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void getRand() {
    	for(int i=0;i<com.length;i++) {
    	   com[i]=(int)(Math.random()*9)+1;
    	   for(int j=0;j<i;j++) {
				if(com[j]==com[i]) {
					i--; // 다시 발생 (원상 복귀)
					break;
				}
    	   }
    	} 	
    }
    public void compare() {
    	s=0;
    	b=0;
    	for(int i=0;i<com.length;i++) {
    		for(int j=0;j<user.length;j++) {
    			if(com[i]==user[j]) {
    				if(i==j) {
    					s++;
    				}else {
    					b++;
    				}
    			}
    		}
    	}
    	String msg="Input numer:"+user[0]+user[1]+user[2]+s+"S-"+b+"B\n";
    	ta.append(msg);
    	if(s==3) {
    		int no=JOptionPane.showConfirmDialog(this, "종료할까요?","종료",JOptionPane.YES_NO_OPTION);
    		if(no==JOptionPane.YES_OPTION) {
    			System.exit(0);
    		}else {
    			tf.setText("");
    			tf.setEnabled(false);
    			b1.setEnabled(true);
    			ta.setText("");
    		}
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new 예외처리_응용2();

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
				int input=Integer.parseInt(no);
				if(input<100 ||input>1000) {
					// || 범위를 벗어나는 경우
					JOptionPane.showMessageDialog(this, "세자리 정수만 사용이 가능합니다!!");
					tf.setText("");
					tf.requestFocus();
					// 처음 상태로 돌아간다
					return;
				}
				user[0]=input/100;
				user[1]=(input%100)/10;
				user[2]=input%10;
				
				// 오류 처리
				if(user[0]==0 || user[1]==0 || user[2]==0) {
					JOptionPane.showMessageDialog(this, "0은 사용할 수 없다!!");
					tf.setText("");
					tf.requestFocus();
					return;
				}
				if(user[0]==user[1] || user[0]==user[2] || user[1]==user[2]) {
					JOptionPane.showMessageDialog(this, "같은 수는 사용 할 수 없다!!");
					tf.setText("");
					tf.requestFocus();
					return;
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다!!");
				tf.setText("");
				tf.requestFocus();
				// 다시 처음부터 동작을 하게 만든다
				return; // 메소드에서 return을 사용하면 => 메소드가 종료된다
			}
			// 비교
			compare();
			tf.setText("");
			tf.requestFocus();
		}
	}

}

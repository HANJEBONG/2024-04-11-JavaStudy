package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Schedule extends JFrame implements MouseListener {

    public JLabel Tl, Ll, DetailL, DateL, etc, etc2;
    public JTextField Tf, Lf;
    public JTextArea DetailA;
    public JComboBox<String> DateB, DateB2;
    public JButton b1, b2;
    private int day;
    
    private JTextArea infoArea;
    private JLabel dateLabel, timeLabel, titleLabel;

    public Add_Schedule(int day) {
        this.day = day;

        setFont(new Font("맑은 고딕", Font.BOLD, 35));
        setTitle("ScrollBar_Schedule");

        // 패널을 사용하여 모든 컴포넌트를 담기
        setLayout(null);

        Tl = new JLabel("제목");
        Tf = new JTextField();

        Ll = new JLabel("위치");
        Lf = new JTextField();

        DetailL = new JLabel("메모");
        DetailA = new JTextArea();

        DateL = new JLabel("시간");

        // JComboBox 객체 생성
        DateB = new JComboBox<>();
        DateB2 = new JComboBox<>();
        etc = new JLabel("시");
        etc2 = new JLabel("분");

        // JComboBox에 항목 추가
        String[] hours = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        String[] minutes = {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

        for (String hour : hours) {
            DateB.addItem(hour);
        }
        for (String minute : minutes) {
            DateB2.addItem(minute);
        }

        b1 = new JButton("등록");
        b2 = new JButton("취소");

        // 배치 
        Tl.setBounds(30, 30, 80, 25);
        Tf.setBounds(90, 30, 360, 25); // 좌우, 위아래, 길이, 높이
        add(Tl);
        add(Tf);

        Ll.setBounds(30, 60, 80, 25);
        Lf.setBounds(90, 60, 240, 25);
        add(Ll);
        add(Lf);

        DateL.setBounds(30, 90, 80, 25);
        DateB.setBounds(90, 90, 50, 25);
        etc.setBounds(150, 90, 20, 25);
        DateB2.setBounds(180, 90, 50, 25);
        etc2.setBounds(240, 90, 20, 25);
        add(DateL);
        add(DateB);
        add(etc);
        add(DateB2);
        add(etc2);

        DetailL.setBounds(30, 120, 80, 25);
        DetailA.setBounds(90, 120, 360, 100);
        add(DetailL);
        add(DetailA);

        JPanel p = new JPanel();
        p.add(b1);
        p.add(b2);
        p.setBounds(150, 250, 200, 100);
        add(p);

        b1.addMouseListener(this);
        b2.addMouseListener(this);

        // JFrame 설정
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // JFrame 크기를 고정
        setResizable(false);

        // JFrame을 화면에 표시
        setVisible(true);
        
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자가 입력한 내용 가져오기
                String title = Tf.getText();
                String location = Lf.getText();
                String hour = (String) DateB.getSelectedItem();
                String minute = (String) DateB2.getSelectedItem();
                String detail = DetailA.getText();
                
                // 콘솔에 사용자가 입력한 내용 출력
                System.out.println("제목: " + title);
                System.out.println("위치: " + location);
                System.out.println("시간: " + hour + "시 " + minute + "분");
                System.out.println("메모: " + detail);
                
             // 일정을 저장하는 메서드 호출
                saveSchedule(title, location, hour, minute, detail);
            }
        });
    }
    
 // 일정을 저장하는 메서드
    private void saveSchedule(String title, String location, String hour, String minute, String detail) {
        // 여기에 일정을 저장하는 로직을 구현합니다.
        // 예를 들어, 데이터베이스에 일정을 저장하는 코드를 작성할 수 있습니다.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (b1 == e.getSource()) {
            String title = Tf.getText();
            if (title.length() < 1) {
                JOptionPane.showMessageDialog(this, "제목을 입력하세요.");
                return;
            }
            int result = JOptionPane.showConfirmDialog(this, "등록 하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                // 일정 등록 로직 추가
                JOptionPane.showMessageDialog(this, "일정이 등록되었습니다.");
                dispose(); // 창 닫기
            }
        } else if (b2 == e.getSource()) {
            int result = JOptionPane.showConfirmDialog(this, "등록 취소하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                dispose(); // 창 닫기
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
  
}
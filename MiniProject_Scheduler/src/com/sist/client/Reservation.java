package com.sist.client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class Reservation extends JFrame implements ActionListener, MouseListener {
    JButton prevB, nextB, OkB;
    JLabel resLa, DateLa, numLa, timeLa, monthLa;
    JTable table, timeTable;
    DefaultTableModel model, timeModel;
    JComboBox<String> numBox;
    public Calendar currentCalendar;
    private int selectedRow = -1;
    private int selectedColumn = -1;

    public Reservation() {
        setTitle("예약");
        setSize(925, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // null 레이아웃 유지

        // JLabel 초기화 및 설정
        resLa = new JLabel("예약하기", JLabel.CENTER);
        resLa.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        resLa.setBounds(300, 10, 300, 50); // 위치와 크기 설정
        add(resLa);

        // 월 정보 표시 라벨 초기화 및 설정
        monthLa = new JLabel("", JLabel.CENTER);
        monthLa.setFont(new Font("맑은 고딕", Font.BOLD, 40));
        monthLa.setBounds(300, 70, 300, 50); // 위치와 크기 설정
        add(monthLa);

        // 이전, 다음 버튼 초기화 및 설정
        prevB = new JButton("<");
        prevB.setBounds(200, 85, 90, 40); // 위치와 크기 설정
        add(prevB);

        nextB = new JButton(">");
        nextB.setBounds(600, 85, 90, 40); // 위치와 크기 설정
        add(nextB);
        
        numLa = new JLabel("인원 수");
        numLa.setBounds(100, 830, 50, 70);
        add(numLa);
        
        numBox = new JComboBox<String>();
        String[] numboxItems = {"1명", "2명", "3명", "4명", "5명 이상 매장 문의"};
        for (String item : numboxItems) {
            numBox.addItem(item);
        }
        numBox.setBounds(160, 850 ,150,30);
        add(numBox);
        
        OkB = new JButton("예약하기");
        OkB.setBounds(350,900,200,30);
        add(OkB);

        currentCalendar = new GregorianCalendar();

        // 이전, 다음 버튼에 액션 리스너 추가
        prevB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        nextB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        // 테이블 컬럼 및 데이터 초기화
        String[] col = {"일", "월", "화", "수", "목", "금", "토"};
        String[][] row = new String[6][7];
        model = new DefaultTableModel(row, col) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // 셀 편집 불가능하게 설정
            }
        };
        /*
        String [] col1 = {"12시","1시","2시","3시","4시","5시","6시","7시","8시","9시"};
        String [][] row1 = new String [1][10];
        timeModel = new DefaultTableModel(row1, col1) {

         @Override
         public boolean isCellEditable(int row, int column) {
            return false;
         }
           
        };*/
        // 테이블 모델 초기화 및 설정

        String[] timeCol = {"Time", "Availability"};
        String[][] timeData = {
            {"12:00", "Available"},
            {"13:00", "Available"},
            {"14:00", "Available"},
            {"15:00", "Available"},
            {"16:00", "Available"},
            {"17:00", "Available"},
            {"18:00", "Available"},
            {"19:00", "Available"},
            {"20:00", "Available"},
            {"21:00", "Available"}
            
        };
        
       
        // 테이블 설정
        table = new JTable(model) {
        	 @Override
             public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                 Component c = super.prepareRenderer(renderer, row, column);
                 if (selectedRow == row && selectedColumn == column) {
                     c.setBackground(Color.GRAY);
                 } else {
                     c.setBackground(Color.WHITE);
                 }
                 return c;
             }
        };
        table.setGridColor(Color.GRAY); // 그리드 선 색상 설정
        table.setShowGrid(true); // 그리드 선 보이기 설정
        table.setRowHeight(80); // 행 높이 설정
        table.setBounds(50, 150, 500, 500); // 위치와 크기 설정

        // 스크롤 팬을 사용하여 테이블 추가
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(100, 150, 700, 503);
        add(scrollPane);

        updateCalendar(); // 캘린더 초기화 및 업데이트
        
        /*
        timeTable = new JTable(timeModel);
        timeTable.setGridColor(Color.DARK_GRAY);
        timeTable.setShowGrid(true);
        timeTable.setRowHeight(20);
        timeTable.setBounds(160, 670, 700, 70);
        
     // 스크롤 팬을 사용하여 테이블 추가
        JScrollPane scrollPane1 = new JScrollPane(timeTable);
        scrollPane1.setBounds(160, 670, 600, 35);
        add(scrollPane1);
        */
        timeModel = new DefaultTableModel(timeData, timeCol);

        // JTable 초기화 및 설정
        timeTable = new JTable(timeModel);
        timeTable.setGridColor(Color.DARK_GRAY);
        timeTable.setShowGrid(true);
        timeTable.setRowHeight(20);

        // 스크롤 팬을 사용하여 테이블 추가
        JScrollPane scrollPane1 = new JScrollPane(timeTable);
        scrollPane1.setBounds(100, 670, 700, 150); // 위치와 크기 설정
        add(scrollPane1);
        
        OkB.addActionListener(this);
        
        setVisible(true); // 프레임 표시
    }

    public void updateCalendar() {
        monthLa.setText(getMonthString());

        Calendar calendar = (Calendar) currentCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) { // 이 부분을 수정
                int day = i * 7 + j - startDay + 1;
                if (day > 0 && day <= numberOfDays) {
                    model.setValueAt(day, i, j);
                } else {
                    model.setValueAt("", i, j);
                }
            }
        }
    }
    public String getMonthString() {
        int year = currentCalendar.get(Calendar.YEAR); // 현재 연도 가져오기
        int month = currentCalendar.get(Calendar.MONTH) + 1; // 현재 월 가져오기 (Calendar.MONTH는 0부터 시작하므로 +1)
        return year + "." + (month < 10 ? "0" + month : month); // 월이 한 자리 숫자일 경우 앞에 0을 붙임
    }

    public static void main(String[] args) {
        new Reservation();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    	 if(e.getClickCount()==1) {
    		 table.repaint();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    	if(e.getSource() == OkB) {
                String message = "예약?";
                String title ="confirm";
       
                JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
                
         }
    }
}
package com.sist.client;

import javax.swing.*;
import javax.swing.table.*;

import com.sist.client.Add_Schedule;
import com.sist.dao.BoardVO;
import com.sist.dao.CalendarDAO;
import com.sist.dao.CalendarVO;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SchedulerPanel extends JPanel implements ActionListener {
    JButton searchBtn, prevBtn, nextBtn;
    JLabel titleLa;
    JLabel monthLabel;
    JTable table;
    DefaultTableModel model;
    public Calendar currentCalendar;
    private int selectedRow = -1;
    private int selectedColumn = -1;
    private JTextArea jta;
    
    JLabel Tl, Ll, DetailL, DateL, etc, etc2;
    JTextField Tf, Lf;
    JTextArea DetailA;
    JComboBox<String> DateB, DateB2;
    JButton b1, b2;
    int day;
    JTextArea infoArea;
    JLabel dateLabel, timeLabel, titleLabel;
    CalendarDAO dao;
    ControllPanel cp;

    	
    public SchedulerPanel(ControllPanel cp, int day) {
    	this.cp=cp;
    	dao=CalendarDAO.newInstance();
    	this.day = day;
    
    	
    	setFont(new Font("맑은 고딕", Font.BOLD, 35));

        // 패널을 사용하여 모든 컴포넌트를 담기
        setLayout(null);

        Tl = new JLabel("제목");
        Tf = new JTextField();

        Ll = new JLabel("위치");
        Lf = new JTextField();

        DetailL = new JLabel("메모");
        DetailA = new JTextArea();

        DateL = new JLabel("날짜");

        // JComboBox 객체 생성
        DateB = new JComboBox<>();
        DateB2 = new JComboBox<>();
        etc = new JLabel("월");
        etc2 = new JLabel("일");

        // JComboBox에 항목 추가
        String[] hours = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] minutes = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        for (String hour : hours) {
            DateB.addItem(hour);
        }
        for (String minute : minutes) {
            DateB2.addItem(minute);
        }

        b1 = new JButton("등록");
        //b2 = new JButton("취소");

        // 배치 
        Tl.setBounds(30, 175, 80, 25);
        Tf.setBounds(90, 175, 250, 25); // 좌우, 위아래, 길이, 높이
        add(Tl);
        add(Tf);

        Ll.setBounds(30, 205, 80, 25);
        Lf.setBounds(90, 205, 200, 25);
        add(Ll);
        add(Lf);

        DateL.setBounds(30, 235, 80, 25);
        DateB.setBounds(90, 235, 50, 25);
        etc.setBounds(150, 235, 20, 25);
        DateB2.setBounds(180, 235, 50, 25);
        etc2.setBounds(240, 235, 20, 25);
        add(DateL);
        add(DateB);
        add(etc);
        add(DateB2);
        add(etc2);

        DetailL.setBounds(30, 265, 80, 25);
        DetailA.setBounds(90, 265, 250, 220);
        add(DetailL);
        add(DetailA);

        JPanel p = new JPanel();
        p.add(b1);
        //p.add(b2);
        p.setBounds(100, 500, 200, 100);
        add(p);

        b1.addActionListener(this);
        //b2.addMouseListener(this);
        
        cp.my.print();

        
        
        

        currentCalendar = new GregorianCalendar();
        initializeComponents();
        setLayout(null); // null 레이아웃 유지
        arrangeComponents();
        updateCalendar();
    }

    private void initializeComponents() {
        // 버튼 초기화
        searchBtn = new JButton("검색");
        prevBtn = new JButton("이전");
        nextBtn = new JButton("다음");

        // 이전, 다음 버튼에 액션 리스너 추가
        prevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, -1);
                updateCalendar();
            }
        });

        nextBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentCalendar.add(Calendar.MONTH, 1);
                updateCalendar();
            }
        });

        // 라벨 초기화
        titleLa = new JLabel("Scheduler", JLabel.CENTER);
        titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 40));

        // 월 정보 표시 라벨 생성
        monthLabel = new JLabel("", JLabel.CENTER);
        monthLabel.setFont(new Font("맑은 고딕", Font.BOLD, 40));

        // JTextField 초기화
        jta = new JTextArea();
        jta.setEditable(false); // 사용자 입력 가능
        jta.setFont(new Font("맑은 고딕", Font.PLAIN, 20)); // 폰트 설정

        // 테이블 컬럼 및 데이터 초기화
        String[] col = {"일", "월", "화", "수", "목", "금", "토"};
        String[][] row = new String[6][7];
        model = new DefaultTableModel(row, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // 테이블 설정
        table = new JTable(model);
        table.setGridColor(Color.BLACK); // 그리드 선 색상 설정
        table.setShowGrid(true); // 그리드 선 보이기 설정
        table.setRowHeight(87); // 행 높이 설정

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedRow = table.getSelectedRow();
                selectedColumn = table.getSelectedColumn();
                table.repaint();

                // 더블 클릭 이벤트 처리
                if (e.getClickCount() == 2) {
                    Integer day = (Integer) table.getValueAt(selectedRow, selectedColumn);
                    if (day != null) {
                        showAddSchedulePanel(day);
                    }
                }

            }
        });

        configureScrollPane();
        configureTable();
    }

    private void showAddSchedulePanel(int day) {
        JFrame frame = new JFrame("일정 추가");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 패널만 닫히도록 설정
        frame.setSize(500, 350);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // 화면 중앙에 표시

        Add_Schedule addSchedulePanel = new Add_Schedule(day); // 부모 패널과 선택된 날짜 정보를 전달
        frame.add(addSchedulePanel);

        frame.setVisible(true);
    }

    private void configureScrollPane() {
        // JScrollPane 설정
        JScrollPane js = new JScrollPane(table);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // 수직 스크롤 바 비활성화

        // 컬럼 너비 설정
        int columnWidth = 153;
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidth);
        }

        // 테이블 속성 설정
        table.getTableHeader().setReorderingAllowed(false);
        table.setShowVerticalLines(true); // 수직 선 표시 설정
        table.setShowHorizontalLines(true); // 수평 선 표시 설정

        js.setViewportView(table);
        add(js);
    }
    
 // 일정을 저장하는 메서드
    private void saveSchedule(String title, String location, String hour, String minute, String detail) {
        // 여기에 일정을 저장하는 로직을 구현합니다.
        // 예를 들어, 데이터베이스에 일정을 저장하는 코드를 작성할 수 있습니다.
    }

    
    private void configureTable() {
        // 요일에 대한 셀 렌더러 설정
        TableCellRenderer dayCellRenderer = new CalendarCellRenderer();

        // 각 열에 대한 셀 렌더러 설정
        for (int i = 0; i < table.getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setCellRenderer(dayCellRenderer);
        }

        // 요일 헤더 색상 설정
        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
                if (column == 0) { // 일요일(0)인 경우
                    headerLabel.setBackground(new Color(255, 204, 204)); // 연한 분홍색
                } else if (column == 6) { // 토요일(6)인 경우
                    headerLabel.setBackground(new Color(204, 229, 255)); // 연한 하늘색
                } else {
                    headerLabel.setBackground(Color.WHITE); // 월요일부터 금요일까지 색상
                }
                headerLabel.setForeground(Color.BLACK); // 헤더 텍스트 색상
                headerLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); // 테두리 설정
                return headerLabel;
            }
        });
    }

    private void arrangeComponents() {
        titleLa.setBounds(415, 25, 620, 50); // 타이틀 텍스트 위치와 크기 설정
        add(titleLa);

        searchBtn.setBounds(1070, 95, 90, 40); // 검색 버튼 위치와 크기 설정
        add(searchBtn);

        prevBtn.setBounds(520, 95, 90, 40); // 이전 버튼 위치와 크기 설정
        add(prevBtn);

        nextBtn.setBounds(830, 95, 90, 40); // 다음 버튼 위치와 크기 설정
        add(nextBtn);

        monthLabel.setBounds(600, 35, 250, 150); // 월 정보 표시 라벨 위치와 크기 설정
        add(monthLabel);

        JScrollPane js = new JScrollPane(table);
        js.setBounds(356, 170, 820, 542); // 스크롤 패널의 위치와 크기 설정
        js.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 수평 스크롤바 비활성화
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // 수직 스크롤바 비활성화
        add(js);

        /*
        jta.setBounds(50, 170, 250, 400); // JTextArea의 위치와 크기 설정
        add(jta);
        
        jta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // JTextArea를 클릭했을 때 실행되는 코드
                // 해당 날짜의 일정을 가져와서 JTextArea에 표시하는 로직 추가
                // 이 예시에서는 간단히 "해당 날짜의 일정"이라는 문자열을 JTextArea에 표시하도록 하겠습니다.
                String schedule = getScheduleForSelectedDate(); // 해당 날짜의 일정 가져오기
                jta.setText(schedule); // JTextArea에 일정 표시
            }
        });
        */

    }

    // 현재 월을 반환하는 메서드
    private String getMonthString() {
        int year = currentCalendar.get(Calendar.YEAR); // 현재 연도 가져오기
        int month = currentCalendar.get(Calendar.MONTH) + 1; // 현재 월 가져오기 (Calendar.MONTH는 0부터 시작하므로 +1)
        return year + "." + (month < 10 ? "0" + month : month); // 월이 한 자리 숫자일 경우 앞에 0을 붙임
    }

    public void updateCalendar() {
        monthLabel.setText(getMonthString());

        Calendar calendar = (Calendar) currentCalendar.clone();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                int day = i * 7 + j - startDay + 1;
                if (day > 0 && day <= numberOfDays) {
                    model.setValueAt(day, i, j);
                } else {
                    model.setValueAt("", i, j);
                }
            }
        }
    }
    /*
    private String getScheduleForSelectedDate() {
        // 여기에 선택한 날짜에 해당하는 일정을 가져오는 로직을 구현합니다.
        // 예를 들어, 간단히 "해당 날짜의 일정"이라는 문자열을 반환하도록 구현할 수 있습니다.
        return "해당 날짜의 일정";
    }
    */


    class CalendarCellRenderer extends JPanel implements TableCellRenderer {
        private JLabel dayLabel;

        public CalendarCellRenderer() {
            setLayout(new BorderLayout());
            dayLabel = new JLabel();
            dayLabel.setHorizontalAlignment(SwingConstants.LEFT);
            add(dayLabel, BorderLayout.NORTH);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Calendar calendar = (Calendar) currentCalendar.clone();
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int startOffset = dayOfWeek - 1;

            int day = row * 7 + column - startOffset + 1;
            int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

            // 이전 달의 마지막 날짜를 계산
            int prevMonthLastDay = new GregorianCalendar(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 0).get(Calendar.DAY_OF_MONTH);

            boolean isCurrentMonth = day > 0 && day <= numberOfDays;
            boolean isPrevMonth = day <= 0;
            boolean isNextMonth = day > numberOfDays;

            if (isCurrentMonth) {
                dayLabel.setForeground(Color.BLACK); // 이번 달의 날짜는 검정색
            } else if (isPrevMonth) {
                dayLabel.setForeground(new Color(150, 150, 150)); // 이전 달의 날짜는 아주 연한 회색
                day = prevMonthLastDay + day; // 이전 달의 날짜로 변경
            } else {
                dayLabel.setForeground(new Color(150, 150, 150)); // 다음 달의 날짜는 아주 연한 회색
                day = day - numberOfDays; // 다음 달의 날짜로 변경
            }

            dayLabel.setText(value == null ? "" : String.valueOf(day));

            // 배경색 설정
            if (column == 0) {
                setBackground(new Color(255, 204, 204)); // 일요일 배경색
            } else if (column == 6) {
                setBackground(new Color(204, 229, 255)); // 토요일 배경색
            } else {
                setBackground(Color.WHITE); // 일반 배경색
            }

            if (row == selectedRow && column == selectedColumn) {
                setBorder(BorderFactory.createLineBorder(Color.BLACK, 4)); // 테두리를 검은색으로 두껍게 설정
            } else {
                setBorder(null); // 선택되지 않은 셀의 테두리 제거
            }

            return this;
        }
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == cp.sp.b1) {
			String title = cp.sp.Tf.getText();
			if(title.length() < 1) {
				cp.sp.Tf.requestFocus();
				return;
			}
			String place = cp.sp.Lf.getText(); 
			if(place.length() < 1) {
				cp.sp.Lf.requestFocus();
				return;
			}
			String content = cp.sp.DetailA.getText(); 
			if(content.length() < 1) {
				cp.sp.DetailA.requestFocus();
				return;
			}
			String Day1 = cp.sp.DateB.getSelectedItem().toString();
			System.out.println(Day1);
			String Day2 = cp.sp.DateB2.getSelectedItem().toString();
			String day = Day1 + Day2;
			
			
			// 데이터를 모아서 DAO 로 전송
			CalendarVO vo = new CalendarVO();
			vo.setTitle(title);
			vo.setDay(day);
			vo.setPlace(place);
			vo.setContent(content);
			vo.setUserId(cp.cMain.myId);
			System.out.println(cp.cMain.myId);
			
			cp.sp.dao.calendarInsert(vo);
			
			// 이동
			
 
			JOptionPane.showMessageDialog(this, "일정 등록 완료");
		}
	}
}
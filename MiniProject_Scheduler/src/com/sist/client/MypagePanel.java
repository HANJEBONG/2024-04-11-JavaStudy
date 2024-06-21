package com.sist.client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import com.sist.dao.*;
/*
 *   1. jbutton, jmenu, jtext
 */
public class MypagePanel extends JPanel implements ActionListener,MouseListener{
	
	JLabel titleLa,pageLa;
	JButton prevB,nextB;
	JTable table;
	DefaultTableModel model;
	ControllPanel cp;
	CalendarDAO dao;
	TableColumn column;
	
	JLabel namela, idla, introla, tablela;
    JTextField nametf, idtf;
    JTextArea introta;
    JButton b1, b2;
    JTable Mtable;
    ControllPanel Mcp;
	
	int curpage = 1; // 현재 페이지
	int totalpage = 0; // 총 페이지
	
	public MypagePanel (ControllPanel cp) {
		this.cp=cp;
		dao = CalendarDAO.newInstance();
		
		// b1 = new JButton("새글"); // <input type=button value ="새글">
		prevB = new JButton("이전");
		nextB = new JButton("다음");
		pageLa = new JLabel("0 page / 0pages"); // <label>0page / 0 pages</label>
		//titleLa = new JLabel("예약확인", JLabel.CENTER);// <table>
		//titleLa.setFont(new Font("맑은 고딕", Font.BOLD, 30)); // <h3></h3>

		String[] col = { "번호", "일정제목", "날짜", "위치", "내용"};// <tr><th></th> ....</tr>
		String[][] row = new String[0][5]; // 한 줄에 5개 데이터를 첨부
		model = new DefaultTableModel(row, col) {

			@Override
			public boolean isCellEditable(int row, int column) {

				return false;
				// 익명의 클래스 => 포함 클래스 => 상속 없이 오버라이딩 할때 사용
//			 										클릭하면 편집기로 바뀌기 때문에 편집 방지 프로그램을 만들어 줘야 함.
//			
			}
		};
		table = new JTable(model);
		JScrollPane js = new JScrollPane(table);
		for (int i = 0; i < col.length; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(50);
			} else if (i == 1) {
				column.setPreferredWidth(350);
			} else if (i == 2) {
				column.setPreferredWidth(100);
			} else if (i == 3) {
				column.setPreferredWidth(150);
			} else if (i == 4) {
				column.setPreferredWidth(50);
			}
		}
		table.getTableHeader().setReorderingAllowed(false);
		table.setShowVerticalLines(false);
		table.setRowHeight(30);
		table.getTableHeader().setBackground(Color.pink);

//		배치
		setLayout(null);
		//titleLa.setBounds(120, 15, 620, 50);
		//add(titleLa);
		
		js.setBounds(250, 400, 866, 30);
		add(js);

		JPanel p = new JPanel();
		p.add(prevB);
		p.add(pageLa);
		p.add(nextB);

		p.setBounds(583, 660, 200, 30);
		add(p);
		print();
		
	
		prevB.addActionListener(this);
		nextB.addActionListener(this);
		
		table.addMouseListener(this);
		

	        this.Mcp=cp;
	        
	        // 사용자 정보 입력 필드 및 레이블 추가
	        namela = new JLabel("이름 : ");
	        namela.setBounds(180, 30, 80, 40);
	        add(namela);

	        nametf = new JTextField();
	        nametf.setBounds(250, 30, 866, 40);
	        nametf.setEnabled(false); // 이름 필드 수정 불가능하게 설정
	        add(nametf);

	        idla = new JLabel("아이디 : ");
	        idla.setBounds(180, 95, 80, 40);
	        add(idla);

	        idtf = new JTextField();
	        idtf.setBounds(250, 95, 866, 40);
	        idtf.setEnabled(false); // 아이디 필드 수정 불가능하게 설정
	        add(idtf);

	        introla = new JLabel("소개 : ");
	        introla.setBounds(180, 180, 80, 30);
	        add(introla);

	        introta = new JTextArea();
	        JScrollPane introScroll = new JScrollPane(introta);
	        introScroll.setBounds(250, 180, 866, 200);
	        add(introScroll);

	        tablela = new JLabel("일정 : ");
	        tablela.setBounds(180, 400, 80, 30);
	        add(tablela);
	        
	        Mtable = new JTable(); 
	        JScrollPane tableScroll = new JScrollPane(Mtable);
	        tableScroll.setBounds(250, 400, 866, 250);
	        add(tableScroll);

	        b1 = new JButton("");
	        b1.setBounds(250, 620, 100, 30);
	        add(b1);

	        b2 = new JButton("저장");
	        b2.setBounds(633, 700, 100, 15);
	        add(b2);

	}
	public void print() {
		// 1. 테이블 지우기
		for(int i = model.getRowCount()-1; i >=0 ; i--) {
			model.removeRow(i);
		}
		// 2. 데이터 읽기
		List<CalendarVO> list = dao.calendarListData(curpage);
		totalpage = dao.CalendarTotalPage();
		
		for(CalendarVO vo : list) {
			String[] data = {
					String.valueOf(vo.getTitle()),
					vo.getPlace(),
					vo.getContent(),
					vo.getDay(),
					vo.getUserId()
			};
			model.addRow(data);
			
			pageLa.setText(curpage+" page / "+ totalpage+" pages ");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == prevB) {// 이전버튼
			if(curpage > 1) {
				curpage--;
				print();
			}
		}
		else if (e.getSource() == nextB) {// 다음버튼
			if(curpage < totalpage) {
				curpage++;
				print();
			}
		}
	}
	
	@Override
	   public void mouseClicked(MouseEvent e) {
	      if (e.getSource() == table) {
	         if (e.getClickCount() == 2) {
	            int row = table.getSelectedRow();
	            String no = model.getValueAt(row, 0).toString();
	            // 데이터를 출력
	            cp.sdetp.print(Integer.parseInt(no));
	            // 이동
	            cp.card.show(cp, "DETAIL");
	         }
	      }
	   }
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}














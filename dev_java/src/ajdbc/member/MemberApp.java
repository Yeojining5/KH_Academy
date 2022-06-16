package ajdbc.member;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ajdbc.zipcode.DBConnectionMgr;



public class MemberApp extends JFrame implements ActionListener, MouseListener {
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	
	String cols[] = {"번호", "아이디", "이름", "주소"}; // JTable의 헤더에 들어갈 1차 배열
	String data[][] = new String[0][4];
	
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	Font font = new Font("돋움체", Font.BOLD,18);
	JScrollPane jsp = new JScrollPane(jtb);
	
	JPanel jp_north = new JPanel();
	JButton jbtn_sel = new JButton("조회");
	JButton jbtn_ins = new JButton("입력");
	JButton jbtn_upd = new JButton("수정");
	JButton jbtn_del = new JButton("삭제");
	
	///////////////////////////////////////////////////////중요////////////
	MemberShip ms = new MemberShip(this);
	//////////////////////////////////////////////////////중요/////////////
	
	public MemberApp() {
		// 이벤트 소스와 이벤트 처리 클래스를 매핑
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
	
		initDisplay();	
		refreshData(); // 이 메소드 배치를 하는 위치가 중요

	}
	
	//////////////////////////////// 전체조회
	public void refreshData() {
		List<Map<String,Object>> memList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address");
		sql.append("  FROM member                                                    ");
		sql.append("ORDER BY mem_no desc                                             ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("mem_no", rs.getInt("mem_no")); // rs커서를 이용해서 컬럼명을 꺼내온다
				rmap.put("mem_id", rs.getString("mem_id"));
				rmap.put("mem_name", rs.getString("mem_name"));
				rmap.put("mem_address", rs.getString("mem_address"));
				memList.add(rmap); // 리스트에 담기	
			}
			//System.out.println(memList); //  단위테스트
			
			// 기존에 조회된 결과 즉, 목록을 삭제하기 위해서 while문을 돌림
			while(dtm.getRowCount() > 0) {
				// 파라미터에 0을 주어서 테이블의 인덱스가 바뀌는 문제를 해결함
				dtm.removeRow(0); // 하나씩 계속 줄어든다
			}
			
			// Iterator : List에 저장된 값들을 읽어오는 인터페이스
			// Iterator는 자료구조가 갖고 있는 정보의 유무를 체크하는데 필요한 메소드를 제공하고 있다.
						Iterator<Map<String,Object>> iter = memList.iterator();
						Object keys[] = null; // 키값 꺼내오기
						while(iter.hasNext()) {
							Map<String,Object> data = iter.next();
							keys = data.keySet().toArray();
							Vector<Object> oneRow = new Vector<>();
							oneRow.add(data.get(keys[2])); // 하나씩 데이터 값을 넣기
							oneRow.add(data.get(keys[1]));
							oneRow.add(data.get(keys[0]));
							oneRow.add(data.get(keys[3]));
							// 데이터셋인 DefaultTableModel에 조회 결과  담기 - 반복처리함 => 10, 20, 30, 40
							dtm.addRow(oneRow);
						}					
		} catch (SQLException se) {
			System.out.println("[[query]]" + sql.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con); // 자원 반납은 생성된 역순으로
		}
	}
	
	
	////////////////////////////////////// 화면 그리기
	public void initDisplay() {
		this.setTitle("회원관리시스템 Ver1.0");
		this.setSize(600,400);;
		this.setVisible(true);
		
		this.add("North", jp_north);
		jp_north.setLayout(new FlowLayout(FlowLayout.CENTER,30,10)); //컴포넌트 간의 좌우간격 30픽셀, 상하간격 10픽셀
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		
		jbtn_sel.setBackground(new Color(158,9,9));       // 버튼의 배경색
		jbtn_sel.setForeground(new Color(212,212,212));   // 버튼의 글자색

		jbtn_ins.setBackground(new Color(7,84,170));
		jbtn_ins.setForeground(new Color(212,212,212));
		
		jbtn_upd.setBackground(new Color(19,99,57));
		jbtn_upd.setForeground(new Color(212,212,212));
		
		jbtn_del.setBackground(new Color(54,54,54));
		jbtn_del.setForeground(new Color(212,212,212));
		
		this.add("Center", jsp);
		
	}
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
		Object obj = e.getSource();
		if(obj == jbtn_ins) {
			ms.initDisplay(); // MemberShip 화면 출력
		}
		
		// 너 조회 누른거야?
		else if(obj == jbtn_sel) {
			refreshData();
		}

	}

	public static void main(String[] args) {
		new MemberApp();

	}

}

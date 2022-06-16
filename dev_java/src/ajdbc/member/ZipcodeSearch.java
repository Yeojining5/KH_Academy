package ajdbc.member;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ajdbc.zipcode.DBConnectionMgr;

public class ZipcodeSearch extends JFrame implements FocusListener, ActionListener, MouseListener {
	////////////  선언부
	String cols[] = {"우편번호", "주소"}; // JTable의 헤더에 들어갈 1차 배열
	String data[][] = new String[0][2];
	
	String zdos[] = {"전체", "서울", "경기"};
	JComboBox jcb = new JComboBox(zdos);
	
	DefaultTableModel dtm = new DefaultTableModel(data, cols);
	JTable jtb = new JTable(dtm);
	Font font = new Font("돋움체", Font.BOLD,18);
	JScrollPane jsp = new JScrollPane(jtb);
	
	JPanel jp_north = new JPanel();
	JTextField jtf_dong = new JTextField("동이름을 입력하세요",20);
	JButton jbtn_search = new JButton("찾기");
	
	//////////////////DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null;// 연결통로
	PreparedStatement 	pstmt 	= null;// DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null;// 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////
	
	MemberShip ms = null; // 여기서 인스턴스화를 하면 복제화 되기 떄문에 안됨
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////// 생성자
	public ZipcodeSearch() {}
	public ZipcodeSearch(MemberShip ms) {
		this.ms = ms; // 출력된 주소를 더블클릭하면 MemberShip 클래스를 열어서 입력할 수 있도록 하기위해
	}
	
	
	
		
	/////////////////////////////////////////////////////////////////////////////// 화면그리기
	public void initDisplay() {
		
		jtf_dong.addFocusListener(this); //
		jtf_dong.addActionListener(this); // 
		jbtn_search.addActionListener(this); // 찾기 버튼 이벤트
		jtb.addMouseListener(this); //
		
		this.setTitle("우편번호 검색기");
		this.setSize(400,400);;
		this.setVisible(true);
		
		this.add("North", jp_north);
		
		this.add("Center", jsp);
		
		jp_north.setLayout(new BorderLayout());
		jp_north.add("Center", jtf_dong); // 패널 가운데 텍스트필드
		jp_north.add("East", jbtn_search); // 패널 동쪽에 찾기 버튼
		jp_north.add("West", jcb); // 패널 서쪽에 콤보 박스
	}
	
	
	public void refreshData(String dong) { /////////////////////////////////////////// refreshData 메소드
		List<Map<String,Object>> zipList = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		 sql.append("SELECT zipcode, address            ");
         sql.append(" FROM zipcode_t                    ");
         sql.append("where dong like '%'||?||'%'        ");
		                                                   
			try {
				con = dbMgr.getConnection();
				pstmt = con.prepareStatement(sql.toString());
				pstmt.setString(1, dong);
				rs = pstmt.executeQuery();
				
				Map<String,Object> rmap = null;
				while(rs.next()) {
					rmap = new HashMap<>();
					rmap.put("zipcode", rs.getString("zipcode"));// rs커서를 이용해서 컬럼명을 꺼내온다
					rmap.put("address", rs.getString("address"));
					zipList.add(rmap); // 리스트에 담기	
				}
				// 조회된 결과를 DefaultTableModel에 매핑하기
				for(int i=0; i < zipList.size(); i++) {
					Map<String,Object> map = zipList.get(i);
					Vector<Object> oneRow = new Vector<>();
					oneRow.add(0,map.get("zipcode"));
					oneRow.add(1,map.get("address"));
					dtm.addRow(oneRow);
				}
			} catch (SQLException se) {
				System.out.println("[[query]]" + sql.toString());
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionMgr.freeConnection(rs, pstmt, con); // 자원 반납은 생성된 역순으로
			}
	}

	
	public static void main(String[] args) { ////////////////////////////////// main
		ZipcodeSearch zc = new ZipcodeSearch();
		zc.initDisplay();

	}



	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource() == jtf_dong) {
			jtf_dong.setText(""); // 텍스트필드에 포커스를 두면 빈문자열로 바꿔라
		}
		
	}



	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jtf_dong || obj == jbtn_search) {
			String user = jtf_dong.getText(); // ex) 역삼, 당산 입력 > 역삼동, 당산동 모두 출력
			refreshData(user); // 입력된것 넘기기
		}
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getClickCount() == 2)
			System.out.println("더블 클릭 한거야?");
		int index[] = jtb.getSelectedRows();
		// 테이블의 데이터를 선택하지 않은 경우
		if(index.length == 0) {
			JOptionPane.showMessageDialog(this, "조회할 데이터를 선택하세요.");
			return;
		}
		else {
			String zipcode = (String)dtm.getValueAt(index[0], 0); // 사용자가 더블클릭한 로우의 우편번호 가져오기
			String address = (String)dtm.getValueAt(index[0], 1); // 사용자가 더블클릭한 로우의 주소 가져오기
			// System.out.println(zipcode+", "+address); // 단위테스트
			ms.jtf_zipcode.setText(zipcode);
			ms.jtf_address.setText(address);
		}
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

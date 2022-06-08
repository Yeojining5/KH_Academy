package ajdbc.zipcode;

import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ZipCodeSearchApp extends JFrame implements ItemListener {
	// JPanel은 디폴트 레이아웃이 FlowLayout임 - 가운데에서 좌우로 펼치면서 배치
	JPanel jp_north = new JPanel();
	String zdo = null; // 선택한 도 정보 담기
	String sigu = null; // 선택된 시구 정보 담기
	String dong = null; // 선택된 동 정보 담기
	
	String zdos[] = null; // 도 콤보박스에 데이터 초기화 사용
	String sigus[] = null; // 시구 콤보박스에 데이터 초기화 사용
	String dongs[] = null; // 동 콤보박스에 데이터 초기화 사용
	
	JComboBox jcb_zdo = null; // 도 콤보박스
	JComboBox jcb_sigu = null; // 시구 콤보박스
	JComboBox jcb_dong = null; // 동 콤보박스
	
	String cols[] = {"주소", "우편번호"};
	String data[][] = new String[0][2];
	DefaultTableModel dtm = new DefaultTableModel();
	JTable            jtb = new JTable(dtm);
	JScrollPane       jsp = new JScrollPane(jtb, 
								            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
								            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	
	
	
	
	
	DBConnectionMgr     dbMgr = new DBConnectionMgr();
	Connection            con = null;
	PreparedStatement   pstmt = null;
	ResultSet              rs = null;
	
	
	
	
	
	
	public ZipCodeSearchApp() { // 선언된 변수들 초기화
		zdos = getZDOList();
		sigus = getSIGUList();
		dongs = getDONGList();
		
		//zdos = new String[] {"전체"};
		//sigus = new String[] {"전체"};
		//dongs = new String[] {"전체"};
		
		jcb_zdo = new JComboBox(zdos);
		jcb_sigu = new JComboBox(sigus);
		jcb_dong = new JComboBox(dongs);	
	}
	
	/////////////////////// 콤보박스에 뿌려질 ZDO 컬럼의 정보를 오라클 서버에서 꺼내오기
	public String[] getZDOList() {
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT '전체' zdo FROM dual      ");
		sql.append(" UNION ALL                        ");
		sql.append(" SELECT zdo                       ");
		sql.append("  FROM (                          ");
		sql.append("      SELECT                      ");
		sql.append("            DISTINCT(zdo) zdo     ");
		sql.append("    FROM zipcode_t                ");
		sql.append("    ORDER BY zdo ASC              ");
		sql.append("    )                             ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String zdo = rs.getString("zdo");
				v.add(zdo);
			}
			zdos = new String[v.size()];
			v.copyInto(zdos);
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
		
		return zdos;
	}//////////////////////////////////////////////////////////
	
	
	public String[] getSIGUList() { /////////////////////////////////////////
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT '전체' sigu FROM dual      ");
		sql.append(" UNION ALL                        ");
		sql.append(" SELECT sigu                       ");
		sql.append("  FROM (                          ");
		sql.append("      SELECT                      ");
		sql.append("            DISTINCT(sigu) sigu     ");
		sql.append("    FROM zipcode_t                ");
		sql.append("    WHERE zdo=?           ");
		sql.append("    ORDER BY sigu             ");
		sql.append("    )                             ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String sigu = rs.getString("sigu");
				v.add(sigu);
			}
			sigus = new String[v.size()];
			v.copyInto(sigus);
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
	
		return sigus;
	}////////////////////////////////////////////////////////////////////////
	
	
	public String[] getDONGList() { ///////////////////////////////////////////
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT '전체' dong FROM dual      ");
		sql.append(" UNION ALL                        ");
		sql.append(" SELECT dong                       ");
		sql.append("  FROM (                          ");
		sql.append("      SELECT                      ");
		sql.append("            DISTINCT(dong) dong     ");
		sql.append("    FROM zipcode_t                ");
		sql.append("    WHERE sigu=?          ");
		sql.append("    ORDER BY dong ASC              ");
		sql.append("    )                             ");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Vector<String> v = new Vector<>();
			while(rs.next()) {
				String dong = rs.getString("dong");
				v.add(dong);
			}
			dongs = new String[v.size()];
			v.copyInto(dongs);
		} catch (Exception e) {
			System.out.println("Exception : "+e.toString());
		}
	
		return dongs;
	}//////////////////////////////////////////////////////
	
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	public void initDisplay() {
		this.setTitle("우편번호 검색기 Ver1.0");
		jp_north.setBackground(Color.orange);
		jp_north.add(jcb_zdo);
		jp_north.add(jcb_sigu);
		jp_north.add(jcb_dong);
		this.add("North", jp_north);
		this.add("Center", jsp);
		this.setSize(600, 500);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		ZipCodeSearchApp zipApp = new ZipCodeSearchApp();
		zipApp.initDisplay();
		
	}

}

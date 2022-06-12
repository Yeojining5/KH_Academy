package ajdbc.crud;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ajdbc.zipcode.DBConnectionMgr;
import oracle.vo.DeptVO;


public class CRUDDept extends JFrame implements ActionListener {
	// 선언부
	
	////////////////// DB연동 /////////////////
	Connection   con        = null;
	PreparedStatement pstmt = null;
	ResultSet rs            = null;
	DBConnectionMgr dbMgr   = new DBConnectionMgr();
	
	// JFrame의 디폴트 레이아웃은 BorderLayout(가운데 중심으로 동서남북 배치)
	JPanel      jp_north    = new JPanel(); // 디폴트레이아웃 : FlowLayout(가운데를 중심으로 배치)
	JButton     jbtn_sel    = new JButton("조회");
	JButton     jbtn_ins    = new JButton("입력");
	JButton     jbtn_upd    = new JButton("수정");
	JButton     jbtn_del    = new JButton("삭제");
	
	//헤더
	String 		cols[] 		= {"부서번호", "부서명", "지역"};
	String		data[][] 	= new String[0][3];
	DefaultTableModel dtm 	= new DefaultTableModel(data, cols); // 데이터셋을 구성
	JTable		jtb 		= new JTable(dtm); // 데이터셋을 파라미터로 넘김
	JScrollPane jsp			= new JScrollPane(jtb);
	
	JPanel      jp_south1   = new JPanel(); 
	JLabel      jl_deptno   = new JLabel("부서번호");
	JTextField  jtf_deptno  = new JTextField("",5);
	
	JPanel      jp_south2   = new JPanel();
	JLabel      jl_dname    = new JLabel("부서이름");
	JTextField  jtf_dname   = new JTextField("",8);
	
	JPanel      jp_south3   = new JPanel();
	JLabel      jl_loc      = new JLabel("지역");
	JTextField  jtf_loc     = new JTextField("",8);
	
	JPanel      jp_south4   = new JPanel();
	
	
	///////////////////////////////////////// 생성자
	public CRUDDept () {
		jbtn_sel.addActionListener(this);
		jbtn_ins.addActionListener(this);
		jbtn_upd.addActionListener(this);
		jbtn_del.addActionListener(this);
		initDisplay();
	}
	
	
	/**************************************************************************
	 * 부서 등록 구현
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다 - 복합데이터 클래스(한꺼번에 3개를 받아옴)
	 * @return int - 1 : 등록 성공 / 0 : 등록 실패
	 * INSERT INTO dept(deptno, dname, loc)
               VALUES(71,'개발1팀','서귀포')
	 **************************************************************************/
	public int deptInsert(DeptVO pdVO) {
		System.out.println("deptInsert 호출 성공");
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO dept(deptno, dname, loc) VALUES(?,?,?)");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			int i = 0;
			pstmt.setInt(++i, pdVO.getDeptno());
			pstmt.setString(++i, pdVO.getDname());
			pstmt.setString(++i, pdVO.getLoc());
//			pstmt.setInt(2, pdVO.getDeptno());
//			pstmt.setString(4, pdVO.getDname());
//			pstmt.setString(6, pdVO.getLoc());
			result = pstmt.executeUpdate();
			
			if(result == 1) { // 1: 정상적으로 불러온경우 전체목록 불러와서 화면초기화
				deptSelectAll(); 
				// 입력후 텍스트필드를 빈칸으로 만들어줌
				setDeptno("");
				setDname("");
				setLoc("");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}		
		return result;
	}
	
	
	
	/**************************************************************************
	 * 부서 수정 구현
	 * @param pdVO - 사용자가 입력한 부서번호, 부서명, 지역을 받는다 - 복합데이터 클래스(한꺼번에 3개를 받아옴)
	 * @param selection 
	 * @return int - 1 : 등록 성공 / 0 : 등록 실패
	 * UPDATE dept
		  set dname = '개발2팀', loc = '거제도'
		 WHERE deptno = 71
	 **************************************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE dept                        ");
	    sql.append("   SET dname = ?, loc = ?          ");
		sql.append("			 WHERE deptno = ?      ");
		
	    try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			int i = 0;
			pstmt.setInt(++i, pdVO.getDeptno());
			pstmt.setString(++i, pdVO.getDname());
			pstmt.setString(++i, pdVO.getLoc());
			result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this, " 데이터가 수정되었습니다.", "Info", 
													JOptionPane.INFORMATION_MESSAGE); // 인포이모지
				deptSelectAll(); 
				// 입력후 텍스트필드를 빈칸으로 만들어줌
				setDeptno("");
				setDname("");
				setLoc("");
			 }
	       } catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBConnectionMgr.freeConnection(pstmt, con);
			}		
			return result;
		}
	
	
	/**************************************************************************
	 * 부서 삭제 구현
	 * @param deptno(int) - 사용자가 선택한 부서번호
	 * @return int - 1 : 등록 성공 / 0 : 등록 실패
	 * DELETE FROM dept
        WHERE deptno IN (71,40)
	 **************************************************************************/
	public int deptDelete(int deptno) {
		System.out.println("deptDelete 호출 성공 :" +deptno);
		int result = 0;
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM dept WHERE deptno = ?");
		
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,  deptno);
			result = pstmt.executeUpdate();
			if(result == 1) {
				JOptionPane.showMessageDialog(this, " 데이터가 삭제되었습니다.", "Info", 
													JOptionPane.INFORMATION_MESSAGE); // 인포이모지
				deptSelectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(pstmt, con);
		}
		
		return result;
	}
	
	
	/**************************************************************************
	 * 부서 목록 전체 조회 구현(새로고침시 재사용 위해서)
	 * @return List<Map<String,Object>>
	 * SELECT deptno, dname, loc FROM dept
	 **************************************************************************/	
	
	public List<Map<String,Object>> deptSelectAll(){
		
		System.out.println("deptSelectAll 호출 성공");
		
		List<Map<String,Object>> deptList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT deptno, dname, loc FROM dept");
		try {
			con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			Map<String,Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);
			}
			//System.out.println(deptList); // 단위테스트용
			
			while(dtm.getRowCount() > 0) {
				dtm.removeRow(0);
			}
			
			
			// Iterator : List에 저장된 값들을 읽어오는 인터페이스
			Iterator<Map<String,Object>> iter = deptList.iterator();
			Object keys[] = null;
			
			while(iter.hasNext()) {
				Map<String,Object> data = iter.next();
				keys = data.keySet().toArray();
				Vector<Object> oneRow = new Vector<>();
				oneRow.add(data.get(keys[2]));
				oneRow.add(data.get(keys[1]));
				oneRow.add(data.get(keys[0]));
				dtm.addRow(oneRow);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return deptList;
	}
	
	
	
	/**************************************************************************
	 * 부서 상세 조회 구현 (1건조회)
	 * @param deptno(int)
	 * @return DeptVO
	 * SELECT deptno, dname, loc FROM dept
	    WHERE deptno = ?
	 **************************************************************************/	
	public DeptVO deptSelectDetail(int deptno){
		System.out.println("deptSelectDetail 호출 성공");
		DeptVO rdVO = null;
		return rdVO;
	}

	
	///////////////////////////////////////////////// 화면 처리부
	public void initDisplay() {	
		
		// 북쪽 패널에 JButton 추가
		//jp_north.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽정렬
		// 왼쪽정렬 + 컴포넌트 간의 좌우간격 30픽셀, 상하간격 10픽셀
		//jp_north.setLayout(new FlowLayout(FlowLayout.LEFT,30,10)); // 왼쪽정렬	
		jp_north.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		this.add("North", jp_north); ///////////// 북쪽 패널
		
		this.add("Center",jsp); /////////////////  중앙 패널
		
		// 남쪽 패널에 JTextField 추가
		jp_south1.add(jl_deptno);
		jp_south1.add(jtf_deptno);
		
		jp_south2.add(jl_dname);
		jp_south2.add(jtf_dname);
		
		jp_south3.add(jl_loc);
		jp_south3.add(jtf_loc);
		
		jp_south4.add(jp_south1); // jp_south4패널안에 south123패널을 배치함
		jp_south4.add(jp_south2);
		jp_south4.add(jp_south3);
		
		this.add("South", jp_south4); /////////////////// 남쪽 패널
				
		this.setTitle("부서관리시스템");
		this.setSize(600, 400);
		this.setVisible(true);
		
		jtb.setSelectionBackground(Color.yellow); // 테이블에서 선택시 색 변하게 하는 방법
		jtb.setSelectionForeground(Color.MAGENTA); // 글자색 변하게 하는 방법
		
	}
	
	////////////////////////////////////////////////// 메인 메소드
	public static void main(String[] args) {
		CRUDDept crud = new CRUDDept();
		crud.initDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); //  너 조회 누른거야?
		if(obj == jbtn_sel) {
			System.out.println("전체조회 호출 성공");
			deptSelectAll();
		}
		
		// 입력하고 싶니?
		else if(obj == jbtn_ins) {
			System.out.println("입력 호출 성공");
			String deptno = getDeptno(); // getText() 호출 > 변수에 저장
			String dname = getDname();
			String loc = getLoc();
			//System.out.println(deptno+","+dname+","+loc); //단위테스트
			
			DeptVO pdVO = new DeptVO();
			pdVO.setDeptno(Integer.parseInt(deptno)); // 입력한 값을 담기
			pdVO.setDname(dname);
			pdVO.setLoc(loc);
			deptInsert(pdVO); // 담긴 값을 pdVO를 통해 파라미터로 넘겨서 메소드 호출!!!
		}
		
		// 수정할거야?
		else if(obj == jbtn_upd) {
			System.out.println("수정 호출 성공");
			int index[] = jtb.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요.", "Error", 
													JOptionPane.ERROR_MESSAGE); // 에러이모지
				return;
			} else {
				String deptno = getDeptno(); // getText() 호출 > 변수에 저장
				String dname = getDname();
				String loc = getLoc();
				
//				dtm.setValueAt(getDeptno(), index[0], 0);
//				dtm.setValueAt(getDname(), index[0], 1);
//				dtm.setValueAt(getLoc(), index[0], 2);
				
			    DeptVO pdVO = new DeptVO();
			    pdVO.setDeptno(Integer.parseInt(deptno));
				pdVO.setDname(dname);
				pdVO.setLoc(loc);
	
				deptUpdate(pdVO); 
				
				
			}
		}
		
		// 삭제를 원해? view > action(delete) > "삭제할 데이터를 선택하세요" > action(select all) > view
		else if (obj == jbtn_del) {
			System.out.println("삭제 호출 성공");
			int index[] = jtb.getSelectedRows(); // 선택한 셀의 row값을 int로 반환
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.", "Error", 
													JOptionPane.ERROR_MESSAGE); // 에러이모지
				return;
			} else {
				Integer deptno = (Integer) dtm.getValueAt(index[0], 0);
				System.out.println("사용자가 선택한 부서번호 :"+deptno);
				deptDelete(deptno); // 삭제 메소드 호출!!!
			}
		}
	} ////////////////////////////////////////// end of actionPerformed
	
	public String getDeptno() { return jtf_deptno.getText(); }
	public void setDeptno(String deptno) { jtf_deptno.setText(deptno); }
	
	public String getDname() { return jtf_dname.getText(); }
	public void setDname(String dname) { jtf_dname.setText(dname); }
	
	public String getLoc() { return jtf_loc.getText(); }
	public void setLoc(String loc) { jtf_deptno.setText(loc); }
	
}

package ajdbc.crud;

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
	
	// JFrame의 디폴트 레이아웃은 BorderLayout
	JPanel      jp_north    = new JPanel(); // 디폴트레이아웃 : FlowLayout
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
	
	JPanel      jp_south    = new JPanel(); // 디폴트레이아웃 : FlowLayout
	JTextField  jtf_deptno  = new JTextField("",10);
	JTextField  jtf_dname   = new JTextField("",20);
	JTextField  jtf_loc     = new JTextField("",20);
	
	
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
	 * @return int - 1 : 등록 성공 / 0 : 등록 실패
	 * UPDATE dept
		  set dname = '개발2팀', loc = '거제도'
		 WHERE deptno = 71
	 **************************************************************************/
	public int deptUpdate(DeptVO pdVO) {
		System.out.println("deptUpdate 호출 성공");
		int result = 0;
		
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
				JOptionPane.showMessageDialog(this, " 데이터가 삭제되었습니다.", "Error", JOptionPane.INFORMATION_MESSAGE); // 인포이모지
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
		// JButton
		jp_north.setLayout(new FlowLayout(FlowLayout.LEFT)); // 왼쪽정렬
		jp_north.add(jbtn_sel);
		jp_north.add(jbtn_ins);
		jp_north.add(jbtn_upd);
		jp_north.add(jbtn_del);
		
		// JTextField
		jp_south.add(jtf_deptno);
		jp_south.add(jtf_dname);
		jp_south.add(jtf_loc);
		
		this.add("North", jp_north);
		
		this.add("Center",jsp);
		
		this.add("South", jp_south);
		
		this.setTitle("부서관리시스템");
		this.setSize(600, 400);
		this.setVisible(true);
		
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
			String deptno = getDeptno();
			String dname = getDname();
			String loc = getLoc();
			//System.out.println(deptno+","+dname+","+loc); //단위테스트
			DeptVO pdVO = new DeptVO();
			pdVO.setDeptno(Integer.parseInt(deptno));
			pdVO.setDname(dname);;
			pdVO.setLoc(loc);;
			deptInsert(pdVO);
		}
		// 수정할거야?
		else if(obj == jbtn_upd) {
			System.out.println("수정 호출 성공");
		}
		// 삭제를 원해? view > action(delete) > "삭제할 데이터를 선택하세요" > action(select all) > view
		else if (obj == jbtn_del) {
			System.out.println("삭제 호출 성공");
			int index[] = jtb.getSelectedRows();
			if(index.length == 0) {
				JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요.", "Error", JOptionPane.ERROR_MESSAGE); // 에러이모지
				return;
			} else {
				Integer deptno = (Integer)dtm.getValueAt(index[0], 0);
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

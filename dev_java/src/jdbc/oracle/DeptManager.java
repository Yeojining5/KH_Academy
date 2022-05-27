package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

// actionlistener 역할이 아직 정해지지 않았다. 뭐가 올지 모르니까 > actionperformed에서 이벤트 처리
public class DeptManager extends JFrame implements ActionListener {
	public final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final String _URL = "jdbc:oracle:thin:@192.168.0.4:1521:orcl11";
	public final String _USER = "scott";
	public final String _PW = "tiger";
	
	Connection          con = null;   // import
	// 오라클 서버에 SQL문을 전달할 때 사용함 (데이터가 오라클 서버안에 있으니까)
	PreparedStatement pstmt = null;   // import
	// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함.
	ResultSet           rs = null;    // import
	String sql = "SELECT deptno, dname, loc From dept";
	JButton jbtn_select = new JButton("조회");
	public DeptManager () {
		// 이벤트 처리를 담당하는 핸들러 클래스의 주소번지 
		// 내안에 actionPerformed 메소드가 재정의 되어있다면 this
		jbtn_select.addActionListener(this);
		initDisplay (); //화면 그리기
	}
	public List<Map<String,Object>> getDeptList() {
		List<Map<String,Object>> deptList = null;
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야 함.
			// 있는 위치는 C:\\app\\user\\product\\11.1.0\\db_1\\jdbc\\lib   아래에 ojdbc6.jar안에 있어요
			Class.forName(_DRIVER);
			con = DriverManager.getConnection(_URL, _USER, _PW); // 메소드 호출로 객체생성 + DriveManager import
			// 파라미터로 받은 select문을 전달
			pstmt = con.prepareStatement(sql);
			// 전달된 select문에 대한 처리를 요청하고 커서 받아내기
			rs = pstmt.executeQuery();
			deptList = new ArrayList<>();
			Map<String, Object> rmap = null;
			while(rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);
			}
			System.out.println(con+"생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack 메모리에 쌓인 에러 메세지에 대한 history 정보 출력 해줌
			e.printStackTrace();
		}
		return deptList;
	}
	public void initDisplay() {
		this.add("North", jbtn_select);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DeptManager();

	}
	@Override // 재정의
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn_select) {
			List<Map<String,Object>> deptList = getDeptList();
			for(int i=0;i<deptList.size();i++) {
				Map<String,Object> rmap = deptList.get(i);
				System.out.println(rmap.get("deptno"));
			}
		}
		
	}

}

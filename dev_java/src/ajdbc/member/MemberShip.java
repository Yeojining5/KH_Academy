package ajdbc.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import ajdbc.zipcode.DBConnectionMgr;
import oracle.vo.MemberVO;

public class MemberShip extends JFrame implements ActionListener, MouseListener {
	
	//  선언부
	JPanel jp_center = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center);
	
	JLabel jlb_id = new JLabel("아이디");
	JTextField jtf_id = new JTextField("",30); // 디폴트로 빈문자열, 길이 20
	JButton jbtn_idcheck = new JButton("중복체크");
	
	JLabel jlb_pw = new JLabel("비밀번호");
	JTextField jtf_pw = new JTextField("",20);
	
	JLabel jlb_name = new JLabel("이름");
	JTextField jtf_name = new JTextField("",20);
	
	JLabel jlb_zipcode = new JLabel("우편번호");
	JTextField jtf_zipcode = new JTextField("",35);
	JButton jbtn_zipcheck = new JButton("우편번호찾기");
	
	JLabel jlb_address = new JLabel("주소");
	JTextField jtf_address = new JTextField("",35);
	
	
	
	JPanel 		jp_south 	= new JPanel();
	JButton 	jbtn_signup 	= new JButton("회원가입");
	JButton 	jbtn_cancel 	= new JButton("취소");
	
	
	////////////////// DB연동 ///////////////////
	DBConnectionMgr 	dbMgr 	= new DBConnectionMgr();
	Connection 			con 	= null; // 연결통로
	PreparedStatement 	pstmt 	= null; // DML구문 전달하고 오라클에게 요청
	ResultSet 			rs		= null; // 조회경우 커서를 조작 필요
	////////////////// DB연동 ///////////////////	
	
	MemberApp memberApp = null; // 여기서 인스턴스화를 하면 복제화 되기 떄문에 안됨
	
	
	
	/////////////////////////////////////////// 생성자
	public MemberShip() {
//		new MemberApp();
//		initDisplay();
	}
	
	public MemberShip(MemberApp memberApp) {
		this.memberApp = memberApp; // 초기화가 된다
	}
	
	
	/////////////////////////////////////////// 화면 처리부
	public void initDisplay() {
		
		// 처음 화면이 열렸을 때는 아이디 중복체크 전이므로 회원가입 버튼 비활성화(false)
		jbtn_signup.setEnabled(false);
		
		// 1) ID중복체크 - 이벤트 소스와 이벤트 처리 핸들러 클래스 연결하기 (actionPerformed에서 확인)
		jbtn_idcheck.addActionListener(this);
		
		jbtn_signup.addActionListener(this);
		
		jbtn_zipcheck.addActionListener(this);
		
		jp_center.setLayout(null); // 절대위치 사용시 널
		jlb_id.setBounds(20, 20, 100, 20);  // (x, y, w, h) x좌표, y좌표, 가로크기(폭), 세로크기(높이)
		jtf_id.setBounds(120, 20, 100, 20);  // (x, y, w, h) x좌표, y좌표, 가로크기, 세로크기
		jbtn_idcheck.setBounds(230,20, 90, 20); // (x, y, w, h) x좌표, y좌표, 가로크기, 세로크기
		jp_center.add(jlb_id);
		jp_center.add(jtf_id);
		jp_center.add(jbtn_idcheck);
		
		jlb_pw.setBounds(20, 60, 100, 20); 
		jtf_pw.setBounds(120, 60, 100, 20);  
		jp_center.add(jlb_pw);
		jp_center.add(jtf_pw);
		
		jlb_name.setBounds(20, 100, 100, 20); 
		jtf_name.setBounds(120,100, 100, 20);  
		jp_center.add(jlb_name);
		jp_center.add(jtf_name);
		
		jlb_zipcode.setBounds(20, 140, 100, 20); 
		jtf_zipcode.setBounds(120, 140, 75, 20);
		jbtn_zipcheck.setBounds(200,140, 110, 20);
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		jp_center.add(jbtn_zipcheck);
		
		jlb_address.setBounds(20, 180, 100, 20); 
		jtf_address.setBounds(120,180, 150, 20);  
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		
		jp_south.add(jbtn_signup);
		jp_south.add(jbtn_cancel);
		
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setTitle("회원가입");
		this.setSize(430, 380);
		this.setVisible(true);
		
		
}
	
	public int memberInsert(MemberVO pmVO) {
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO member(mem_no, mem_id, mem_pw, mem_name, mem_zipcode, mem_address) ");
	    sql.append("VALUES (seq_member_no.nextval,?,?,?,?,?)                                       ");
	    
	   try {
		   con = dbMgr.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			
			int i = 0;
			// mem_no 는 시퀀스로 처리하였음(자동생성) > seq_member_no.nextval
			pstmt.setString(++i, pmVO.getMem_id());
			pstmt.setString(++i, pmVO.getMem_pw());
			pstmt.setString(++i, pmVO.getMem_name());
			pstmt.setString(++i, pmVO.getMem_zipcode());
			pstmt.setString(++i, pmVO.getMem_address());
			
			result = pstmt.executeUpdate();
			System.out.println("result :"+result); // 단위테스트
	    } catch (Exception e) {
	    	e.printStackTrace();
		} finally {
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}			   		
	    return result;
	}
	
	/**********************************************************
	 * 아이디 중복체크 
	 * @param mem_id - 사용자가 입력한 아이디
	 * @return boolean - true이면 회원가입 버튼 활성화
	 * 1 : 아이디 존재함, 0: 아이디 사용가능함, -1: 디폴트(end of file, 찾을수없다)
	 **********************************************************/
	public boolean idCheck (String user_id) {
		boolean isOk = false;
		
		StringBuilder sql = new StringBuilder();
	    sql.append("        SELECT 1                            ");
	    sql.append("          FROM dual                         ");
	    sql.append("           WHERE EXISTS (SELECT MEM_NAME    ");
	    sql.append("                           FROM MEMBER      ");
	    sql.append("                          WHERE MEM_ID=?)   ");
	    
	    try {
	    	con = dbMgr.getConnection();
	    	// ? 자리에 들어갈 아이디를 설정해야 함
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, user_id);
			// select 처리 시는 executeQuery() 호출
			// insert, update, delete 처리 시는 executeUpdate() 호출
			rs = pstmt.executeQuery();
			if(rs.next()) {  // 조회결과가 참이니
				isOk = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	    	DBConnectionMgr.freeConnection(rs, pstmt, con); // 사용한 자원 반드시 반납할 것
		}
		return isOk;
	} //////////////////////////////////////////// end of idCheck
	
	
	
	
	
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
		
		if(obj == jbtn_signup) {
			System.out.println("회원 가입 호출 성공");
			MemberVO pmVO = new MemberVO();
			pmVO.setMem_id(getId());
			pmVO.setMem_pw(getPw());
			pmVO.setMem_name(getName());
			pmVO.setMem_zipcode(getZipcode());
			pmVO.setMem_address(getAddress());
			int result = memberInsert(pmVO);
			
			if(result == 1) {
				System.out.println("result ===> "+result);
				////////////////////////////////////////////////// 가입이 성공하면 화면 닫기
				this.dispose();
				// 회원가입이 닫히고 MemberApp클래스의 화면에 데이터가 입력된다 = 새로고침 메소드 호출하기
				memberApp.refreshData();
			}
		}
		
		// 너 ID중복체크 하려구?
		if(obj == jbtn_idcheck) {
			boolean isOk = idCheck(getId());
			System.out.println("ID중복체크 호출 성공");
			
				if(isOk) {
					JOptionPane.showMessageDialog(this,  "사용할 수 없는 아이디 입니다.", "Error", JOptionPane.ERROR_MESSAGE);
					return;  // if문 안에서 return을 만나면 함수를 빠져나감. 여기서는 actionPerformed에서 빠져나감
				} else{
					JOptionPane.showMessageDialog(this,  "사용 가능한 아이디입니다.", "INFO", JOptionPane.INFORMATION_MESSAGE);
					isOk = true;
					jbtn_signup.setEnabled(isOk); // 회원가입 버튼 활성화! true 대신 isOk를 사용하는 것이 세련된 것
				}
	     }
		
		if(obj == jbtn_zipcheck) {
			ZipcodeSearch zs = new ZipcodeSearch(this);
			zs.initDisplay();
		}
		
	}  //////////////////////// end of actionPerformed

	public static void main(String[] args) {
		new MemberShip();

	}

	public String getId() { return jtf_id.getText(); }
	public void setId(String mem_id) { jtf_id.setText(mem_id); }
	public String getPw() { return jtf_pw.getText(); }
	public void setPw(String mem_pw) { jtf_pw.setText(mem_pw); }
	public String getName() { return jtf_name.getText(); }
	public void setName(String mem_name) { jtf_name.setText(mem_name); }
	public String getZipcode() { return jtf_zipcode.getText(); }
	public void setZipcode(String mem_zipcode) { jtf_zipcode.setText(mem_zipcode); }
	public String getAddress() { return jtf_address.getText(); }
	public void setAddress(String mem_address) { jtf_address.setText(mem_address); }
	
}

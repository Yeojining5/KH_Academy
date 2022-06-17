package ajdbc.member3;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ajdbc.zipcode.DBConnectionMgr;

public class Member3Login extends JFrame implements ActionListener  {
	/////////////////////////////////////////////////////
	/* 선언부 */
	/////////////////////////////////////////////////////
	Connection		  con	= null;
	PreparedStatement pstmt = null;
	ResultSet 		  rs	= null;
	DBConnectionMgr   dbMgr = new DBConnectionMgr();
	
	String nickName="";
	String imgPath="src\\ajdbc\\dept\\";
	JLabel jlb_id = new JLabel("아이디");
	JLabel jlb_pw = new JLabel("패스워드");

	Font jl_font = new Font("휴먼매직체", Font.BOLD, 17);
	JTextField jtf_id = new JTextField("test");
	JPasswordField jpf_pw = new JPasswordField("123");

	JButton jbtn_login = new JButton(
			new ImageIcon(imgPath+"login.png"));
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\login.png"));
	JButton jbtn_join = new JButton(
			new ImageIcon(imgPath+"confirm.png"));
			//new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\co   nfirm.png"));

	// JPanel에 쓰일 이미지아이콘
	//ImageIcon ig = new ImageIcon("C:\\Users\\minkh\\Desktop\\practice\\dev_java\\src\\com\\Final\\image\\main.png");
	ImageIcon ig = new ImageIcon(imgPath+"main.PNG");

	
	/////////////////////////////////////////////////////
	/* 생성자 */
	/////////////////////////////////////////////////////
	public Member3Login(){
		initDisplay();
	}

	/////////////////////////////////////////////////////
	/* jpanal 오버라이드 */
	/////////////////////////////////////////////////////

	/* 배경이미지 */
	class mypanal extends JPanel {
		public void paintComponent(Graphics g) {
			g.drawImage(ig.getImage(), 0, 0, null);
			setOpaque(false);
			super.paintComponents(g);
		}
	}

	
	///////////////////////////////////////////////// 화면 그리기
	public void initDisplay () {
		setContentPane(new mypanal());
		
		/* 버튼과 텍스트필드 구성 */
		jbtn_join.addActionListener(this);
		jbtn_login.addActionListener(this);
		this.setLayout(null);
		this.setTitle("자바채팅 ver.1");
		this.setSize(350, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocation(800, 250);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		// id 라인
		jlb_id.setBounds(45, 200, 80, 40);
		jlb_id.setFont(jl_font);
		jtf_id.setBounds(110, 200, 185, 40);
		this.add(jlb_id);
		this.add(jtf_id);

		// pw 라인
		jlb_pw.setBounds(45, 240, 80, 40);
		jlb_pw.setFont(jl_font);
		jpf_pw.setBounds(110, 240, 185, 40);
		this.add(jlb_pw);
		this.add(jpf_pw);

		// 로그인 버튼 라인
		jbtn_login.setBounds(175, 285, 120, 40);
		this.add(jbtn_login);

		// 회원가입 버튼 라인
		jbtn_join.setBounds(45, 285, 120, 40);
		this.add(jbtn_join);		
	}
	
	/*******************************************************************
	 * 로그인 구현
	 * @param mem_id - 사용자가 입력한 아이디 받아오기
	 * @param mem_pw - 사용자가 입력한 비밀번호 받아오기
	 * @return - 사용자 이름 
	 *******************************************************************/
	
	public String login(String mem_id, String mem_pw) {
		String mem_name = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT                                      ");
		sql.append("      mem_name                              ");
		sql.append("FROM(                                       ");
		sql.append("   SELECT                                   ");
		sql.append("	 CASE WHEN mem_id=? THEN                ");
		sql.append("	   CASE WHEN mem_pw=? THEN mem_name     ");
        sql.append("      	 ELSE '0'                           ");
        sql.append("      	 END                                ");
        sql.append("      ELSE '-1'                             ");
        sql.append("      END AS mem_name                       ");
        sql.append("     FROM member                            ");
        sql.append("    )                                       ");
        sql.append("WHERE ROWNUM = 1                            ");
		try {
			con = dbMgr.getConnection();
	    	pstmt = con.prepareStatement(sql.toString()); // 물음표 채우기
	    	pstmt.setString(1, mem_id);
	    	pstmt.setString(2, mem_pw);
	    	rs = pstmt.executeQuery();
	    	// 조회 결과는 0이거나 1을 출력하는 row이므로 if문 사용
	    	
	    	if(rs.next()) {
	    		mem_name = rs.getString("mem_name");
	    	}
	    	System.out.println("mem_name : "+mem_name);
		} catch (SQLException se) {
	    	System.out.println("[[query]]"+ sql.toString());
	    	System.out.println(se.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 반납은 생성된 역순으로 한다.
			DBConnectionMgr.freeConnection(rs, pstmt, con);
		}
		return mem_name;
	}
	
	public static void main(String[] args) {
		new Member3Login();

	}

	
	@Override ///////////////////////////////////////////////////////// @Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == jbtn_join) {
			Member3Ship ship = new Member3Ship();
			ship.initDisplay();
		} 
		else if (obj == jbtn_login) {
			String user_id = jtf_id.getText();
			String user_pw = jpf_pw.getText(); // 비밀번호를 가져오는 것이라. 앞으로 지원하지 않겠다는 의미..
			String mem_name = null;
			mem_name = login(user_id, user_pw);
			System.out.println("로그인 요청 결과는? " + mem_name);
			
			if(mem_name == null) {
				JOptionPane.showMessageDialog(this, "회원가입 여부를 확인하세요");
				return;
			} else if(mem_name.length() > 2) {
				this.dispose();    // 사용자명이 있다면 로그인창을 닫아라
				new Member3App(); // MemberApp 화면을 띄워라
			}
		}
	}
}

package ajdbc.member;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class MemberApp extends JFrame implements ActionListener, MouseListener {
	
	//  선언부
	JPanel jp_center = new JPanel();
	JScrollPane jsp = new JScrollPane(jp_center);
	
	JLabel jlb_id = new JLabel("아이디");
	JTextField jtf_id = new JTextField("",30); // 디폴트로 빈문자열, 길이 20
	JButton jbtn_idcheck = new JButton("아이디중복체크");
	
	JLabel jlb_pw = new JLabel("비밀번호");
	JTextField jtf_pw = new JTextField("",30);
	
	JLabel jlb_name = new JLabel("이름");
	JTextField jtf_name = new JTextField("",30);
	
	JLabel jlb_zipcode = new JLabel("우편번호");
	JTextField jtf_zipcode = new JTextField("",30);
	
	JLabel jlb_address = new JLabel("주소");
	JTextField jtf_address = new JTextField("",30);
	
	
	
	JPanel 		jp_south 	= new JPanel();
	JButton 	jbtn_signup 	= new JButton("회원가입");
	JButton 	jbtn_cancel 	= new JButton("취소");
	
	// 생성자
	public MemberApp() {
		initDisplay();
	}
	
	// 화면 처리부
	public void initDisplay() {
		
		jp_center.setLayout(null); // 절대위치 사용시 널
		jlb_id.setBounds(20, 20, 100, 20);  // (x, y, w, h) x좌표, y좌표, 가로크기(폭), 세로크기(높이)
		jtf_id.setBounds(120, 20, 100, 20);  // (x, y, w, h) x좌표, y좌표, 가로크기, 세로크기
		jbtn_idcheck.setBounds(230,20, 140, 20); // (x, y, w, h) x좌표, y좌표, 가로크기, 세로크기
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
		jtf_zipcode.setBounds(120, 140, 100, 20);  
		jp_center.add(jlb_zipcode);
		jp_center.add(jtf_zipcode);
		
		jlb_address.setBounds(20, 180, 100, 20); 
		jtf_address.setBounds(120,180, 100, 20);  
		jp_center.add(jlb_address);
		jp_center.add(jtf_address);
		
		jp_south.add(jbtn_signup);
		jp_south.add(jbtn_cancel);
		
		this.add("Center", jsp);
		this.add("South", jp_south);
		this.setTitle("회원가입 하기");
		this.setSize(430, 380);
		this.setVisible(true);
		
		
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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new MemberApp();

	}

}

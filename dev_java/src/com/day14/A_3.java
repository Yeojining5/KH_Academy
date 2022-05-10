package com.day14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class A_3 extends JFrame implements ActionListener {
	B_3 b = new B_3();
	JButton jbtn_insert = new JButton("입력");

	public void initDisplay() {
		this.setLayout(new FlowLayout());
		jbtn_insert.addActionListener(this);
		this.add(jbtn_insert);
		this.setSize(400, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// 예외처리 - try.. catch 블록을 사용한다
		// try작성 > Ctrl+Space > 엔터 (자동완성 기능 사용하기)
		try {
			// 예외가 발생할 가능성이 있는 코드 집어넣기
			A_3 a = new A_3();
			a.initDisplay();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("NullpointerException 발생함");
		}
		System.out.println("initDisplay 호출 후...");
	}
	// JVM이 정의하고 있는 객체중에 JVM이 대신 인스턴스화 해주는 클래스가 있다.
	// 그것은 '의존성 주입'이라고 한다. - 너가 필요할 때 알아서 해줌
	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼을 누르는건 사용자 이지만 느끼는건 JVM이다.
		// JVM이 느낀 버튼의 주소번지를 가져오는 메소드가 있다. > getsource(리턴타입 object - API에 있음. 마우스갖다대면 보임)
		// 더 큰타입은 더 작은 방에 담을 수 없다. 대입X. 오른쪽이 무조건 작아야 한다.
		// but 강제 형전환 가능
		Object obj = e.getSource(); // NullPointException 발생 안함 - 의존성 주입
		if(obj == jbtn_insert) { // JVM이 감지한 주소번지와 개발자가 선언한 주소번지가 같니?
			System.out.println("입력버튼 눌렸다.");
		}
	}

}

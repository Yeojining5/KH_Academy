package com.day8;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JButtonView {

	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("조회");
	// 생성자 파라미터에 this는 자기자신을 가리키는 예약어이다
	// JButtonView
	JButtonEventHandler event = new JButtonEventHandler (this);
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		jbtn_north.addActionListener(event);
		jf.add("North", jbtn_north);
		jf.setSize(400, 300);
		jf.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		JButtonTest_1 jbt = new JButtonTest_1 ();
		jbt.initDisplay();
		
	}

}

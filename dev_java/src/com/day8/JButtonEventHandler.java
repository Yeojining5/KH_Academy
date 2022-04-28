package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonEventHandler implements ActionListener {

	JButtonView jButtonView = null;
	public JButtonEventHandler(JButtonView jButtonView) {
		this.jButtonView = jButtonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // 오버라이드
		Object obj = e.getSource();
		if(obj == jButtonView.jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		}

	}
}

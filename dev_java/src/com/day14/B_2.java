package com.day14;

import javax.swing.JDialog;
// 클래스 분할
// 어떤 클래스 이던지 main 메소드를 가질 수 있다.
public class B_2 extends JDialog {
	public B_2() {
		initDisplay();
	}
	public void initDisplay() {
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(true);
	}



	}


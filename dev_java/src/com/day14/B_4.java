package com.day14;

import javax.swing.JDialog;

public class B_4 extends JDialog {
	String title = null;
	boolean isView = false;
	
	public B_4() {
		System.out.println("B_3() 생성자 호출");
		initDisplay();
	}
	public void set(String title, boolean isView) {
		this.setTitle(title);
		this.setVisible(isView);
	}
	
	public void initDisplay() {
		System.out.println("initDisplay 호출");
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(isView);
	}
	public static void main(String[] args) {
		B_3 b = new B_3();
		System.out.println("before ===> "+b);
		b.initDisplay();
		// 생성자에서 한 번만 호출이 일어난다
		b = new B_3();
		System.out.println("before ===> "+b);
		
	}


	}


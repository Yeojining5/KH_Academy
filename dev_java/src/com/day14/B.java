package com.day14;

import javax.swing.JDialog;
// 클래스 분할
// 어떤 클래스 이던지 main 메소드를 가질 수 있다.
public class B extends JDialog {
	// 생성자 안에서도 메소드를 호출할 수 있다.
	// 이 때는 메인메소드와는 다르게 인스터스화 없이도
	// 내 안에 있는 메소드이므로 호출이 가능하다.
	
	// [[생성자]] 접근제한자 클래스이름()
	public B() {
		System.out.println("B 디폴트 생성자 호출 성공 : 전변 초기화(선언시 초기화 생략가능)");
		// 실행문(변수선언, 제어문, 조건문과 반복문, 연산자, 산술식)
		initDisplay();
	}
	public void initDisplay() {
		this.setTitle("자손창-다이얼로그");
		this.setSize(300, 500);
		this.setVisible(true);
	}

// 메인메소드가 있어야 실행파일 exe로 만들 수 있다.
//  가장 먼저 실행되는 코드이며, JVM 순서대로 코딩을 전개하는 것이 맞는 방법
	public static void main(String[] args) {
		B b = new B ();
		b.initDisplay();
		

	}

}

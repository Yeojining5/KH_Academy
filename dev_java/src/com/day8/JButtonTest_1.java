package com.day8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * 이벤트 처리 순서
 * 1. 해당 컴포넌트가 지원하는 이벤트 리스너 선정하기 - ActionListener(인터페이스)
 * 		추상메소드를 가짐 = 메소드 오버라이딩 (추상메소드를 오버라이딩 해줘야함)
 * 2. 이벤트 소스와 이벤트 처리 핸들러 클래스를 매핑함
 * 3. 이벤트 처리를 담당하는 메소드 구현하기
 */
// ActionListener를 implements하는 클래스를 이벤트 처리를 담당하는 이벤트 핸들러 클래스라고 부른다.
//  JButtonTest_1은 ActionListner의 구현체 클래스 이다.
// 인터페이스는 단독으로 인스턴스화 할 수 없다.
// 인터페이스를 메모리에 로딩할 때는 선언부와 생성부의 이름이 다르다
// 자바에서는 같은 이름의 메소드를 중복 선언할 수 있다.
// 이것을 가능하게 하는 컨벤션이 메소드 오버라이딩과 메소드 오버로딩이 있다.
public class JButtonTest_1 implements ActionListener {
	// 선언부
	JFrame jf = new JFrame();
	JButton jbtn_north = new JButton("조회"); // "조회"는 버튼의 라벨역할 - 여기서 인자가 없으면 텅 비어있음
	// 생성자 -  리턴타입을 쓰지 않는 것이 convention (리턴타입을 사용하면 메소드가 됨)
	// 생성자가 있어서 전역변수는 초기화를 생략할 수 있는 것이다 *** 중요
	// 생성자는 호출 가능
	public JButtonTest_1 () {
		System.out.println("JButtonTest_1 호출 성공");
	}
	// 화면 처리부 - 사용자정의 메소드(자동으로 실행되지 않는다)
	// 콜백메소드 - 시스템에서 자동으로 호출함 = main()
	// static이 붙은 변수는 클래스 급이다 (인스턴스화가 필요)
	public void initDisplay() {
		System.out.println("initDisplay 호출 성공");
		// 이 코드가 있어야 콜백메소드 자동호출 > 언제? 버튼이 눌려 졌을 때
		jbtn_north.addActionListener(this); // convention - 이 코드가 두번 있을 때 두번 출력됨
		jf.add("North", jbtn_north);
		jf.setSize(400, 300); // Parameter 가 2개 온다는 것만 알면됨
		jf.setVisible(true);
		
	}
	
	// 메인메소드는 반드시 필요한 것은x - exe파일로 만들때만 필요함
	public static void main(String[] args) {
		// 생성부의 이름으로 객체가 만들어 진다.
		// 메모리에 로딩이 일어난다.
		// 메소드와 변수를 누릴(호출, 부를수) 수 있다. (인스턴스화를 하는 이유)
		// 변수를 호출하면 값이 나온다 - 원시형 타입
		// 인스턴스화에서 생성부는 생성자를 호출해주는 코드이다
		JButtonTest_1 jbt = new JButtonTest_1 ();
		jbt.initDisplay();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {  // JVM이 생성한 메소드 (이벤트 감지함)
		// getSource() 호출하면 어떤 컴포넌트에 감지가 되었는지 알 수 있다.
		// println 메소드는 메소드 오버로딩의 대표적인 예이다.
		Object obj = e.getSource();
		if(obj == jbtn_north) {
			System.out.println("조회 버튼 클릭 성공");
		}
	}

}

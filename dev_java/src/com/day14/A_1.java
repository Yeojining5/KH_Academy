package com.day14;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// JVM이 자동으로 검색할 수 있는 패키지는 java.lang뿐이다.
// 이것을 제외한 나머지 패키지는 반드시 import해줘야함
import javax.swing.JButton;
import javax.swing.JFrame;

// implements는 convention
// addActionListener 작성 > JFrame implements ActionListener 코드 수정(인터페이스 구현체) > ActionListener import > @Override
public class A_1 extends JFrame implements ActionListener {
	
	// 인스턴스화는 초기화와 생성하기를 나누어 작성할 수도 있다.
	// 선언부에서 초기화 따로 생성 따로 불가. 메소드 안에서는 가능
	
	// 인터페이스는 단독으로 인스턴스화가 불가하다. ***** 중요!! convention
	// 위의 이유로 해서 인터페이스 안에는 추상메소드만 올 수 있다.
	// 추상메소드란 선언부 뒤에 세미콜론으로 끝나는 경우를 말한다.
	// 아래 있는 initDisplay메소드의 경우 좌중괄호, 우중괄호가 있으므로 추상메소드가 아니다.
	// 추상메소드에는 리턴타입, 접근제한자가 올 수 있다 (메소드 호출 ; 과 다른 이유)
	// 생성부에는 반드시 구현체 클래스 이름이 와야 한다. ****** 중요! convention
	
	//ActionListener a1 = new A_1();
	//ActionListener a2 = new ActionListener(); 오류
	
	B_1 b = new B_1 (); // 초기화와 생성을 한 번에 한 경우, 메모리에 로딩-기억시키기 위해 인스턴스화를 한다
	JButton jbtn_insert = new JButton("입력"); // 버튼에대한 라벨 "입력"
	public void initDisplay() {
		// 입력버튼이 눌러졌을때 이벤트를 감지하고 콜백메소드를 호출하는 코드추가
		// 현재 클래스 안에 actionPerformed라는 메소드가 재정의(오버라이딩) 안되어있으면 Listener오류뜸
		// 이벤트 처리를 담당하는 클래스를 외부에 둘 수도 있다.
		
		// FlowLayout API를 이용해서 배치할때는 동서남북중앙 배치가 불가하다
		// 그럼 아까는 왜 된거야? BorderLayout이 기본이라 생략할 수 있어서 (false가 디폴트니까)
		this.setLayout(new FlowLayout());
		jbtn_insert.addActionListener(this);
		// this에 무엇을 붙일 것인가는 파라미터를 통해서 결정할 수 없다.
		this.add(jbtn_insert); // this는 A_1클래스를 의미하고 add메소드는 JFrame창에 버튼을 붙이는 기능
		this.setSize(400, 500);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		A_1 a = new A_1 ();
		a.initDisplay();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

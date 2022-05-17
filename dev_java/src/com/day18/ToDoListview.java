package com.day18;
import java.awt.FlowLayout;
import java.awt.Font;

// java.lang이 아닌 모든 패키지는 JVM이 접근할 수 없다.
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ToDoListview extends JFrame {
	
	javax.swing.JLabel jlb_timer = new javax.swing.JLabel("현재시간 : ");
	Font f = new Font("궁서체", Font.BOLD,40);
	public ToDoListview() {
		// 화면을 그리는 메소드를 디폴트 생성자에서 호출 - 표현력 키우기, 위치의 다양성
		// 생성자 안에서 호출할 때는 인스턴스화가 필요없다 = 직접 호출 가능
		initDisplay();
		// 객체주입
		TimeClient tc = new TimeClient(jlb_timer);
		tc.start(); 
	}
	
	public void initDisplay() {
		jlb_timer.setFont(f);
		this.setTitle("TODO Ver1.0");
		this.setLayout(new FlowLayout()); // 중앙에서 양쪽으로 배치가 일어남
		// BorderLayout은 동서남북 이므로 아래 코드 사용X
		//this.add("North", jlb_timer);
		this.add(jlb_timer);
		this.setSize(500, 300);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		ToDoListview tv = new ToDoListview();
		

	}

}

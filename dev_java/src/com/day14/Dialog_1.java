package com.day14;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class Dialog_1 extends JDialog {
	// 디폴트 생성자는 생략가능함 - 인스턴스화를 하면 JVM 자동으로 해주니까(파라미터 없는 경우)
	// 어디서? (Main_1 20번라인)
	// Dialog_1 dialog  = null; > 1. 선언만! 초기값을 가짐 (0, false, ...) C언어에는 없음
	// dialog = new Dialog_1(); > 2. Dialog_1 클래스에 대해 생성! = 메모리에 로딩시킴
	// Dialog_1 dialog = new Dialog_1(); > 3. 생성자 호출
   public void initDisplay() { // 화면을 그려주는 메소드 구현. (서브창이다 = 자식창이다)
       this.setTitle("메인 서브창");
       this.setSize(300, 400);
       this.setVisible(true);
   }
}

package com.day14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Dialog_3 extends JDialog implements ActionListener{
   String title = null;
   boolean isView = false; // false이면 메모리에 로딩되어 있지만 화면에는 비활성화. true이면 화면에도 보여줘
   JScrollPane jsp = new JScrollPane();
   JPanel jp_north = new JPanel();
   JButton jbtn_save = new JButton("저장");
   Main_3 main_3 = null;
   public Dialog_3() {
   }
   // 자손의 클래스를 인스턴스화 하면 화면을 그리는 initDisplay() 호출되게 하자
   public Dialog_3(Main_3 main_3) { // 대문자 클래스, 소문자 지역변수
	   // 왜 파라미터에 부모의 주소를 받아야 하는가
      this.main_3 = main_3;
      jbtn_save.addActionListener(this);
      initDisplay(); // 추가함 - 중요!
   }
   public void initDisplay() {
      jp_north.add(jbtn_save);
      this.add("North", jp_north);
      this.add("Center",jsp);
       this.setTitle(title);
       this.setSize(300, 400);
       this.setVisible(isView); // false 처리시 화면 보이지않음, false를 isView로 전역변수화 시킴! 이게 베스트
   }
   public void set(String title) {
      this.title = title;
   }
   public void set(String title, boolean isView, Main_3 main_3) {
	   set(title);
	   this.isView = isView;
	   this.main_3 = main_3; //파라미터로 넘어온 주소번지를 전변에 재저장하기 - 원본의 주소번지를 담는다.
   }
   @Override
   public void actionPerformed(ActionEvent e) {
      Object obj = e.getSource();
      if(obj == jbtn_save) {
         // insert here - 부모의 메소드 호출하기 실습
         main_3.refreshData();
      }
   }
}

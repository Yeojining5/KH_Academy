package com.day14;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.util.List;
// 소나타는 자동차이다. 소나타 is a 자동차 - 상속
// JFrame이 부모, Main_1이 자식
public class Main_1 extends JFrame implements ActionListener{
	   // 메인화면에 사용할 컴포넌트들을 선언합니다.
	    private JButton btnInsert = new JButton("입력");
	    private JButton btnUpdate = new JButton("수정");
	    private JButton btnDelete = new JButton("삭제");
	    private JButton btnSelect = new JButton("조회");
	    private JButton btnDetail = new JButton("상세보기");
	    Dialog_1 dialog = null;
	   public void initDisplay() {
	      dialog = new Dialog_1();
	      // 창의 x버튼을 눌렀을 때 열린 화면에 자원을 회수합니다.
	       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       // JFrame은 디폴트 레이아웃이 BorderLayout인데 굳이 일부러 FlowLayout으로 변경한 것
	       // FlowLayout은 디폴트가 왼쪽에서 오른쪽으로 배치가 되는 레이아웃을 담당하는 클래스입니다.
	       this.setLayout(new FlowLayout());
	       // 입력 버튼이 눌려졌을 때, 누가? JVM이 감지하고 이벤트 처리메소드를 호출해주는 역할 > addActionListener
	       // 아래 코드가 없으면 느낄 수가 없다.
	       btnInsert.addActionListener(this);
	       // [[상속]]  this = Main_1(나자신),  super = JFrame / 자식은 부모를 감싸고 있다. 자식이 더 범위가 큼
	       // 내안에서(Main_1) add, SetTilte, setSize, setVisible 메소드를 선언 및 구현한 적이 없다. 
	       this.add(btnInsert); // 부모가 제공하는 메소드를 호출한다. [[단지 호출]] 세미콜론으로 끝났잖아
	       this.add(btnUpdate); 
	       this.add(btnDelete);
	       this.add(btnSelect);
	       this.add(btnDetail);
	       this.setTitle("메인 Ver1.0");
	       this.setSize(700, 500);
	       this.setVisible(true);
	   }
/* 44 - 45(인.화 : 디폴트생성자 호출(파라미터X)) - Main_1에 생성자가 정의되지 않았다. - but, JVM에서 제공함
 * - 46 (hot spot) - 21번(인.화[Dialog_1]) - (23~39 : UI화면그리기-강사님이 분석해줌)  
 */   	   
	   public static void main(String[] args) {
	      Main_1 abook = new Main_1();
	      abook.initDisplay(); // **** 중요라인
	   }
	   @Override
	   public void actionPerformed(ActionEvent e) {
	      Object obj = e.getSource();
	      if(btnInsert == obj) {
	         dialog.initDisplay();
	      }
	   }
	}


	

}

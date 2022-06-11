package swing.template;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//import swing.TableTest1.TableSelect;

//복사해서 쓸것
//Java5.0버전 이후 프레임 앞에 컨테이너가 기본으로 하나가 있다.
//따라서 컨테이너를 바꿔준다.
public class TableTest2 extends JFrame implements ActionListener {
	Container cp;

	// 테이블생성
	JTable table;

	// 텍스트필드 생성
	TextField tfSang, tfSu, tfDan;

	// 버튼 생성
	Button btnAdd, btnDel, btnMod;

	JScrollPane jsp;
	DefaultTableModel model;
	JTable table2;

	String[][] data = { { "사과", "2", "1200", "2400" }, { "딸기", "4", "4000", "16000" }, { "우유", "9", "5000", "45000" },
			{ "포도", "2", "3000", "6000" }, { "쥬스", "6", "6000", "36000" } };

	String title[] = { "상품명", "수량", "단가", "총금액" };

	int row = -1;

	public TableTest2(String title) {
		super(title);
		cp = this.getContentPane();
		this.setDesign();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(300, 100, 400, 400);
		cp.setBackground(new Color(255, 255, 200));
		this.setVisible(true);
	}

	public void setDesign() {
		cp.setLayout(new BorderLayout()); ///////// ????????????????????????????????????
		// 탑패널 생성
		JPanel pTop = new JPanel();

		/// 텍스트필트 추가시작
		tfSang = new TextField(5);
		pTop.add(new JLabel("상품명"));
		pTop.add(tfSang);

		tfSu = new TextField(5);
		pTop.add(new JLabel("수량"));
		pTop.add(tfSu);

		tfDan = new TextField(5);
		pTop.add(new JLabel("단가"));
		pTop.add(tfDan);

		cp.add("North", pTop);
		/*
		 * JPanel pTop = new JPanel(); tfSang = new JTextField(8); tfSu = new
		 * JTextField(4); tfDan = new JTextField(7); pTop.add(new JLabel("상품명"));
		 * pTop.add(tfSang); pTop.add(new JLabel("수량")); pTop.add(tfSu); pTop.add(new
		 * JLabel("단가")); pTop.add(tfDan); cp.add("North",pTop);
		 */

		// pBottom 패널 생성
		JPanel pBottom = new JPanel();

		btnAdd = new Button("추가");
		btnDel = new Button("삭제");
		btnMod = new Button("수정");

		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnMod.addActionListener(this);

		pBottom.add(btnAdd);
		pBottom.add(btnDel);
		pBottom.add(btnMod);

		cp.add("South", pBottom);

		// 테이블을 화면 중앙에 뿌려줌
		model = new DefaultTableModel(data, title);
		table2 = new JTable(model);
		jsp = new JScrollPane(table2);
		cp.add("Center", jsp);

		table2.setSelectionBackground(Color.yellow); // 테이블에서 선택시 색 변하게 하는 방법
		table2.setSelectionForeground(Color.MAGENTA); // 테이블에서 선택시 글자색 변하게 하는 방법

		// 마우스 클릭시 이벤트 발생을 위한 내부 클래스 호출
		table2.addMouseListener(new TableSelect());

	}

	public static void main(String[] args) {
		new TableTest2("데이터를 테이블에 추가해보기");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] str = new String[4];
		Object ob = e.getSource();
		/*
		 * if(ob==btnAdd) { str[0]=tfSang.getText(); str[1]=tfSu.getText();
		 * str[2]=tfDan.getText();
		 * 
		 * int kum=Integer.parseInt(tfSang.getText()) /////////////상품명이 아니라 수량이다. ㅠㅠ
		 * 에러발견 Integer.parseInt(tfDan.getText());
		 * 
		 * str[3]=String.valueOf(kum); model.addRow(str); tfSang.setText("");
		 * tfSu.setText(""); tfDan.setText(""); tfSang.requestFocus();
		 * 
		 * }
		 */

		if (ob == btnAdd) {
			// 입력체크
			if (tfSang.getText().equals("")) // 주소를 비교하는 것이므로 equals로 비교한다. ==로 하면 안될때가 있다
			{
				JOptionPane.showMessageDialog(this, "상품명을 입력해주세요");
				tfSang.requestFocus();
				return;
			}

			if (tfSu.getText().equals("")) // 주소를 비교하는 것이므로 equals로 비교한다. ==로 하면 안될때가 있다
			{
				JOptionPane.showMessageDialog(this, "수량을 입력해주세요");
				tfSu.requestFocus();
				return;
			}
			if (tfDan.getText().equals("")) // 주소를 비교하는 것이므로 equals로 비교한다. ==로 하면 안될때가 있다
			{
				JOptionPane.showMessageDialog(this, "단가를 입력해주세요");
				tfDan.requestFocus();
				return;
			}
			str[0] = tfSang.getText();
			str[1] = tfSu.getText();
			str[2] = tfDan.getText();

			int kum = Integer.parseInt(tfSu.getText()) * Integer.parseInt(tfDan.getText());
			str[3] = String.valueOf(kum);
			model.addRow(str); // 테이블의 맨마지막 row(null 값)을 가져와서 str을추가한다
			this.clearData();

		} else if (ob == btnDel) // 삭제 버튼을 누를때
		{
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "먼저 삭제할 행을 선택해주세요");

				return;
			}

			else {
				JOptionPane.showConfirmDialog(this, "를 삭제할까요?", "삭제", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				model.removeRow(row);
				row = -1;
				this.clearData();

			}
		} else if (ob == btnMod) {

			if (row == -1) {
				JOptionPane.showConfirmDialog(this, "먼저 수정할 행을 선택해주세요", "수정확인", JOptionPane.INFORMATION_MESSAGE);

				return;
			}
			model.setValueAt(tfSang.getText(), row, 0);
			model.setValueAt(tfSu.getText(), row, 1);
			model.setValueAt(tfDan.getText(), row, 2);

			int kum = Integer.parseInt(tfSu.getText()) * Integer.parseInt(tfDan.getText());

			model.setValueAt(String.valueOf(kum), row, 3);
		}

	}

	public void clearData() {

		tfSang.setText(""); // 텍스트필드 창을 지운다.
		tfSu.setText("");
		tfDan.setText("");
		tfSang.requestFocus(); // tfSang 텍스트 필드로 커서를 가져온다.
	}

	class TableSelect extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			row = table2.getSelectedRow(); // 테이블에서 선택된 행의 값을 row에 저장한다.

			// 행번호와 행의 데이터 텍스트 필드에 출력하기
			tfSang.setText((String) table2.getValueAt(row, 0));
			tfSu.setText((String) table2.getValueAt(row, 1));
			tfDan.setText((String) table2.getValueAt(row, 2));
		}

	}

}
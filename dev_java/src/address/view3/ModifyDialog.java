package address.view3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 입력:insert, 수정:update 있는걸 바꾼다, 상세보기
class ModifyDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	// 입력, 수정, 조회 화면에 사용할 컴포넌트를 선언합니다.
	private JLabel labelName;
	private JTextField txtName;
	private JLabel labelAddr;
	private JTextField txtAddress;
	private JLabel labelTel;
	private JTextField txtTel;
	private JLabel labelRel;
	private JTextField txtRelationShip;
	private JLabel labelGender;
	private JComboBox comboGender;
	private JLabel labelBirth;
	private JTextField txtBirthDay;
	private JLabel labelComment;
	private JTextArea txtComment;
	private JLabel labelRegDate;
	private JTextField txtRegDate;
	private JScrollPane scrollPane;
	private JScrollPane scrollComment;
	private JPanel panel;
	private JPanel panelBtn;
	private Font font;

	private Frame parent;
	private String title;

	private JButton btnOk;
	private JButton btnCancel;

	public AddressVO avo = null;
	public static AddressBook abook = null;
	private boolean isCancel;
	// 생성자는 컴포넌트들을 초기화하는 작업만 합니다.
	public ModifyDialog(){
		
	}
	public ModifyDialog(JFrame frm) {
		super(frm,true);
		parent = frm;
		isCancel = true;
		initComponents();
	}

	// 컴포넌트들을 설정하고 배치합니다.
	private void initComponents() {
		//다이얼로그에 색상 정의할 때 사용
		this.getContentPane().setBackground(Color.red);
		// 데이터 칼럼명을 보여줄 레이블을 정의합니다.
		labelName = new JLabel("이름(필수입력) ");
		labelAddr = new JLabel("주소 ");
		labelTel = new JLabel("전화번호 ");
		labelRel = new JLabel("관계 ");
		labelGender = new JLabel("성별 ");
		labelBirth = new JLabel("생일(YYYYMMDD) ");
		labelComment = new JLabel("비고 ");
		labelRegDate = new JLabel("수정일 ");

		labelName.setFont(font);
		labelAddr.setFont(font);
		labelTel.setFont(font);
		labelRel.setFont(font);
		labelGender.setFont(font);
		labelBirth.setFont(font);
		labelComment.setFont(font);
		labelRegDate.setFont(font);

		// 데이터를 보여줄 텍스트 필드등을 정의합니다.
		txtName = new JTextField(20);
		txtAddress = new JTextField(20);
		txtTel = new JTextField(20);
		txtRelationShip = new JTextField(20);
		txtBirthDay = new JTextField(20);
		txtComment = new JTextArea(3, 20);
		scrollComment = new JScrollPane(txtComment);
		txtRegDate = new JTextField(20);

		String [] genderList= {"남자", "여자"};
		comboGender = new JComboBox(genderList);

		// 버튼을 정의합니다.
		btnOk= new JButton("확인");
		btnOk.setFont(font);
		btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("확인 버튼");
                btnOkayActionPerformed(evt);
            }
        });

		btnCancel = new JButton("취소");
		btnCancel.setFont(font);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("취소 버튼");
				btnCancelActionPerformed(evt);
			}
		});

		panel = new JPanel();
//컴넌트들의 위치를 정해줍니다.
		panel.setLayout(null);

		labelName.setBounds(20,20, 100,20);
		txtName.setBounds(120,20, 150,20);

		labelAddr.setBounds(20, 45, 100,20);
		txtAddress.setBounds(120,45, 150,20);

		labelTel.setBounds(20,70, 100,20);
		txtTel.setBounds(120,70, 150, 20);

		labelRel.setBounds(20,95, 100,20);
		txtRelationShip.setBounds(120,95, 150,20);

		labelGender.setBounds(20,120, 100,20);
		comboGender.setBounds(120, 120, 150,20);
  		comboGender.setFont(new java.awt.Font("굴림", 0, 12));

		labelBirth.setBounds(20,145, 100,20);
		txtBirthDay.setBounds(120,145, 150,20);

		labelComment.setBounds(20, 170, 100,20);
		scrollComment.setBounds(120,170, 250,60);

		labelRegDate.setBounds(20, 235, 100,20);
		txtRegDate.setBounds(120,235, 150,20);
		txtRegDate.setEditable(false);

		// 컴포넌트들을 패널에 붙입니다.
		panel.add(labelName);
		panel.add(txtName);
		panel.add(labelAddr);
		panel.add(txtAddress);
		panel.add(labelTel);
		panel.add(txtTel);
		panel.add(labelRel);
		panel.add(txtRelationShip);
		panel.add(labelGender);
		panel.add(comboGender);
		panel.add(labelBirth);
		panel.add(txtBirthDay);
		panel.add(labelComment);
		panel.add(scrollComment);
		panel.add(labelRegDate);
		panel.add(txtRegDate);

		panel.add(btnOk);
		panel.add(btnCancel);

		panelBtn= new JPanel();

		panelBtn.add(btnOk);
		panelBtn.add(btnCancel);

		scrollPane = new JScrollPane(panel);

		setTitle(title);

		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().add(panelBtn, BorderLayout.SOUTH);

		setSize(430,400);

	}

	// 화면의 타이틀과 수정여부를 셋팅하는 메쏘드입니다.
	public void set(String title, boolean editable) {
		this.setTitle(title);
		this.setEditable(editable);
	}

	// 타이틀, 수정여부, Value Object를 받아서 윈도우를 설정합니다.
	/**************************************************************************
	 * 
	 * @param title 사용자가 선택한 메뉴에 대한 자식창의 타이틀 값
	 * @param editable 이른인스턴스화 후 입력 컴포넌트에 쓰기를 허용할건가? 아님 읽기전용으로 할건가를 결정함
	 *  입력(수정가능), 수정(수정가능), 상세보기(onlyread)
	 * @param vo
	 * @param abook
	 **************************************************************************/
	// 자바 리펙토링
	public void set(String title, boolean editable, AddressVO vo, AddressBook abook) {
		// 수정 액션처리할 때(확인버튼 눌렀을 때- 1)입력(insert), 2)수정(update)
		this.avo = vo;
		this.abook = abook;
		this.set(title, editable);
		this.setValue(vo);
	}

	// 입력, 수정시는 칼럼값을 수정 가능하도록, 조회시는 불가능하게
	// 셋팅하는 메쏘드입니다.
	private void setEditable(boolean e) {// 파라미터 boolean true, false
		txtName.setEditable(e);//true가 오면 이름을 변경가능함, false변경 불가함
		txtAddress.setEditable(e);
		txtTel.setEditable(e);	
		txtRelationShip.setEditable(e);
		comboGender.setEnabled(e);
		txtBirthDay.setEditable(e);
		txtComment.setEditable(e);
	}

	// 확인버튼 선택시 작업을 정의합니다.
	// 콜백함수는 원본을 건드리지 않는다
  	private void btnOkayActionPerformed(ActionEvent evt) {
  		if(getName().trim().length() == 0) {
  			JOptionPane.showMessageDialog(this, "이름을 입력하세요.", "Error",
  				JOptionPane.ERROR_MESSAGE);
  			return;
  		}
		isCancel= false;
		//수정화면에서 확인버튼을 눌렀을 때와 입력화면에서 확인 버튼을 눌렀을 때
		//처리하기
		//아이디가 존재하면 수정 모드, 그렇지 않으면 입력 모드로 처리한다.
		if(avo !=null){
			JOptionPane.showMessageDialog(this, "수정하기에서 확인 입니다.","INFO", JOptionPane.INFORMATION_MESSAGE);		
			try{
				AddressVO vo = new AddressVO();
				// vo를 send메소드의 파라미터로 넘기는 이유가 뭘까?
				// 버튼은 AddressBook에 있는데... 처리는 ModifyDialog에서 해야 함
				vo.setCommand("update");
				vo.setName(getName());
				vo.setAddress(getAddress());
				vo.setGender(getGender());
				//상세보기에서 아이디값을 출력하는 화면은 없으니까
				// 아래 코드값에 대한 확인 필요!
				vo.setId(avo.getId());
				AddressCtrl ctrl = new AddressCtrl();
				AddressVO raVO = ctrl.send(vo);
				if(raVO.getResult() == 1) {
					abook.refreshData();// 새로고침
				}				
			}catch(Exception e){
				JOptionPane.showMessageDialog(this, "수정중 에러가 발생했습니다." + e,
						"Error", JOptionPane.ERROR_MESSAGE);				
			}
		/*
		 * 아이디가 0보다 큰값이 아니면 입력모드 이다.	
		 */
		}else{
			try {
				JOptionPane.showMessageDialog(this, "입력하기에서 확인 입니다.","INFO", JOptionPane.INFORMATION_MESSAGE);		
				AddressVO vo = new AddressVO();	
				vo.setCommand("insert");
				vo.setName(getName());
				vo.setAddress(getAddress());
				vo.setTelephone(getTel());
				vo.setGender(getGender());
				vo.setRelationship(getRelationShip());
				vo.setBirthday(getBirthDay());
				vo.setComments(getComment());
				// 입력이든 수정이든 반드시 AddressCtrl를 경유한다. - 컨벤션(MVC 패턴)
				AddressCtrl ctrl = new AddressCtrl();
				// vo안에는 전변이 있다. 읽고(getter getXXX()) 쓰지(setter setXXX())?
				AddressVO raVO = ctrl.send(vo);		
				if(raVO.getResult() == 1) {
					abook.refreshData();// 새로고침
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "입력중 에러가 발생했습니다." + e,
					"Error", JOptionPane.ERROR_MESSAGE);
			}			
		}
		setVisible(false);
	}

	public void setValue(AddressVO vo) {
		// 입력을 위한 윈도우 설정-모든값을 null로 셋팅합니다.
		if(vo == null) {
			setName("");
	  		setAddress("");
			setTel("");
			setGender("1");
			setRelationShip("");
			setBirthDay("");
			setComment("");
			setRegDate("");
		// 조회, 수정시는 Value Object에서 받은 값으로 셋팅합니다.
		} else {
			setName(vo.getName());
	  		setAddress(vo.getAddress());
			setTel(vo.getTelephone());
			setGender(vo.getGender());
			setRelationShip(vo.getRelationship());
			setBirthDay(vo.getBirthday());
			setComment(vo.getComments());
			setRegDate(vo.getRegistedate());
		}
	}

	// 취소버튼 선택시 작업을 정의합니다.
	private void btnCancelActionPerformed(ActionEvent evt) {
		isCancel= true;	
		dispose();
	}

	// 각 컬럼의 값들을 설정하거나 읽어오는 getter/setter 메쏘드입니다.
	public String getName() { return txtName.getText(); }
	public void setName(String strName) { txtName.setText(strName); }
	public String getAddress() { return txtAddress.getText(); }
	public void setAddress(String strAddress) { txtAddress.setText(strAddress); }
	public String getTel() { return txtTel.getText(); }
	public void setTel(String strTel) { txtTel.setText(strTel); }
	public String getRelationShip() { return txtRelationShip.getText(); }
	public void setRelationShip(String strRelation) { txtRelationShip.setText(strRelation); }
	public String getBirthDay() { return txtBirthDay.getText(); }
	public void setBirthDay(String strBirth) { 	txtBirthDay.setText(strBirth); }
	public void setRegDate(String strReg) { txtRegDate.setText(strReg); }
	public String getGender() {
		if (comboGender.getSelectedItem().equals("남자")) return "1";
		else return "2";
	}
	public void setGender(String strGender) {
		if(strGender == null) strGender = "1";
		if (strGender.equals("1"))  comboGender.setSelectedItem("남자");
		else comboGender.setSelectedItem("여자");
	}
	public String getComment() { return txtComment.getText(); }
	public void setComment(String strComment) { txtComment.setText(strComment); }
	public String getRegDate() { return txtRegDate.getText(); }

}

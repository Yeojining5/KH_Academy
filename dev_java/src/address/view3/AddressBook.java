package address.view3;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.*;

public class AddressBook extends JFrame {
	private static final long serialVersionUID = 1L;
	DBConnectionMgr dbMgr = new DBConnectionMgr();
	// 메인화면에 사용할 컴포넌트들을 선언합니다.
    private JMenuBar menuBar;
    private JMenu menuMenu;
    private JMenu menuAbout;
	private JMenuItem menuItemConnect;
    private JMenuItem menuItemInsert;
    private JMenuItem menuItemUpdate;
    private JMenuItem menuItemDelete;
    private JMenuItem menuItemDetail;
    private JMenuItem menuItemSelectAll;
    private JMenuItem menuItemAbout;
    private JSeparator menuSeparator1;
    private JSeparator menuSeparator2;
    private JMenuItem menuItemExit;
    private JToolBar toolbar;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnDetail;
    private JButton btnSelectAll;
    private JScrollPane jScrollPane1;
    private JTable table;
	private MyTableModel myTableModel;
	private JPanel panelTimer;
	private JLabel labelTimer;

	private JOptionPane optionDlg;
	private ModifyDialog mDialog;
	private Font font;
	private String path;

	// DB작업을 중개해줄 Controller 클래스
	private AddressCtrl ctrl;
	public static AddressBook abook = null;
	AddressVO [] vos = null;
	// 메인 메쏘드는 AddressBook의 인스턴스를 생성하고 보여주는 일만 합니다.
    public static void main(String args[]) {
    	JFrame.setDefaultLookAndFeelDecorated(true);
        abook = new AddressBook();
        abook.initComponents();
        abook.setVisible(true);
    }

    // 생성자는 컴포넌트들을 초기화합니다.
    public AddressBook() {
        //initComponents();
    }

	// 초기화 작업은 컴포넌트들의 값을 셋팅하고 배치합니다.
    private void initComponents() {
    	// DefaultTableModel을 상속받은 MyTableModel 클래스가 테이블의
    	// 데이타를 담당합니다.
		myTableModel= new MyTableModel();

		// 메뉴바, 메뉴, 메뉴 아이템을 정의합니다.
        menuBar = new JMenuBar();
        menuMenu = new JMenu();
		menuAbout= new JMenu();
		menuItemConnect= new JMenuItem();
        menuItemInsert = new JMenuItem();
        menuItemUpdate = new JMenuItem();
        menuItemDelete = new JMenuItem();
        menuItemDetail= new JMenuItem();
        menuItemSelectAll= new JMenuItem();
		menuItemAbout = new JMenuItem();
        menuSeparator1 = new JSeparator();
        menuSeparator2 = new JSeparator();
        menuItemExit = new JMenuItem();
        menuMenu.setText("메뉴");
        menuMenu.setFont(font);

        // 툴바와 이미지 버튼을 정의합니다.
        toolbar = new JToolBar();
        btnInsert = new JButton();
        btnInsert.setToolTipText("입력");
        btnUpdate = new JButton();
        btnUpdate.setToolTipText("수정");
        btnDelete = new JButton();
        btnDelete.setToolTipText("삭제");
        btnDetail = new JButton();
        btnDetail.setToolTipText("상세조회");
        btnSelectAll = new JButton("전체조회");
        btnSelectAll.setToolTipText("전체조회");
        jScrollPane1 = new JScrollPane();
        table = new JTable(myTableModel);
        JTableHeader jth = new JTableHeader();
        jScrollPane1.getViewport().setBackground(Color.black);

		labelTimer = new JLabel("현재 시간");
		labelTimer.setFont(font);
		panelTimer = new JPanel();
		font= new Font("굴림",0, 12);
		path = "src//images//address//";


		// About 화면을 출력할 대화상자 정의
		optionDlg = new JOptionPane();
		// 입력, 수정, 조회에 사용할 화면정의
        mDialog = new ModifyDialog(this);
        mDialog.setVisible(false);

        // DB연결 메뉴아이템
		menuItemConnect.setFont(font);
		menuItemConnect.setText("DB 연결");
		menuItemConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
                System.out.println("DB 연결 메뉴");
                connectActionPerformed(evt);
			}
		});

		// 상세조회 메뉴아이템
        menuItemDetail.setFont(font);
        menuItemDetail.setText("상세조회");
        menuItemDetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("조회 메뉴");
                detailActionPerformed();
            }
        });
        // 전체조회 메뉴아이템
        menuItemSelectAll.setFont(font);
        menuItemSelectAll.setText("전체조회");
        menuItemSelectAll.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		System.out.println("전체조회 메뉴");
        		refreshData();
        	}
        });

		// 입력 메뉴아이템
	    menuItemInsert.setFont(font);
        menuItemInsert.setText("입력");
        menuItemInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("입력 메뉴");
                addActionPerformed(evt);
            }
        });

		// 수정 메뉴아이템
        menuItemUpdate.setFont(font);
        menuItemUpdate.setText("수정");
        menuItemUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.out.println("수정 메뉴");
            	updateActionPerformed();
            }
        });

		// 삭제 메뉴아이템
        menuItemDelete.setFont(font);
        menuItemDelete.setText("삭제");
        menuItemDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("삭제 메뉴");
            	deleteActionPerformed();
            }
        });

		// 종료 메뉴아이템
        menuItemExit.setFont(font);
        menuItemExit.setText("종료");
        menuItemExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("종료 메뉴");
            	exitActionPerformed(evt);
            }
        });

        // 메뉴 아이템을 메뉴에 붙입니다.
		menuMenu.add(menuItemConnect);
        menuMenu.add(menuSeparator1);
		menuMenu.add(menuItemSelectAll);
		menuMenu.add(menuItemDetail);
		menuMenu.add(menuItemInsert);
		menuMenu.add(menuItemUpdate);
		menuMenu.add(menuItemDelete);
		menuMenu.add(menuSeparator2);
        menuMenu.add(menuItemExit);

 		// 첫번째 메뉴를 메뉴바에 붙입니다.
        menuBar.add(menuMenu);

		// About 메뉴
		menuAbout.setFont(font);
		menuAbout.setText("About");

		// About 메뉴아이템
		menuItemAbout.setFont(font);
		menuItemAbout.setText("About");
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				System.out.println("About 메뉴");
				aboutActionPerformed(evt);
			}
		});
		menuAbout.add(menuItemAbout);

		// 두번째 메뉴를 메뉴바에 붙입니다.
		menuBar.add(menuAbout);
		// 완성된 메뉴바를 프레임과 연결합니다.
		setJMenuBar(menuBar);

        // 프레임 관련 설정을 합니다.
		setTitle("주소록 데모 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFont(font);

		// 윈도우 리스너 설정
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
            	System.out.println("윈도우 종료");
            	System.exit(0);
            }
        });

		// 조회 아이콘
		btnDetail.setIcon(new ImageIcon(path+"detail.gif"));
        btnDetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("상세조회 아이콘");
            	detailActionPerformed();
            }
        });
        toolbar.add(btnDetail);
		toolbar.add(new JToolBar.Separator());

		// 입력 아이콘
        btnInsert.setIcon(new ImageIcon(path+"new.gif"));
        btnInsert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("입력 아이콘");
            	addActionPerformed(evt);
            }
        });
		toolbar.add(btnInsert);

        // 수정 아이콘
        btnUpdate.setIcon(new ImageIcon(path+"update.gif"));
		btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("수정 아이콘");
            }
        });
        toolbar.add(btnUpdate);

        // 삭제 아이콘
        btnDelete.setIcon(new ImageIcon(path+"delete.gif"));
		btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	System.out.println("삭제 아이콘");
            	deleteActionPerformed();
            }
        });
        toolbar.add(btnDelete);

        // 툴바를 컨테이너에 붙입니다.
        getContentPane().add(toolbar, java.awt.BorderLayout.NORTH);

        // 데이터 리스트가 조회될 테이블을 설정합니다.
        table.setFont(font);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				if (me.getClickCount() >= 2) {
					System.out.println("데이타 더블클릭");
					detailActionPerformed();
				}
			}
		});
		// 테이블을 스크롤 페널에 연결하여 붙입니다.
        jScrollPane1.setViewportView(table);
        getContentPane().add(jScrollPane1, BorderLayout.CENTER);
		// 서버로부터 받아온 시간을 출력할 레이블을 붙입니다.
		panelTimer.add(labelTimer);
		getContentPane().add(panelTimer, BorderLayout.SOUTH);
        pack();

		// 데이터가 표시될 테이블의 칼럼을 설정합니다.
		myTableModel.setColumnCount(0);

		myTableModel.addColumn("아이디");
		table.getColumnModel().getColumn(0).setWidth(300);
		myTableModel.addColumn("이름");
		table.getColumnModel().getColumn(0).setWidth(300);
		myTableModel.addColumn("주소");
		table.getColumnModel().getColumn(0).setWidth(800);
		myTableModel.addColumn("전화번호");
		table.getColumnModel().getColumn(0).setWidth(500);

    }

	// DB연결 메뉴 선택시 작업을 정의합니다.
	private void connectActionPerformed(ActionEvent evt) {
		Connection con = null;
		try {
			con = dbMgr.getConnection();
			if(con != null) {
				JOptionPane.showMessageDialog(this, "DB 연결에 성공했습니다.\n","Info", JOptionPane.INFORMATION_MESSAGE);
				return;
			}else {
				JOptionPane.showMessageDialog(this, "DB 연결에 실패했습니다.\n","Error", JOptionPane.ERROR_MESSAGE);
				return;				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "DB 연결에 실패했습니다.\n" + e,"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	// 조회 메뉴나 조회 아이콘 선택시 작업을 정의합니다.
	private void detailActionPerformed() {
		System.out.println("상세조회 구현");		
		int index[] = table.getSelectedRows();
		// 너 선택 안했네...
		if(index.length == 0) {
			JOptionPane.showMessageDialog(this, "상세보기할 데이터를 선택하세요.","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		else if(index.length > 1) {
			JOptionPane.showMessageDialog(this, "상세보기할 데이터한 건만 선택하세요.","Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			AddressVO paVO = new AddressVO();
			//사용자가 선택한 로우의 id값 가져오기
			Integer id = Integer.parseInt(myTableModel.getValueAt(index[0], 0).toString());
			paVO.setId(id);
			paVO.setCommand("select");
			ctrl = new AddressCtrl();
			AddressVO raVO = ctrl.send(paVO);
			// 조회된 데이터를 보여줄 윈도우 설정
			mDialog.set("상세보기", false, raVO, abook);
			mDialog.setVisible(true);
			
		}
	}

	// 입력 메뉴나 입력 아이콘 선택시 작업을 정의합니다.
	private void addActionPerformed(ActionEvent evt) {
		System.out.println("입력하기");	
		// AddressBook에서 입력버튼이 눌리면 abook에서 이벤트감지
		// ModifyDialog에 set메소드 호출한다
		// 호출할때 파라미터로는 사용자가 선택한 버튼의 이름, 화면보여줄까?, AddressVO(왜냐면 새로입력하는거니까)
		// null, abook의 주소번지(원본-공유-static)- 이태릭체 - static
		//1)하나의 화면으로 입력 or 수정 or 상세조회
		//2)입력,수정:각 입력 콤포넌트가 수정할 수 있는 상태
		//  상세조회:onlyread - false
		//3)입력 -> view->action(insert)->action(selectall)->view
		//  수정 -> action(select:1건)->view->action(update)->action(selectall)-view
		//  상세보기 -> action(select:1건)-> view(ModifyDialog)
		//4)abook넘긴다 - 단 원본을 넘겨야 한다. 복사본을 만들면 망함
		mDialog.set("입력", true, null,abook);
		mDialog.setVisible(true);
	}

	// 수정 메뉴나 수정 아이콘 선택시 작업을 정의합니다.
	public void updateActionPerformed() {
		System.out.println("수정하기");
		int index[] = table.getSelectedRows();
		// 수정의 경우 상세보기 선 처리
		AddressVO vo = new AddressVO();
		if(index.length == 0) {
			JOptionPane.showMessageDialog(this, "수정할 데이터를 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else if(index.length > 1) {
			JOptionPane.showMessageDialog(this, "데이터를 한건만 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {
			try {
				// 테이블에서 선택된 컬럼의 id를 읽어옵니다.
//				Integer id= (Integer)myTableModel.getValueAt(index[0], 0);
				int id = Integer.parseInt(myTableModel.getValueAt(index[0], 0).toString());
				AddressVO newVo = null;
				vo.setId(id);
				vo.setCommand("select");
				newVo = ctrl.send(vo);
				
				mDialog.set("수정", true, newVo, abook);
				mDialog.setVisible(true);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "데이터를 가져오는 중 발생했습니다."+e.toString(),"Error", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}

	// 삭제 메뉴나 삭제 아이콘 선택시 작업을 정의합니다.
	private void deleteActionPerformed() {
		System.out.println("삭제하기");
		int index[] = table.getSelectedRows();
		if(index.length == 0) {// 아무것도 선택하지 않았어
			JOptionPane.showMessageDialog(this, "삭제할 데이터를 선택하세요...", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}else {
			AddressVO paVO = new AddressVO();
			for(int i=0;i<myTableModel.getRowCount();i++) {
				if(table.isRowSelected(i)) {
					Integer id = Integer.parseInt(myTableModel.getValueAt(i, 0).toString());
					paVO.setCommand("delete");
					paVO.setId(id);
					ctrl = new AddressCtrl();
					AddressVO raVO = ctrl.send(paVO);
					int result = 0;
					result = raVO.getResult();
					// 삭제 처리가 되었다면
					if(result == 1) {
						refreshData();
					}
				}/////// end of if
			}/////////// end of for
		}/////////////// end of else
	}

	// 종료 메뉴 선택시 작업을 정의합니다.
	private void exitActionPerformed(ActionEvent evt) {
		System.exit(0);
	}

	// About 메뉴 선택시 작업을 정의합니다.
	private void aboutActionPerformed(ActionEvent evt) {
		optionDlg.setFont(font);
		JOptionPane.showMessageDialog(this, "주소록 데모 프로그램 1.0","About", JOptionPane.INFORMATION_MESSAGE);
	}

	// 전체 데이터를 다시 조회합니다.
	// SELECT * FROM mkaddrtb
	public void refreshData() {
		System.out.println("전체 데이터를 다시 조회합니다.");
		// 이미 테이블에 조회된 결과가 있다면 모두 삭제처리 먼저 함
		// 테이블에 관련된 이벤트 처리시 주의사항
		// 폼에 대한 처리 인지 데이터셋에 대한 처리 인지 구분
		while(myTableModel.getRowCount() > 0) {
			myTableModel.removeRow(0);
		}
		// 전체조회 감지되면 이벤트 처리 - refreshData()호출
		// MVC패턴 적용 -> AddressCtrl
		// 디폴트 생성자로 변경한 이유는 send메소드의 파라미터로 넘길 수 있다
		ctrl = new AddressCtrl();	
		// Controller에서 넘겨 받은 전체 데이터를 테이블에 셋팅합니다.
		//vos = ctrl.send();
		List<Map<String,Object>> bookList = ctrl.myBatisSend();
		System.out.println(vos);
//		if(vos != null && vos.length > 0) {
		if(bookList != null && bookList.size() > 0) {
			for (int i = 0; i < bookList.size(); i++) {
				Map<String,Object> rmap = bookList.get(i);
				Vector<Object> oneRow = new Vector<>();
				oneRow.addElement(rmap.get("ID"));
				oneRow.addElement(rmap.get("NAME"));
				oneRow.addElement(rmap.get("ADDRESS"));
				oneRow.addElement(rmap.get("TELEPHONE"));			
				myTableModel.addRow(oneRow);
			}
		}///////////// end of if
	}///////////////// end of refreshData

}

// 데이터를 보여줄 테이블의 실제 데이터를 관리하는 클래스입니다.
class MyTableModel extends DefaultTableModel {

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

}

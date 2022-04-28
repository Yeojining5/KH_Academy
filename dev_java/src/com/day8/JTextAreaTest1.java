package com.day8;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextAreaTest1 extends JFrame {
	JTextArea jta_display = new JTextField (); // 속지
	JTextField jf_msg = new JTextField();
	
	public void initDisplay() {
		jta_display.setBackground(Color.GREEN);
		jf_msg.setBackground(Color.yellow);
		this.add("center", jta_display);
		this.add("South", jf_msg);
		this.setSize(300, 400);
		this.setVisible(true); // false이면 비활성화
 		
	}
	public static void main(String[] args) {
		JTextAreaTest1 jtt = new JTextAreaTest1 ();
		jtt.initDisplay();
		
			
		}
		
		
	}

}

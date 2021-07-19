package lab08;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class MyFrame extends JFrame implements ActionListener {

	private JLabel lbl1;
	private JLabel lbl2;
	private JButton btn;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;

	public MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("이자 계산기");
		this.setSize(250,170);
		this.setLayout(new BorderLayout());
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
		
		lbl1 = new JLabel("원금을 입력하시오");
		lbl2 = new JLabel("이율을 입력하시오");
		btn = new JButton("변환");
		txt1 = new JTextField(8);
		txt2 = new JTextField(8);
		txt3 = new JTextField(20);
		txt3.setEnabled(false);
		btn.addActionListener(this);
		
		panel1.add(lbl1);
		panel1.add(txt1);
		panel2.add(lbl2);
		panel2.add(txt2);
		
		btn.setPreferredSize(new Dimension(20,30));
		panel3.setLayout(new BorderLayout());
		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.SOUTH);
		
		btn.setPreferredSize(new Dimension(70, 30));
		txt3.setPreferredSize(new Dimension(20, 20));
		panel4.add(btn);
		panel5.add(txt3);
		
		this.add(panel3, BorderLayout.NORTH);
		this.add(panel4, BorderLayout.CENTER);
		this.add(panel5, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			float interest = Integer.parseInt(txt1.getText()) * (Float.parseFloat(txt2.getText())/100);
			txt3.setText("이자는 연 " + (int)interest + "만 원 입니다.");
		}
	}
}

public class MyFrameTest {
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}
}
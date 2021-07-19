package lab08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftRight extends JFrame implements ActionListener {
	JPanel[] panels;
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JButton left;
	JButton right;

	public LeftRight() {
		super("박스 움직이기");
		panels = new JPanel[10];

		for (int i = 0; i < 10; i++) {
			panels[i] = new JPanel();
			panels[i].setPreferredSize(new Dimension(20, 220));
			panels[i].setBackground(Color.YELLOW);
		}
		panels[2].setBackground(Color.RED);

		left = new JButton("왼쪽으로 이동");
		right = new JButton("오른쪽으로 이동");

		panel1.setBackground(Color.YELLOW);
		panel1.setLayout(new GridLayout(1, 10, 5, 5));
		
		for (int i = 0; i < 10; i++) {
			panel1.add(panels[i]);
		}

		left.addActionListener(this);
		right.addActionListener(this);

		panel2.add(left);
		panel2.add(right);

		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if (b.getText().equals("왼쪽으로 이동") == true) {
			if (panels[0].getBackground() == Color.RED) {
				panels[0].setBackground(Color.RED);
				panels[1].setBackground(Color.YELLOW);
			}
			else if (panels[1].getBackground() == Color.RED) {
				panels[0].setBackground(Color.RED);
				panels[1].setBackground(Color.YELLOW);
			}
			else if (panels[2].getBackground() == Color.RED) {
				panels[1].setBackground(Color.RED);
				panels[2].setBackground(Color.YELLOW);
			}
			else if (panels[3].getBackground() == Color.RED) {
				panels[2].setBackground(Color.RED);
				panels[3].setBackground(Color.YELLOW);
			}
			else if (panels[4].getBackground() == Color.RED) {
				panels[3].setBackground(Color.RED);
				panels[4].setBackground(Color.YELLOW);
			}
			else if (panels[5].getBackground() == Color.RED) {
				panels[4].setBackground(Color.RED);
				panels[5].setBackground(Color.YELLOW);
			}
			else if (panels[6].getBackground() == Color.RED) {
				panels[5].setBackground(Color.RED);
				panels[6].setBackground(Color.YELLOW);
			}
			else if (panels[7].getBackground() == Color.RED) {
				panels[6].setBackground(Color.RED);
				panels[7].setBackground(Color.YELLOW);
			}
			else if (panels[8].getBackground() == Color.RED) {
				panels[7].setBackground(Color.RED);
				panels[8].setBackground(Color.YELLOW);
			}
			else if (panels[9].getBackground() == Color.RED) {
				panels[8].setBackground(Color.RED);
				panels[9].setBackground(Color.YELLOW);
			}
		}
		if (b.getText().equals("오른쪽으로 이동") == true) {
			if (panels[0].getBackground() == Color.RED) {
				panels[0].setBackground(Color.YELLOW);
				panels[1].setBackground(Color.RED);
			}
			else if (panels[1].getBackground() == Color.RED) {
				panels[2].setBackground(Color.RED);
				panels[1].setBackground(Color.YELLOW);
			}
			else if (panels[2].getBackground() == Color.RED) {
				panels[3].setBackground(Color.RED);
				panels[2].setBackground(Color.YELLOW);
			}
			else if (panels[3].getBackground() == Color.RED) {
				panels[4].setBackground(Color.RED);
				panels[3].setBackground(Color.YELLOW);
			}
			else if (panels[4].getBackground() == Color.RED) {
				panels[5].setBackground(Color.RED);
				panels[4].setBackground(Color.YELLOW);
			}
			else if (panels[5].getBackground() == Color.RED) {
				panels[6].setBackground(Color.RED);
				panels[5].setBackground(Color.YELLOW);
			}
			else if (panels[6].getBackground() == Color.RED) {
				panels[7].setBackground(Color.RED);
				panels[6].setBackground(Color.YELLOW);
			}
			else if (panels[7].getBackground() == Color.RED) {
				panels[8].setBackground(Color.RED);
				panels[7].setBackground(Color.YELLOW);
			}
			else if (panels[8].getBackground() == Color.RED) {
				panels[9].setBackground(Color.RED);
				panels[8].setBackground(Color.YELLOW);
			}
			else if (panels[9].getBackground() == Color.RED) {
				panels[9].setBackground(Color.RED);
				panels[8].setBackground(Color.YELLOW);
			}
		}

	}

	public static void main(String[] args) {
		new LeftRight();
	}
}
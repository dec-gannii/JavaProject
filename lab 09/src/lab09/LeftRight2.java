package lab09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftRight2 extends JFrame implements KeyListener {
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel = new JPanel();
	JButton left;
	JButton right;

	public LeftRight2() {
		super("�ڽ� �����̱�");
		left = new JButton("�������� �̵�");
		right = new JButton("���������� �̵�");
		panel1.setBackground(Color.YELLOW);
		panel1.setSize(300, 300);
		panel.setPreferredSize(new Dimension(20, 220));
		panel.setBackground(Color.RED);

		panel1.add(panel);
		panel2.add(left);
		panel2.add(right);

		this.setLayout(new BorderLayout());

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);

		this.addKeyListener(this);
		
		this.requestFocus();
		setFocusable(true);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args) {
		new LeftRight2();
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
		int pnl_x = panel.getX();
		int keycode = e.getKeyCode();
		switch (keycode) {
		case KeyEvent.VK_LEFT:
			pnl_x -= 10;
			panel.setLocation(pnl_x, panel.getY());
			break;
		case KeyEvent.VK_RIGHT:
			pnl_x += 10;
			panel.setLocation(pnl_x, panel.getY());
			break;
		}
		panel1.add(panel);
		
	}
}
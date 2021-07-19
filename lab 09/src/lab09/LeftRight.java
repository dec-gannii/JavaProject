package lab09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeftRight extends JFrame implements KeyListener, ActionListener {
	//GUI 구현에 필요한 요소들 생성
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel = new JPanel();
	JButton left;
	JButton right;
	private int pnl_x = 0;

	public LeftRight() {
		super("박스 움직이기");
		left = new JButton("왼쪽으로 이동");
		right = new JButton("오른쪽으로 이동");
		panel1.setBackground(Color.YELLOW);
		panel1.setSize(300, 300);
		panel.setPreferredSize(new Dimension(20, 220));
		panel.setBackground(Color.RED);
		//버튼 눌러서 이동 방식
		left.addActionListener(this);
		right.addActionListener(this);

		panel1.add(panel);
		panel2.add(left);
		panel2.add(right);

		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		//키보드 눌러서 이동 방식
		this.addKeyListener(this);
		//버튼 누른 이후에 키보드 방식도 이용할 수 있게 하기 위해서 버튼의 포커스 false로 설정
		left.setFocusable(false);
		right.setFocusable(false);
		this.requestFocus();
		setFocusable(true);
		//드래그 이동 방식을 빨강색 패널에 추가
		panel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				pnl_x = panel.getX();
				panel.setLocation(x + pnl_x, 5);
			}
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args) {
		new LeftRight();
	}
	//키 눌렸을 때 이동하는 코드
	public void keyPressed(KeyEvent e) {
		int keycode = e.getKeyCode();
		pnl_x = panel.getX();
		switch (keycode) {
		case KeyEvent.VK_LEFT:
			pnl_x -= 10;
			panel.setLocation(pnl_x, 5);
			break;
		case KeyEvent.VK_RIGHT:
			pnl_x += 10;
			panel.setLocation(pnl_x, 5);
			break;
		}
		panel1.add(panel);
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}
	//버튼 눌렀을 때 이동하는 코드
	public void actionPerformed(ActionEvent e) {
		pnl_x = panel.getX();
		if (e.getSource() == left) {
			pnl_x -= 10;
			panel.setLocation(pnl_x, panel.getY());
		} else if (e.getSource() == right) {
			pnl_x += 10;
			panel.setLocation(pnl_x, panel.getY());
		}
	}
}
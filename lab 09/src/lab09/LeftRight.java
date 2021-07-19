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
	//GUI ������ �ʿ��� ��ҵ� ����
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel = new JPanel();
	JButton left;
	JButton right;
	private int pnl_x = 0;

	public LeftRight() {
		super("�ڽ� �����̱�");
		left = new JButton("�������� �̵�");
		right = new JButton("���������� �̵�");
		panel1.setBackground(Color.YELLOW);
		panel1.setSize(300, 300);
		panel.setPreferredSize(new Dimension(20, 220));
		panel.setBackground(Color.RED);
		//��ư ������ �̵� ���
		left.addActionListener(this);
		right.addActionListener(this);

		panel1.add(panel);
		panel2.add(left);
		panel2.add(right);

		this.setLayout(new BorderLayout());
		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.SOUTH);
		//Ű���� ������ �̵� ���
		this.addKeyListener(this);
		//��ư ���� ���Ŀ� Ű���� ��ĵ� �̿��� �� �ְ� �ϱ� ���ؼ� ��ư�� ��Ŀ�� false�� ����
		left.setFocusable(false);
		right.setFocusable(false);
		this.requestFocus();
		setFocusable(true);
		//�巡�� �̵� ����� ������ �гο� �߰�
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
	//Ű ������ �� �̵��ϴ� �ڵ�
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
	//��ư ������ �� �̵��ϴ� �ڵ�
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
package myFrame;
import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("�ڹٴ� ����ֳ���?");
		JButton Button1 = new JButton("YES");
		JButton Button2 = new JButton("NO");
		
		panel.add(label1);
		panel.add(Button1);
		panel.add(Button2);
		
		this.add(panel);
		
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׽�Ʈ ������");
		setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}

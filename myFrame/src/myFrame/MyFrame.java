package myFrame;
import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("자바는 재미있나요?");
		JButton Button1 = new JButton("YES");
		JButton Button2 = new JButton("NO");
		
		panel.add(label1);
		panel.add(Button1);
		panel.add(Button2);
		
		this.add(panel);
		
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");
		setVisible(true);
	}
	public static void main(String[] args) {
		MyFrame f = new MyFrame();
	}

}

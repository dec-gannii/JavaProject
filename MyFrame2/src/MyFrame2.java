import javax.swing.*;

public class MyFrame2 extends JFrame {
	public MyFrame2() {

		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("테스트 프레임");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JLabel label = new JLabel("자바 호텔에 오신 것을 환영합니다. 숙박일수를 입력하세요.");
		panel1.add(label);

		JButton button1 = new JButton("1명");
		JButton button2 = new JButton("2명");
		JButton button3 = new JButton("3명");
		JButton button4 = new JButton("4명");
		JButton button5 = new JButton("5명");

		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);

		panel3.add(panel1);
		panel3.add(panel2);
		add(panel3);

		setVisible(true);
	}

}

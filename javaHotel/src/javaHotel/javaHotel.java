package javaHotel;
import javax.swing.*;

public class javaHotel extends JFrame {
	public javaHotel() {
		
		setSize(500, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�׽�Ʈ ������");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JLabel label = new JLabel("�ڹ� ȣ�ڿ� ���� ���� ȯ���մϴ�. �����ϼ��� �Է��ϼ���.");
		panel1.add(label);

		JButton button1 = new JButton("1��");
		JButton button2 = new JButton("2��");
		JButton button3 = new JButton("3��");
		JButton button4 = new JButton("4��");
		JButton button5 = new JButton("5��");

		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		panel2.add(button4);
		panel2.add(button5);

		panel3.add(panel1);
		panel3.add(panel2);

	}
	
	public static void main(String[] args) {
		javaHotel jvhtl = new javaHotel();
	}

}

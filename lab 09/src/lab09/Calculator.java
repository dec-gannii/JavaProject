package lab09;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField tField;
	private JButton[] buttons;
	private JButton[] buttons1;
	private String[] labels = { "Backspace", "CE", "C" };
	private String[] labels1 = { "7", "8", "9", "/", "sqrt", "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x", "0",
			"+/-", ".", "+", "=" };
	private float result = 0;
	private String oper = "";

	public Calculator() {
		setTitle("°è»ê±â");
		tField = new JTextField(35);
		panel = new JPanel();
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		tField.setText("0");
		tField.setEnabled(true);
		tField.setHorizontalAlignment(JTextField.RIGHT);

		this.setLayout(new BorderLayout(15, 5));
		panel1.setLayout(new GridLayout(0, 3, 10, 10));
		panel2.setLayout(new GridLayout(4, 0, 10, 10));
		panel3.setLayout(new BorderLayout(15, 5));

		panel.add(tField);

		buttons = new JButton[3];
		for (int i = 0; i < 3; i++) {
			buttons[i] = new JButton(labels[i]);
			buttons[i].setForeground(Color.RED);
			buttons[i].addActionListener(this);
			panel1.add(buttons[i]);
		}

		buttons1 = new JButton[20];
		int index = 0;
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 5; c++) {
				buttons1[index] = new JButton(labels1[index]);
				buttons1[index].addActionListener(this);
				if (c == 3)
					buttons1[index].setForeground(Color.RED);
				panel2.add(buttons1[index]);
				index++;
			}
		}
		buttons1[19].setForeground(Color.RED);

		panel3.add(panel1, BorderLayout.NORTH);
		panel3.add(panel2, BorderLayout.SOUTH);
		this.add(panel, BorderLayout.NORTH);
		this.add(panel3, BorderLayout.CENTER);

		setVisible(true);
		pack();
	}

	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (e.getSource() == buttons[0] || e.getSource() == buttons[1]) {
			if (tField.getText() == "0" || tField.getText().length() == 1) {
				tField.setText("0");
			} else {
				tField.setText(tField.getText().substring(0, tField.getText().length() - 1));
			}
		} else if (e.getSource() == buttons[2]) {
			tField.setText("0");
		}

		for (int i = 0; i < 20; i++) {
			if (e.getSource() == buttons1[i]) {
				switch (i) {
				case 0:
				case 1:
				case 2:
				case 5:
				case 6:
				case 7:
				case 10:
				case 11:
				case 12:
				case 15:
					if (tField.getText().equals("0")) {
						tField.setText("");
						tField.setText(tField.getText() + actionCommand);
					} else if (tField.getText().equals("-")) {
						tField.setText("" + Integer.parseInt(actionCommand) * (-1));
					} else {

						tField.setText(tField.getText() + actionCommand);
					}
					break;
				case 4:
					double dAnswer = Math.sqrt(Float.parseFloat(tField.getText()));
					tField.setText("" + dAnswer);
					break;
				case 9:
					float fAnswer = Float.parseFloat(tField.getText()) * (float) 0.01;
					tField.setText("" + fAnswer);
					break;
				case 14:
					float num = Float.parseFloat(tField.getText());
					num = 1 / num;
					tField.setText("" + num);
					break;
				case 16:
					tField.setText("" + Float.parseFloat(tField.getText()) * (-1));
					break;
				case 17:
					tField.setText(tField.getText() + ".");
					break;
				case 3:
					oper = actionCommand;
					result = Float.parseFloat(tField.getText());
					tField.setText("");
					tField.setText(tField.getText());
					break;
				case 8:
					oper = actionCommand;
					result = Float.parseFloat(tField.getText());
					tField.setText("");
					tField.setText(tField.getText());
					break;
				case 13:
					if (tField.getText().equals("0")) {
						tField.setText("-");
						break;
					}
					oper = actionCommand;
					result = Float.parseFloat(tField.getText());
					tField.setText("");
					tField.setText(tField.getText());
					break;
				case 18:
					oper = actionCommand;
					result = Float.parseFloat(tField.getText());
					tField.setText("");
					tField.setText(tField.getText());
					break;
				case 19:
					float nmb2 = Float.parseFloat(tField.getText());
					if (oper == "/") {
						tField.setText("");
						result /= nmb2;
					} else if (oper == "*") {
						result *= nmb2;
						tField.setText("");
					} else if (oper == "+") {
						result += nmb2;
						tField.setText("");
					} else if (oper == "-") {
						result -= nmb2;
						tField.setText("");
					}
					tField.setText("" + result);
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
	}

}
package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HowPanel extends JPanel {
	protected JRadioButton oneWay, round;
	protected ButtonGroup bg; 
	
	public HowPanel() {
		setLayout(new GridLayout(2, 1));
		oneWay = new JRadioButton("�� ����", true);
		round = new JRadioButton("�պ� ����");

		bg = new ButtonGroup();
		bg.add(oneWay);
		bg.add(round);

		setBorder(BorderFactory.createTitledBorder("��-�պ�"));

		add(oneWay);
		add(round);
	}
}
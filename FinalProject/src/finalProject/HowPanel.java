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
		oneWay = new JRadioButton("편도 일정", true);
		round = new JRadioButton("왕복 일정");

		bg = new ButtonGroup();
		bg.add(oneWay);
		bg.add(round);

		setBorder(BorderFactory.createTitledBorder("편도-왕복"));

		add(oneWay);
		add(round);
	}
}
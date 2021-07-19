package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class GradePanel extends JPanel {
	protected JRadioButton economyS, economyR, business, first;
	protected ButtonGroup bg;
	int gradePrice = 0;

	public GradePanel() {
		setLayout(new GridLayout(4, 1));
		economyS = new JRadioButton("이코노미 특가석", true);
		economyR = new JRadioButton("이코노미 일반석");
		business = new JRadioButton("비즈니스석");
		first = new JRadioButton("퍼스트석");

		gradePrice = 80000;
		
		bg = new ButtonGroup();
		bg.add(economyS);
		bg.add(economyR);
		bg.add(business);
		bg.add(first);

		setBorder(BorderFactory.createTitledBorder("좌석 등급"));

		add(economyS);
		add(economyR);
		add(business);
		add(first);
	}
}
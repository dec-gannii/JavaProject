package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class AgePanel extends JPanel {
	JCheckBox[] buttons = new JCheckBox[3];
	String[] ages = {"성인", "소아 (만2세~12세 미만)", "유아 (만 2세 미만)"};
	int agePrice = 0, adultCost = 0, kidCost = 0, babyCost = 0;
	int aChosenCount = 0, kChosenCount = 0, bChosenCount = 0;


	public AgePanel() {
		setLayout(new GridLayout(3, 0));
		
		for (int i = 0; i < 3; i++) {
			buttons[i] = new JCheckBox(ages[i]);
			add(buttons[i]);
		}
		
		setBorder(BorderFactory.createTitledBorder("탑승객"));
	}
	
	
}
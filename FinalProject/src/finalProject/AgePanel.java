package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class AgePanel extends JPanel {
	JCheckBox[] buttons = new JCheckBox[3];
	String[] ages = {"����", "�Ҿ� (��2��~12�� �̸�)", "���� (�� 2�� �̸�)"};
	int agePrice = 0, adultCost = 0, kidCost = 0, babyCost = 0;
	int aChosenCount = 0, kChosenCount = 0, bChosenCount = 0;


	public AgePanel() {
		setLayout(new GridLayout(3, 0));
		
		for (int i = 0; i < 3; i++) {
			buttons[i] = new JCheckBox(ages[i]);
			add(buttons[i]);
		}
		
		setBorder(BorderFactory.createTitledBorder("ž�°�"));
	}
	
	
}
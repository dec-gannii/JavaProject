package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SeatPanel extends JPanel {
	protected JRadioButton window, aisle;
	protected ButtonGroup bg;

	public SeatPanel() {
		setLayout(new GridLayout(2, 1));
		window = new JRadioButton("창가", true);
		aisle = new JRadioButton("통로");
		
		bg = new ButtonGroup();
		bg.add(window);
		bg.add(aisle);

		setBorder(BorderFactory.createTitledBorder("좌석 위치"));

		add(window);
		add(aisle);
	}
}
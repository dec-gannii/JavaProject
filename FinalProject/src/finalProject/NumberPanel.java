package finalProject;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NumberPanel extends JPanel {
	protected JButton aplus, aminus, kplus, kminus, bplus, bminus;
	protected int aValue = 0, kValue = 0, bValue = 0;
	protected JLabel aCount, kCount, bCount;

	public NumberPanel() {
		setLayout(new GridLayout(3, 3));

		aplus = new JButton("+");
		aminus = new JButton("-");
		kplus = new JButton("+");
		kminus = new JButton("-");
		bplus = new JButton("+");
		bminus = new JButton("-");

		aCount = new JLabel("     " + aValue);
		kCount = new JLabel("     " + kValue);
		bCount = new JLabel("     " + bValue);

		aCount.setAlignmentX(CENTER_ALIGNMENT);
		kCount.setAlignmentX(CENTER_ALIGNMENT);
		bCount.setAlignmentX(CENTER_ALIGNMENT);

		setBorder(BorderFactory.createTitledBorder("ÀÎ¿ø"));

		aplus.setEnabled(false);
		aminus.setEnabled(false);
		kplus.setEnabled(false);
		kminus.setEnabled(false);
		bplus.setEnabled(false);
		bminus.setEnabled(false);
		
		add(aminus);
		add(aCount);
		add(aplus);

		add(kminus);
		add(kCount);
		add(kplus);

		add(bminus);
		add(bCount);
		add(bplus);
	}
}
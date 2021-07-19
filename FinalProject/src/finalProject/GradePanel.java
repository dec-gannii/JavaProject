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
		economyS = new JRadioButton("���ڳ�� Ư����", true);
		economyR = new JRadioButton("���ڳ�� �Ϲݼ�");
		business = new JRadioButton("����Ͻ���");
		first = new JRadioButton("�۽�Ʈ��");

		gradePrice = 80000;
		
		bg = new ButtonGroup();
		bg.add(economyS);
		bg.add(economyR);
		bg.add(business);
		bg.add(first);

		setBorder(BorderFactory.createTitledBorder("�¼� ���"));

		add(economyS);
		add(economyR);
		add(business);
		add(first);
	}
}